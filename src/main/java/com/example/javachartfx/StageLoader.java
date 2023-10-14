package com.example.javachartfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;

public class StageLoader {
    public static final String CHART_VIEW_FXML = "BarChartView.fxml";
    public static final String TABLE_VIEW_FXML = "TableChartView.fxml";

    public StageLoader() {
    }

    public static void loadStageWithFXML(Stage stage, String fxmlResource) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(StageLoader.class.getResource(fxmlResource));
            Scene scene = new Scene(fxmlLoader.load());
            InputStream iconStream = StageLoader.class.getResourceAsStream("/images/flash_yellow_edit_32_32.png");
            if (iconStream != null) {
                Image icon = new Image(iconStream);
                stage.getIcons().add(icon);
            }

            scene.getStylesheets().add("/style.css");
            stage.setTitle("Global Data on Sustainable Energy");
            stage.setScene(scene);
            stage.setResizable(false);
            stage.show();
        } catch (IOException var6) {
            throw new RuntimeException("Error loading the resource " + fxmlResource, var6);
        }
    }
}
