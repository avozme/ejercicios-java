package com.iescelia;

import java.io.FileOutputStream;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class VentanaPrincipalController {
    @FXML
    TextField headerText, headerSize, headerColor, headerFont;

    @FXML
    TextField bodyText, bodySize, bodyColor, bodyFont;

    @FXML
    private void generarHTML(Event e) {
    try {
      FileOutputStream fos = new FileOutputStream("pagina.html");
      
      fos.write("<html>\n\t<head>\n\t\t<meta charset='UTF-8'>\n\t\t<title>Ejemplo Java</title>\n\t</head>\n".getBytes());
      fos.write(("<body><p style = 'font-size: " + headerSize.getText() + " ; color:" + headerColor.getText() + "; " + 
                  "font-family: " + headerFont.getText() + "'>" + headerText.getText() + "</p>").getBytes());
                 
      fos.write(("<p style = 'color:" + bodyColor.getText() + "; font-size: " + bodySize.getText() + "; " + 
                 "font-family: " + bodyFont.getText() + "'>" + bodyText.getText() + "</p></body></html>").getBytes());
      fos.close();
    }
    catch (Exception ex) { 
      System.out.println("Error al escribir el fichero de salida: " + ex.getMessage()); 
    }

    }

    @FXML
    private void resetearFormulario(Event e) {
        headerText.setText("");
        headerSize.setText("");
        headerColor.setText("");
        headerFont.setText("");

        bodyText.setText("");
        bodySize.setText("");
        bodyColor.setText("");
        bodyFont.setText("");
    }    
}
