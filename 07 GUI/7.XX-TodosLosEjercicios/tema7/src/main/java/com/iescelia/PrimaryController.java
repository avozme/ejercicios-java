package com.iescelia;

import java.io.IOException;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class PrimaryController {
    @FXML
    private TextField texto;
    
    // Este método abre otro FXML y lo establece como raíz de la ventana.
    // El nombre del FXML lo tomamos de la propiedad id del MenuItem que ha sido pulsado.
    @FXML
    private void abrirEjercicio(Event e) throws IOException {
        // Vamos a mirar el id del menú item que ha sido pulsado
        String id = ((MenuItem)e.getSource()).getId();
        // Vamos a abrir una ventana con el mismo nombre que el id. Para eso, he tenido la precaución
        // de que los archivos fxml se llamen igual que el id de cada MenuItem
        App.setRoot(id);
    }

    // Este método solo sirve para abrir el FXML de la tabla de multiplicar.
    // A modo de ejemplo, le inyectaremos el contenido de un campo de texto para aprender
    // a pasar datos entre controladores.
    @FXML
    private void abrirTablaMultiplicarConDatos(Event e) throws IOException {
        TablaMultiplicarController tablaController = (TablaMultiplicarController) App.setRoot("tablaMultiplicar");
        tablaController.setNumero(texto.getText());
    }      

    @FXML
    private void salir() throws IOException {
        System.exit(0);
    }
}
