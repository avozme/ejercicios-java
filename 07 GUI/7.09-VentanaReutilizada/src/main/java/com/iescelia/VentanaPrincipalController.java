package com.iescelia;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class VentanaPrincipalController {

    @FXML
    private VBox contenedor;  // Contenedor donde se cargarán las vistas

    @FXML
    private void abrirNuevaVentana(javafx.event.Event e) throws IOException {
        String ventana = "";
        
        // Determinamos qué botón se presionó y cargamos la vista correspondiente
        if (((Button) e.getSource()).getId().equals("btnEjercicio1")) {
            App.setRoot("ejercicio1.fxml");
        } else if (((Button) e.getSource()).getId().equals("btnEjercicio2")) {
            App.setRoot("ejercicio1.fxml");
        }
    }

}
