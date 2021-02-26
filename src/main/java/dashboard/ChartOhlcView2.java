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
@Named(value = "chartOhlcView2")
@SessionScoped
public class ChartOhlcView2 implements Serializable {
    private OhlcChartModel ohlcModel2;
 
    @PostConstruct
    public void init() {
        createOhlcModels();
    }
 
    public OhlcChartModel getOhlcModel2() {
        return ohlcModel2;
    }
 
    private void createOhlcModels() {
        createOhlcModel2();
    }
 
    private void createOhlcModel2() {
        ohlcModel2 = new OhlcChartModel();
 
        for (int i = 1; i < 41; i++) {
            ohlcModel2.add(new OhlcChartSeries(i, Math.random() * 80 + 80, Math.random() * 50 + 110, Math.random() * 20 + 80, Math.random() * 80 + 80));
        }
 
        ohlcModel2.setTitle("Candlestick");
        ohlcModel2.setCandleStick(true);
        ohlcModel2.getAxis(AxisType.X).setLabel("Sector");
        ohlcModel2.getAxis(AxisType.Y).setLabel("Index Value");
    }
}