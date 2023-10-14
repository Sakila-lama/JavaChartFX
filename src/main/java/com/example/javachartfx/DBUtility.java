package com.example.javachartfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DBUtility {
    private static final String dbUser = "Sakila200548805";
    private static final String password = "jHZEV400p_";
    private static final String connectURL = "jdbc:mysql://172.31.22.43:3306/Sakila200548805";

    public DBUtility() {
    }

    public static Connection getConnection() {
        try {
            Properties dbProperties = new Properties();
            dbProperties.put("user", dbUser);
            dbProperties.put("password", password);
            Connection connection = DriverManager.getConnection(connectURL, dbProperties);
            return connection;
        } catch (SQLException var2) {
            throw new RuntimeException("Can't open connection to database.", var2);
        }
    }

    private static List<AveragePerYear> getAverageByYear(String query) {
        List<AveragePerYear> result = new ArrayList<>();

        try {
            Connection connection = getConnection();

            List<AveragePerYear> var14;
            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet resultSet = statement.executeQuery(query);

                    while (resultSet.next()) {
                        Double average = resultSet.getDouble("Average");
                        Integer year = resultSet.getInt("Year");
                        AveragePerYear averagePerYear = new AveragePerYear(year, average);
                        result.add(averagePerYear);
                    }

                    var14 = result;
                } catch (Throwable var11) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var10) {
                            var11.addSuppressed(var10);
                        }
                    }

                    throw var11;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var9) {
                        var12.addSuppressed(var9);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }

            return var14;
        } catch (SQLException var13) {
            throw new RuntimeException(var13);
        }
    }

    public static List<AveragePerYear> getEnergyConsumptionByYear() {
        String query = "SELECT AVG(`energy_consumption_per_person`) AS `Average`, `year` AS `Year`"
                + " FROM `global-data`"
                + " GROUP BY `year`;";
        return getAverageByYear(query);
    }

    public static List<GlobalData> getAll() {
        String query = "SELECT * FROM `global-data` ORDER BY `country`, `year`";
        List<GlobalData> globalDataList = new ArrayList<>();

        try {
            Connection connection = getConnection();

            try {
                Statement statement = connection.createStatement();

                try {
                    ResultSet resultSet = statement.executeQuery(query);

                    try {
                        while (resultSet.next()) {
                            GlobalData globalData = new GlobalData();
                            globalData.setCountry(resultSet.getString("country"));
                            globalData.setYear(resultSet.getInt("year"));
                            globalData.setElectricityAccess(resultSet.getDouble("electricity_access"));
                            globalData.setCleanFuelsAccess(resultSet.getDouble("clean_fuels_access"));
                            globalData.setFossilElectricity(resultSet.getDouble("fossil_electricity"));
                            globalData.setNuclearElectricity(resultSet.getDouble("nuclear_electricity"));
                            globalData.setRenewablesElectricity(resultSet.getDouble("renewables_electricity"));
                            globalData.setLowCarbonElectricityPercentage(resultSet.getDouble("low_carbon_electricity_percentage"));
                            globalData.setEnergyConsumptionPerPerson(resultSet.getDouble("energy_consumption_per_person"));
                            globalData.setValueCo2Emissions(resultSet.getDouble("value_co2_emissions_kt_by_country"));
                            globalData.setContinent(resultSet.getString("continent"));
                            globalDataList.add(globalData);
                        }
                    } catch (Throwable var10) {
                        if (resultSet != null) {
                            try {
                                resultSet.close();
                            } catch (Throwable var9) {
                                var10.addSuppressed(var9);
                            }
                        }

                        throw var10;
                    }

                    if (resultSet != null) {
                        resultSet.close();
                    }
                } catch (Throwable var11) {
                    if (statement != null) {
                        try {
                            statement.close();
                        } catch (Throwable var8) {
                            var11.addSuppressed(var8);
                        }
                    }

                    throw var11;
                }

                if (statement != null) {
                    statement.close();
                }
            } catch (Throwable var12) {
                if (connection != null) {
                    try {
                        connection.close();
                    } catch (Throwable var7) {
                        var12.addSuppressed(var7);
                    }
                }

                throw var12;
            }

            if (connection != null) {
                connection.close();
            }

            return globalDataList;
        } catch (SQLException var13) {
            throw new RuntimeException(var13);
        }
    }
}
