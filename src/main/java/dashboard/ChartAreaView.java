package dashboard;

import gestion.EstudianteGestion;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import model.YearGender;
import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.CategoryAxis;
import org.primefaces.model.chart.LineChartSeries;
import org.primefaces.model.chart.LineChartModel;

@Named(value = "chartAreaView")
@Dependent
public class ChartAreaView {

    private LineChartModel areaModel;

    public ChartAreaView() {
    }

    public LineChartModel getAreaModel() {
        return areaModel;
    }

    @PostConstruct
    public void init() {
        createAreaModel();
    }

    private void createAreaModel() {
        areaModel = new LineChartModel();

//        LineChartSeries boys = new LineChartSeries();
//        boys.setFill(true);
//        boys.setLabel("Boys");
//        boys.set("2004", 120);
//        boys.set("2005", 100);
//        boys.set("2006", 44);
//        boys.set("2007", 150);
//        boys.set("2008", 25);
//
//        LineChartSeries girls = new LineChartSeries();
//        girls.setFill(true);
//        girls.setLabel("Girls");
//        girls.set("2004", 52);
//        girls.set("2005", 60);
//        girls.set("2006", 110);
//        girls.set("2007", 90);
//        girls.set("2008", 120);

        /*Declare Lines*/
        LineChartSeries boys = new LineChartSeries();
        LineChartSeries girls = new LineChartSeries();
        /*Allow fill the grafic*/
        boys.setFill(true);
        girls.setFill(true);

        /*Variables for Labels*/
        String label = "N/A";
        String label1 = "N/A";

        /*Call DataBase*/
        ArrayList<YearGender> list = EstudianteGestion.getIngresoYearGender();
        int mayor = list.get(0).getTotal();

        /*Create a New List to get the gender*/
        ArrayList<String> genders = new ArrayList<>();

        /*Iterate existing list to add the elements to the new list*/
        list.forEach(linea -> {
            genders.add(linea.getGenero());
        });

        /*Get Collection without duplicates  Distinct  */
        List<String> distinctGenders = genders.stream().distinct().collect(Collectors.toList());

        /*Assign Labels*/
        for (String s : distinctGenders) {
            if (s.equalsIgnoreCase("M")) {
                label = "Masculino";

            }
            if (s.equalsIgnoreCase("F")) {
                label1 = "Femenino";
            }
        }

        boys.setLabel(label);
        girls.setLabel(label1);

        for (YearGender row : list) {
            if (row.getGenero().equalsIgnoreCase("M")) {
                boys.set(row.getYear(), row.getTotal());                
            }
            if (row.getGenero().equalsIgnoreCase("F")) {
                girls.set(row.getYear(), row.getTotal());
            }
            if (mayor < row.getTotal()) {
                mayor = row.getTotal();
            }
        }

        areaModel.addSeries(boys);
        areaModel.addSeries(girls);

        areaModel.setTitle("Ingreso Year Gender");
        areaModel.setLegendPosition("ne");
        areaModel.setStacked(true);
        areaModel.setShowPointLabels(true);

        Axis xAxis = new CategoryAxis("Years");
        areaModel.getAxes().put(AxisType.X, xAxis);
        Axis yAxis = areaModel.getAxis(AxisType.Y);
        yAxis.setLabel("Total");
        yAxis.setMin(0);
//        yAxis.setMax(300);
    }
}
