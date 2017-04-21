/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tiendadisco;

/**
 *
 * @author Angie Castañeda
 */
public class Cancion {
    
    private String nombreCancion;
    private String duracion;

    public Cancion(String nombreCancion, String duracion) {
        this.nombreCancion = nombreCancion;
        this.duracion = duracion;
    }

    public String getNombreCancion() {
        return nombreCancion;
    }

    public void setNombreCancion(String nombreCancion) {
        this.nombreCancion = nombreCancion;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }
    
    
    
}
