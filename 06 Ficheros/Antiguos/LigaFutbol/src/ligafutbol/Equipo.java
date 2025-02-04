/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ligafutbol;

import java.io.*;

/**
 * Esta clase representa a cada uno de los equipos de la liga de fútbol.
 */
public class Equipo {
    String nombre;
    int jugados, ganados, empatados, perdidos;
    boolean borrado;
    public static final int TAM_REGISTRO = 39;

    public Equipo() {
        nombre = "Desconocido";
        jugados = 0;
        ganados = 0;
        empatados = 0;
        perdidos = 0;
        borrado = false;
    }

    public Equipo(String nombre, int jugados, int ganados, int empatados, int perdidos) {
        this.nombre = nombre;
        this.jugados = jugados;
        this.ganados = ganados;
        this.empatados = empatados;
        this.perdidos = perdidos;
        this.borrado = false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getJugados() {
        return jugados;
    }

    public void setJugados(int jugados) {
        this.jugados = jugados;
    }

    public int getGanados() {
        return ganados;
    }

    public void setGanados(int ganados) {
        this.ganados = ganados;
    }

    public int getEmpatados() {
        return empatados;
    }

    public void setEmpatados(int empatados) {
        this.empatados = empatados;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }

    public boolean isBorrado() {
        return borrado;
    }

    public void setBorrado(boolean borrado) {
        this.borrado = borrado;
    }
    
    public int getPuntos() {
        return ganados * 3 + empatados;
    }

    /**
     * Escribe el equipo en un stream
     * @param os El stream que apunta al fichero de datos
     */
    public void saveToFile(DataOutputStream os) {
        try {
            // Forzamos que el nombre tenga siempre 20 caracteres
            // para tener registros de longitud fija
            String nombre20caract = String.format("%-20s", nombre);
            os.writeUTF(nombre20caract);
            os.writeInt(jugados);
            os.writeInt(ganados);
            os.writeInt(empatados);
            os.writeInt(perdidos);
            os.writeBoolean(borrado);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }

    /**
     * Escribe el equipo en un RandomAccessFile
     * 
     * @param raf El RandomAccessFile que apunta al fichero
     */
    public void saveToFile(RandomAccessFile raf) {
        try {
            // Forzamos que el nombre tenga siempre 20 caracteres
            // para tener registros de longitud fija
            String nombre20caract = String.format("%-20s", nombre);
            raf.writeUTF(nombre20caract);
            raf.writeInt(jugados);
            raf.writeInt(ganados);
            raf.writeInt(empatados);
            raf.writeInt(perdidos);
            raf.writeBoolean(borrado);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    /**
     * Carga el equipo desde un stream
     * @param is El stream que apunta al fichero de entrada
     */
    public void loadFromFile(DataInputStream is) {
        try {
            nombre = is.readUTF();
            jugados = is.readInt();
            ganados = is.readInt();
            empatados =  is.readInt();
            perdidos = is.readInt();
            borrado = is.readBoolean();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Carga el equipo desde un RandomAccessFile
     * 
     * @param raf El RandomAccessFile que apunta al fichero de datos
     */
    public void loadFromFile(RandomAccessFile raf) {
        try {
            nombre = raf.readUTF();
            jugados = raf.readInt();
            ganados = raf.readInt();
            empatados =  raf.readInt();
            perdidos = raf.readInt();
            borrado = raf.readBoolean();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
}
