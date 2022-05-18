import java.util.Scanner;

public class Convert {
    public static void main(String[] args) {
        metricConversion();
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
        FToCel("Fahrenheit to Celcius", 10),
        LtrToCup("Liters to Cups", 11),
        CupToLtr("Cups to Liters", 12);

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
            return MetricOptions.CelToF;
        }
    }

    static void metricConversion() {
        System.out.println("This is metric conversion system. Please enter any key to continue.");
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();
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
        String convertedString = getConvertedValue(MetricOptions.getMetric(selectedOption), enteredValue);
        System.out.println(convertedString);
    }

    static String getConvertedValue(MetricOptions metricOption, double enteredValue) {
        double convertedValue;
        switch (metricOption) {
            case MilToKm:
                convertedValue = enteredValue * 1.61;
                return enteredValue + " " + (enteredValue > 1 ? "Miles" : "Mile") + " = " + convertedValue + " "
                        + (convertedValue > 1 ? "KMs" : "KM");
            case KmToMil:
                convertedValue = enteredValue * 0.62;
                return enteredValue + " " + (enteredValue > 1 ? "KMs" : "KM") + " = " + convertedValue + " "
                        + (convertedValue > 1 ? "Miles" : "Mile");
        }
        return "";
    }
}
