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
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import universidadejemplo.Entidades.Materia;

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
        String []  nombresColumnas = {"idMateria","nombre","año","Estado"};
        String [] registros = new String[4];
        
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
                
                registros[3] = rs.getString("estado");               
                
                
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
}
