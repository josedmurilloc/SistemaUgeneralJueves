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
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BubbleChartModel;
import org.primefaces.model.chart.BubbleChartSeries;

/**
 *
 * @author wmolina
 */
@Named(value = "chartBubbleView2")
@SessionScoped
public class ChartBubbleView2 implements Serializable {
    private BubbleChartModel bubbleModel2;

    public BubbleChartModel getBubbleModel2() {
        return bubbleModel2;
    }
 
    @PostConstruct
    public void init() {
        createBubbleModels();
    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
 
  
    private void createBubbleModels() {     
        bubbleModel2 = new BubbleChartModel();
        
        bubbleModel2.add(new BubbleChartSeries("Acura", 70, 183, 55));
        bubbleModel2.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
        bubbleModel2.add(new BubbleChartSeries("AM General", 24, 104, 40));
        bubbleModel2.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
        bubbleModel2.add(new BubbleChartSeries("BMW", 15, 89, 25));
        bubbleModel2.add(new BubbleChartSeries("Audi", 40, 180, 80));
        bubbleModel2.add(new BubbleChartSeries("Aston Martin", 70, 70, 48));
        
        bubbleModel2.setTitle("Custom Options");
        bubbleModel2.setShadow(false);
        bubbleModel2.setBubbleGradients(true);
        bubbleModel2.setBubbleAlpha(0.8);
        bubbleModel2.getAxis(AxisType.X).setTickAngle(-50);
        Axis yAxis = bubbleModel2.getAxis(AxisType.Y);
        yAxis.setLabel("Labels");
        yAxis.setMin(0);
        yAxis.setMax(250);
        yAxis.setTickAngle(50);
    }
}