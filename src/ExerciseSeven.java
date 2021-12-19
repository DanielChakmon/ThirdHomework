import java.util.Scanner;

public class ExerciseSeven //skipped the bonus
{
    public static void equationInterceptorAndSolver() {
        final int HOW_MUCH_COEFFICIENTS = 3;
        int coefficientCount = 0;
        int xsCount = 0;
        int[] coefficientArray = new int[HOW_MUCH_COEFFICIENTS];
        int skipCount = 0;
        boolean isItValid = true;
        Scanner scanner = new Scanner(System.in);
        System.out.println("please enter a quadratic equation of the form of 'ax^2+bx+c=0' note that the x is not capital\n " +
                "+1 coefficient should be written as 'x^2+x+=0' and -1 coefficient should be written as '-x^2+-x+-=0' note that all numbers need to be whole and over -1\n" +
                " 0 coefficient should be written as zero that replace one of a,b,c (sane as all the other numbers)  ");
        String usersEquation = scanner.nextLine();
        for (int i = 0; i < usersEquation.length(); i++) {
            if (skipCount > 0) {
                skipCount--;
                continue;
            }
            if (usersEquation.charAt(i) == '+' && (usersEquation.charAt(i + 1) == 'x' || usersEquation.charAt(i + 1) == '=')) {
                coefficientArray[coefficientCount] = 1;
                coefficientCount++;
                continue;
            } else {
                if (usersEquation.charAt(i)=='+'){
                    if(usersEquation.charAt(i+1)=='-'){
                        coefficientArray[coefficientCount]=-1;
                        coefficientCount++;
                        skipCount=1;
                        continue;
                    }
                    else{
                        if (usersEquation.charAt(i+1) >= 48 && usersEquation.charAt(i+1) <= 57){
                            coefficientArray[coefficientCount]=usersEquation.charAt(i+1);
                            coefficientCount++;
                            skipCount=1;
                            continue;

                        }
                    }
                }
                if (usersEquation.charAt(i + 1) == 'x') {
                    if (usersEquation.charAt(i) == '-') {
                        coefficientArray[coefficientCount] = -1;
                        coefficientCount++;
                        continue;
                    }
                    if (usersEquation.charAt(i) >= 48 && usersEquation.charAt(i) <= 57) {
                        coefficientArray[coefficientCount] = (int) usersEquation.charAt(i);
                        coefficientCount++;
                        continue;
                    }
                } else {
                    if (usersEquation.charAt(i) == 'x') {
                        if (xsCount == 0) {
                            if (usersEquation.charAt(i + 1) == '^' && usersEquation.charAt(i + 2) == '2') {
                                xsCount++;
                                skipCount = 2;
                                continue;
                            } else {
                                System.out.println("input invalid");
                                isItValid = false;
                                break;
                            }
                        } else {
                            if (xsCount == 1) {
                                if (usersEquation.charAt(i + 1) == '+') {
                                    xsCount++;
                                    continue;
                                } else {
                                    isItValid = false;
                                    System.out.println("input invalid");
                                    break;
                                }
                            } else {
                                if (xsCount>=2)
                                {
                                    System.out.println("input invalid");
                                    isItValid = false;
                                    break;
                                }
                            }
                        }
                    } else {
                        if (xsCount ==2 && usersEquation.charAt(i)=='=' && usersEquation.charAt(i+1)=='0'){
                            isItValid=true;
                            break;
                        }
                        else {
                            if (xsCount==2&&coefficientCount==3){
                                isItValid=false;
                                break;
                            }
                        }
                    }
                }
            }
            isItValid=false;// if it didn't stop earlier than it's wrong.
            break;
        }
           if(isItValid==true) {
               double determinant = Math.pow(coefficientArray[1], 2.0D) - 4.0D * coefficientArray[0] * coefficientArray[2];
               double firstSolution = (-coefficientArray[1] + Math.sqrt(determinant)) / (2.0D * coefficientArray[0]);
               double secondSolution = (-coefficientArray[1] - Math.sqrt(determinant)) / (2.0D * coefficientArray[0]);
               if (determinant > 0.0D) {
                   System.out.println("you have two solutions:");
                   System.out.println("X1=" + firstSolution);
                   System.out.println("X2=" + secondSolution);
               } else if (determinant == 0.0D) {
                   System.out.println("you have one solution:");
                   System.out.println("x=" + firstSolution);
               } else {
                   System.out.println("you do not have any solutions.");
               }
           }
           }

    public static void main(String[] args) {
        equationInterceptorAndSolver();
    }
}
