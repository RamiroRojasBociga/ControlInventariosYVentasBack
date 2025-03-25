package com.infraestructura.ControlGananciasBack.controller;

import com.infraestructura.ControlGananciasBack.DTO.CategoriaDTO;
import com.infraestructura.ControlGananciasBack.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para manejar operaciones CRUD de categorías.
 */
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;

    @Autowired
    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    /**
     * Obtiene todas las categorías.
     * @return Lista de categorías
     */
    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> getAllCategorias() {
        List<CategoriaDTO> categorias = categoriaService.getAllCategorias();
        return new ResponseEntity<>(categorias, HttpStatus.OK);
    }

    /**
     * Obtiene una categoría por su ID.
     * @param id ID de la categoría
     * @return Categoría encontrada
     */
    @GetMapping("/{id}")
    public ResponseEntity<CategoriaDTO> getCategoriaById(@PathVariable Long id) {
        CategoriaDTO categoria = categoriaService.getCategoriaById(id);
        return new ResponseEntity<>(categoria, HttpStatus.OK);
    }

    /**
     * Crea una nueva categoría.
     * @param categoriaDTO Datos de la categoría
     * @return Categoría creada
     */
    @PostMapping
    public ResponseEntity<CategoriaDTO> createCategoria(@RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO nuevaCategoria = categoriaService.createCategoria(categoriaDTO);
        return new ResponseEntity<>(nuevaCategoria, HttpStatus.CREATED);
    }

    /**
     * Actualiza una categoría existente.
     * @param id ID de la categoría a actualizar
     * @param categoriaDTO Nuevos datos de la categoría
     * @return Categoría actualizada
     */
    @PutMapping("/{id}")
    public ResponseEntity<CategoriaDTO> updateCategoria(
            @PathVariable Long id,
            @RequestBody CategoriaDTO categoriaDTO) {
        CategoriaDTO categoriaActualizada = categoriaService.updateCategoria(id, categoriaDTO);
        return new ResponseEntity<>(categoriaActualizada, HttpStatus.OK);
    }

    /**
     * Elimina una categoría.
     * @param id ID de la categoría a eliminar
     * @return Respuesta vacía con código 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        categoriaService.deleteCategoria(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
