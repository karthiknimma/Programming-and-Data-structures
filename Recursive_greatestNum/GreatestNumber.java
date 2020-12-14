//THis program takes an array of integer values and prints out the largest value in the array.
import java.util.Scanner;

public class GreatestNumber {
    public static void main(String[] args ){
        Scanner scanner= new Scanner(System.in);
        int n , greatestNumber;     // 'n' is the size of the array
        int[] arr;

        System.out.print("Enter the size of array: ");
        n=scanner.nextInt();
        arr = new int[n];       //Creating an array object of size n

        //Loop to input the values to the array variable 'arr'
        //Type checking is done for every input
        //while loop repeats until user inputs valid input
        for(int i=0;i<n;i++){
            System.out.print("Enter element "+ (i+1) +(": "));
            while (!scanner.hasNextInt()){
                System.out.print("Please enter a valid value: ");
                scanner.next();     //Used to read the next input token from the input stream
            }
            arr[i]=scanner.nextInt();
        }
        System.out.print("\nArray content: ");
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");   //Print out each element in the array
        }
        greatestNumber=findGreatestNumber(arr);
        System.out.println("");
        System.out.println("The greatest value in the array is "+greatestNumber);

    }
    public static int findGreatestNumber(int[] array){
        int max=0;
        for(int i=0;i<array.length;i++){
            if(array[i]>max){
                max=array[i];           //If current array value is greater than max, setting max=current value
            }
        }
        return max;
    }
}
