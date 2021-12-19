import java.util.Scanner;

//assume that 0 is even
public class ExerciseOne {
    public static boolean evenDetector(int number) {
        boolean isEven = false;
        double evanChecker = number;
        if ((evanChecker / 2) == ((int) evanChecker / 2)) {
            isEven = true;
        } else {
            isEven = false;
        }
        return isEven;
    }

    public static boolean swapDetector(int number) {
        boolean isSwapped = true;
        while (true) {
            if (number / 10 == 0) {
                isSwapped = true;
                break;
            } else {
                int lastCurrentDigit = number % 10;
                int secondToLastCurrentDigit = (number / 10) % 10;
                if (evenDetector(lastCurrentDigit) == evenDetector(secondToLastCurrentDigit)) {
                    isSwapped = false;
                    break;
                } else {
                    isSwapped = true;
                }
                number = number / 10;
            }
        }
        return isSwapped;
    }

    public static int lowestDigitSumSwappedNumberFinder(int[] numbersArray) {
        int sum = 0;
        int highestSum = 0;
        int highestSumIndex = -1;
        for (int i = 0; i < numbersArray.length; i++) {
            int temp = numbersArray[i];
            if (swapDetector(numbersArray[i]) == true) {
                while (temp != 0) {
                    sum = temp % 10 + sum;
                    temp = temp / 10;
                }
            } else {
                continue;
            }
            if (sum > highestSum) {
                highestSum = sum;
                highestSumIndex = i;
            }
        }
        return highestSumIndex;
    }

    public static void main(String[] args) {
        int[] arr = {1, 51, 42, 5, 67, 0};
        System.out.println(lowestDigitSumSwappedNumberFinder(arr));

    }
}
