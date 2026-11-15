 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminasutn;
import java.util.Random;

/**
 *
 * @author Yader
 */
public class Tablero {
 private int tamaño;
 private int numMinas;
 private Casilla[][] casillas;
 private boolean juegoTerminado;

 public Tablero(int tamaño){
     if (tamaño < 2) {
         throw new IllegalArgumentException("El tablero debe tener al menos dos filas y columnas");
     }
     this.tamaño = tamaño;
     this.numMinas = 2 * tamaño; //segun el requerimiento
     this.casillas = new Casilla[tamaño][tamaño];
     this.juegoTerminado = false;

     // inicializar todas las casillas
     for (int i = 0; i < tamaño; i++){
         for (int j = 0; j < tamaño; j++){
             casillas[i][j] = new Casilla();
         }
     }

     generarMinas();
     contarMinasAdyacentesParaTodas();

 }
 private void contarMinasAdyacentesParaTodas() {
     for (int fila = 0; fila < tamaño; fila++) {
         for (int columna = 0; columna < tamaño; columna++) {
             casillas[fila][columna].setMinasAdyacentes(contarMinasAdyacentes(fila, columna));
         }
     }
 }

 private void generarMinas(){
     Random random = new Random();
     int minasColocadas = 0;
     while (minasColocadas < numMinas){
         int fila = random.nextInt(tamaño);
         int columna = random.nextInt(tamaño);

         // sila casilla no tiene ya una mina, se pone una
         if (!casillas[fila][columna].isEsMina()){
             casillas[fila][columna].setEsMina(true);
             minasColocadas++;

     }
     }
 }


    private int contarMinasAdyacentes(int fila, int columna) {
        int count = 0;
        // Revisar las 8 casillas alrededor
        for (int i = Math.max(0, fila - 1); i <= Math.min(tamaño - 1, fila + 1); i++) {
            for (int j = Math.max(0, columna - 1); j <= Math.min(tamaño - 1, columna + 1); j++) {
                if (i == fila && j == columna) continue; // Saltarse la propia casilla
                if (casillas[i][j].isEsMina()) {
                    count++;
                }
            }
        }
        return count;
    }

    public boolean destaparCasilla(int fila, int columna) {
        Casilla casilla = casillas[fila][columna];

        if (casilla.isEstaMarcada() || casilla.isEstaDestapada()) {
            return false; // No hacer nada si está marcada o ya destapada
        }

        casilla.setEstaDestapada(true);

        if (casilla.isEsMina()) {
            juegoTerminado = true;
            return true; // Se pisó una mina -> game over
        }

        // Lógica de expansión si la casilla tiene 0 minas adyacentes
        if (casilla.getMinasAdyacentes() == 0) {
            // Expandirse a todas las casillas adyacentes
            for (int i = Math.max(0, fila - 1); i <= Math.min(tamaño - 1, fila + 1); i++) {
                for (int j = Math.max(0, columna - 1); j <= Math.min(tamaño - 1, columna + 1); j++) {
                    if (i == fila && j == columna) continue;
                    if (!casillas[i][j].isEstaDestapada()) {
                        destaparCasilla(i, j); // Llamada recursiva
                    }
                }
            }
        }
        return false;
    }

    public void marcarCasilla(int fila, int columna) {
        Casilla casilla = casillas[fila][columna];
        if (!casilla.isEstaDestapada()) {
            casilla.setEstaMarcada(!casilla.isEstaMarcada()); // Alternar entre marcada/desmarcada
        }
    }

    public boolean haGanado() {
        for (int i = 0; i < tamaño; i++) {
            for (int j = 0; j < tamaño; j++) {
                Casilla casilla = casillas[i][j];
                // Si hay una casilla que no es mina y no está destapada, no se ha ganado
                if (!casilla.isEsMina() && !casilla.isEstaDestapada()) {
                    return false;
                }
            }
        }
        return true;
    }
    // Getters para la interfaz gráfica
    public Casilla[][] getCasillas() {
        return casillas;
    }
    public int getTamaño() {
        return tamaño;
    }
    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}




