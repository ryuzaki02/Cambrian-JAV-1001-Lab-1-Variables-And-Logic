/*
    Name - Aman Thakur
    Student Number - A00257629
    Program - JAV-1001 - 50733 - App Development for Android - 202205 - 001
    Lab - 1 - Variables and Logic
*/

import java.util.Scanner;

// This class holds all the logic to convert desired metric with help of user inputs. 
public class MetricConversion {

    // tryAgain :- This boolena variable checks whether it's a fresh start or user
    // has entered try again.
    private Boolean tryAgain = false;

    /*
     * This enum holds all the metric coversion available in the system.
     * Add more values to it to reflect more conversion to user.
     */
    private enum MetricOptions {
        KmToMil(Constants.KmToMil, 1),
        MilToKm(Constants.MilToKm, 2),
        CmToInch(Constants.CmToInch, 3),
        InchToCm(Constants.InchToCm, 4),
        KgToLb(Constants.KgToLb, 5),
        LbToKg(Constants.LbToKg, 6),
        GmToOz(Constants.GmToOz, 7),
        OzToGm(Constants.OzToGm, 8),
        CelToF(Constants.CelToF, 9),
        CelToK(Constants.CelToK, 10),
        FToCel(Constants.FToCel, 11),
        FToK(Constants.FToK, 12),
        LtrToCup(Constants.LtrToCup, 13),
        CupToLtr(Constants.CupToLtr, 14);

        private String stringValue;
        private int intValue;

        // Initialiser of enum value
        // toString: A string value of enum.
        // value: An integer value of enum.
        private MetricOptions(String toString, int value) {
            stringValue = toString;
            intValue = value;
        }

        // Provides desired string and integer value of enum for computation purposes.
        @Override
        public String toString() {
            return stringValue;
        }

        // Map user input integer to MetricOptions for computation purposes.
        /// Returns MetricOptions variable.
        // metricValue: An integer value which maps itself to particular enum case.
        public static MetricOptions getMetric(int metricValue) {
            for (MetricOptions option : MetricOptions.values()) {
                if (option.intValue == metricValue) {
                    return option;
                }
            }
            return null;
        }
    }

