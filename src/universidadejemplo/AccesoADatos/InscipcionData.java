
package universidadejemplo.AccesoADatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import universidadejemplo.Entidades.Alumno;
import universidadejemplo.Entidades.Inscripcion;
import universidadejemplo.Entidades.Materia;
import universidadejemplo.Vistas.formInscripcion;

public class InscipcionData {
    private Connection con=null;
    private MateriaData md= new MateriaData();
    private AlumnoData ad= new AlumnoData();
    
 
  

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

    //borrado fisico
  public void BorrarInscripcionMateriaAlumno (int idAlumno, int idMateria){
      Connection con = Conexion.Conectar();
      
      
      String sql="DELETE FROM incripcion WHERE idAlumno=? AND idMateria=?";
       
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);
            
            int filas=ps.executeUpdate();
            if(filas>0){
                JOptionPane.showMessageDialog(null, "se elimino inscripcion");
            }
            ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, " no se conecto a base de datos");
        }
      
      
      
  }
  
  public void ActualizarNota(int idAlumno,int idMateria, double nota){
       Connection con = Conexion.Conectar();
       
       String sql="Update inscripcion set nota=? where idAlumno=? and idMateria";
       
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int filas=ps.executeUpdate();
            
            if(filas>0){
                JOptionPane.showMessageDialog(null, "nota actualizada");
            }
            ps.close();
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "no se encontro la nota");
        }
              
       
       
      
      
      
  }
  
  
  
  public List <Inscripcion> obtenerInscripciones(){
      List <Inscripcion> cursadas=new ArrayList<>();
      
      String sql= "SELECT * FROM inscripcion";
      
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setIdinscripcion(rs.getInt("idInscripto"));
           Alumno alu= ad.BuscarAlumno(rs.getInt("idAlumno"));
           Materia mat =md.BuscarMateria(rs.getInt("idMateria"));
           insc.setAlumno(alu);
           insc.setMateria(mat);
           
           insc.setNota(rs.getDouble("nota"));
           
           cursadas.add(insc);
           
           
            }
            ps.close ();
            
      
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se accedio a inscripcion");
        }
      
      return cursadas;
      
      
  }
  
  
  public List <Inscripcion> obtenerInscripcionesxAlumno(int idAlumno){
      List <Inscripcion> cursadas=new ArrayList<>();
      
      String sql= "SELECT * FROM inscripcion WHERE idAlumno=?";
      
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ResultSet rs=ps.executeQuery();
            
            while(rs.next()){
            Inscripcion insc = new Inscripcion();
            insc.setIdinscripcion(rs.getInt("idInscripto"));
           Alumno alu= ad.BuscarAlumno(rs.getInt("idAlumno"));
           Materia mat =md.BuscarMateria(rs.getInt("idMateria"));
           insc.setAlumno(alu);
           insc.setMateria(mat);
           
           insc.setNota(rs.getDouble("nota"));
           
           cursadas.add(insc);
           
           
            }
            ps.close ();
            
      
        
        
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se accedio a inscripcion");
        }
      
      return cursadas;
      
      
  }
  
  public List <Materia> obtenerMateriasCursadas(int idAlumno){
      List <Materia> materias= new ArrayList<>();
      String sql="SELECT inscripcion.idMateria, nombre, año FROM inscripcion,"
              + "materia WHERE inscripcion.idMateria= Materia.idMateria"
              + "AND inscripcion.idAlumno=?;";
      
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Materia materia=new Materia();
                
                materia.setIdmateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAniomateria(rs.getInt("año"));
                
                materias.add(materia);
                ps.close();
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se conecto a la base :(");
        }
        
        return materias;
  }
  
  
  public List <Materia> obtenerMateriasNOCursadas(int idAlumno){
       List <Materia> materias= new ArrayList<>();
       
       String sql="SELECT * FROM materia WHERE estado=1 AND idMateria not in"
               + "(SELECT idMateria FROM inscripcion WHERE idAlumno=?)";
       
       try {
            PreparedStatement ps=con.prepareStatement(sql);
            
            ps.setInt(1, idAlumno);
            ResultSet rs= ps.executeQuery();
            
            while(rs.next()){
                Materia materia=new Materia();
                
                materia.setIdmateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAniomateria(rs.getInt("año"));
                
                materias.add(materia);
                ps.close();
            }
            
            
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "no se conecto a la base :(");
        }
        
        return materias;
       
       
      
      
      
      
      
  }
  
  public List<Alumno> ObteneralumnoXMateria(int idMateria){
      
      List <Alumno> alumnosMateria= new ArrayList<>();
      
      String sql= "SELECT a.idAlumno,dni,nombre,apellido,fechaNacimiento,estado"
              + "FROM inscripcion i , alumno a WHERE i.idAlumno = a.idAlumno AND idMateria=?"
              + "AND a.estado=1";
      
      
        try {
            PreparedStatement ps=con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
              
            Alumno alumno=new Alumno();
            alumno.setIdalumno(rs.getInt("idAlumno"));
            alumno.setDni(rs.getInt("dni"));
            alumno.setNombre(rs.getString("nombre"));
            alumno.setApellido(rs.getString("nombre"));
            alumno.setFechadenacimiento(rs.getDate("fechaNacimiento").toLocalDate());
            alumno.setEstado(rs.getBoolean("estado"));
            alumnosMateria.add(alumno);
            
            
             
                
            }
            ps.close();
            
            
            
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "error al acceder a la tabla ");
        }
            
     return alumnosMateria; 
      
  }
  
  
  
  
    
    
}
 