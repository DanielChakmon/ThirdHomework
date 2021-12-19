import java.util.Scanner;

public class ExerciseFour {
    public static int[] duplicatesRemover(int[] userArray) {
        int[] temp = new int[userArray.length];
        boolean duplicateIndicator;
        int uniqueNumberCount = 0;
        int zeroCount = 0;
        int nextUnoccupiedCellPlace = 0;
        for (int i = 0; i < userArray.length; i++) {
            duplicateIndicator = false;
            if (userArray[i] == 0) {
                zeroCount++;
                if (zeroCount == 1) {
                    uniqueNumberCount++;
                    temp[nextUnoccupiedCellPlace] = userArray[i];
                    nextUnoccupiedCellPlace++;
                }
                continue;
            } else {
                for (int j = 0; j < temp.length; j++) {
                    if (temp[j] == userArray[i]) {
                        duplicateIndicator = true;
                        break;
                    }
                }
            }
            if (duplicateIndicator == false) {
                uniqueNumberCount++;
                temp[nextUnoccupiedCellPlace] = userArray[i];
                nextUnoccupiedCellPlace++;
            }
        }

        int[] noDuplicatesArray = new int[uniqueNumberCount];
        for (
                int t = 0;
                t < uniqueNumberCount; t++) {
            noDuplicatesArray[t] = temp[t];
        }
        return noDuplicatesArray;
    }
    public static int[] arraySorter(int[] noDuplicatesArray) {
        int temp;
        int numberOfChanges=0;
        for(int i=0;i<noDuplicatesArray.length;i++){
            for(int j=1;j<noDuplicatesArray.length-i;j++){
                if(noDuplicatesArray[j-1]>noDuplicatesArray[j]){
                    temp=noDuplicatesArray[j];
                    noDuplicatesArray[j]=noDuplicatesArray[j-1];
                    noDuplicatesArray[j-1]=temp;
                    numberOfChanges++;
                }
            }
            if(numberOfChanges==0){
                break; //if there were no changes in this round that is certainly means that the array is sorted properly.
            }
        }
        return noDuplicatesArray;
    }
    public static boolean fullArrayChecker(int[] sortedNoDuplicatesArray){
        boolean isItFullArray=true;
        final int FIRST_NUMBER =sortedNoDuplicatesArray[0];
        final int LAST_NUMBER= sortedNoDuplicatesArray[sortedNoDuplicatesArray.length-1];
        for(int i=FIRST_NUMBER;i<LAST_NUMBER;i++){
            if(i!=sortedNoDuplicatesArray[i-FIRST_NUMBER]){
                isItFullArray=false;
                break;
            }
        }
        return isItFullArray;
    }
    public static boolean isItFullArray (int[] userArray){
        int[] noDuplicatesArray=duplicatesRemover(userArray);
        int[] sortedNoDuplicatesArray=arraySorter(noDuplicatesArray);
        boolean isItFullArray=fullArrayChecker(sortedNoDuplicatesArray);
        return isItFullArray;
    }
    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        System.out.println("please enter wanted array size");
        int arraySize=scanner.nextInt();
        int[] userArray=new int[arraySize];
        for(int i=0;i<arraySize;i++){
            System.out.println("please enter the number wanted in cell number "+i);
            userArray[i]=scanner.nextInt();
        }
        boolean isItFullArray=isItFullArray(userArray);
        System.out.println(isItFullArray);
    }
}