package com.iescelia;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class VentanasMultiplesVentana1Controller {

    @FXML
    Button btnCerrar;
    
    @FXML
    private void cerrarVentana() {
        // Obtenemos la ventana actual y la cerramos
        Stage stage = (Stage) btnCerrar.getScene().getWindow();
        stage.close();
    }

    // Aquí iría el resto del código del controlador del ejercicio 1 (tabla de multiplicar)
}



