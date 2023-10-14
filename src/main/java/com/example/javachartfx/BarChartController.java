package com.example.javachartfx;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;



public class BarChartController implements Initializable {
    // BarChart object
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Button tableViewBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Initialize the chart with data
        displayEnergyConsumptionChart(new ActionEvent());
    }

    /**
     * Loads the TableView stage when the TableView button is clicked
     *
     */
    @FXML
    private void switchToTableView(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Scene scene = source.getScene();
        Stage stage = (Stage) scene.getWindow();
        StageLoader.loadStageWithFXML(stage, StageLoader.TABLE_VIEW_FXML);
    }

    /**
     * Displays a bar chart of energy consumption data for the selected year
     *
     */
    @FXML
    private void displayEnergyConsumptionChart(ActionEvent actionEvent) {
        // fetch data
        List<AveragePerYear> list = DBUtility.getEnergyConsumptionByYear();
        XYChart.Series<String, Number> series =
                convertListToSeries(list);

        series.setName("Energy Consumption Per Person");
        barChart.getData().clear();
        barChart.getData().add(series);
        addHints(series);

        barChart.getYAxis().setLabel("kWt/person");
    }


    private XYChart.Series<String, Number> convertListToSeries(
            List<AveragePerYear> list) {

        XYChart.Series<String, Number> series = new XYChart.Series<>();

        for (AveragePerYear item : list) {
            XYChart.Data<String, Number> data
                    = new XYChart.Data<>(item.getYear().toString(), item.getAverageValue());
            series.getData().add(data);
        }

        return series;
    }


    private static void addHints(XYChart.Series<String, Number> series) {
        // Add tooltips to the bars
        for (XYChart.Data<String, Number> data : series.getData()) {
            Tooltip tooltip = new Tooltip("Value: "
                    + String.format("%.2f", data.getYValue().doubleValue()));
            Tooltip.install(data.getNode(), tooltip);
        }
    }
}
