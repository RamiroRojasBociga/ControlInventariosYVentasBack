package com.infraestructura.ControlGananciasBack.repository;

import com.infraestructura.ControlGananciasBack.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositorio para la entidad Producto.
 * Hereda operaciones CRUD básicas de JpaRepository.
 */
@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {

    /**
     * Busca productos por ID de categoría.
     * @param categoriaId ID de la categoría
     * @return Lista de productos en la categoría
     */
    List<Producto> findByCategoriaId(Long categoriaId);

    /**
     * Busca productos que aplican para ganancia especial.
     * @return Lista de productos con aplicaGanancia=true
     */
    List<Producto> findByAplicaGananciaTrue();
}