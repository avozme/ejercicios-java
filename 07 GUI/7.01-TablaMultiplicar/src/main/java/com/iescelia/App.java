package com.iescelia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

// Clase inicial de la aplicación JavaFX
public class App extends Application {

    private static Scene scene;  // Usaremos esta variable para cambiar la vista de la aplicación, si es necesario

    // Método de inicio de la aplicación JavaFX
    @Override
    public void start(Stage stage) throws IOException {
        // Creamos una Scene a partir de un archivo FXML y la muestramos en la ventana (stage)
        scene = new Scene(loadFXML("ventanaPrincipal.fxml"), 400, 450);
        stage.setTitle("Tabla de multiplicar");
        stage.setScene(scene);
        stage.show();
    }

    // Método para cambiar la vista de la aplicación en cualquier momento.
    // Puedes llamarlo con App.setRoot() desde cualquier controlador cuando lo necesites.
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Método para cargar un archivo FXML y devolverlo como un nodo de la interfaz de usuario
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    // Método main. Lanza la aplicación JavaFX.
    public static void main(String[] args) {
        launch();
    }
}