/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventariolibros.puravida_mipyme.exceptions;

/**
 *
 * @author Yader
 */
public class ProductoDuplicadoException extends Exception {
        public ProductoDuplicadoException(String message) {
        super(message);
    }

    public ProductoDuplicadoException(String message, Throwable cause) {
        super(message, cause);
    }
}
