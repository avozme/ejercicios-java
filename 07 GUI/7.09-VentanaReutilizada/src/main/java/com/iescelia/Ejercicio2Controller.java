package com.iescelia;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Ejercicio2Controller {

    @FXML
    Button btnCerrar;

    @FXML
    private void cerrarVentana() throws IOException {
        App.setRoot("ventanaPrincipal.fxml");
    }

    // Aquí iría el resto del controlador del ejercicio 2 (lotería primitiva)
}
