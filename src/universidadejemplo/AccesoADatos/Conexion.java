/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Dylan
 */
public class Conexion {
    private static Connection con;
  private static boolean conectado = false;
    public  static Connection Conectar(){
    try{
            
            if (conectado == false){               
         
                
                String driver = ("org.mariadb.jdbc.Driver");
                String url = ("jdbc:mariadb://localhost:3306/universidadulp");
                String pwd = ("");
                String usr = ("root");
                               
                Class.forName(driver);
            
                con = DriverManager.getConnection(url, usr, pwd); 
                System.out.println("Conectado");
            }

            return con; 
        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null,"Error al crear la conexión "+e.getMessage());
            
            throw new RuntimeException("Error al crear la conexión");
        }
    }
 
}
