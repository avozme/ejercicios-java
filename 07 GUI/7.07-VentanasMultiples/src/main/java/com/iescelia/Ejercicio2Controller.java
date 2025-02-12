package com.iescelia;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Ejercicio2Controller {

    @FXML
    Button btnCerrar;

    @FXML
    private void cerrarVentana() {
        // Obtenemos la ventana actual y la cerramos
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    // Aquí iría el resto del controlador del ejercicio 2 (lotería primitiva)
}
