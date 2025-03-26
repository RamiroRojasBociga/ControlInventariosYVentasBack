package com.infraestructura.ControlGananciasBack.model;

import com.infraestructura.ControlGananciasBack.model.Categoria;
import jakarta.persistence.*;
import java.util.Date;

/**
 * Entidad que representa un producto (chancla) en el sistema.
 * Mapea la tabla 'producto' de la base de datos.
 */
@Entity
@Table(name = "producto") // Nombre exacto de la tabla en MySQL
public class Producto {

    // ----------------------------
    // ATRIBUTOS (Mapeo de columnas)
    // ----------------------------

    /**
     * ID único del producto (autoincremental)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * Código de referencia único del producto
     */
    @Column(name = "referencia", nullable = false, length = 50, unique = true)
    private String referencia;

    /**
     * Nombre descriptivo del producto (ej: "Sueco doble suela pin")
     */
    @Column(name = "producto", nullable = false, length = 100)
    private String nombre;

    /**
     * Precio al que se compró el producto
     */
    @Column(name = "valor_compra", nullable = false)
    private Double valorCompra;

    /**
     * Precio al que se vende el producto
     */
    @Column(name = "valor_venta", nullable = false)
    private Double valorVenta;

    /**
     * Indica si este producto aplica para el cálculo especial de ganancias
     */
    @Column(name = "aplica_ganancia")
    private Boolean aplicaGanancia = false; // Valor por defecto

    /**
     * Cantidad disponible en inventario
     */
    @Column(name = "cantidad")
    private Integer cantidad = 0; // Valor por defecto

    /**
     * Ganancia calculada para este producto (opcional)
     */
    @Column(name = "ganancia")
    private Double ganancia;

    /**
     * Fecha de registro del producto
     */
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE) // Solo almacena fecha (sin hora)
    private Date fecha = new Date(); // Fecha actual por defecto

    // ----------------------------
    // RELACIONES
    // ----------------------------

    /**
     * Categoría a la que pertenece el producto
     * Relación ManyToOne: Muchos productos pueden pertenecer a una categoría
     */
    @ManyToOne(optional = false)
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    // ----------------------------
    // CONSTRUCTORES
    // ----------------------------

    /**
     * Constructor por defecto (requerido por JPA)
     */
    public Producto() {
    }

    /**
     * Constructor para creación rápida de productos
     */
    public Producto(String referencia, String nombre, Double valorCompra,
                    Double valorVenta, Categoria categoria) {
        this.referencia = referencia;
        this.nombre = nombre;
        this.valorCompra = valorCompra;
        this.valorVenta = valorVenta;
        this.categoria = categoria;
    }

    // ----------------------------
    // GETTERS Y SETTERS
    // ----------------------------

    public Long getId() {
        return id;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getValorCompra() {
        return valorCompra;
    }

    public void setValorCompra(Double valorCompra) {
        this.valorCompra = valorCompra;
    }

    public Double getValorVenta() {
        return valorVenta;
    }

    public void setValorVenta(Double valorVenta) {
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

    public Double getGanancia() {
        return ganancia;
    }

    public void setGanancia(Double ganancia) {
        this.ganancia = ganancia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    // ----------------------------
    // MÉTODOS ÚTILES
    // ----------------------------

    /**
     * Calcula la ganancia básica (venta - compra)
     */
    public Double calcularGananciaBasica() {
        return this.valorVenta - this.valorCompra;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "referencia='" + referencia + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}