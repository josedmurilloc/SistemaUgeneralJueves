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
import model.Usuario;

/**
 *
 * @author User
 */
public class UsuarioGestion {

    private static final String SQL_GETUSUARIO = "Select * from usuario where idUsuario=? and pwUsuario=MD5(?)";

    public static Usuario getUsuario(String idUsuario, String pwUsuario) {
        Usuario usuario = null;
        try {
            PreparedStatement sentencia = Conexion.getConexion().prepareStatement(SQL_GETUSUARIO);
            sentencia.setString(1, idUsuario);
            sentencia.setString(2, pwUsuario);
            ResultSet rs = sentencia.executeQuery();
            /*Esto es lo que captura el resultset*/
 /* id idUsuario Pwusuario Nombre  IdRol
               1    jose     123       jose    admin */
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(idUsuario);
                usuario.setPwUsuario(pwUsuario);
                usuario.setNombreUsuario(rs.getString(4));
                usuario.setIdRol(rs.getString(5));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioGestion.class.getName()).log(Level.SEVERE, null, ex);

        }

        return usuario;

    }
}
