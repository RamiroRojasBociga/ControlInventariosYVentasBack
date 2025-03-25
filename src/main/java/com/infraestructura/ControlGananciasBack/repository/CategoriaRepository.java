package com.infraestructura.ControlGananciasBack.repository;

import com.infraestructura.ControlGananciasBack.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para la entidad Categoria.
 * Extiende JpaRepository para obtener operaciones CRUD básicas.
 */
@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    /**
     * Busca una categoría por su nombre.
     * @param nombre Nombre de la categoría a buscar
     * @return Categoría encontrada o null si no existe
     */
    Categoria findByNombre(String nombre);

    /**
     * Verifica si existe una categoría con el nombre especificado.
     * @param nombre Nombre a verificar
     * @return true si existe, false si no
     */
    boolean existsByNombre(String nombre);
}