import java.util.Arrays;

import static java.util.Arrays.*;

// It is not possible to provide static methods to this class as they need access to non-static variables such as the
// array buffer. Hence it is better to use non-static methods

public class IntBuff {
    int[] elements;
    int current_size;

    IntBuff(){
        elements = new int[0];
        current_size=0;
    }
    IntBuff(int[] arr,final int n){
        elements = new int[n];
        current_size=0;
        boolean hasAppend=false;
        while (current_size<n){
            hasAppend= append(arr[current_size]);
        }
        System.out.println("Append status: "+hasAppend);
    }
     IntBuff(IntBuff buff){
        this.elements = new int[buff.elements.length];
        for(int i=0;i<buff.elements.length;i++){
            this.elements[i] = buff.elements[i];
            current_size = buff.current_size;
        }
    }
    boolean append(final int v){
       try {

           if (current_size >= elements.length){
               elements = copyOf(elements, 2 * elements.length);
            }
           elements[current_size]=v;
           current_size++;
           return true;
       }
       catch (Exception e){
           return false;
       }
    }
    boolean insert(final int index,final int v){
        try{
            int i;
            int len_of_buffer = elements.length;
            int[] newArr =  new int[len_of_buffer + 1];

            for( i = 0; i < len_of_buffer + 1; i++){
                if (i < index - 1)
                    newArr[i] = elements[i];
                else if (i == index - 1)
                    newArr[i] = v;
                else
                    newArr[i] = elements[i - 1];
            }
            current_size++;
            elements = copyOf(newArr,newArr.length);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    boolean delete(final int index){
        try {
            for(int i = index; i < current_size; i++){
                elements[i-1] = elements[i];
            }
            current_size--;
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
    void println(){
        System.out.print("Buffer: ");
        for(int i=0;i < current_size;i++){
            System.out.print(elements[i]+" ");
        }
        System.out.println("");
    }
    public boolean linearSearch(final int v){
        for(int i=0;i<elements.length;i++){
            if(elements[i] == v){
                return true;
            }
        }
        return false;
    }
    public boolean binarySearch(final int v){
        int[] sorted = copyOf(elements,elements.length);
        Arrays.sort(sorted);
        int low = 0;
        int high = sorted.length-1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(sorted[mid] >v ){
                high = mid-1;
            }
            if(sorted[mid] < v){
                low = mid+1;
            }
            if(sorted[mid] == v){
                return true;
            }

        }
        return false;
    }
    public void insertionSort() {
        int i,j,key;
        for (i = 1; i < elements.length; i++) {
            key = elements[i];
            j = i - 1;

            while (j >= 0 && elements[j] > key) {
                elements[j + 1] = elements[j];
                j = j - 1;
            }
            elements[j + 1] = key;
        }
    }
    public void mergeSort(){
        int left = 1;
        int right = current_size-1;
        mSort(elements,left,right);
        System.out.print("Merge Sorted ");
    }
    public void mSort(int arr[], int l, int r)
    {
        if (l < r)
        {
            // Find the middle point
            int m = (l+r)/2;

            // Sort first and second halves
            mSort(arr, l, m);
            mSort(arr , m+1, r);

            // Merging
            merge(arr, l, m, r);
        }
    }
    public void merge(int arr[], int left, int middle, int right)
    {
        // Find sizes of two subarrays to be merged
        int n1 = middle - left + 1;
        int n2 = right - middle;

        /* Create temp arrays */
        int L[] = new int [n1];
        int R[] = new int [n2];

        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; i++) {
            L[i] = arr[left + i];
        }

        for (int j=0; j < n2; j++) {
            R[j] = arr[middle + 1+ j];
        }

        /* Merge the temp arrays */
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;

        // Initial index of merged subarry array
        int k = left;
        while (i < n1 && j < n2)
        {
            if (L[i] <= R[j])
            {
                arr[k] = L[i];
                i++;
            }
            else
            {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
        /* Copy remaining elements of L[] if any */
        while (i < n1)
        {
            arr[k] = L[i];
            i++;
            k++;
        }

        /* Copy remaining elements of R[] if any */
        while (j < n2)
        {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    public void quickSort(){
        int left = 1;
        int right = current_size-1;
        qSort(elements,left,right);
        System.out.print("Quick Sorted ");
    }
    void qSort(int arr[], int low, int high)
    {
        if (low < high)
        {

           int  pi = partition(arr, low, high);
            qSort(arr, low, pi - 1);
            qSort(arr, pi + 1, high);
        }
    }
    int partition (int[] arr, int low, int high)
    {
        int pivot = arr[high];

        int i = (low - 1);  // Index of smaller element

        for (int j = low; j <= high- 1; j++)
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;
                int temp = arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
//        swap arr[i + 1] and arr[high])
        int temp = arr[i+1];
        arr[i+1] = arr[high];
        arr[high] = temp;
        return (i + 1);
    }

}
