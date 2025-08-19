/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventariolibros.puravida_mipyme.dominio;
import com.inventariolibros.puravida_mipyme.exceptions.PrecioInvalidoException;
import com.inventariolibros.puravida_mipyme.exceptions.StockNegativoException;
import java.util.Objects;
/**
 *
 * @author Yader
 */
public class Producto {
    private String codigo;
    private String nombre;
    private String categoria;
    private double precio; // Debe ser >= 0
    private int stockMin; // Debe ser >= 0
    private int stockActual; // Debe ser >= 0

    // Constructores
    public Producto() {
        // Constructor por defecto
    }

    public Producto(String codigo, String nombre, String categoria, double precio, int stockMin, int stockActual) throws PrecioInvalidoException, StockNegativoException {
        this.codigo = codigo;
        this.nombre = nombre;
        this.categoria = categoria;
        setPrecio(precio); // Usamos el setter para validación
        setStockMin(stockMin); // Usamos el setter para validación
        setStockActual(stockActual); // Usamos el setter para validación
    }

    // Getters
    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public double getPrecio() {
        return precio;
    }

    public int getStockMin() {
        return stockMin;
    }

    public int getStockActual() {
        return stockActual;
    }

    // Setters con validaciones
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setPrecio(double precio) throws PrecioInvalidoException {
        if (precio < 0) {
            throw new PrecioInvalidoException("El precio no puede ser negativo: " + precio);
        }
        this.precio = precio;
    }

    public void setStockMin(int stockMin) throws StockNegativoException {
        if (stockMin < 0) {
            throw new StockNegativoException("El stock mínimo no puede ser negativo: " + stockMin);
        }
        this.stockMin = stockMin;
    }

    public void setStockActual(int stockActual) throws StockNegativoException {
        if (stockActual < 0) {
            throw new StockNegativoException("El stock actual no puede ser negativo: " + stockActual);
        }
        this.stockActual = stockActual;
    }

    // Métodos para modificar stock de forma controlada (opcional pero útil)
    // Podrías agregar métodos como aumentarStock(int cantidad) o disminuirStock(int cantidad)

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo); // Dos productos son iguales si tienen el mismo código
    }

    @Override
    public int hashCode() {
        return Objects.hash(codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", categoria='" + categoria + '\'' +
                ", precio=" + precio +
                ", stockMin=" + stockMin +
                ", stockActual=" + stockActual +
                '}';
    }

    
    
}
