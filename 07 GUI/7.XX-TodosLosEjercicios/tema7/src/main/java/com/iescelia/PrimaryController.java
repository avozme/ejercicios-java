package com.iescelia;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;

public class PrimaryController {

    @FXML
    private void abrirEjercicio(Event e) throws IOException {
        // Vamos a mirar el id del menú item que ha sido pulsado
        String id = ((MenuItem)e.getSource()).getId();
        System.out.println("Abriendo " + id + ".fxml");
        // Vamos a abrir una ventana con el mismo nombre que el id. Para eso, he tenido la precaución
        // de que los archivos fxml se llamen igual que el id de cada MenuItem
        App.setRoot(id);
    }

    @FXML
    private void salir() throws IOException {
        System.exit(0);
    }
}
