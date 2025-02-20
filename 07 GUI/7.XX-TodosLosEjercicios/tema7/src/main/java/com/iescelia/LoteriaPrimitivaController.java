package com.iescelia;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class LoteriaPrimitivaController {
    @FXML
    TextField salida;


    @FXML
    private void generarCombinacion(Event e) {
        String str = "";
        for (int i = 1; i <= 6; i++) {
            str += (int)(Math.random() * 49) + 1 + "  ";
        }
        salida.setText(str);
    }

    @FXML
    private void borrarTabla(Event e) {
        salida.setText("");
    }    
}
