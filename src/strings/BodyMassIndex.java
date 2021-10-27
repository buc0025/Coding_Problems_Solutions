package strings;
/*
https://edabit.com/challenge/AkQseRG6jtznJH9bb

Body Mass Index (BMI) is found by taking your weight in kilograms and dividing by the square of your height in meters. The BMI
categories are:

Underweight: <18.5
Normal weight: 18.5–24.9
Overweight: 25–29.9
Obesity: BMI of 30 or greater
Create a function that will accept weight and height (in kilos, pounds, meters, or inches) and return the BMI and the associated
category. Round the BMI to nearest tenth.

Notes
1 inch = 0.0254 meter
1 pound = 0.453592 kilo
 */

public class BodyMassIndex {

    // Not returning weight individual is overweight, normal weight, or underweight. Also need to figure out returning tenth of
    // number
    public static String BMI(String weight, String height) {
        String weight2 = "";
        String height2 = "";
        double kilo = 0;
        double meter = 0;

        for (int i = 0; i < weight.length(); i++) {
            if (Character.isDigit(weight.charAt(i))) {
                weight2 += weight.substring(i, i + 1);
            } else {
                break;
            }
        }

        for (int i = 0; i < height.length(); i++) {
            if (Character.isDigit(height.charAt(i))) {
                height2 += height.substring(i, i + 1);
            } else {
                break;
            }
        }

        if (weight.contains("kilo")) {
            kilo = Integer.parseInt(weight2);
        } else {
            kilo = Integer.parseInt(weight2) * 0.453592;
            kilo = Math.round(kilo);
        }

        if (height.contains("meter")) {
            meter = Integer.parseInt(height2);
        } else {
            meter = Integer.parseInt(height2) * 0.0254;
        }

        double bmi = kilo / (meter * meter);

        System.out.format("%.1f", bmi);
    }
}
