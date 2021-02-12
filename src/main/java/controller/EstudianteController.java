/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import gestion.EstudianteGestion;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import model.Estudiante;

/**
 *
 * @author User
 */
@Named(value = "estudianteController")
@SessionScoped
public class EstudianteController extends Estudiante implements Serializable {

    /**
     * Creates a new instance of EstudianteController
     */
    public EstudianteController() {
    }

    public List<Estudiante> getEstudiantes() {
        return EstudianteGestion.getEstudiantes();
    }

    //Metodo encargado de mostrar un unico estudiante para editar
    public String editaEstudiante(int id,String idEstudiante) {
        Estudiante e = EstudianteGestion.getEstudiante(id, idEstudiante);
        if (e != null) {
            this.setId(e.getId());
            this.setIdEstudiante(e.getIdEstudiante());
            this.setNombre(e.getNombre());
            this.setApellido1(e.getApellido1());
            this.setApellido2(e.getApellido2());
            this.setFechaNaci(e.getFechaNaci());
            this.setFechaIngr(e.getFechaIngr());
            this.setGenero(e.getGenero());
            return "edit.xhtml";
        } else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error",
                    "Posiblemente el registro no exista");
            FacesContext.getCurrentInstance().addMessage("editaEstudianteForm:identificacion", msg);
            return "list.xhtml";
        }
    }

}
