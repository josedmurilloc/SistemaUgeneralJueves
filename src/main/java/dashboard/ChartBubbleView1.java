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
@Named(value = "chartBubbleView1")
@SessionScoped
public class ChartBubbleView1 implements Serializable {
    private BubbleChartModel bubbleModel1;
 
    @PostConstruct
    public void init() {
        createBubbleModel();
    }

    public BubbleChartModel getBubbleModel1() {
        return bubbleModel1;
    }
 
    public void itemSelect(ItemSelectEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Item selected",
                "Item Index: " + event.getItemIndex() + ", Series Index:" + event.getSeriesIndex());
 
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }    
  
    private void createBubbleModel() {
        bubbleModel1 = new BubbleChartModel(); 
        
        bubbleModel1.add(new BubbleChartSeries("Acura", 70, 183, 55));
        bubbleModel1.add(new BubbleChartSeries("Alfa Romeo", 45, 92, 36));
        bubbleModel1.add(new BubbleChartSeries("AM General", 24, 104, 40));
        bubbleModel1.add(new BubbleChartSeries("Bugatti", 50, 123, 60));
        bubbleModel1.add(new BubbleChartSeries("BMW", 15, 89, 25));
        bubbleModel1.add(new BubbleChartSeries("Audi", 40, 180, 80));
        bubbleModel1.add(new BubbleChartSeries("Aston Martin", 70, 70, 48)); 
        

        bubbleModel1.setTitle("Bubble Chart");
        bubbleModel1.getAxis(AxisType.X).setLabel("Price");
        Axis yAxis = bubbleModel1.getAxis(AxisType.Y);
        yAxis.setMin(0);
        yAxis.setMax(250);
        yAxis.setLabel("Labels");
        yAxis.setTickAngle(50);
    }

}