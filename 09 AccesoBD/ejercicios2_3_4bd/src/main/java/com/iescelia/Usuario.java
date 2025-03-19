/**
 * Modelo de Usuarios
 */

package com.iescelia;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;

public class Usuario {
    private IntegerProperty id;
    private StringProperty nick;
    private StringProperty email;

    public Usuario(int id, String nick, String email) {
        this.id = new SimpleIntegerProperty(id);
        this.nick = new SimpleStringProperty(nick);
        this.email = new SimpleStringProperty(email);
    }

    public IntegerProperty idProperty() {
        return id;
    }

    public StringProperty nickProperty() {
        return nick;
    }

    public StringProperty emailProperty() {
        return email;
    }

    // Getters y Setters
    public int getId() {
        return id.get();
    }

    public void setId(int id) {
        this.id.set(id);
    }

    public String getNick() {
        return nick.get();
    }

    public void setNick(String nick) {
        this.nick.set(nick);
    }

    public String getEmail() {
        return email.get();
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    // Busca todos los usuarios de la BD y los coloca en un ObservableList
    public static void getAll(ObservableList<Usuario> listaUsuarios) {
        Connection con = conectarBD();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios");
            while (rs.next()) {
                Usuario u = new Usuario(rs.getInt("id"), rs.getString("nick"), rs.getString("email"));
                listaUsuarios.add(u);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
    }

    // Devuelve el ID más alto asignado en la BD
    public static int getLastId() {
        Connection con = conectarBD();
        int lastId = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) FROM usuarios");
            if (rs.next()) {
                lastId = rs.getInt(1);
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return lastId;
    }

    // Almacena el usuario en la BD. Devuelve 1 si consigue guardar un registro y 0 si no lo consigue.
    // Si el usuario no existía, lo añade (con INSERT). Si el usuario ya existía, lo modifica (con UPDATE)
    public int save() {
        Connection con = conectarBD();
        int filasAfectadas = 0;
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM usuarios WHERE id=" + this.getId());
            if (rs.next()) {
                // Si el usuario ya existía, lo modificamos
                filasAfectadas = st.executeUpdate("UPDATE usuarios SET nick='" + this.getNick() + "', email='" + this.getEmail() + "' WHERE id=" + this.getId());
            } else {
                // Si el usuario no existía, lo añadimos
                filasAfectadas = st.executeUpdate("INSERT INTO usuarios VALUES (" + this.getId() + ", '" + this.getNick() + "', '" + this.getEmail() + "')");
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return filasAfectadas;
    }

    // Elimina un usuario de la BD. Devuelve 1 si consigue borrar un registro y 0 si no lo consigue.
    public int delete() {
        Connection con = conectarBD();
        int filasAfectadas = 0;
        try {
            Statement st = con.createStatement();
            filasAfectadas = st.executeUpdate("DELETE FROM usuarios WHERE id=" + this.getId());
            con.close();
        } catch (Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return filasAfectadas;
    }


    // Intenta conectar con la base de datos y devuelve un objeto Connection o null si no consigue conectar
    private static Connection conectarBD() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://iescelia.org/evaluacion_lomloe", "usrPrueba2", "N3e4wu9*");
        } catch (Exception e) {
            System.out.println("Error de SQL: " + e.getMessage());
        }
        return con;
    }

}
