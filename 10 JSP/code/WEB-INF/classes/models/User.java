// MODELO DE USUARIOS
package models;
import java.sql.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class User {
    private int id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
    private String githubUrl;
    private String photo;

    // Constructor con id (para usuarios ya existentes en la BD)
    public User(int id, String username, String email, String firstName, String lastName, String githubUrl, String photo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.githubUrl = githubUrl;
        this.photo = photo;
    }

    // Constructor sin id (para usuarios nuevos)
    public User(String username, String email, String firstName, String lastName, String githubUrl, String photo) {
        this.id = User.getLastId() + 1; // ID se asignará automáticamente en la BD
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.githubUrl = githubUrl;
        this.photo = photo;
    }

    // Constructor vacío
    public User() {
        this.id = 0;
        this.username = "";
        this.email = "";
        this.firstName = "";
        this.lastName = "";
        this.githubUrl = "";
        this.photo = "";
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGithubUrl() { return githubUrl; }
    public String getPhoto() { return photo; }

    // Método para obtener el último ID de la tabla Users
    public static int getLastId() {
        int lastId = 0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT MAX(id) AS maxId FROM Users");

            if (rs.next()) {
                lastId = rs.getInt("maxId");
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return lastId;
    }


    // Método estático para obtener todos los usuarios desde la BD
    public static List<User> getAll() {
        List<User> users = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users");

            while (rs.next()) {
                users.add(new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("github_url"),
                    rs.getString("photo")
                ));
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return users;
    }

    // Método estático para obtener un usuario a partir de su ID
    public static User getById(int id) {
        User user = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE id = " + id);

            if (rs.next()) {
                user = new User(
                    rs.getInt("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("first_name"),
                    rs.getString("last_name"),
                    rs.getString("github_url"),
                    rs.getString("photo")
                );
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    // Método para almacenar en la BD el usuario actual.
    // Si no existe, lo crea. Si existe, lo actualiza.
    // Devuelve true si se ha creado o actualizado correctamente, false en caso contrario.
    public boolean save() {
        boolean correcto = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
            Statement st = conn.createStatement();
            // Vamos a comprobar si el usuario ya existe
            ResultSet rs = st.executeQuery("SELECT * FROM Users WHERE id = " + id);

            if (rs.next()) {
                // Usuario ya existe. Lo actualizamos.
                String sql = "UPDATE Users SET username = '" + username + "', email = '" + email + "', first_name = '" + firstName + "', last_name = '" + lastName + "', github_url = '" + githubUrl + "', photo = '" + photo + "' WHERE id = " + id;
                int ok = st.executeUpdate(sql);
                if (ok == 1) correcto = true;
            }
            else {
                // Usuario no existe. Lo creamos.
                String sql = "INSERT INTO Users (username, email, first_name, last_name, github_url, photo) VALUES ('" + username + "', '" + email + "', '" + firstName + "', '" + lastName + "', '" + githubUrl + "', '" + photo + "')";
                int ok = st.executeUpdate(sql);
                if (ok == 1) correcto = true;
            }

            rs.close();
            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;
    }

    // Método para eliminar un usuario de la BD
    // Devuelve true si se ha eliminado correctamente, false en caso contrario.
    public static boolean delete(int id) {
        boolean correcto = false;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql:3306/pruebasJSP", "root", "");
            Statement st = conn.createStatement();

            // Vamos a intentar borrar el usuario
            int ok = st.executeUpdate("DELETE FROM Users WHERE id = " + id);
            if (ok == 1) correcto = true;

            st.close();
            conn.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return correcto;
    } 
}