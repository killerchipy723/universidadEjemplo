/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.Entidades.Materia;
import universidadejemplo.Vistas.formInscripcion;

/**
 *
 * @author Marcoooooo
 */
public class MateriaData {
    
    Conexion con;

    public MateriaData() {
    }
    
    public void guardarMateria(Materia materia){
        
    }
    //public Materia buscarMateria(int id ){
        
   // }
    
    public void modificarMateria(Materia materia){
        
    }
    
    public void eliminarMateria(int id){
        
    }
    
//    public List <Materia> listarmateria(){
        
  //  }
    
    public DefaultTableModel mostrarMaterias()
    {
        String []  nombresColumnas = {"id","Nombre","Año"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM materia";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.Conectar();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("idMateria");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("año");
                
                    
                
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
 
  public List <Materia> listarMaterias ()   {
      
  
      List<Materia> materias = new ArrayList<>();
      
      
      try {
 String sql = "SELECT * FROM materia WHERE estado = 1 ";
 Connection con = Conexion.Conectar();
 PreparedStatement ps = con.prepareStatement(sql);
 ResultSet rs = ps.executeQuery();
 while (rs.next()) {
Materia materia = new Materia();
materia.setIdmateria(rs.getInt("idmateria"));
materia.setNombre(rs.getString("nombre"));
materia.setAniomateria(rs.getInt("año"));
materia.setActivo(rs.getBoolean("estado"));
materias.add(materia);




 }
ps.close();


 } catch (SQLException ex) {
 JOptionPane.showMessageDialog(null, " Error al acceder a la tabla Alumno "+ex.getMessage());
 }

      
      
  
    
    

      return materias;
  }
  
  
  
  ///Listar Materias Inscriptas por el alumno
  public DefaultTableModel mostrarMateriaCursadas()
    {

        formInscripcion frm = new formInscripcion();
     
        String selectedItem = (String) frm.comboAlumnos.getSelectedItem();
            String[] parts = selectedItem.split("-");
            int idAlumno = Integer.parseInt(parts[0]);
        String []  nombresColumnas = {"id","Nombre","Año"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo1 = new DefaultTableModel(null,nombresColumnas);        
        String sql = "SELECT inscripcion.idMateria, nombre, año FROM inscripcion JOIN materia ON(inscripcion.idMateria=materia.idMateria) WHERE inscripcion.idAlumno ="+idAlumno+"" ;
        
        Connection cn = null;        
        PreparedStatement pst = null;        
        ResultSet rs = null;
        
        try{
            cn = Conexion.Conectar();            
            pst = cn.prepareStatement(sql);        
            
            rs = pst.executeQuery();            
            while(rs.next())
            {
                registros[0] = rs.getString("idMateria");
                
                registros[1] = rs.getString("nombre");
                
                registros[2] = rs.getString("año");       
                    
                
                
                modelo1.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo1;
    }
  
  
} 