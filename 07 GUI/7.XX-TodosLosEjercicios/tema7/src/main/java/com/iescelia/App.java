package com.iescelia;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 400, 480);
        stage.setScene(scene);
        stage.setResizable(false); // Deshabilita el cambio de tamaño de la ventana
        stage.setMaximized(false); // Deshabilita la maximización de la ventana
        stage.show();
    }

    // Este método carga otra escena FXML y la establece como raíz de la ventana.
    // Devuelve el controlador del FXML cargado.
    static Object setRoot(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        Parent root = fxmlLoader.load();
        scene.setRoot(root);

        // Devolver el controlador del FXML cargado
        return fxmlLoader.getController();
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}