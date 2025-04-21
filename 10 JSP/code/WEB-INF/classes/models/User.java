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

    // Constructor
    public User(int id, String username, String email, String firstName, String lastName, String githubUrl, String photo) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.githubUrl = githubUrl;
        this.photo = photo;
    }

    // Getters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGithubUrl() { return githubUrl; }
    public String getPhoto() { return photo; }

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
}