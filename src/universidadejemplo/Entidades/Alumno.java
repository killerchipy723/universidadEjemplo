/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.Entidades;

import java.time.LocalDate;

/**
 *
 * @author scscl
 */
public class Alumno {
    
    int idalumno;
    String nombre;
    String apellido;
    LocalDate fechadenacimiento;
    boolean activo;

    public Alumno(int idalumno, String nombre, String apellido, LocalDate fechadenacimiento, boolean activo) {
        this.idalumno = idalumno;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechadenacimiento = fechadenacimiento;
        this.activo = activo;
    }

    public Alumno(String nombre, String apellido, LocalDate fechadenacimiento, boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechadenacimiento = fechadenacimiento;
        this.activo = activo;
    }

    public int getIdalumno() {
        return idalumno;
    }

    public void setIdalumno(int idalumno) {
        this.idalumno = idalumno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public LocalDate getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(LocalDate fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    @Override
    public String toString() {
        return "Alumno{" + "idalumno=" + idalumno + ", nombre=" + nombre + ", apellido=" + apellido + ", fechadenacimiento=" + fechadenacimiento + ", activo=" + activo + '}';
    }
    
    
    
    
    
}
