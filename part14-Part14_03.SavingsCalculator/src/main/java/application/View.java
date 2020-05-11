/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javafx.scene.Parent;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

/**
 *
 * @author woohoo
 */
public class View {

    private Slider savingsSlider;
    private Model model;
    private LineChart<Number, Number> lineChart;
    private List<XYChart.Data> savingsData;
    private XYChart.Series savingsLine;
    private Slider interestSlider;
    private XYChart.Series interestLine;
    private ArrayList<Object> interestData;
    private Label savingsSliderLabel;
    private Label interestSliderLabel;

    public View(Model model) {
        this.model = model;
        this.savingsData = new ArrayList<>();
        this.interestData = new ArrayList<>();
        this.savingsLine = new XYChart.Series();
        this.interestLine = new XYChart.Series();
        this.savingsLine.setName("Yearly savings");
        this.interestLine.setName("Yearly interest");
    }

    public Parent getLayout() {
        BorderPane layout = new BorderPane();
        NumberAxis xAxis = new NumberAxis(0, 50, 1);
        NumberAxis yAxis = new NumberAxis();
        this.lineChart = new LineChart<>(xAxis, yAxis);

        VBox topComponent = new VBox();

        BorderPane top1 = new BorderPane();
        top1.setLeft(new Label("Monthly savings"));
        savingsSlider = new Slider();
        savingsSlider.setMin(25.0);
        savingsSlider.setMax(250.0);
        savingsSlider.setShowTickLabels(true);
        savingsSlider.setShowTickMarks(true);
        savingsSlider.setSnapToTicks(true);
        savingsSlider.setMajorTickUnit(25);
        savingsSlider.setMinorTickCount(5);
        savingsSlider.setBlockIncrement(5);
        top1.setCenter(savingsSlider);
        savingsSliderLabel = new Label("");
        top1.setRight(savingsSliderLabel);
        savingsSlider.setOnMouseReleased((event) -> {
            savingsSliderLabel.setText("");
            // Set the model's monthly saving amount
            this.model.setMonthlySavingsAmount((int) savingsSlider.getValue());

            // recalculate the sums
            this.model.recalculate();

            this.savingsData = new ArrayList<>();

            this.savingsLine = new XYChart.Series();
            this.savingsLine.setName("Yearly savings");
            setLineChart(this.model.getYearlyAmount(), this.model.getYearlyAmountIncludingSavings());
            updateSavingsLineChart();
            this.savingsSliderLabel.setText("" + String.format("%.2f", savingsSlider.getValue()));

            interestSliderLabel.setText("");
            // Set the model's monthly saving amount
            this.model.setInterestRate(interestSlider.getValue());

            // recalculate the sums
            this.model.recalculate();

            this.interestData = new ArrayList<>();
            this.interestLine = new XYChart.Series();
            this.interestLine.setName("Yearly interest");
            setLineChart(this.model.getYearlyAmount(), this.model.getYearlyAmountIncludingSavings());
            updateInterestLineChart();
            interestSliderLabel.setText("" + String.format("%.2f", interestSlider.getValue()));
        });

        BorderPane top2 = new BorderPane();
        interestSlider = new Slider();
        interestSlider.setMin(0.0);
        interestSlider.setMax(10.0);
        interestSlider.setShowTickLabels(true);
        interestSlider.setShowTickMarks(true);
        interestSlider.setMajorTickUnit(10);
        interestSlider.setMinorTickCount(9);
        interestSlider.setBlockIncrement(9);
        interestSlider.setSnapToTicks(true);

        top2.setLeft(new Label("Yearly interest rate"));
        top2.setCenter(interestSlider);
        interestSliderLabel = new Label("");
        top2.setRight(interestSliderLabel);

        interestSlider.setOnMouseReleased((event) -> {
            savingsSliderLabel.setText("");
            // Set the model's monthly saving amount
            this.model.setMonthlySavingsAmount((int) savingsSlider.getValue());

            // recalculate the sums
            this.model.recalculate();

            this.savingsData = new ArrayList<>();

            this.savingsLine = new XYChart.Series();
            this.savingsLine.setName("Yearly savings");
            setLineChart(this.model.getYearlyAmount(), this.model.getYearlyAmountIncludingSavings());
            updateSavingsLineChart();
            this.savingsSliderLabel.setText("" + String.format("%.2f", savingsSlider.getValue()));

            interestSliderLabel.setText("");
            // Set the model's monthly saving amount
            this.model.setInterestRate(interestSlider.getValue());

            // recalculate the sums
            this.model.recalculate();

            this.interestData = new ArrayList<>();
            this.interestLine = new XYChart.Series();
            this.interestLine.setName("Yearly interest");
            setLineChart(this.model.getYearlyAmount(), this.model.getYearlyAmountIncludingSavings());
            updateInterestLineChart();
            interestSliderLabel.setText("" + String.format("%.2f", interestSlider.getValue()));
        });
        topComponent.getChildren().addAll(top1, top2);

        layout.setTop(topComponent);
        layout.setCenter(lineChart);
        return layout;
    }

    private void setLineChart(Map<Integer, Integer> savingsData, Map<Integer, Double> interestData) {
        this.savingsData.clear();
        this.interestData.clear();
        for (Integer year : savingsData.keySet()) {
            this.savingsData.add(new XYChart.Data(year, savingsData.get(year)));
            this.interestData.add(new XYChart.Data(year, interestData.get(year)));
        }
    }

    private void updateSavingsLineChart() {
        Iterator<Series<Number, Number>> it = this.lineChart.getData().iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals("Yearly savings")) {
                it.remove();
            }
        }

        this.savingsData.forEach((d) -> {
            this.savingsLine.getData().add(d);
        });
        this.lineChart.getData().add(savingsLine);
    }

    private void updateInterestLineChart() {
        Iterator<Series<Number, Number>> it = this.lineChart.getData().iterator();
        while (it.hasNext()) {
            if (it.next().getName().equals("Yearly interest")) {
                it.remove();
            }
        }
        this.interestData.forEach((d) -> {
            this.interestLine.getData().add(d);
        });

        this.lineChart.getData().add(interestLine);
    }
}
