public class ExerciseTwo {
   public static int sumOfDigits(int number){
    int sum=0;
    int temp=number;
       while (temp != 0) {
           sum = temp % 10 + sum;
           temp = temp / 10;
       }
       return sum;
   }
    public static boolean siblingsDetector(int number1,int number2 ){
       boolean areTheySiblings=false;
       if (sumOfDigits(number1)==sumOfDigits(number2)){
            areTheySiblings=true;
        }
       else {
           areTheySiblings=false;
       }
       return areTheySiblings;
    }
     public static int bestRelativeNumberIndexFinder(int[] arr1, int[] arr2){
       int relativityLevel=0;
       int highestRelativityLevel=0;
       int greatestRelativeIndex=0;
       boolean areTheySiblings=false;
       for(int i=0; i<arr1.length;i++){
           relativityLevel=0;
           for(int j=0; j<arr2.length;j++){
               areTheySiblings=siblingsDetector(arr1[i],arr2[j]);
               if (areTheySiblings==true){
                   relativityLevel++;
               }
           }
           if (relativityLevel>highestRelativityLevel){
               highestRelativityLevel=relativityLevel;
               greatestRelativeIndex=i;
           }
       }
       return greatestRelativeIndex;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 0, 55, 551, 69, 8, 74};
        int[] arr2={0,1,10,11,57,83};
        System.out.println(bestRelativeNumberIndexFinder(arr1,arr2));
    }
}
