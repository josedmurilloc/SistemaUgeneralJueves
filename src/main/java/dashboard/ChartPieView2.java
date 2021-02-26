/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author wmolina
 */
@Named(value = "chartPieView2")
@SessionScoped
public class ChartPieView2 implements Serializable {    
    private PieChartModel pieModel2;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel2() {
        return pieModel2;
    }
 
    private void createPieModels() {
        createPieModel2();
    }
 
    private void createPieModel2() {
        pieModel2 = new PieChartModel();
 
        pieModel2.set("Brand 1", 540);
        pieModel2.set("Brand 2", 325);
        pieModel2.set("Brand 3", 702);
        pieModel2.set("Brand 4", 421);
 
        pieModel2.setTitle("Custom Pie");
        pieModel2.setLegendPosition("e");
        pieModel2.setFill(false);
        pieModel2.setShowDataLabels(true);
        pieModel2.setDiameter(150);
        pieModel2.setShadow(false);
    } 
}