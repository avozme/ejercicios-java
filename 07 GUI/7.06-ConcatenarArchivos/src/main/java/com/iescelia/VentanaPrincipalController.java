package com.iescelia;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.scene.control.Label;
import javafx.scene.control.Button;

public class VentanaPrincipalController {

  @FXML
  Label archivoEntrada1, archivoEntrada2, archivoSalida;

  File archivo1, archivo2, archivo3; // Los dos archivos de entrada y el de salida

  /**
   * Selecciona el primer archivo de entrada
   */
  @FXML
  private void seleccionarArchivoEntrada1(Event e) {
    archivo1 = seleccionarArchivo(e);
    // Si se ha seleccionado algún archivo, actualizamos el Label con la ruta
    if (archivo1 != null) {
      archivoEntrada1.setText(archivo1.getAbsolutePath());
    }
  }

  /**
   * Selecciona el segundo archivo de entrada
   */
  @FXML
  private void seleccionarArchivoEntrada2(Event e) {
    archivo2 = seleccionarArchivo(e);
    // Si se ha seleccionado algún archivo, actualizamos el Label con la ruta
    if (archivo2 != null) {
      archivoEntrada1.setText(archivo2.getAbsolutePath());
    }
  }

  /**
   * Método auxiliar para el selector de archivos.
   * Abre el cuadro de diálogo para seleccionar un archivo y devuelve un File con el archivo elegido.
   */
  private File seleccionarArchivo(Event e) {
    // Obtenemos la referencia de la ventana principal (stage)
    Stage stage = (Stage) archivoEntrada1.getScene().getWindow();
    // Creamos cuadro de diálogo para seleccionar archivo y establecemos el tipo a
    // archivos de texto
    FileChooser fileChooser = new FileChooser();
    fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));

    // Abrimos el cuadro de diálogo y obtener el archivo seleccionado
    File archivo = fileChooser.showOpenDialog(stage);
    return archivo;
  }


  /**
   * Selecciona el archivo de salida
   */
  @FXML
  private void seleccionarArchivoSalida(Event e) {
      // Creamos el cuadro de diálogo para seleccionar archivo
      FileChooser fileChooser = new FileChooser();
      fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Archivos de Texto", "*.txt"));
      
      // Obtenemos la referencia de la ventana principal (stage)
      Stage stage = (Stage) archivoSalida.getScene().getWindow();
      
      // Abrimos el cuadro de diálogo para seleccionar o crear el archivo de salida (showSaveDialog)
      File archivoSeleccionado = fileChooser.showSaveDialog(stage);
      
      // Si se selecciona un archivo, actualizamos el Label correspondiente
      if (archivoSeleccionado != null) {
          archivo3 = archivoSeleccionado;
          archivoSalida.setText(archivoSeleccionado.getAbsolutePath());
      }
  }
  

  /**
   * Realiza la unión de los archivos: abre los dos archivos de entrada
   * y los envía uno tras otro a la salida.
   */
  @FXML
  private void fusionarArchivos(Event e) {
    if (archivo1 != null && archivo2 != null && archivo3 != null) {
      try {
        FileReader fi1 = new FileReader(archivo1);
        FileReader fi2 = new FileReader(archivo2);
        FileWriter fo = new FileWriter(archivo3);
        char[] c = new char[1024]; // Leeremos bloques de hasta 1024 bytes para ir más rápido
        int i;
        String s = null;

        System.out.println("Voy a procesar el primer archivo");
        // Vamos leyendo el archivo de entrada de 1024 en 1024 bytes y poniéndolo todo en un String
        while (fi1.read(c, 0, 1024) != -1) { 
          s = s + new String(c);
        }
        fo.write(s);   // Enviamos el String al archivo de salida

        // Hacemos lo mismo con el segundo archivo de entrada
        System.out.println("Voy a procesar el segundo archivo");
        while ((i = fi2.read()) != -1) {
          fo.write(i);
        }

        fi1.close();
        fi2.close();
        fo.close();
        System.out.println("He creado el fichero fusionado con éxito");
      } catch (Exception ex) {
        ex.printStackTrace();
      }

    }
  }
}
