package com.infraestructura.ControlGananciasBack.controller;

import com.infraestructura.ControlGananciasBack.model.Producto;
import com.infraestructura.ControlGananciasBack.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador REST para gestionar operaciones CRUD de productos.
 * Expone endpoints API bajo la ruta base "/api/productos".
 */
@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    private final ProductoService productoService;

    /**
     * Inyección de dependencias por constructor (mejor práctica que @Autowired en campo)
     * @param productoService Servicio de lógica de negocio para productos
     */
    @Autowired
    public ProductoController(ProductoService productoService) {
        this.productoService = productoService;
    }

    // ----------------------------
    // Endpoints CRUD
    // ----------------------------

    /**
     * Obtiene todos los productos registrados.
     * @return ResponseEntity con lista de productos y código HTTP 200 (OK)
     */
    @GetMapping
    public ResponseEntity<List<Producto>> obtenerTodosProductos() {
        List<Producto> productos = productoService.obtenerTodos();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    /**
     * Obtiene un producto específico por su ID.
     * @param id ID del producto a buscar
     * @return ResponseEntity con el producto y código HTTP 200 (OK)
     * @throws RuntimeException Si el producto no existe (manejado por GlobalExceptionHandler)
     */
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id) {
        Producto producto = productoService.obtenerPorId(id);
        return new ResponseEntity<>(producto, HttpStatus.OK);
    }

    /**
     * Crea un nuevo producto.
     * @param producto Datos del producto a crear (en formato JSON en el body)
     * @return ResponseEntity con el producto creado y código HTTP 201 (Created)
     */
    @PostMapping
    public ResponseEntity<Producto> crearProducto(@RequestBody Producto producto) {
        Producto nuevoProducto = productoService.crearProducto(producto);
        return new ResponseEntity<>(nuevoProducto, HttpStatus.CREATED);
    }

    /**
     * Actualiza un producto existente.
     * @param id ID del producto a actualizar
     * @param producto Datos actualizados del producto
     * @return ResponseEntity con el producto actualizado y código HTTP 200 (OK)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(
            @PathVariable Long id,
            @RequestBody Producto producto) {
        Producto productoActualizado = productoService.actualizarProducto(id, producto);
        return new ResponseEntity<>(productoActualizado, HttpStatus.OK);
    }

    /**
     * Elimina un producto existente.
     * @param id ID del producto a eliminar
     * @return ResponseEntity vacío con código HTTP 204 (No Content)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoService.eliminarProducto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    // ----------------------------
    // Endpoints de consultas especiales
    // ----------------------------

    /**
     * Filtra productos por categoría.
     * @param categoriaId ID de la categoría para filtrar
     * @return ResponseEntity con lista de productos filtrados y código HTTP 200 (OK)
     */
    @GetMapping("/por-categoria/{categoriaId}")
    public ResponseEntity<List<Producto>> obtenerProductosPorCategoria(
            @PathVariable Long categoriaId) {
        List<Producto> productos = productoService.obtenerPorCategoria(categoriaId);
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }

    /**
     * Obtiene productos que aplican para ganancia especial.
     * @return ResponseEntity con lista de productos y código HTTP 200 (OK)
     */
    @GetMapping("/con-ganancia-especial")
    public ResponseEntity<List<Producto>> obtenerProductosConGananciaEspecial() {
        List<Producto> productos = productoService.obtenerConGananciaEspecial();
        return new ResponseEntity<>(productos, HttpStatus.OK);
    }
}