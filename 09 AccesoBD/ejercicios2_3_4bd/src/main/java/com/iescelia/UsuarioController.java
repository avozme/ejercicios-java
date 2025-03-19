/**
 * Controlador de usuarios
 */

package com.iescelia;

import java.io.IOException;
import java.sql.*;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class UsuarioController {

    @FXML
    TableView tableView;                            // TableView para mostrar los datos

    @FXML
    private TableColumn<Usuario, Integer> colId;    // Columna de la tabla para el id

    @FXML
    private TableColumn<Usuario, String> colNick;   // Columna de la tabla para el nick

    @FXML
    private TableColumn<Usuario, String> colEmail;  // Columna de la tabla para el email    

    // Lista de usuarios en un ObservableList en lugar de un ArrayList,
    // para que el TableView se actualice automáticamente al cambiar los datos de la lista.
    private ObservableList<Usuario> listaUsuarios = FXCollections.observableArrayList();

    // En initialize() se inicializa el TableView y se asocia a la lista de usuarios.
    // ¡Esto solo hay que hacerlo una vez!
    public void initialize() {
        // Inicializamos las columnas de la tabla.
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        // Hacemos que las columnas nick y email sean editables (no el id)
        colNick.setCellFactory(TextFieldTableCell.forTableColumn());
        colEmail.setCellFactory(TextFieldTableCell.forTableColumn());

        // Asignamos un manejador de eventos para cuando se editen las celdas de la tabla
        colNick.setOnEditCommit(event -> {
            // Cuando se edita el campo "nick", se guarda automáticamente
            Usuario usuario = event.getRowValue();
            usuario.setNick(event.getNewValue());  // Actualiza el valor de la propiedad 'nick'
            saveRow(usuario);                  // Actualiza la fila en la base de datos
        });        
        colEmail.setOnEditCommit(event -> {
            // Cuando se edita el campo "email", también se guarda automáticamente
            Usuario usuario = event.getRowValue();
            usuario.setEmail(event.getNewValue());  // Actualiza el valor de la propiedad 'email'
            saveRow(usuario);                   // Actualiza la fila en la base de datos
        });        
        // Asignamos la ObservableList de usuarios al TableView. Así, cada vez que cambie la lista,
        // la vista se actualizará automáticamente.
        tableView.setItems(listaUsuarios);
        loadData();    
    }

    // Este método muestra todos los usuarios de la BD en el TableView
    private void loadData() {
        Usuario.getAll(listaUsuarios);   // Llamamos al modelo Usuario
        // Como tenemos el TableView asociado a la ObservableList usuarios, el TableView se actualizará automáticamente
        // al cambiar la lista de usuarios sin necesidad de hacer tableView.setItems(usuarios).
        // Si usuarios fuera un ArrayList convencional, habría que actualizar el tableView cada vez que cambiasen los datos de la lista.
    }

    @FXML
    public void addRow() throws IOException {
        // Creamos un usuario vacío
        Usuario filaVacia = new Usuario(Usuario.getLastId()+1, "", "");

        // Añadimos la fila vacía al ObservableList (esto lo añadirá también al TableView)
        listaUsuarios.add(filaVacia);

        // Seleccionamos la fila recién añadida y hacemos que sea editable
        tableView.getSelectionModel().select(filaVacia);
        tableView.edit(tableView.getSelectionModel().getSelectedIndex(), colNick);
    }


    // Guarda un usuario en la base de datos
    public void saveRow(Usuario usuario) {
        usuario.save();   // Llamamos al modelo Usuario
    }    

    // Elimina un usuario de la base de datos y del TableView
    @FXML
    public void deleteRow() {
        // Pedimos confirmación con un Alert antes de continuar
        Alert a = new Alert(AlertType.CONFIRMATION);
        a.setTitle("Confirmación");
        a.setHeaderText("¿Estás seguro de que quieres borrar este usuario?");
        Optional<ButtonType> result = a.showAndWait();
        if (result.get() == ButtonType.OK) {
            // Obtenemos el usuario seleccionado
            Usuario usuario = (Usuario) tableView.getSelectionModel().getSelectedItem();
            usuario.delete();  // Lo borramos de la base de datos
            listaUsuarios.remove(usuario);  // Lo borramos del ObservableList y del TableView
        }
    }
}