    // This method takes user inputs and convert it to desired selected metric by
    // user.
    // Does not return anything
    void startMetricConversion() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Checks whether it's fresh start or try again.
            if (!tryAgain) {
                // This only excutes if it's fresh start.
                // Shows welcome message and ask user to enter any key to continue execution.
                System.out.println(
                        Constants.WelcomeMessage);
                scanner.nextLine();
            }
            // Asks user to enter value to convert.
            System.out.println(Constants.ValueToConvertMessage);
            double enteredValue = scanner.nextDouble();
            scanner.nextLine();
            System.out.println("\n");
            String inpuString = Constants.AvailableMetricsMessage;
            // This loop shows all the available metric options to user.
            // It iterates through all the values of enum and append to input string.
            for (MetricOptions metric : MetricOptions.values()) {
                inpuString += "\n" + metric.intValue + ". " + metric.stringValue;
            }
            System.out.println(inpuString);
            System.out.println("\n");
            // This asks for option selection from user.
            System.out.println(Constants.OptionSelectionMessage);
            int selectedOption = scanner.nextInt();
            System.out.println("\n");
            // Converts user selected option to particular MetricOptions value for further
            // metric conversion.
            MetricOptions selectedMetricOption = MetricOptions.getMetric(selectedOption);
            // Checks whether user has entered value from the options given or not.
            String convertedString = selectedMetricOption == null ? Constants.OptionNotAvailableMessage
                    : getConvertedValue(selectedMetricOption, enteredValue);
            // If user selected available option then it shows actual conversion. Otherwise,
            // shows message to select again.
            System.out.println("=> " + convertedString + "\n");
            scanner.nextLine();
            // This will re-iterate the whole function for next selection.
            tryAgain(scanner);
        } catch (Exception e) {
            if (e.toString().equals("java.util.InputMismatchException")) {
                System.out.println(Constants.InvalidInput);
            } else {
                System.out.println(e.toString());
            }
        }
    }

    // Function to re-iterate whole metric conversion on the basis of user input.
    // Asks "Y": To enter more values, and "N" : To quit.
    // If user enters any other value, it calls itself.
    private void tryAgain(Scanner scanner) {
        System.out.println(Constants.TryAgainMessage);
        String tryAgainInput = scanner.nextLine();
        if (tryAgainInput.equalsIgnoreCase("Y")) {
            tryAgain = true;
            startMetricConversion();
        } else if (tryAgainInput.equalsIgnoreCase("N")) {
            return;
        } else {
            System.out.println(Constants.InvalidOptionMessage);
            tryAgain(scanner);
        }
    }

    // This function is the core of Metric coversion
    // Holds all the mathematical conversions and formulae
    // Switch cases use to detect user input and convert it to desired result
    private String getConvertedValue(MetricOptions metricOption, double enteredValue) {
        double convertedValue;
        switch (metricOption) {
            case KmToMil:
                convertedValue = enteredValue * 0.62;
                return enteredValue + " " + Constants.KM + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Mile + (convertedValue > 1 ? "s" : "");
            case MilToKm:
                convertedValue = enteredValue * 1.61;
                return enteredValue + " " + Constants.Mile + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.KM + (convertedValue > 1 ? "s" : "");
            case CmToInch:
                convertedValue = enteredValue * 0.39;
                return enteredValue + " " + Constants.CM + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Inch + (convertedValue > 1 ? "s" : "");
            case InchToCm:
                convertedValue = enteredValue * 2.54;
                return enteredValue + " " + Constants.Inch + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.CM + (convertedValue > 1 ? "s" : "");
            case KgToLb:
                convertedValue = enteredValue * 2.2;
                return enteredValue + " " + Constants.KG + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Lb + (convertedValue > 1 ? "s" : "");
            case LbToKg:
                convertedValue = enteredValue * 0.45;
                return enteredValue + " " + Constants.Lb + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.KG + (convertedValue > 1 ? "s" : "");
            case GmToOz:
                convertedValue = enteredValue * 0.04;
                return enteredValue + " " + Constants.GM + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Ounce + (convertedValue > 1 ? "s" : "");
            case OzToGm:
                convertedValue = enteredValue * 28.35;
                return enteredValue + " " + Constants.Ounce + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.GM + (convertedValue > 1 ? "s" : "");
            case CelToF:
                convertedValue = (enteredValue * 9 / 5) + 32;
                return enteredValue + " " + Constants.Cel + Constants.EqualsTo + convertedValue + " "
                        + Constants.F;
            case CelToK:
                convertedValue = enteredValue + 273.15;
                return enteredValue + " " + Constants.Cel + Constants.EqualsTo + convertedValue + " "
                        + Constants.Kelvin;
            case FToCel:
                convertedValue = (enteredValue - 32) + 5 / 9;
                return enteredValue + " " + Constants.F + Constants.EqualsTo + convertedValue + " "
                        + Constants.Cel;
            case FToK:
                convertedValue = (enteredValue - 32) * 5 / 9 + 273.15;
                return enteredValue + " " + Constants.F + Constants.EqualsTo + convertedValue + " "
                        + Constants.Cel;
            case LtrToCup:
                convertedValue = enteredValue * 4.17;
                return enteredValue + " " + Constants.Ltr + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Cup + (convertedValue > 1 ? "s" : "");
            case CupToLtr:
                convertedValue = enteredValue * 4.17;
                return enteredValue + " " + Constants.Cup + (enteredValue > 1 ? "s" : "") + Constants.EqualsTo
                        + convertedValue
                        + " "
                        + Constants.Ltr + (convertedValue > 1 ? "s" : "");
            default:
                return "";
        }
    }
}
