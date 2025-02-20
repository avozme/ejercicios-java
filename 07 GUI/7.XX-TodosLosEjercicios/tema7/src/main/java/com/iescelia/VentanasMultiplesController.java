package com.iescelia;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class VentanasMultiplesController {

    @FXML
    private void abrirNuevaVentana(Event e) {
        Button btn = (Button) e.getSource();  // Averiguamos qué botón se pulsó
        String ventana = "";
        // Según el botón que se pulsó, abrimos una ventana u otra
        if (btn.getId().equals("btn1")) {
            ventana = "ventanasMultiplesVentana1.fxml";
        } else if (btn.getId().equals("btn2")) {
            ventana = "ventanasMultiplesVentana2.fxml";
        }
        // Abrimos la ventana del ejercicio seleccionado
        try {
            // Cargamos el archivo FXML de la nueva ventana
            FXMLLoader loader = new FXMLLoader(getClass().getResource(ventana));
            Parent root = loader.load();

            // Creamos la nueva ventana (Stage)
            Stage nuevaVentana = new Stage();
            nuevaVentana.setTitle("Ventana Secundaria");
            nuevaVentana.setScene(new Scene(root));
            nuevaVentana.show();  

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
