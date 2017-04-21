/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Angie Castañeda
 */
public class Artista {
    
    private String nombre;
    private Genero genero;
    private Nacionalidad nacionalidad;
    private List<Disco> disco;

    public Artista(String nombre, Genero genero, Nacionalidad nacionalidad) {
        this.nombre = nombre;
        this.genero = genero;
        this.nacionalidad = nacionalidad;
        this.disco = new ArrayList<Disco>();        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Nacionalidad getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(Nacionalidad nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public List<Disco> getDisco() {
        return disco;
    }

    public void setDisco(List<Disco> disco) {
        this.disco = disco;
    }
    

}
