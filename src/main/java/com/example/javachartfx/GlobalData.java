package com.example.javachartfx;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class GlobalData {
    private SimpleStringProperty country;
    private SimpleIntegerProperty year;
    private SimpleDoubleProperty electricityAccess;
    private SimpleDoubleProperty cleanFuelsAccess;
    private SimpleDoubleProperty fossilElectricity;
    private SimpleDoubleProperty nuclearElectricity;
    private SimpleDoubleProperty renewablesElectricity;
    private SimpleDoubleProperty lowCarbonElectricityPercentage;
    private SimpleDoubleProperty energyConsumptionPerPerson;
    private SimpleDoubleProperty valueCo2Emissions;
    private SimpleStringProperty continent;

    public GlobalData() {
        country = new SimpleStringProperty();
        year = new SimpleIntegerProperty();
        electricityAccess = new SimpleDoubleProperty();
        cleanFuelsAccess = new SimpleDoubleProperty();
        fossilElectricity = new SimpleDoubleProperty();
        nuclearElectricity = new SimpleDoubleProperty();
        renewablesElectricity = new SimpleDoubleProperty();
        lowCarbonElectricityPercentage = new SimpleDoubleProperty();
        energyConsumptionPerPerson = new SimpleDoubleProperty();
        valueCo2Emissions = new SimpleDoubleProperty();
        continent = new SimpleStringProperty();
    }

    public String getCountry() {
        return country.get();
    }

    public SimpleStringProperty countryProperty() {
        return country;
    }

    public void setCountry(String country) {
        this.country.set(country);
    }

    public int getYear() {
        return year.get();
    }

    public SimpleIntegerProperty yearProperty() {
        return year;
    }

    public void setYear(int year) {
        this.year.set(year);
    }

    public double getElectricityAccess() {
        return electricityAccess.get();
    }

    public SimpleDoubleProperty electricityAccessProperty() {
        return electricityAccess;
    }

    public void setElectricityAccess(double electricityAccess) {
        this.electricityAccess.set(electricityAccess);
    }

    public double getCleanFuelsAccess() {
        return cleanFuelsAccess.get();
    }

    public SimpleDoubleProperty cleanFuelsAccessProperty() {
        return cleanFuelsAccess;
    }

    public void setCleanFuelsAccess(double cleanFuelsAccess) {
        this.cleanFuelsAccess.set(cleanFuelsAccess);
    }

    public double getFossilElectricity() {
        return fossilElectricity.get();
    }

    public SimpleDoubleProperty fossilElectricityProperty() {
        return fossilElectricity;
    }

    public void setFossilElectricity(double fossilElectricity) {
        this.fossilElectricity.set(fossilElectricity);
    }

    public double getNuclearElectricity() {
        return nuclearElectricity.get();
    }

    public SimpleDoubleProperty nuclearElectricityProperty() {
        return nuclearElectricity;
    }

    public void setNuclearElectricity(double nuclearElectricity) {
        this.nuclearElectricity.set(nuclearElectricity);
    }

    public double getRenewablesElectricity() {
        return renewablesElectricity.get();
    }

    public SimpleDoubleProperty renewablesElectricityProperty() {
        return renewablesElectricity;
    }

    public void setRenewablesElectricity(double renewablesElectricity) {
        this.renewablesElectricity.set(renewablesElectricity);
    }

    public double getLowCarbonElectricityPercentage() {
        return lowCarbonElectricityPercentage.get();
    }

    public SimpleDoubleProperty lowCarbonElectricityPercentageProperty() {
        return lowCarbonElectricityPercentage;
    }

    public void setLowCarbonElectricityPercentage(double lowCarbonElectricityPercentage) {
        this.lowCarbonElectricityPercentage.set(lowCarbonElectricityPercentage);
    }

    public double getEnergyConsumptionPerPerson() {
        return energyConsumptionPerPerson.get();
    }

    public SimpleDoubleProperty energyConsumptionPerPersonProperty() {
        return energyConsumptionPerPerson;
    }

    public void setEnergyConsumptionPerPerson(double energyConsumptionPerPerson) {
        this.energyConsumptionPerPerson.set(energyConsumptionPerPerson);
    }

    public double getValueCo2Emissions() {
        return valueCo2Emissions.get();
    }

    public SimpleDoubleProperty valueCo2EmissionsProperty() {
        return valueCo2Emissions;
    }

    public void setValueCo2Emissions(double valueCo2Emissions) {
        this.valueCo2Emissions.set(valueCo2Emissions);
    }

    public String getContinent() {
        return continent.get();
    }

    public SimpleStringProperty continentProperty() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent.set(continent);
    }
}