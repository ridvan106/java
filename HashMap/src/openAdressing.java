/**
 * Created by oem on 2/18/18.
 */
public class openAdressing<K,V> implements map<K,V> {

    private int CAPACITY = 19; //prime number
    private pair<K,V> []table;


    public openAdressing(){
        table = new pair[CAPACITY];
    }
    private int calculater(K val){

        int temp = val.toString().hashCode();
        return (temp%CAPACITY);


    }

    public void put(K key,V value){
        int index = this.calculater(key);
        if(table[index] == null){
            table[index] = new pair<K, V>(key,value);
        }
        else{
            if(table[index].getKey().equals(key)){
                table[index] = new pair<K, V>(key,value);
            }
            else {
                for (int i = index + 1; i < CAPACITY; i++) {
                    if (table[index] == null) {
                        table[index] = new pair<K, V>(key, value);
                    }
                }
            }
        }

    }

    public V get(K key){
        int index = calculater(key);
        if(key.equals(table[index].getKey()))
            return table[index].getValue();
        else{
            for (int i = index+1; i <CAPACITY ; i++) {
                if(table[i] == null)
                    return null;
                else if(key.equals(table[i].getKey()))
                    return table[i].getValue();

            }

        }
        return null;

    }
    public V remove(K key){
        int index = calculater(key);
        if(key.equals(table[index].getKey())){
            V tmep = table[index].getValue();
            table[index] =null;
            return tmep;
        }
        else{
            for (int i = index+1; i <CAPACITY ; i++) {
                if(table[index].equals(null)){
                    return null;
                }
                if(key.equals(table[i].getKey())){
                    V tmep = table[i].getValue();
                    table[i] =null;
                    return tmep;
                }
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
