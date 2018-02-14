/**
 * Created by oem on 2/13/18.
 */
public class circularList<E> {
    private int place = 5;
    private E [] datas = (E[]) new Object[place];
    private int size = 0;
    private int first = -1;
    private int last = -1;
    public void add(E datt){

        if(datas[((last+1)% place)] == null) {
            datas[(last+1)%place] = datt;
        }
        else{
            newPlace();
            datas[(last+1)%place] = datt;
        }
        if(size == 0)
            first++;
        last= (last+1)%place;
        size++;

    }

    private void newPlace() {
        E [] temp = datas;
        place *=2;
        datas =(E[])  new Object[place];
        int j = 0;
        for (int i = 0; i < temp.length ; i++) {
            if(temp[i] != null) {
                datas[j] = temp[i];
                j++;
            }
        }
        this.first = 0;
        this.last =j-1;
    }

    public void remove(int index){
        if(index == last)
            last--;
        if(index == first)
            first = (first+1)%place;
        size--;
        datas[index] = null;
    }

    @Override
    public String toString(){
        System.out.println("first: "+first+"\nlast: "+last+"\n");
        StringBuilder temp = new StringBuilder();
        for(int i=first;i !=last; i=(i+1)%(place))
            if(datas[i] != null)
            temp.append(datas[i].toString()+"\n");
        temp.append(datas[last].toString()+"\n");

        return temp.toString();


    }

}
