/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.inventariolibros.puravida_mipyme.exceptions;

/**
 *
 * @author Yader
 */
public class StockNegativoException extends Exception {
            public StockNegativoException(String message) {
        super(message);
    }

    public StockNegativoException(String message, Throwable cause) {
        super(message, cause);
    }
}
