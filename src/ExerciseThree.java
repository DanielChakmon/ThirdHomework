import java.util.Scanner;

public class ExerciseThree {
    public static int[] divisorsFinder(int number) {
        int nextUnoccupiedCellPlace = 0;
        int[] temp = new int[number / 2];
        while (number % 2 == 0) {
            temp[nextUnoccupiedCellPlace] = 2;
            nextUnoccupiedCellPlace++;
            number = number / 2;
        }
        for (int i = 3; i <= number; i = i + 2) {
              while (number%i==0){
                  temp[nextUnoccupiedCellPlace]=i;
                  nextUnoccupiedCellPlace++;
                  number=number/i;
              }
        }
        int[] divisorsArray=new int[nextUnoccupiedCellPlace];
        for (int j=0;j<nextUnoccupiedCellPlace;j++){
            divisorsArray[j]=temp[j];
        }
        return divisorsArray;
    }

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter a whole number");
        int userNumber=scanner.nextInt();
        if (userNumber==0||userNumber==1) {
            System.out.println("your number doesn't have any divisors...");

        }
        else {
            int[] divisorsArray = divisorsFinder(userNumber);
            for (int i = 0; i < divisorsArray.length; i++) {
                System.out.print(divisorsArray[i]);
                if (i != divisorsArray.length - 1) {
                    System.out.print(" * ");
                } else {
                    System.out.println(" = " + userNumber);
                }
            }
        }
    }
}