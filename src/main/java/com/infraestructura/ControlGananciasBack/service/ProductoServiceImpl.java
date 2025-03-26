package com.infraestructura.ControlGananciasBack.service;

import com.infraestructura.ControlGananciasBack.model.Producto;
import com.infraestructura.ControlGananciasBack.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Implementación concreta del servicio de productos.
 * Contiene la lógica de negocio para gestionar productos.
 */
@Service
@Transactional
public class ProductoServiceImpl implements ProductoService {

    private final ProductoRepository productoRepository;

    @Autowired
    public ProductoServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Producto crearProducto(Producto producto) {
        // Validación básica
        if (producto.getNombre() == null || producto.getNombre().trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del producto no puede estar vacío");
        }
        if (producto.getValorCompra() <= 0 || producto.getValorVenta() <= 0) {
            throw new IllegalArgumentException("Los valores de compra y venta deben ser positivos");
        }

        return productoRepository.save(producto);
    }

    @Override
    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    @Override
    public Producto obtenerPorId(Long id) {
        Optional<Producto> producto = productoRepository.findById(id);
        return producto.orElseThrow(() ->
                new RuntimeException("Producto no encontrado con ID: " + id));
    }

    @Override
    public Producto actualizarProducto(Long id, Producto producto) {
        Producto existente = obtenerPorId(id);

        // Actualiza solo los campos no nulos
        if (producto.getNombre() != null) {
            existente.setNombre(producto.getNombre());
        }
        if (producto.getValorCompra() != null) {
            existente.setValorCompra(producto.getValorCompra());
        }
        if (producto.getValorVenta() != null) {
            existente.setValorVenta(producto.getValorVenta());
        }
        if (producto.getAplicaGanancia() != null) {
            existente.setAplicaGanancia(producto.getAplicaGanancia());
        }

        return productoRepository.save(existente);
    }

    @Override
    public void eliminarProducto(Long id) {
        if (!productoRepository.existsById(id)) {
            throw new RuntimeException("No existe producto con ID: " + id);
        }
        productoRepository.deleteById(id);
    }

    @Override
    public List<Producto> obtenerPorCategoria(Long categoriaId) {
        return productoRepository.findByCategoriaId(categoriaId);
    }

    @Override
    public List<Producto> obtenerConGananciaEspecial() {
        return productoRepository.findByAplicaGananciaTrue();
    }
}