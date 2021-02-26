/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dashboard;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import org.primefaces.model.chart.MeterGaugeChartModel;
/**
 *
 * @author wmolina
 */
@Named(value = "chartMeterGaugeView")
@SessionScoped
public class ChartMeterGaugeView1 implements Serializable {
    private MeterGaugeChartModel meterGaugeModel1;
    
    @PostConstruct
    public void init() {
        createMeterGaugeModels();
    }
 
    public MeterGaugeChartModel getMeterGaugeModel1() {
        return meterGaugeModel1;
    }
 
    private MeterGaugeChartModel initMeterGaugeModel() {
        List<Number> intervals = new ArrayList<Number>() {
            {
                add(20);
                add(50);
                add(120);
                add(220);
            }
        };
 
        return new MeterGaugeChartModel(140, intervals);
    }
 
    private void createMeterGaugeModels() {
        meterGaugeModel1 = initMeterGaugeModel();
        meterGaugeModel1.setTitle("MeterGauge Chart");
        meterGaugeModel1.setGaugeLabel("km/h");
        meterGaugeModel1.setGaugeLabelPosition("bottom");       
    }
 
}