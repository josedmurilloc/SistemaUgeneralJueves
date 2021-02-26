/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.event.ItemSelectEvent;
import org.primefaces.model.chart.DonutChartModel;

/**
 *
 * @author wmolina
 */
@Named(value = "chartDonutView1")
@SessionScoped
public class ChartDonutView1 implements Serializable {

    private DonutChartModel donutModel1;

    @PostConstruct
    public void init() {
        createDonutModels();
    }

    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());

        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public DonutChartModel getDonutModel1() {
        return donutModel1;
    }

    private void createDonutModels() {
        donutModel1 = new DonutChartModel();

        Map<String, Number> circle1 = new LinkedHashMap<>();
        circle1.put("Brand 1", 150);
        circle1.put("Brand 2", 400);
        circle1.put("Brand 3", 200);
        circle1.put("Brand 4", 10);
        donutModel1.addCircle(circle1);

        Map<String, Number> circle2 = new LinkedHashMap<>();
        circle2.put("Brand 1", 540);
        circle2.put("Brand 2", 125);
        circle2.put("Brand 3", 702);
        circle2.put("Brand 4", 421);
        donutModel1.addCircle(circle2);

        Map<String, Number> circle3 = new LinkedHashMap<>();
        circle3.put("Brand 1", 40);
        circle3.put("Brand 2", 325);
        circle3.put("Brand 3", 402);
        circle3.put("Brand 4", 421);
        donutModel1.addCircle(circle3);

        donutModel1.setTitle("Donut Chart");
        donutModel1.setLegendPosition("w");
    }

}
