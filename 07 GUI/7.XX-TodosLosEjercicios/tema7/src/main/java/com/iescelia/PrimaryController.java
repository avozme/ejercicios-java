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
        // Vamos a abrir una ventana con el mismo nombre que el id
        App.setRoot(id);
    }
}
