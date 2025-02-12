package com.iescelia;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;

public class VentanaPrincipalController {

    @FXML
    private VBox contenedor;  // Contenedor donde se cargarán las vistas

    @FXML
    private void abrirNuevaVentana(javafx.event.Event e) {
        String ventana = "";
        
        // Determinamos qué botón se presionó y cargamos la vista correspondiente
        if (((Button) e.getSource()).getId().equals("btnEjercicio1")) {
            ventana = "ejercicio1.fxml";
        } else if (((Button) e.getSource()).getId().equals("btnEjercicio2")) {
            ventana = "ejercicio2.fxml";
        }

        cargarVista(ventana);
    }

    // Método para cargar la vista seleccionada en el VBox
    public void cargarVista(String archivoFXML) {
        try {
            // Cargar el archivo FXML de la nueva vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource(archivoFXML));
            Parent vista = loader.load();

            // Limpiar el contenedor
            contenedor.getChildren().clear();

            // Añadir la nueva vista al contenedor
            contenedor.getChildren().add(vista);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
