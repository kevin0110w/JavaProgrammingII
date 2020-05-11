package application;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

public class PartiesApplication extends Application {

    public static void main(String[] args) {
        launch(PartiesApplication.class);
        System.out.println("Hello world!");
    }

    @Override
    public void start(Stage stage) throws Exception {
        // create the x and y axes that the chart is going to use
        NumberAxis xAxis = new NumberAxis(1968, 2008, 4);

        NumberAxis yAxis = new NumberAxis();

        // set the titles for the axes
        xAxis.setLabel("Year");
        yAxis.setLabel("Relative support (%)");

        // create the line chart. The values of the chart are given as numbers
        // and it uses the axes we created earlier
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        lineChart.setTitle("Relative support in the years 1968-2008");
        List<Parties> parties = readFile();
        List<XYChart.Series> data = convertFileDataIntoChartData(parties);

        for (XYChart.Series entry : data) {
            lineChart.getData().add(entry);
        }

        // display the line chart
        Scene view = new Scene(lineChart, 640, 480);
        stage.setScene(view);
        stage.show();
    }

    public boolean isDouble(String number) {
        try {
            Double.parseDouble(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private List<Parties> readFile() {
        List<Parties> parties = new ArrayList<>();
        try (Scanner s = new Scanner(Paths.get("partiesdata.tsv"))) {
            String firstLine = s.nextLine();
            String[] year = firstLine.split("\t");
            while (s.hasNextLine()) {
                firstLine = s.nextLine();
                String[] parts = firstLine.split("\t");
                Parties p = new Parties(parts[0]);
                for (int i = 1; i < parts.length; i++) {
                    if (!isDouble(parts[i])) {
                        continue;
                    }
                    p.addYearlyRatings(Integer.valueOf(year[i]), Double.valueOf(parts[i]));
                }
                parties.add(p);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parties;
    }

    private List<XYChart.Series> convertFileDataIntoChartData(List<Parties> parties) {
        List<XYChart.Series> data = new ArrayList<>();
        for (Parties party : parties) {
            XYChart.Series p = new XYChart.Series();
            p.setName(party.getPartyName());
            for (Integer year : party.getYearlyRatings().keySet()) {
                p.getData().add(new XYChart.Data(year, party.getYearlyRatings().get(year)));
            }
            data.add(p);
        }
        return data;
    }
}
