import java.util.IllegalFormatException;

/**
 * Created by oem on 2/17/18.
 */
public class map<K,V> {
    private int capacity = 10;
    private pair<K,V> []datas = new pair[capacity];
    private int size = 0;
    public void put(K key, V value) throws IllegalAccessException {

            if (IsThere(key)) {
                throw new IllegalAccessException();
            }
            datas[size] = new pair<K, V>(key, value);
            size++;
        }

    public V get(K key){
        for (int i = 0; i < size; i++) {
            if(datas[i].getKey().equals(key)){
                return datas[i].getValue();
            }
        }
        return null;
    }
    public void set(K key,V value){
        for (int i = 0; i < size; i++) {
            if(datas[i].getKey().equals(key)){
                datas[i].set(value);
            }
        }

    }
    public void remove(K key){
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if(datas[i].getKey().equals(key) | flag){
                datas[i] = datas[i+1];
                flag = true;
            }
        }
        size--;




    }
    private boolean IsThere(K key){
        for (int i = 0; i < size; i++) {
            if(datas[i].getKey().equals(key)){
                return true;
            }
        }
        return false;
    }

}
