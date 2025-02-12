package com.iescelia;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class Ejercicio1Controller {

    @FXML
    Button btnCerrar;
    
    @FXML
    private void cerrarVentana() {
        // Limpiar el contenedor y restaurar el contenido original
        VentanaPrincipalController controladorPrincipal = new VentanaPrincipalController();
        controladorPrincipal.cargarVista("ventanaPrincipal.fxml");
    }

    // Aquí iría el resto del código del controlador del ejercicio 1 (tabla de multiplicar)
}



