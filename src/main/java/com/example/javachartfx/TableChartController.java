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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * Class contains controls and TableView to display data from the database
 */
public class TableChartController implements Initializable {
    // a button for switch to the BarChartView
    @javafx.fxml.FXML
    private Button chartViewBtn;
    // a button to load data from the database
    @javafx.fxml.FXML
    private Button loadAllDataBtn;
    // a TableView contains data from the database
    @javafx.fxml.FXML
    private TableView<GlobalData> globalTableView;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // initialize a TableView with columns
        initializeTableView();
    }

    private void initializeTableView() {
        // create columns and set properties
        TableColumn<GlobalData, String> countryColumn = new TableColumn<>("Country");
        countryColumn.setCellValueFactory(new PropertyValueFactory<>("country"));

        TableColumn<GlobalData, Integer> yearColumn = new TableColumn<>("Year");
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));

        TableColumn<GlobalData, Double> electricityAccessColumn =
                new TableColumn<>("Electricity Access");
        electricityAccessColumn.setCellValueFactory(new PropertyValueFactory<>("electricityAccess"));

        TableColumn<GlobalData, Double> cleanFuelsAccessColumn =
                new TableColumn<>("Clean Fuels Access");
        cleanFuelsAccessColumn.setCellValueFactory(new PropertyValueFactory<>("cleanFuelsAccess"));

        TableColumn<GlobalData, Double> fossilElectricityColumn =
                new TableColumn<>("Fossil Electricity");
        fossilElectricityColumn.setCellValueFactory(new PropertyValueFactory<>("fossilElectricity"));

        TableColumn<GlobalData, Double> nuclearElectricityColumn =
                new TableColumn<>("Nuclear Electricity");
        nuclearElectricityColumn.setCellValueFactory(new PropertyValueFactory<>("nuclearElectricity"));

        TableColumn<GlobalData, Double> renewablesElectricityColumn =
                new TableColumn<>("Renewables Electricity");
        renewablesElectricityColumn.setCellValueFactory(new PropertyValueFactory<>("renewablesElectricity"));

        TableColumn<GlobalData, Double> lowCarbonElectricityPercentageColumn =
                new TableColumn<>("Low Carbon Electricity Percentage");
        lowCarbonElectricityPercentageColumn.setCellValueFactory(
                new PropertyValueFactory<>("lowCarbonElectricityPercentage"));

        TableColumn<GlobalData, Double> energyConsumptionPerPersonColumn =
                new TableColumn<>("Energy Consumption Per Person");
        energyConsumptionPerPersonColumn.setCellValueFactory(
                new PropertyValueFactory<>("energyConsumptionPerPerson"));

        TableColumn<GlobalData, Double> valueCo2EmissionsColumn =
                new TableColumn<>("Value CO2 Emissions");
        valueCo2EmissionsColumn.setCellValueFactory(new PropertyValueFactory<>("valueCo2Emissions"));

        TableColumn<GlobalData, String> continentColumn =
                new TableColumn<>("Continent");
        continentColumn.setCellValueFactory(new PropertyValueFactory<>("continent"));

        // Add columns to the TableView
        globalTableView.getColumns().addAll(
                countryColumn, yearColumn, electricityAccessColumn, cleanFuelsAccessColumn,
                fossilElectricityColumn, nuclearElectricityColumn, renewablesElectricityColumn,
                lowCarbonElectricityPercentageColumn, energyConsumptionPerPersonColumn,
                valueCo2EmissionsColumn, continentColumn
        );
    }

    @FXML
    private void loadAllDataFromDB(ActionEvent actionEvent) {
        // get all data from DB
        List<GlobalData> globalDataList = DBUtility.getAll();
        // clear the TableView from the previous data
        globalTableView.getItems().clear();
        // Set data to the TableView
        globalTableView.getItems().addAll(globalDataList);
    }

    @FXML
    private void switchToChartView(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Scene scene = source.getScene();
        Stage stage = (Stage) scene.getWindow();
        StageLoader.loadStageWithFXML(stage, StageLoader.CHART_VIEW_FXML);
    }
}
