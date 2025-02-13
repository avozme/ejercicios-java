package com.iescelia;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Ejercicio1Controller {

    @FXML
    Button btnCerrar;
    
    @FXML
    private void cerrarVentana() throws IOException {
        App.setRoot("ventanaPrincipal.fxml");
    }

    // Aquí iría el resto del código del controlador del ejercicio 1 (tabla de multiplicar)
}



