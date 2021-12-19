import java.util.Scanner;

public class ExerciseNine { // skipped 8
    public static boolean duplicateDetector(String duplicateSuspect) {
        boolean duplicateIndicator = false;
        boolean breakOuterLoop = false;
        for (int i = 0; i < duplicateSuspect.length(); i++) {
            for (int j = 0; j < duplicateSuspect.length(); j++) {
                if (duplicateSuspect.length() == 1) {
                    duplicateIndicator = false;
                    breakOuterLoop = true;
                    break;
                }
                if (duplicateSuspect.charAt(i) == duplicateSuspect.charAt(j) && i != j) {
                    duplicateIndicator = true;
                    breakOuterLoop = true;
                    break;
                } else {
                    duplicateIndicator = false;
                }
            }
            if (breakOuterLoop) {
                break;
            }
        }
        return duplicateIndicator;
    }

    public static boolean digitsInRangeIndicator(String userCodeGuess) {
        final int LOWEST_IN_RANGE_ASCII = 49;
        final int HIGHEST_IN_RANGE_ASCII = 54;
        boolean isItInRange = true;
        for (int i = 0; i < userCodeGuess.length(); i++) {
            if (userCodeGuess.charAt(i) < LOWEST_IN_RANGE_ASCII || userCodeGuess.charAt(i) > HIGHEST_IN_RANGE_ASCII) {
                isItInRange = false;
                break;
            } else {
                isItInRange = true;
            }
        }
        return isItInRange;
    }

    public static String secretCodeMaker() {
        final int LENGTH_OF_CODE = 4;
        boolean didADigitGotAdded = false;
        String secretCode = new String();
        int proposedNewDigit = 0;
        for (int i = 0; i < LENGTH_OF_CODE; i++) {
            while (!didADigitGotAdded) {
                proposedNewDigit = (int) (6 * Math.random() + 1);
                boolean isItValidDigit = !duplicateDetector(secretCode + (proposedNewDigit));
                if (isItValidDigit) {
                    secretCode = secretCode + proposedNewDigit;
                    break;
                }
            }
        }
        return secretCode;
    }

    public static int[] correctAndPartialDigitsFinder(String userGuess, String secretCode) {
        final int NUMBER_OF_OPTIONS = 2;
        int[] correctDigitsAndPartialDigitsAmounts = new int[NUMBER_OF_OPTIONS];
        final int CORRECT_DIGITS_CELL = 0;
        final int PARTIAL_DIGITS_CELL = 1;
        for (int i = 0; i < userGuess.length(); i++) {
            for (int j = 0; j < secretCode.length(); j++) {
                if (userGuess.charAt(i) == secretCode.charAt(j)) {
                    if (i == j) {
                        correctDigitsAndPartialDigitsAmounts[CORRECT_DIGITS_CELL]++;
                    } else {
                        correctDigitsAndPartialDigitsAmounts[PARTIAL_DIGITS_CELL]++;
                    }
                }
            }
        }
        return correctDigitsAndPartialDigitsAmounts;
    }

    public static void main(String[] args) {
        final int LENGTH_OF_CODE = 4;
        boolean winIndicator = false;
        Scanner scanner = new Scanner(System.in);
        String secretCode = secretCodeMaker();
        boolean isLevelNumberValid = false;
        System.out.println("welcome to the 'Secret code game'!\n" +
                "a secret-four digit number will be generated, and its digits would be in a range of 1 to 6, and each digit will appear no more than once. \n" +
                "you need to discover the secret code within the try limit to win the game \n" +
                "if you get right one of the digits from the secret code in the dame place as in the code it will be called 'correct digit' \n" +
                "but if one of the digits appear in the secret code but in different place it will be called 'partially correct digit' \n " +
                "if you enter the same digit twice you will lose 2 guesses instead of one.\n" +
                "there are 4 difficulty levels:\n" +
                "1.Easy- you get 20 trys. \n" +
                "2.Normal- you get 15  trys. \n" +
                "3.Hard- you get 10 trys. \n" +
                "4.Surprising mode- you get random trys number between 5 to 25, you will not be told how much guesses you got to go at any point.\n" +
                "to start enter a number between 1 to 4 according to wanted difficulty level. ");
        int levelChosen = scanner.nextInt();
        int tryAmount = 0;
        boolean isSurprising = false;
        while (isLevelNumberValid == false) {
            switch (levelChosen) {
                case 1: {
                    isLevelNumberValid = true;
                    tryAmount = 20;
                    break;
                }
                case 2: {
                    isLevelNumberValid = true;
                    tryAmount = 15;
                    break;
                }
                case 3: {
                    isLevelNumberValid = true;
                    tryAmount = 10;
                    break;
                }
                case 4: {
                    tryAmount = (int) (21 * Math.random() + 5);
                    isLevelNumberValid = true;
                    isSurprising = true;
                    break;
                }
                default: {
                    System.out.println("please enter a valid level number");
                    levelChosen = scanner.nextInt();
                    isLevelNumberValid = false;
                    break;
                }
            }
        }
        String userGuess = new String();
        int numberOfTurns = 0;
        while (tryAmount > 0) {
            if (!isSurprising) {
                System.out.println("you got " + tryAmount + " guesses to go");
            }
            System.out.println("please enter a guess");
            if (numberOfTurns == 0) {
                while (true) {
                    userGuess = scanner.nextLine();
                    if (userGuess.length() < 4) {
                    } else {
                        break;
                    }
                }
            } else {
                userGuess = scanner.nextLine();
            }
            numberOfTurns++;
            if (duplicateDetector(userGuess) == true) {
                System.out.println("invalid input, you have duplicates, -2 trys :(");
                tryAmount = tryAmount - 2;
                continue;
            }
            if (userGuess.length() != 4) {
                System.out.println("you entered invalid guess, quit wasting your trys, it should be 4 digit long.");
                tryAmount--;
                continue;
            }
            if (!digitsInRangeIndicator(userGuess)) {
                System.out.println("all digits should be between 1 to 6, such a wasted turn");
                tryAmount--;
                continue;
            }
            int[] correctDigitsAndPartialDigitsAmounts = correctAndPartialDigitsFinder(userGuess, secretCode);
            final int CORRECT_DIGITS_CELL = 0;
            final int PARTIAL_DIGITS_CELL = 1;
            if (correctDigitsAndPartialDigitsAmounts[0] == LENGTH_OF_CODE) {
                System.out.println("congratulations you won!");
                winIndicator = true;
                break;
            }
            System.out.println("you have " + correctDigitsAndPartialDigitsAmounts[CORRECT_DIGITS_CELL] + " correct digits and " + correctDigitsAndPartialDigitsAmounts[PARTIAL_DIGITS_CELL] + " partially correct digits.");
            tryAmount--;
        }
        if (!winIndicator) {
            System.out.println("looks like you're out of guesses:( \n" +
                    "by the way the number was: " + secretCode + "\n" +
                    "better luck next time!");
        }
    }
}
