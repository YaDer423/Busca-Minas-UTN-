/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventariolibros.puravida_mipyme.dominio;
import java.util.Objects;
/**
 *
 * @author Yader
 */
public class Cliente {
    private String idInterno; // Identificador único interno
    private String nombre;
    private String correo;
    private String telefono;
    // La cédula se guarda cifrada. Se usará String para almacenar el resultado del cifrado.
    private String cedulaCifrada;

    // Constructores
    public Cliente() {
        // Constructor por defecto
    }

    public Cliente(String idInterno, String nombre, String correo, String telefono, String cedulaCifrada) {
        this.idInterno = idInterno;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.cedulaCifrada = cedulaCifrada; // Se espera que ya esté cifrada al crear el objeto
    }

    // Getters
    public String getIdInterno() {
        return idInterno;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCedulaCifrada() {
        return cedulaCifrada; // Devuelve la cédula cifrada
    }

    // Setters
    public void setIdInterno(String idInterno) {
        this.idInterno = idInterno;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCedulaCifrada(String cedulaCifrada) {
        this.cedulaCifrada = cedulaCifrada; // Se espera que reciba la cédula ya cifrada
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(idInterno, cliente.idInterno); // Dos clientes son iguales si tienen el mismo idInterno
    }

    @Override
    public int hashCode() {
        return Objects.hash(idInterno);
    }

    @Override
    public String toString() {
        // Nota: No incluimos cedulaCifrada en el toString por seguridad, aunque técnicamente es solo texto cifrado.
        return "Cliente{" +
                "idInterno='" + idInterno + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                // ", cedulaCifrada='" + cedulaCifrada + '\'' + // Omitido por claridad en logs
                '}';
    }

    
}
