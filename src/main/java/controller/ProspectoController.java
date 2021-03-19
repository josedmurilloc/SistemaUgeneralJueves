/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.ProspectoGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.io.StringReader;
import java.io.StringWriter;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;
import javax.json.JsonWriter;

import model.Prospecto;

/**
 *
 * @author User
 */
@Named(value = "prospectoController")
@SessionScoped
public class ProspectoController extends Prospecto implements Serializable {

    private String tiraJson;

    /**
     * Creates a new instance of ProspectoController
     */
    public ProspectoController() {
    }

    //Metodo Encargado de Insertar Prospecto.
    public String insertaProspecto() {
        if (ProspectoGestion.insertarProspecto(this)) {
            return "confirmacion.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR,
                    "Error", "Posiblemente el Registro se encuentre duplicado.");
            FacesContext.getCurrentInstance().addMessage("registroProspectoForm:cedula", msg);
            return "registro.xhtml";
        }

    }

    
}
