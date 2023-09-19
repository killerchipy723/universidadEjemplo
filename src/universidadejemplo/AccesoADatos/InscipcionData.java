
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
import universidadejemplo.Vistas.formInscripcion;

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
    
// private void cargarInscripcion(){
//            formInscripcion frmIns = new formInscripcion();
//        try {
//            Connection con = Conexion.Conectar();
//            String sql = "INSERT INTO inscripcion (nota,idAlumno,idMateria) VALUES (?,?,?)" ;
//            PreparedStatement stm = con.prepareStatement(sql);
//            String selectedItem = (String) frmIns.comboAlumnos.getSelectedItem();
//            String[] parts = selectedItem.split("-");
//            int idAlumno = Integer.parseInt(parts[0]);
//            
//            stm.setString(1, "0");
//           stm.setInt(2, idAlumno);
//            int selectedRow = frmIns.tablaMaterias.getSelectedRow();
//             stm.setString(3, frmIns.tablaMaterias.getValueAt(selectedRow, 0).toString());
//             
//            stm.executeUpdate();
//            JOptionPane.showMessageDialog(frmIns, "La inscripcion del Alumno se Realizó Correctamente");
//        } catch (SQLException ex) {
//            Logger.getLogger(formInscripcion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }

  public void BorrarInscripcionMateriaAlumno (int idAlumno, int idMateria){
      
  }
  
  public void ActualizarNota(int idAlumno,int idMateria, double nota){
      
  }
  
  //public List<Alumno> ObteneralumnoXMateria(id Materia){
      
  //}
    
    
}
 