
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Inscripcion;

public class InscipcionData {
  

    public void InscipcionData() {
      
    }
    
    public void GuardarInscripcion(Inscripcion ins){
         Connection con = Conexion.Conectar();
        String slq = "INSERT INTO inscripcion(idAlumno,nombre,nota)VALUES(?,?,?)";
        try {
            PreparedStatement pst = con.prepareStatement(slq,Statement.RETURN_GENERATED_KEYS);
            pst.setInt(1,ins.getAlumno().getIdalumno());
            pst.setInt(2,ins.getMateria().getIdmateria());
            pst.setDouble(3, ins.getNota());
            pst.executeUpdate();
            ResultSet rs = pst.getGeneratedKeys();
            if(rs.next()){
                ins.setIdinscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null,"Inscripcion Exitosa");
                
            }
            
            pst.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Erro al conectar"+ ex);
        }
    }
    
//    public List <Inscripcion> ObtenerInscripciones(){
        
  //  }
    
    //public List <Inscripcion> ObtenerInscripcionesPorAlumno(int id){
        
   // }
    
    //public List <Inscripcion> ObtenerMateriasCursadas(int id){
        
    //}
    
    //public List <Inscripcion> ObtenerMateriasNOCursadas(int id){
        
   //}

  public void BorrarInscripcionMateriaAlumno (int idAlumno, int idMateria){
      
  }
  
  public void ActualizarNota(int idAlumno,int idMateria, double nota){
      
  }
  
  //public List<Alumno> ObteneralumnoXMateria(id Materia){
      
  //}
    
    
}
