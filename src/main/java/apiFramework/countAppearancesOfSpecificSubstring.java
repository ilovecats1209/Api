package apiFramework;



public class countAppearancesOfSpecificSubstring {
    public static int wordCount(String targetString, String subString){
        int index = targetString.indexOf(subString);
        int count = 0;
        while (index != -1) {
            count++;
            index = targetString.indexOf(subString, index+1);
        }
        return count;
    }
}
