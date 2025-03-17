package com.iescelia;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;

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
}
