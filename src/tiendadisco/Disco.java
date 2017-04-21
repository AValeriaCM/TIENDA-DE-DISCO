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
public class Disco {
    
    private String nombreDisco;
    private String precio;
    private List<Cancion> cancion;

    public Disco(String nombreDisco, String precio) {
        this.nombreDisco = nombreDisco;
        this.precio = precio;
        this.cancion = new ArrayList<Cancion>();
    }

    public String getNombreDisco() {
        return nombreDisco;
    }

    public void setNombreDisco(String nombreDisco) {
        this.nombreDisco = nombreDisco;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public List<Cancion> getCancion() {
        return cancion;
    }

    public void setCancion(List<Cancion> cancion) {
        this.cancion = cancion;
    }


}
