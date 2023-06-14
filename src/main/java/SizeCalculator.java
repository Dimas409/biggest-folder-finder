import java.util.HashMap;

public class SizeCalculator {
    private static char[] sizeNames = {'b', 'K', 'M', 'G'};
    private static HashMap<Character, Integer> char2multiplier = getMultipliers();
    public static String getHumanReadableSize(long size){
        for (int i = 0; i < sizeNames.length; i++) {
            double value = ((double) size) / Math.pow(1024., i);
            if(value < 1024){
                return Math.round(value * 100) / 100. + "" + sizeNames[i] + (i > 0 ? "b" : "");
            }
        }
        return "Very big";
//        int power = (int) (Math.log(size) / Math.log(1024));
//        double value = size / Math.pow(1024, power);
//        double roundedValue = Math.round(value * 100) / 100.;
//        return roundedValue + " " + sizeNames[power];
    }

    public static   long getSizeFromHumanReadable(String size){
        char sizeFactor = size
                .replaceAll("[0-9\\s+]+", "")
                .charAt(0);
        int multiplier = char2multiplier.get(sizeFactor);
        long length = multiplier * Long.valueOf(size.replaceAll("[^0-9]", ""));

        return length;
    }
    public static HashMap<Character, Integer> getMultipliers(){
        char[] multipliers = {'B', 'K', 'M', 'G', 'T'};
        HashMap<Character, Integer> char2multiplier = new HashMap<>();
        for (int i = 0; i < multipliers.length; i++) {
            char2multiplier.put(multipliers[i], (int)Math.pow(1024, i));
        }
        return char2multiplier;
    }
}
