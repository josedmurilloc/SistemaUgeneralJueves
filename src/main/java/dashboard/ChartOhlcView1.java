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
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.OhlcChartModel;
import org.primefaces.model.chart.OhlcChartSeries;
/**
 *
 * @author wmolina
 */
@Named(value = "chartOhlcView1")
@SessionScoped
public class ChartOhlcView1 implements Serializable {
    private OhlcChartModel ohlcModel;
 
    @PostConstruct
    public void init() {
        createOhlcModels();
    }
 

    public OhlcChartModel getOhlcModel() {
        return ohlcModel;
    }
 
    private void createOhlcModels() {
        createOhlcModel1();     
    }
 
    private void createOhlcModel1() {
        ohlcModel = new OhlcChartModel();
 
        ohlcModel.add(new OhlcChartSeries(2007, 143.82, 144.56, 136.04, 136.97));
        ohlcModel.add(new OhlcChartSeries(2008, 138.7, 139.68, 135.18, 135.4));
        ohlcModel.add(new OhlcChartSeries(2009, 143.46, 144.66, 139.79, 140.02));
        ohlcModel.add(new OhlcChartSeries(2010, 140.67, 143.56, 132.88, 142.44));
        ohlcModel.add(new OhlcChartSeries(2011, 136.01, 139.5, 134.53, 139.48));
        ohlcModel.add(new OhlcChartSeries(2012, 124.76, 135.9, 124.55, 135.81));
        ohlcModel.add(new OhlcChartSeries(2013, 123.73, 129.31, 121.57, 122.5));
 
        ohlcModel.setTitle("OHLC Chart");
        ohlcModel.getAxis(AxisType.X).setLabel("Year");
        ohlcModel.getAxis(AxisType.Y).setLabel("Price Change $K/Unit");
    }
 
}