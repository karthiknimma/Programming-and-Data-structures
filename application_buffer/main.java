public class main {
    public static void main(String[]  args){

//        Creating input array
        int[] input = new int[]{6, 5, 7, 10, 0, 1, -1, 3 };
        IntBuff intBuff = new IntBuff(input,input.length);
        intBuff.println();

//        Sorting using QuickSort
        intBuff.quickSort();
        intBuff.println();

//        Using the copy constructor to make another copy of intBuff
        IntBuff intBuff2 = new IntBuff(intBuff);
        intBuff.println();

//        Using merge sort
        intBuff2.mergeSort();
        intBuff2.println();











        /* The following statements are operations on the buffer1 */
//Uncomment the following to execute
/*
        IntBuff buffer1 = new IntBuff(7);
        int[] inputs = new int[]{51, 7, 89, 106, 2, 0, -18};
        for(int i=0;i<inputs.length;i++){
            boolean appendToBuff = buffer1.append(inputs[i]);

        }
        buffer1.println();
        System.out.println(buffer1.delete(3));
        buffer1.println();
        System.out.println(buffer1.insert(5,'a'));
        buffer1.println();
*/


/* THe following Operations on buffer2 include linear search and binary search */
//Uncomment to execute
/*
        IntBuff buffer2 = new IntBuff(9);
        int[] inputs2 = new int[]{64, 5, 97, 101, 2, 0, -18, 13, 2008 };
        for (int value : inputs2) {
            boolean appendToBuff = buffer2.append(value);

        }
        buffer2.println();
        System.out.println(buffer2.linearSearch(0));
        System.out.println(buffer2.linearSearch(-1));
        System.out.println(buffer2.binarySearch(107));
        System.out.println(buffer2.binarySearch(13));
        buffer2.insertionSort();
        buffer2.println();
*/

    }
}