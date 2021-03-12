package lesson2;

public class DzArrayList<T> {
    private static final int DEFAULT_CAPACITY = 4;
    T[] arr;
    private int number;
    private int capacity;

    public DzArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        this.arr = (T[]) new Object[capacity];
        this.number = 0;
    }

    public void add (T item){
        if (number == capacity){
            capacity= capacity*2;
            T[] tmp = (T[]) new Object[capacity];
            System.arraycopy(arr,0,tmp,0,arr.length);
            this.arr = tmp;
        }
        arr[number] = item;
        number++;
    }
    public T get (int i){
        if (i>=number){
            throw new IndexOutOfBoundsException();
        }
        return arr[i];
    }
    public void print(){
        for (int i = 0; i < number; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public void remove (int i){
        System.arraycopy(arr,i+1,arr,i,arr.length-1);
        arr[number]= null;
        number--;
    }
    public boolean isEmpty(){
        return number==0;
    }

    public  int indexOf(T t){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(t)){
                return i;
            }
        }
        return -1;
    }
public T set(int i, T t){
        T oldVal = arr[i];
        arr [i] = t;
        return oldVal;
}

}
