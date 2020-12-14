
//THis program takes an array of integer values and prints out the largest value in the array.

import java.util.Scanner;

public class Greatest_Recursive {
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
        for (int value : arr) {
            System.out.print(value + " ");   //Print out each element in the array
        }

    //The function findGreatestNumber takes two extra parameters to set the initial position and max value
        greatestNumber=findGreatestNumber(arr,0,0);
        System.out.println("");
        System.out.println("The greatest value in the array is "+greatestNumber);
    }

    public static int findGreatestNumber(int[] array,int position,int max){
        if(array[position]>max){    //Checks if value at index position > value of max
            max=array[position];
        }
        if(position == (array.length - 1) ){
            return max;     //Return the value of max when reached end of array
        }
        return findGreatestNumber(array,position+1,max); //Recursive call incrementing position
    }

}

