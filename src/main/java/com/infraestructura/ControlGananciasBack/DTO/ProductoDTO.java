package com.infraestructura.ControlGananciasBack.DTO;

import com.infraestructura.ControlGananciasBack.model.Categoria;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * DTO (Data Transfer Object) para la entidad Producto.
 * Se utiliza para transferir datos entre el frontend y el backend,
 * exponiendo solo los campos necesarios y protegiendo la estructura interna.
 */
@JsonInclude(JsonInclude.Include.NON_NULL) // Omite campos nulos en las respuestas JSON
public class ProductoDTO {

    private Long id;
    private String nombre;
    private String referencia;
    private BigDecimal valorCompra;
    private BigDecimal valorVenta;
    private Boolean aplicaGanancia;
    private Integer cantidad;
    private LocalDate fecha;
    private Categoria categoria;

    // ----------------------------
    // Constructores
    // ----------------------------

    public ProductoDTO() {
    }

    public ProductoDTO(Long id, String nombre, String referencia, BigDecimal valorCompra,
                       BigDecimal valorVenta, Boolean aplicaGanancia, Integer cantidad,
                       LocalDate fecha, Categoria categoria) {
        this.id = id;
        this.nombre = nombre;
        this.referencia = referencia;
        this.valorCompra = valorCompra;
        this.valorVenta = valorVenta;
        this.aplicaGanancia = aplicaGanancia;
        this.cantidad = cantidad;
        this.fecha = fecha;
        this.categoria = categoria;
    }

    // ----------------------------
    // Getters y Setters
    // ----------------------------

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

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    public BigDecimal getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(BigDecimal valorVenta) {
        this.valorVenta = valorVenta;
    }

    public Boolean getAplicaGanancia() {
        return aplicaGanancia;
    }

    public void setAplicaGanancia(Boolean aplicaGanancia) {
        this.aplicaGanancia = aplicaGanancia;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // ----------------------------
    // Métodos útiles
    // ----------------------------

    /**
     * Calcula la ganancia básica del producto (venta - compra)
     * @return Valor de la ganancia o null si falta algún precio
     */
    public BigDecimal calcularGanancia() {
        if (valorVenta != null && valorCompra != null) {
            return valorVenta.subtract(valorCompra);
        }
        return null;
    }

    @Override
    public String toString() {
        return "ProductoDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", referencia='" + referencia + '\'' +
                '}';
    }
}