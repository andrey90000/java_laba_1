package Array;

import java.util.Arrays;

/**
 * Class Array built on the static one-dimensional array.
 * Its executes main functions of java ArrayList collection such us addition, deletion, search.
 * @author Усов Андрей
 * @param <E>
 */
public class Array<E> {
    /** field arr:one-dim-nal array */
    public E[] arr;
    /** field capacity:capacity of the array arr */
    private int capacity;
    /** field size:amount of elements in array arr now*/
    public int size;
    /**
     * Constructor - creation of the new object
     * @param n- size of initial array arr
     */
    public Array(int n) {
        size = 0;
        capacity = n;
        arr = (E[]) new Object[capacity];
    }

    /**
     * Getter for size of array arr
     * @return returns size of arr
     */
    public int getSize(){
        return size;
    }

    /**
     * Function which adds new element in array arr
     * @param elem - element which you would like to add
     */
    public void add(E elem) {
        if (capacity <= size) {
            capacity += (capacity / 2) + 1;
            arr = Arrays.copyOf(arr, capacity);
        }
        arr[size] = elem;
        size++;
    }

    /**
     * Overrides classic method equals in java
     * @param obj - object for comparison
     * @return Returns - true, if objects are the same;
     * Returns - false in other way.
     *
     */
    @Override
    public boolean equals(Object obj){
        if(obj==null)
            return false;
        if (obj.getClass()!=this.getClass())
            return false;

        Array other=(Array) obj;

        if(other.size!=this.size)
            return false;

        for(int i=0;i<size;i++){
            if(this.arr[i]!=other.arr[i])
                return false;
        }
        return true;

    }

    /**
     * Overrides classic method hashcode in java
     * @return Hashcode
     */
    @Override
    public int hashCode(){
        final int prime=11;
        return((size*prime)%100);
    }

    /**
     * Function executes access by index for element in array arr
     * @param i - index of required element
     * @return Returns required element in arr
     */
    public E getElem(int i) {
        if (i < size) return (arr[i]);
        else return (null);
    }

    /**
     * Overrides classical function toString
     * and outputs elements of array arr
     * @return Returns string which consists of elements of arr in form:[elem_1,elem_2,...]
     */
    @Override
    public String toString(){
        String result="["+arr[0];
        for(int i=1;i<size;i++)
        {

            result+=", "+arr[i];
        }
        return(result+"]");//можно было просто сделать return(Arrays.toString(arr)), но тогда пришлось бы всегда уменьшать
                            // размеры массива с  capacity на size
    }

    /**
     * Function deletes the first element with value elem in arr
     * @param elem - element in arr which you would like to delete
     */
    public void delete(E elem) {
        int index = linearSearch(elem);
        if (index > -1) {
            arr= swap(arr,index);
            arr = Arrays.copyOf(arr, size - 1);
            size--;
            capacity=size;
        }

    }

    /**
     * Function finds the index of first met required value in array arr
     * @param elem - element which you would like to find in array
     * @return if element is found in arr - function returns index of required element in array arr
     * else returns value= -1
     */
    private int linearSearch(E elem) {
        for (int i = 0; i < size; i++) {
            if (elem == arr[i]) return i;
        }
        return (-1);
    }

    /**
     * Function replaces the current element to the end of array a
     * @param a-array for manipulations
     * @param index - index of element which is moving to end of array
     * @return Returns converted array
     */
    private E[] swap(E[] a, int index) {
        for (int i = index; i < size-1; i++) {
            E temp= a[i];
            a[i]=a[i+1];
            a[i+1]=temp;
        }
        return a;
    }

}
