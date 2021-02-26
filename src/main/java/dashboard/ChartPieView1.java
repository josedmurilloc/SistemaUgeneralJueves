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
import org.primefaces.model.chart.PieChartModel;
/**
 *
 * @author wmolina
 */
@Named(value = "chartPieView1")
@SessionScoped
public class ChartPieView1 implements Serializable {
    private PieChartModel pieModel1;
 
    @PostConstruct
    public void init() {
        createPieModels();
    }

    public PieChartModel getPieModel1() {
        return pieModel1;
    }
 
    private void createPieModels() {
        createPieModel1();
    }
 
    private void createPieModel1() {
        pieModel1 = new PieChartModel();
 
        pieModel1.set("Brand 1", 540);
        pieModel1.set("Brand 2", 325);
        pieModel1.set("Brand 3", 702);
        pieModel1.set("Brand 4", 421);
 
        pieModel1.setTitle("Simple Pie");
        pieModel1.setLegendPosition("w");
        pieModel1.setShadow(false);
    }
  
}