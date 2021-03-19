/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Estudiante;
import model.YearGender;

/**
 *
 * @author User
 */
public class EstudianteGestion {

    private static final String SQL_GETESTUDIANTES = "SELECT * FROM estudiante";
    private static final String SQL_GETESTUDIANTE = "SELECT * FROM estudiante where id=? and idEstudiante=?";
    private static final String SQL_GETESTUDIANTEReporte = "SELECT * FROM estudiante where  idEstudiante=?";
    private static final String SQL_INSERTESTUDIANTE = "insert into estudiante(idEstudiante,nombre,apellido1,apellido2,fechaNaci,fechaIngr,genero) values (?,?,?,?,?,?,?)";
    private static final String SQL_UPDATEESTUDIANTE = "update  estudiante set nombre=?,apellido1=?,apellido2=?,fechaNaci=?,fechaIngr=?,genero=? where id=? and idEstudiante=?";
    private static final String SQL_DELETEESTUDIANTE = "Delete FROM estudiante where id=? and idEstudiante=?";
    private static final String SQL_INGRESO_YEAR_GENDER = "SELECT YEAR(fechaIngr) as Fecha,genero,Count(*) total FROM estudiante group by  YEAR(fechaIngr),genero order by YEAR(fechaIngr)";

    //Metodo encargado de traer todos los estudiantes
    public static ArrayList<Estudiante> getEstudiantes() {
        ArrayList<Estudiante> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETESTUDIANTES);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new Estudiante(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).charAt(0)
                ));

            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;

    }

    //Metodo encargado de traer un estudiante
    public static Estudiante getEstudiante(int id, String idEstudiante) {
        Estudiante estudiante = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETESTUDIANTE);
            sentencia.setInt(1, id);
            sentencia.setString(2, idEstudiante);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                estudiante = new Estudiante(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).charAt(0)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return estudiante;
    }

    //Metodo encargado de traer un estudiante
    public static Estudiante buscarEstudiante(String idEstudiante) {
        Estudiante estudiante = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETESTUDIANTEReporte);
            sentencia.setString(1, idEstudiante);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                estudiante = new Estudiante(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getDate(6),
                        rs.getDate(7),
                        rs.getString(8).charAt(0)
                );
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return estudiante;
    }

    //Metodo encargado de traer todos los estudiantes
    public static ArrayList<YearGender> getIngresoYearGender() {
        ArrayList<YearGender> list = new ArrayList<>();
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INGRESO_YEAR_GENDER);
            ResultSet rs = sentencia.executeQuery();
            while (rs != null && rs.next()) {
                list.add(new YearGender(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getInt(3)));
            }

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return list;

    }

    public static boolean insertEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_INSERTESTUDIANTE);
            sentencia.setString(1, estudiante.getIdEstudiante());
            sentencia.setString(2, estudiante.getNombre());
            sentencia.setString(3, estudiante.getApellido1());
            sentencia.setString(4, estudiante.getApellido2());
            sentencia.setObject(5, estudiante.getFechaNaci());
            sentencia.setObject(6, estudiante.getFechaIngr());
            sentencia.setString(7, "" + estudiante.getGenero());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean updateEstudiante(Estudiante estudiante) {
        try {

            PreparedStatement sentencia = Conexion.getConexion().prepareCall(SQL_UPDATEESTUDIANTE);
            sentencia.setString(1, estudiante.getNombre());
            sentencia.setString(2, estudiante.getApellido1());
            sentencia.setString(3, estudiante.getApellido2());
            sentencia.setObject(4, estudiante.getFechaNaci());
            sentencia.setObject(5, estudiante.getFechaIngr());
            sentencia.setString(6, "" + estudiante.getGenero());
            sentencia.setInt(7, estudiante.getId());
            sentencia.setString(8, estudiante.getIdEstudiante());
            return sentencia.executeUpdate() > 0;

        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public static boolean deleteEstudiante(Estudiante estudiante) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_DELETEESTUDIANTE);
            sentencia.setInt(1, estudiante.getId());
            sentencia.setString(2, estudiante.getIdEstudiante());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteGestion.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }
}
