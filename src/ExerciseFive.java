import java.util.Scanner;

public class ExerciseFive {
    public static String replacerByIndex(String unfinishedString, int indexOfCharToReplace, char replaceWithThis) {
        String fixedString= "";
        for (int i = 0; i < unfinishedString.length(); i++) {
            if (indexOfCharToReplace != i) {
                fixedString = fixedString + unfinishedString.charAt(i);
            }
            else {
                fixedString=fixedString+replaceWithThis;
            }
        }
        return fixedString;
    }

    public static String charsReplacer(String userString, char firstChar, char secondChar) {
        String fixedString=userString;
        for (int i=0; i < userString.length(); i++) {
            if (userString.charAt(i) == firstChar) {
                fixedString = replacerByIndex(fixedString,i,secondChar);
            }
            else {
                if (userString.charAt(i)==secondChar){
                    fixedString = replacerByIndex(fixedString,i,firstChar);
                }
            }
        }
        return fixedString;
    }

    public static String mostPopularCharsSwitcher() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a String");
        String userString = scanner.nextLine();
        int appearanceCounter = 0;
        int highestAppearanceCount = 0;
        int indexOfMostPopular = -1;
        int secondHighestAppearanceCount = 0;
        int indexOfSecondMostPopular = -1;
        char[] arrayOfCheckedChars = new char[userString.length()];
        int sizeOfArray = 0;
        boolean didItAppear = false;
        for (int i = 0; i < userString.length(); i++) {
            if (userString.charAt(i)==' '){
                continue;
            }
            appearanceCounter = 0;
            didItAppear=false;
            for (int j = 0; j < sizeOfArray; j++) {
                if (userString.charAt(i) == arrayOfCheckedChars[j]) {
                    didItAppear = true;
                    break;
                }
            }
            if (didItAppear) {
                continue;
            }
            arrayOfCheckedChars[sizeOfArray] = userString.charAt(i);
            sizeOfArray++;
            for (int j = 0; j < userString.length(); j++) {
                if (userString.charAt(i) == userString.charAt(j)) {
                    appearanceCounter++;
                }
            }
            if (appearanceCounter > highestAppearanceCount) {
                secondHighestAppearanceCount = highestAppearanceCount;
                indexOfSecondMostPopular = indexOfMostPopular;
                highestAppearanceCount = appearanceCounter;
                indexOfMostPopular = i;
            } else {
                if (appearanceCounter > secondHighestAppearanceCount) {
                    secondHighestAppearanceCount = appearanceCounter;
                    indexOfSecondMostPopular = i;
                }
            }
        }
        String fixedString=null;
        fixedString=charsReplacer(userString,userString.charAt(indexOfMostPopular),userString.charAt(indexOfSecondMostPopular));
        return fixedString;
    }
    public static void main(String[] args){
        String encryptedString =mostPopularCharsSwitcher();
        System.out.println(encryptedString);
    }
}
