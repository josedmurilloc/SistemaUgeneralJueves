/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.UsuarioGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Usuario;

/**
 *
 * @author User
 */
@Named(value = "usuarioController")
@SessionScoped
public class UsuarioController extends Usuario implements Serializable {

//    private boolean rolAdmin = false;false
    /**
     * Creates a new instance of UsuarioController
     */
    public UsuarioController() {
    }

    public String getUsuario() {
        Usuario usuario = UsuarioGestion.getUsuario(this.getIdUsuario(), this.getPwUsuario());
        if (usuario != null) {
            this.setNombreUsuario(usuario.getNombreUsuario());
            this.setIdRol(usuario.getIdRol());
//            if (usuario.getIdRol() == "admin") {
//                rolAdmin = true; <!--esto en la plantilla
//rendered="#{usuarioController.rolAdmin} property to control access -->
//            }
            return "principal.xhtml";

        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario o contraseña invalida");
            FacesContext.getCurrentInstance().addMessage("loginForm:clave", msg);
            return "index.xhtml";
        }
    }
}
