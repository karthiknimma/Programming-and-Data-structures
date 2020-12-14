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
    IntBuff(final int n){
        elements = new int[n];
        current_size=0;
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
        System.out.println();
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
        sort(sorted);
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
}
