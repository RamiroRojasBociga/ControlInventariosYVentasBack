package com.infraestructura.ControlGananciasBack.model;

import jakarta.persistence.*;
import java.util.Objects;

@Entity // Indica que esta clase es una entidad JPA (se mapea a una tabla en la BD)
@Table(name = "usuarios") // Nombre de la tabla en la base de datos
public class Usuario {

    // ----------------------------
    // Atributos (Columnas en la BD)
    // ----------------------------
    @Id // Marca este campo como la clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-incremental
    private Long id;

    @Column(unique = true, nullable = false) // Restricciones: único y no nulo
    private String username;

    @Column(nullable = false) // No puede ser nulo
    private String password;

    // ----------------------------
    // Constructores
    // ----------------------------

    // Constructor vacío (obligatorio para JPA)
    public Usuario() {
    }

    // Constructor con parámetros (útil para crear instancias rápido)
    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // ----------------------------
    // Getters y Setters (necesarios para JPA/Spring)
    // ----------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    // ----------------------------
    // Métodos adicionales
    // ----------------------------

    // toString() - Para imprimir el objeto en logs o consola
    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}'; // No incluimos la contraseña por seguridad
    }


}
