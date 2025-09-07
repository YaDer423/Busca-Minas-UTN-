/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package buscaminasutn;

/**
 *
 * @author Yader
 */
public class Casilla {
    private boolean esMina;
    private boolean estaDestapada;
    private boolean estaMarcada;
    private int minasAdyacentes;

    public Casilla() {
        this.esMina = false;
        this.estaDestapada = false;
        this.estaMarcada = false;
        this.minasAdyacentes = 0;
    }

    // Getters y Setters (¡Genera estos automáticamente en NetBeans!
    // Botón derecho > Insert Code > Getter and Setter > Selecciona todos)
    public boolean isEsMina() {
        return esMina;
    }
    public void setEsMina(boolean esMina) {
        this.esMina = esMina;
    }
    public boolean isEstaDestapada() {
        return estaDestapada;
    }
    public void setEstaDestapada(boolean estaDestapada) {
        this.estaDestapada = estaDestapada;
    }
    // ... (otros getters y setters)
    public int getMinasAdyacentes() {
        return minasAdyacentes;
    }
    public void setMinasAdyacentes(int minasAdyacentes) {
        this.minasAdyacentes = minasAdyacentes;
    }
}
