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

/**
 *
 * @author User
 */
public class EstudianteGestion {

    private static final String SQL_GETESTUDIANTES = "SELECT * FROM estudiante";
    private static final String SQL_GETESTUDIANTE = "SELECT * FROM estudiante where id=? and idEstudiante=?";

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
}
