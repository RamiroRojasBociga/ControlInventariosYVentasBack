package com.infraestructura.ControlGananciasBack.service;

import com.infraestructura.ControlGananciasBack.DTO.CategoriaDTO;
import com.infraestructura.ControlGananciasBack.model.Categoria;
import com.infraestructura.ControlGananciasBack.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementación concreta del servicio de categorías.
 */
@Service
public class CategoriaServiceImpl implements CategoriaService {

    private final CategoriaRepository categoriaRepository;

    @Autowired
    public CategoriaServiceImpl(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Override
    public List<CategoriaDTO> getAllCategorias() {
        return categoriaRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CategoriaDTO getCategoriaById(Long id) {
        Categoria categoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));
        return convertToDTO(categoria);
    }

    @Override
    public CategoriaDTO createCategoria(CategoriaDTO categoriaDTO) {
        // Verificar si ya existe una categoría con el mismo nombre
        if (categoriaRepository.existsByNombre(categoriaDTO.getNombre())) {
            throw new RuntimeException("Ya existe una categoría con el nombre: " + categoriaDTO.getNombre());
        }

        Categoria categoria = new Categoria();
        categoria.setNombre(categoriaDTO.getNombre());
        categoria.setTipo(categoriaDTO.getTipo());

        Categoria savedCategoria = categoriaRepository.save(categoria);
        return convertToDTO(savedCategoria);
    }

    @Override
    public CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO) {
        Categoria existingCategoria = categoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Categoría no encontrada con id: " + id));

        // Verificar si el nuevo nombre ya existe (y no es el mismo registro)
        if (categoriaRepository.existsByNombre(categoriaDTO.getNombre()) &&
                !existingCategoria.getNombre().equals(categoriaDTO.getNombre())) {
            throw new RuntimeException("Ya existe otra categoría con el nombre: " + categoriaDTO.getNombre());
        }

        existingCategoria.setNombre(categoriaDTO.getNombre());
        existingCategoria.setTipo(categoriaDTO.getTipo());

        Categoria updatedCategoria = categoriaRepository.save(existingCategoria);
        return convertToDTO(updatedCategoria);
    }

    @Override
    public void deleteCategoria(Long id) {
        if (!categoriaRepository.existsById(id)) {
            throw new RuntimeException("Categoría no encontrada con id: " + id);
        }
        categoriaRepository.deleteById(id);
    }

    /**
     * Convierte una entidad Categoria a un DTO.
     * @param categoria Entidad a convertir
     * @return DTO resultante
     */
    private CategoriaDTO convertToDTO(Categoria categoria) {
        return new CategoriaDTO(
                categoria.getId(),
                categoria.getNombre(),
                categoria.getTipo()
        );
    }
}