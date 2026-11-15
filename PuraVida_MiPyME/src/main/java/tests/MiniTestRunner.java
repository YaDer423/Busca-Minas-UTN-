package tests;

import com.inventariolibros.puravida_mipyme.application.dominio.*;
import java.math.BigDecimal;

/** Comprobación ejecutable del flujo Producto -> ItemOrden -> Orden. */
public class MiniTestRunner {
    private static void importe(String esperado, BigDecimal actual) {
        if (new BigDecimal(esperado).compareTo(actual) != 0)
            throw new AssertionError("Importe esperado " + esperado + ", recibido " + actual);
    }
    public static void main(String[] args) {
        Orden orden = new Orden();
        orden.calcularTotales();
        importe("0", orden.getTotalBruto());
        Producto cafe = new Producto("P1", "Café", "Bebidas", new BigDecimal("12.75"), 1, 10);
        Producto libro = new Producto("P2", "Libro", "Librería", new BigDecimal("8.10"), 1, 10);
        orden.getItems().add(new ItemOrden(cafe, 2, cafe.getPrecio()));
        orden.getItems().add(new ItemOrden(libro, 3, libro.getPrecio()));
        orden.calcularTotales();
        importe("49.80", orden.getTotalBruto());
        orden.calcularTotales();
        importe("49.80", orden.getTotalBruto());
        orden.getItems().get(0).setCantidad(1);
        orden.calcularTotales();
        importe("37.05", orden.getTotalBruto());
        System.out.println("PASS: orden vacía, importes decimales, recálculo y cambio de cantidades");
    }
}
