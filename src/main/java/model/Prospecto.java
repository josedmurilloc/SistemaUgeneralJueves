/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Prospecto {

    private String idProspecto;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private Date fechaNacimiento;
    private Date fechaGraduacionColegio;
    private Date fechaPosibleIngreso;
    private String correo;
    private String celular;

    public Prospecto() {
    }

    public Prospecto(String idProspecto, String nombre, String apellido1, String apellido2, Date fechaNacimiento, Date fechaGraduacionColegio, Date fechaPosibleIngreso, String correo, String celular) {
        this.idProspecto = idProspecto;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaGraduacionColegio = fechaGraduacionColegio;
        this.fechaPosibleIngreso = fechaPosibleIngreso;
        this.correo = correo;
        this.celular = celular;
    }

    public String getIdProspecto() {
        return idProspecto;
    }

    public void setIdProspecto(String idProspecto) {
        this.idProspecto = idProspecto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido1() {
        return apellido1;
    }

    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }

    public String getApellido2() {
        return apellido2;
    }

    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaGraduacionColegio() {
        return fechaGraduacionColegio;
    }

    public void setFechaGraduacionColegio(Date fechaGraduacionColegio) {
        this.fechaGraduacionColegio = fechaGraduacionColegio;
    }

    public Date getFechaPosibleIngreso() {
        return fechaPosibleIngreso;
    }

    public void setFechaPosibleIngreso(Date fechaPosibleIngreso) {
        this.fechaPosibleIngreso = fechaPosibleIngreso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
//Metodo ToString devuelve un JSON

    @Override
    public String toString() {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        String fecha1 = format.format(this.fechaNacimiento);
        String fecha2 = format.format(this.fechaGraduacionColegio);
        String fecha3 = format.format(this.fechaPosibleIngreso);
        return "{\"Prospecto\":{\n\"cedula\":\""
                + idProspecto + "\",\n\"nombre\":\""
                + nombre + "\",\n\"apellido1\":\""
                + apellido1 + "\",\n\"apellido2\":\""
                + apellido2 + "\",\n\"fechaNacimiento\":\""
                + fecha1 + "\",\n\"fechaGraduacionColegio\":\""
                + fecha2 + "\",\n\"fechaPosibleIngreso\":\""
                + fecha3 + "\",\n\"correo\":\""
                + correo + "\",\n\"celular\":\""
                + celular + "\"\n}\n}";

    }

}
