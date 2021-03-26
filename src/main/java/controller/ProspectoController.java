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

    public String getTiraJson() {
        return tiraJson;
    }

    public void setTiraJson(String tiraJson) {
        this.tiraJson = tiraJson;
    }

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

    public void recupera(String idProspecto) {
        Prospecto e = ProspectoGestion.getProspecto(idProspecto);
        if (e != null) {
            this.setIdProspecto(e.getIdProspecto());
            this.setNombre(e.getNombre());
            this.setApellido1(e.getApellido1());
            this.setApellido2(e.getApellido2());
            this.setFechaNacimiento(e.getFechaNacimiento());
            this.setFechaGraduacionColegio(e.getFechaGraduacionColegio());
            this.setFechaPosibleIngreso(e.getFechaPosibleIngreso());
            this.setCorreo(e.getCorreo());
            this.setCelular(e.getCelular());
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("prospectoJsonForm:identificacion", msg);

        }
    }

    /*De objeto a Json*/
    public void creaJson() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String fecha1 = format.format(this.getFechaNacimiento());
        JsonObjectBuilder creadorJson = Json.createObjectBuilder();
        JsonObject objectJson = creadorJson.add("idProspecto", this.getIdProspecto())
                .add("nombre", this.getNombre())
                .add("apellido1", this.getApellido1())
                .add("apellido2", this.getApellido2())
                .add("fechaNacimiento", fecha1)
                .add("correo", this.getCorreo())
                .add("celular", this.getCelular())
                .build();
        StringWriter tira = new StringWriter();
        JsonWriter jsonWriter = Json.createWriter(tira);
        jsonWriter.writeObject(objectJson);
        setTiraJson(tira.toString());

    }

    /*De Json a Objeto*/
    public void crearObjetoProspecto() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            JsonReader lectorJson = Json.createReader(new StringReader(tiraJson));
            JsonObject objectJson = lectorJson.readObject();
            this.setIdProspecto(objectJson.getString("idProspecto"));
            this.setNombre(objectJson.getString("nombre"));
            this.setApellido1(objectJson.getString("apellido1"));
            this.setApellido2(objectJson.getString("apellido2"));
            this.setFechaNacimiento(format.parse(objectJson.getString("fechaNacimiento")));
            this.setCorreo(objectJson.getString("correo"));
            this.setCelular(objectJson.getString("celular"));
        } catch (ParseException ex) {
            Logger.getLogger(ProspectoController.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}
