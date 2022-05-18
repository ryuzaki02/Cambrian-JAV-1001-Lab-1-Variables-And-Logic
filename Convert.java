import java.util.Scanner;

public class Convert {
    public static void main(String[] args) {
        metricConversion(false);
    }

    public enum MetricOptions {
        KmToMil("KMs to Miles", 1),
        MilToKm("Miles to KMs", 2),
        CmToInch("CMs to Inches", 3),
        InchToCm("Inches to CMs", 4),
        KgToLb("KGs to Lbs", 5),
        LbToKg("Lbs to KGs", 6),
        GmToOz("GMs to Ounces", 7),
        OzToGm("Ounces to GMs", 8),
        CelToF("Celcius to Fahrenheit", 9),
        CelToK("Celcius to Kelvin", 10),
        FToCel("Fahrenheit to Celcius", 11),
        FToK("Fahrenheit to Kelvin", 12),
        LtrToCup("Liters to Cups", 13),
        CupToLtr("Cups to Liters", 14);

        private String stringValue;
        private int intValue;

        private MetricOptions(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        @Override
        public String toString() {
            return stringValue;
        }

        public int toInt() {
            return intValue;
        }

        public static MetricOptions getMetric(int metricValue) {
            for (MetricOptions option : MetricOptions.values()) {
                if (option.intValue == metricValue) {
                    return option;
                }
            }
            return null;
        }
    }

    static void metricConversion(boolean isTryAgain) {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!isTryAgain) {
                System.out.println(
                        "*********** Welcome to the metric conversion system ***********.\nPlease enter any key to continue.");
                scanner.nextLine();
            }
            System.out.println("Please enter any value which you want to convert!");
            double enteredValue = scanner.nextDouble();
            System.out.println("\n");
            String inpuString = "Availbale metric conversions are :-\n";
            for (MetricOptions metric : MetricOptions.values()) {
                inpuString += "\n" + metric.intValue + ". " + metric.stringValue;
            }
            System.out.println(inpuString);
            System.out.println("\n");
            System.out.println("Please select any one metric from the options given.");
            int selectedOption = scanner.nextInt();
            System.out.println("\n");
            MetricOptions selectedMetricOption = MetricOptions.getMetric(selectedOption);
            String convertedString = selectedMetricOption == null ? "OOPS. Selected option is not available."
                    : getConvertedValue(selectedMetricOption, enteredValue);
            System.out.println(convertedString);
            scanner.nextLine();
            tryAgain(scanner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    static void tryAgain(Scanner scanner) {
        System.out.println("Do you want to try any other option? (Y/N)");
        String tryAgainInput = scanner.nextLine();
        if (tryAgainInput.equalsIgnoreCase("Y")) {
            metricConversion(true);
        } else if (tryAgainInput.equalsIgnoreCase("N")) {
            return;
        } else {
            System.out.println("Invalid Option. Try again.\n");
            tryAgain(scanner);
        }
    }

    static String getConvertedValue(MetricOptions metricOption, double enteredValue) {
        double convertedValue;
        switch (metricOption) {
            case KmToMil:
                convertedValue = enteredValue * 0.62;
                return enteredValue + " " + (enteredValue > 1 ? "KMs" : "KM") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Miles" : "Mile");
            case MilToKm:
                convertedValue = enteredValue * 1.61;
                return enteredValue + " " + (enteredValue > 1 ? "Miles" : "Mile") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "KMs" : "KM");
            case CmToInch:
                convertedValue = enteredValue * 0.39;
                return enteredValue + " " + (enteredValue > 1 ? "Cms" : "Cm") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Inches" : "Inch");
            case InchToCm:
                convertedValue = enteredValue * 2.54;
                return enteredValue + " " + (enteredValue > 1 ? "Inches" : "Inch") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Cms" : "Cm");
            case KgToLb:
                convertedValue = enteredValue * 2.2;
                return enteredValue + " " + (enteredValue > 1 ? "KGs" : "KG") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Lbs" : "Lb");
            case LbToKg:
                convertedValue = enteredValue * 0.45;
                return enteredValue + " " + (enteredValue > 1 ? "Lbs" : "Lb") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "KGs" : "KG");
            case GmToOz:
                convertedValue = enteredValue * 0.04;
                return enteredValue + " " + (enteredValue > 1 ? "Gms" : "Gm") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "ounces" : "ounce");
            case OzToGm:
                convertedValue = enteredValue * 28.35;
                return enteredValue + " " + (enteredValue > 1 ? "ounces" : "ounce") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + (convertedValue > 1 ? "gms" : "gm");
            case CelToF:
                convertedValue = (enteredValue * 9 / 5) + 32;
                return enteredValue + " " + "C" + Constants.EqualsTo + convertedValue + " "
                        + "F";
            case CelToK:
                convertedValue = enteredValue + 273.15;
                return enteredValue + " " + "C" + Constants.EqualsTo + convertedValue + " "
                        + "K";
            case FToCel:
                convertedValue = (enteredValue - 32) + 5 / 9;
                return enteredValue + " " + "F" + Constants.EqualsTo + convertedValue + " "
                        + "C";
            case FToK:
                convertedValue = (enteredValue - 32) * 5 / 9 + 273.15;
                return enteredValue + " " + "F" + Constants.EqualsTo + convertedValue + " "
                        + "C";
            case LtrToCup:
                convertedValue = enteredValue * 4.17;
                return enteredValue + " " + (enteredValue > 1 ? "Ltrs" : "Ltr") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Cups" : "Cup");
            case CupToLtr:
                convertedValue = enteredValue * 4.17;
                return enteredValue + " " + (enteredValue > 1 ? "Cups" : "Cup") + Constants.EqualsTo + convertedValue
                        + " "
                        + (convertedValue > 1 ? "Ltrs" : "Ltr");
            default:
                return "";
        }
    }
}
