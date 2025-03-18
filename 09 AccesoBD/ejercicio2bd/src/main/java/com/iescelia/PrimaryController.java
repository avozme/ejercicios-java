package com.iescelia;

import java.io.IOException;
import java.sql.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

public class PrimaryController {

    @FXML
    TextArea textArea;                              // TextArea para mostrar los datos

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
    private ObservableList<Usuario> usuarios = FXCollections.observableArrayList();

    // En initialize() se inicializa el TableView y se asocia a la lista de usuarios.
    // ¡Esto solo hay que hacerlo una vez!
    public void initialize() {
        // Inicializamos las columnas de la tabla.
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colNick.setCellValueFactory(new PropertyValueFactory<>("nick"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colNick.setOnEditCommit(event -> {
            // Cuando se edita el campo "nick", se guarda automáticamente
            Usuario usuario = event.getRowValue();
            usuario.setNick(event.getNewValue());  // Actualiza el valor de la propiedad 'nick'
    
            // Guardar la fila en la base de datos
            guardarFila(usuario);
        });        
        // Asignamos la ObservableList de usuarios al TableView. Así, cada vez que cambie la lista,
        // la vista se actualizará automáticamente.
        tableView.setItems(usuarios);        
    }

    // Este método lanza una consulta a la BD y muestra los datos por la consola de texto
    @FXML
    private void loadDataConsole() throws IOException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://iescelia.org/evaluacion_lomloe", "user", "password");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                System.out.println(rs.getString("id") + " - " + rs.getString("nick") + " - " + rs.getString("email"));
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
    }

    // Este método lanza una consulta a la BD y muestra los datos en un TextArea
    @FXML
    private void loadDataTextArea() throws IOException {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://iescelia.org/evaluacion_lomloe", "celia360_user", "Ksav9p88");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            textArea.clear();
            while (rs.next()) {
                textArea.appendText(rs.getString("id") + " - " + rs.getString("nick") + " - " + rs.getString("email") + "\n");
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }    
    }

    // Este método lanza una consulta a la BD y muestra los datos en un TableView
    @FXML
    private void loadDataTableView() throws IOException {

        // Como tenemos el TableView asociado a la ObservableList usuarios, el TableView se actualizará automáticamente 
        // al cambiar la lista de usuarios sin necesidad de hacer tableView.setItems(usuarios).
        // Si usuarios fuera un ArrayList convencional, habría que actualizar el tableView cada vez que cambiasen los datos de la lista.

        // Rellenamos la lista de usuarios con la información de la BD
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://iescelia.org/evaluacion_lomloe", "celia360_user", "Ksav9p88");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nick"), rs.getString("email"));
                usuarios.add(u);
            }
            con.close();
        }
        catch(Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }    

    }

    @FXML
    public void addRowToTableView() throws IOException {
        // Creamos un usuario vacío
        Usuario filaVacia = new Usuario(0, "", "");

        // Añadir la fila vacía al ObservableList (esto lo añadirá también al TableView)
        usuarios.add(filaVacia);

        // Seleccionamos la fila recién añadida
        tableView.getSelectionModel().select(filaVacia);

        // Hacemos que esa fila sea editable
        tableView.edit(tableView.getSelectionModel().getSelectedIndex(), colNick);
    }


    // Método para guardar la fila cuando el usuario la complete
    public void guardarFila(Usuario usuario) {
        // Aquí puedes hacer lo que necesites, como insertar en la base de datos
        // Agregar el nuevo usuario a la base de datos
        insertarUsuarioEnBD(usuario);

        // Luego puedes quitar la fila vacía si fue editada y guardada correctamente
        if (usuario.getId() == 0) {
            usuarios.remove(usuario);  // Eliminar la fila vacía si es necesario
        }
    }

    private void insertarUsuarioEnBD(Usuario usuario) {
        // Lógica para insertar el usuario en la base de datos
    }    
}
