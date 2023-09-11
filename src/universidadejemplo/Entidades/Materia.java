/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Entidades;

/**
 *
 * @author Marcoooooo
 */
public class Materia {
    
    int idmateria;
    String nombre;
    int aniomateria;
    boolean activo;

    public Materia() {
    }

    public Materia(int idmateria, String nombre, int aniomateria, boolean activo) {
        this.idmateria = idmateria;
        this.nombre = nombre;
        this.aniomateria = aniomateria;
        this.activo = activo;
    }

    public Materia(String nombre, int aniomateria, boolean activo) {
        this.nombre = nombre;
        this.aniomateria = aniomateria;
        this.activo = activo;
    }

    public int getIdmateria() {
        return idmateria;
    }

    public void setIdmateria(int idmateria) {
        this.idmateria = idmateria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAniomateria() {
        return aniomateria;
    }

    public void setAniomateria(int aniomateria) {
        this.aniomateria = aniomateria;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Materia{" + "idmateria=" + idmateria + ", nombre=" + nombre + ", aniomateria=" + aniomateria + ", activo=" + activo + '}';
    }
    
    
    
}
