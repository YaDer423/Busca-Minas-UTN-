/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventariolibros.puravida_mipyme.exceptions;

/**
 *
 * @author Yader
 */
public class PrecioInvalidoException extends Exception {
        public PrecioInvalidoException(String message) {
        super(message);
    }

    public PrecioInvalidoException(String message, Throwable cause) {
        super(message, cause);
    }
}
