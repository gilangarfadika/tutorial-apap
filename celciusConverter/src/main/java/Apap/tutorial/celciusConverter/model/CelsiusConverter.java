package Apap.tutorial.celciusConverter.model;

public class CelsiusConverter {
    private Double celcius ;

    public CelsiusConverter(Double celcius) {
        this.celcius = celcius;
    }

    public String ConvertToFahrenheit() {
        double fahrenheit = (celcius*9/5) + 32 ;
        return  String.format("%.2f", fahrenheit);

    }

    public  String ConvertToKelvin(){
        double kelvin = celcius + 273.15;
        return String.format("%.2f",kelvin);

    }

    public  String  ConvertToRankine() {
        double rankine = (celcius + 273.15) *9/5 ;
        return  String.format("%.2f", rankine);
    }

    public double getCelsius(){return  celcius;}


}
