package com.iescelia;

import javafx.fxml.FXML;
import javafx.stage.Stage;
import javafx.scene.control.Button;

public class Ejercicio2Controller {

    @FXML
    Button btnCerrar;

    @FXML
    private void cerrarVentana() {
        // Limpiar el contenedor y restaurar el contenido original
        VentanaPrincipalController controladorPrincipal = new VentanaPrincipalController();
        controladorPrincipal.cargarVista("ventanaPrincipal.fxml");
    }

    // Aquí iría el resto del controlador del ejercicio 2 (lotería primitiva)
}
