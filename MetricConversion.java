import java.util.Scanner;

public class MetricConversion {

    private Boolean tryAgain = false;

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

    void startMetricConversion() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (!tryAgain) {
                System.out.println(
                        Constants.WelcomeMessage);
                scanner.nextLine();
            }
            System.out.println(Constants.ValueToConvertMessage);
            double enteredValue = scanner.nextDouble();
            System.out.println("\n");
            String inpuString = Constants.AvailableMetricsMessage;
            for (MetricOptions metric : MetricOptions.values()) {
                inpuString += "\n" + metric.intValue + ". " + metric.stringValue;
            }
            System.out.println(inpuString);
            System.out.println("\n");
            System.out.println(Constants.OptionSelectionMessage);
            int selectedOption = scanner.nextInt();
            System.out.println("\n");
            MetricOptions selectedMetricOption = MetricOptions.getMetric(selectedOption);
            String convertedString = selectedMetricOption == null ? Constants.OptionNotAvailableMessage
                    : getConvertedValue(selectedMetricOption, enteredValue);
            System.out.println("=> " + convertedString + "\n");
            scanner.nextLine();
            tryAgain(scanner);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

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
