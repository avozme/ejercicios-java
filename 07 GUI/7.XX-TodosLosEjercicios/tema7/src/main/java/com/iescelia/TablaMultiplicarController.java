package com.iescelia;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class TablaMultiplicarController {
    @FXML
    TextField numero;

    @FXML
    TextArea salida;

    @FXML
    private void mostrarTabla(Event e) {
        String tabla = "";
        int n = Integer.parseInt(numero.getText());
        for (int i = 1; i <= 10; i++) {
            tabla += n + " x " + i + " = " + (n*i) + "\n";
        }
        salida.setText(tabla);
    }

    @FXML
    private void borrarTabla(Event e) {
        salida.setText("");
    }    

    public void setNumero(String s) {
        numero.setText(s);;
    }
}
