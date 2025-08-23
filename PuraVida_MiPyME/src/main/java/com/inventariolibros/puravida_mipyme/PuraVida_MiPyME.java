/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.inventariolibros.puravida_mipyme;
import javax.swing.*;
/**
 *
 * @author Yader
 */
public class PuraVida_MiPyME {

    public static void main(String[] args) {
           SwingUtilities.invokeLater(() -> {
            try {
                // Aquí iría la inicialización de la GUI
                // Por ahora, solo lanzamos las pruebas
                tests.MiniTestRunner.main(args);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
    }

