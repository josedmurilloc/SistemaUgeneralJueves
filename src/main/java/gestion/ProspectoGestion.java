/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Conexion;
import model.Estudiante;
import model.Prospecto;

/**
 *
 * @author User
 */
public class ProspectoGestion {

    public ProspectoGestion() {
    }
    private static final String SQL_INSERT_PROSPECTO = "INSERT INTO PROSPECTO(idProspecto,nombre,Apellido1,Apellido2,fechaNacimiento,fechaGraduacionColegio,fechaPosibleIngreso,correo,celular)VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String SQL_SELECT_PROSPECTO = "Select * from PROSPECTO WHERE idProspecto=?";

    //Insert-Post
    public static boolean insertarProspecto(Prospecto prospecto) {
        try {
            PreparedStatement sentencia = Conexion.getConexion().
                    prepareStatement(SQL_INSERT_PROSPECTO);
            sentencia.setString(1, prospecto.getIdProspecto());
            sentencia.setString(2, prospecto.getNombre());
            sentencia.setString(3, prospecto.getApellido1());
            sentencia.setString(4, prospecto.getApellido2());
            sentencia.setObject(5, prospecto.getFechaNacimiento());
            sentencia.setObject(6, prospecto.getFechaGraduacionColegio());
            sentencia.setObject(7, prospecto.getFechaPosibleIngreso());
            sentencia.setString(8, prospecto.getCorreo());
            sentencia.setString(9, prospecto.getCelular());
            return sentencia.executeUpdate() > 0;
        } catch (SQLException ex) {
            Logger.getLogger(ProspectoGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return false;

    }

    //Select student
    public static Prospecto getProspecto(String idProspecto) {
        Prospecto prospecto = null;
        try {
            PreparedStatement consulta = Conexion.getConexion().
                    prepareStatement(SQL_SELECT_PROSPECTO);
            consulta.setString(1, idProspecto);
            ResultSet datos = consulta.executeQuery();
            while (datos != null && datos.next()) {
                prospecto = new Prospecto(
                        datos.getString(2),
                        datos.getString(3),
                        datos.getString(4),
                        datos.getString(5),
                        datos.getDate(6),
                        datos.getDate(7),
                        datos.getDate(8),
                        datos.getString(9),
                        datos.getString(10));
            }

        } catch (SQLException ex) {
            Logger.getLogger(ProspectoGestion.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        return prospecto;
    }
}
