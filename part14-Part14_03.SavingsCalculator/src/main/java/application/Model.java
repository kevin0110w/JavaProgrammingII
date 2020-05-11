/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author woohoo
 */
public class Model {

    private int monthlySavingsAmount;
    private double interestRate;
    private final int SAVING_YEARS = 31;
    private Map<Integer, Integer> yearlyAmount;
    private Map<Integer, Double> yearlyAmountIncludingSavings;

    public Model() {
        this.yearlyAmount = new HashMap<>();
        this.yearlyAmountIncludingSavings = new HashMap<>();
        this.monthlySavingsAmount = 0;
        this.interestRate = 0.0;
    }

    public void calculateYearlyAmount() {
        for (int i = 0; i < SAVING_YEARS; i++) {
            int yearlyamount = ((int) this.monthlySavingsAmount) * i * 12;
            saveYearlyAmount(i, yearlyamount);
        }

        for (Integer year : this.yearlyAmount.keySet()) {
            double yearlyamount = 0.0;
            int amountAYear = this.yearlyAmount.get(1);
            for (int i = 0; i < year; i++) {
                yearlyamount += ((yearlyamount + amountAYear) * ((this.interestRate) / 100)) + amountAYear;
            }
            saveYearlyAmountPlusInterest(year, yearlyamount);
        }
    }

    private void saveYearlyAmount(int i, int yearlyamount) {
        this.yearlyAmount.put(i, yearlyamount);
    }

    public void setMonthlySavingsAmount(double monthlySavingsAmount) {
        this.monthlySavingsAmount = (int) monthlySavingsAmount;
    }

    public void clearYearlySavingAmounts() {
        this.yearlyAmount.clear();
    }

    public void clearYearlySavingAmountsIncludingSavings() {
        this.yearlyAmountIncludingSavings.clear();
    }

    public int getMonthlySavingsAmount() {
        return monthlySavingsAmount;
    }

    public int getSAVING_YEARS() {
        return SAVING_YEARS;
    }

    public Map<Integer, Integer> getYearlyAmount() {
        return yearlyAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public Map<Integer, Double> getYearlyAmountIncludingSavings() {
        return yearlyAmountIncludingSavings;
    }

    public void recalculate() {
        clearYearlySavingAmounts();
        calculateYearlyAmount();
    }

    private void saveYearlyAmountPlusInterest(int i, double yearlyAmountIncludingSavings) {
        this.yearlyAmountIncludingSavings.put(i, yearlyAmountIncludingSavings);
    }

    public void setInterestRate(double i) {
        this.interestRate = i;
    }
}
