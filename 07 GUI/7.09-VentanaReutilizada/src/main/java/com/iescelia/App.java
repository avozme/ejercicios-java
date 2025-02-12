package com.iescelia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class App extends Application {

    private static Scene scene;  // Contenedor base de la aplicación

    // Método de inicio de cualquier aplicación JavaFX
    @Override
    public void start(Stage stage) throws IOException {
        // Crea una Scene a partir de un archivo FXML y la muestra en la ventana (stage)
        scene = new Scene(loadFXML("ventanaPrincipal.fxml"), 400, 450);
        stage.setScene(scene);
        stage.show();
    }

    // Método para cambiar la vista de la aplicación en cualquier momento
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    // Parent es la clase base de la jerarquía de JavaFX. Representa un nodo en la escena de la interfaz de usuario.
    // Al devolverlo aquí, significa que este método puede devolver cualquier nodo de la interfaz de usuario.
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}