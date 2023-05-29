package concurrency.core;

public class ExGregorySeries {

    public static void main(String[] args) throws Exception {

        GregorySeriesCalculator calculator = new GregorySeriesCalculator();
        System.out.println(calculator.calculate());
    }
}
