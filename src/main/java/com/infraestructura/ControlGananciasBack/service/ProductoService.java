package com.infraestructura.ControlGananciasBack.service;

import com.infraestructura.ControlGananciasBack.model.Producto;
import java.util.List;

/**
 * Interfaz que define las operaciones disponibles para gestionar productos.
 * Separa la definición del contrato de su implementación concreta.
 */
public interface ProductoService {

    /**
     * Crea un nuevo producto en el sistema.
     * @param producto El producto a crear
     * @return El producto creado y persistido
     */
    Producto crearProducto(Producto producto);

    /**
     * Obtiene todos los productos existentes.
     * @return Lista de todos los productos
     */
    List<Producto> obtenerTodos();

    /**
     * Busca un producto por su identificador único.
     * @param id El ID del producto a buscar
     * @return El producto encontrado
     * @throws RuntimeException Si el producto no existe
     */
    Producto obtenerPorId(Long id);

    /**
     * Actualiza un producto existente.
     * @param id El ID del producto a actualizar
     * @param producto Los nuevos datos del producto
     * @return El producto actualizado
     */
    Producto actualizarProducto(Long id, Producto producto);

    /**
     * Elimina un producto del sistema.
     * @param id El ID del producto a eliminar
     */
    void eliminarProducto(Long id);

    /**
     * Obtiene productos filtrados por categoría.
     * @param categoriaId El ID de la categoría para filtrar
     * @return Lista de productos que pertenecen a la categoría
     */
    List<Producto> obtenerPorCategoria(Long categoriaId);

    /**
     * Obtiene productos que aplican para el cálculo especial de ganancias.
     * @return Lista de productos marcados para ganancia especial
     */
    List<Producto> obtenerConGananciaEspecial();
}