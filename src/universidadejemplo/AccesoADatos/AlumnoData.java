/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;


import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

import static java.awt.image.ImageObserver.WIDTH;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.SpringLayout.WIDTH;

import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Vistas.alumnos;

/**
 *
 * @author Marcoooooo
 */
public class AlumnoData {
    Conexion con;
     
     private String guardar;

    public AlumnoData() {
       
    }
    
    

   
    
   
    
 
   public Alumno BuscarAlumno(int id){
    
    Alumno alumno = null;
 String sql = "SELECT dni, apellido, nombre, fechaNacimiento FROM alumno WHERE idAlumno = ? AND estado = 1";
 PreparedStatement ps = null;
 try {
 ps = con.prepareStatement(sql);
 //carga bd ob
 ps.setInt(1,id );
 ResultSet rs = ps.executeQuery();

 if (rs.next()) {
alumno=new Alumno();
alumno.setIdalumno(id);
alumno.setDni(rs.getInt("dni"));
alumno.setApellido(rs.getString("apellido"));
alumno.setNombre(rs.getString("nombre"));
alumno.setFechadenacimiento(rs.getDate("fechadenacimiento").toLocalDate());
alumno.setEstado(true);


 } else {
 JOptionPane.showMessageDialog(null, "No existe el alumno");



 ps.close();
 }
 } 
 catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage()); 

}
 return alumno;
}
    

    
  public Alumno BuscarAlumnoPordni(int dni){
    
    
    
    
    
Alumno alumno = null;
 String sql = "SELECT idAlumno, dni, apellido, nombre, fechaNacimiento FROM alumno WHERE dni=? AND estado = 1";
 PreparedStatement ps = null;
 try {
 ps = con.prepareStatement(sql);
 ps.setInt(1,dni );
 ResultSet rs = ps.executeQuery();

 if (rs.next()) {
 alumno=new Alumno();
 alumno.setIdalumno(rs.getInt("idAlumno"));
 alumno.setDni(rs.getInt("dni"));
 alumno.setApellido(rs.getString("apellido"));
 alumno.setNombre(rs.getString("nombre"));
 alumno.setFechadenacimiento(rs.getDate("fechaNacimiento").toLocalDate());
 alumno.setEstado(true);


 } else {
 JOptionPane.showMessageDialog(null, "No existe el alumno"); 

}
 ps.close();
} catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage());
}

return alumno;
}
    
    
    
 
       
public ArrayList listarAlumnos() {

    ArrayList alumnos = new ArrayList();
    try {
         String sql = "SELECT * FROM alumno WHERE estado = 1 ";
        Connection con = Conexion.Conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
        Alumno alumno = new Alumno();

        alumno.setIdalumno(rs.getInt("idAlumno"));
        alumno.setDni(rs.getInt("dni"));
        alumno.setApellido(rs.getString("apellido"));
        alumno.setNombre(rs.getString("nombre"));
        alumno.setFechadenacimiento(rs.getDate("fechaNacimiento").toLocalDate());
        alumno.setEstado(rs.getBoolean("estado"));
        alumnos.add(alumno);
            }
        ps.close();


    } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
 }
 return alumnos;
   
       
       
   }
    
     public void ModificarAlumno(Alumno alumno){
        String sql = "UPDATE alumno SET dni = ? , apellido = ?, nombre = ?, fechadenacimiento = ? WHERE idAlumno = ?";
 PreparedStatement ps = null;

try {
 ps = con.prepareStatement(sql);
 ps.setInt(1, alumno.getDni());
ps.setString(2, alumno.getApellido());
 ps.setString(3, alumno.getNombre());
 ps.setDate(4, Date.valueOf(alumno.getFechadenacimiento()));
 ps.setInt(5, alumno.getIdalumno());
 int exito = ps.executeUpdate();

if (exito == 1) {
 JOptionPane.showMessageDialog(null, "Modificado Exitosamente.");
 } else {
 JOptionPane.showMessageDialog(null, "El alumno no existe");
 }

} catch (SQLException ex) {
JOptionPane.showMessageDialog(null, "Error al acceder a la tabla Alumno "+ex.getMessage()); 
         
}    
        
    }
     
     public void EliminarAlumno(JTextField txtId){
         alumnos alu = new alumnos();
         
   String sql = "UPDATE alumno SET estado = 0 WHERE idAlumno = ?";
   
  try {
 
 PreparedStatement ps = con.prepareStatement(sql);

 int fila=ps.executeUpdate();
ps.setString(1,txtId.getText());
      System.out.println(""+fila);
if(fila==1){
 JOptionPane.showMessageDialog(null, " Se eliminó el alumno.");
}
ps.close();
 } catch (SQLException e) {
    JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno");    
         
}   
         
     }

    
      
    }
   

   
    
    
    
    
    

