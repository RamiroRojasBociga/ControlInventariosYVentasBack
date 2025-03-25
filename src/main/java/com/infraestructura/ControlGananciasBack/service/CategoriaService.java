package com.infraestructura.ControlGananciasBack.service;

import com.infraestructura.ControlGananciasBack.DTO.CategoriaDTO;
import java.util.List;

/**
 * Interfaz que define los servicios disponibles para la gestión de categorías.
 */
public interface CategoriaService {

    /**
     * Obtiene todas las categorías.
     * @return Lista de categorías
     */
    List<CategoriaDTO> getAllCategorias();

    /**
     * Obtiene una categoría por su ID.
     * @param id ID de la categoría
     * @return Categoría encontrada
     */
    CategoriaDTO getCategoriaById(Long id);

    /**
     * Crea una nueva categoría.
     * @param categoriaDTO Datos de la categoría a crear
     * @return Categoría creada
     */
    CategoriaDTO createCategoria(CategoriaDTO categoriaDTO);

    /**
     * Actualiza una categoría existente.
     * @param id ID de la categoría a actualizar
     * @param categoriaDTO Nuevos datos de la categoría
     * @return Categoría actualizada
     */
    CategoriaDTO updateCategoria(Long id, CategoriaDTO categoriaDTO);

    /**
     * Elimina una categoría por su ID.
     * @param id ID de la categoría a eliminar
     */
    void deleteCategoria(Long id);
}