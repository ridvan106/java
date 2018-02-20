import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by oem on 2/19/18.
 */
public class chaning<K,V> implements map<K,V> {
    private int CAPACITY = 19; // prime number
    private LinkedList<pair>[] table;

    private int calculater(K val){

        int temp = val.toString().hashCode();
        return (temp%CAPACITY);


    }
    public chaning(){
        table = new LinkedList[CAPACITY];
    }
    @Override
    public void put(K key, V value) {
        int index = this.calculater(key);
        if(table[index] == null){
            table[index] = new LinkedList<>();
            table[index].add(new pair(key,value));
        }
        else{// linked listin peşine ekleme
            boolean flag = true;
            for (int i = 0; i < table[index].size() ; i++) {
                if(table[index].get(i).getKey() == key){
                    table[index].set(i,new pair(key,value));
                    flag = false;

                }



            }
            if(flag)
                table[index].add(new pair(key,value));
        }


    }

    @Override
    public V get(K key) {
        int index = this.calculater(key);
        for (int i = 0; i <table[index].size() ; i++) {
            if(table[index].get(i).getKey() == key)
                return (V) table[index].get(i).getValue();
        }
        return null;


    }

    @Override
    public V remove(K key) {
        int index = this.calculater(key);
        for (int i = 0; i < table[index].size(); i++) {
            if(table[index].get(i).getKey() == key){
                V temp = (V) table[index].get(i).getValue();
                table[index] =null;
                return temp;
            }


        }
        return null;
    }
    private static class pair<K,V> {
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
}
