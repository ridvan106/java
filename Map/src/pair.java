/**
 * Created by oem on 2/17/18.
 */
public class pair<K,V> {
    private K key;
    private V value;

    public pair(K key,V value){
        this.key = key;
        this.value = value;
    }
    public V getValue(){
        return this.value;
    }
    public pair(){

    }
    public K getKey(){
        return this.key;
    }
    public void set(V value){
        this.value = value;
    }




}
