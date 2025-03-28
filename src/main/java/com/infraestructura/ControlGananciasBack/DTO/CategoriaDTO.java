package com.infraestructura.ControlGananciasBack.DTO;

/**
 * Objeto de Transferencia de Datos (DTO) para la entidad Categoria.
 * Se utiliza para transferir datos entre el cliente y el servidor
 * sin exponer la entidad completa.
 */
public class CategoriaDTO {

    private Long id;
    private String nombre;
    private String tipo;

    // Constructores
    public CategoriaDTO() {
    }

    public CategoriaDTO(Long id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
