/**
 * Created by oem on 2/20/18.
 */
public class quicksort {
    public void sort(Integer [] data){
        sort(data,0,data.length);




    }
    private void sort(Integer [] data,int left,int right){
        if(left < right){
            Integer pivot = rearrange(data,left,right);
            System.out.println(pivot);
            sort(data,pivot+1,right);
            sort(data,left,pivot);

        }

    }

    private int rearrange(Integer [] data,int leftt,int rightt){
        Integer pivot = data[leftt];
        Integer left = rightt;
        Integer right = leftt;
        while(left > right){
            do {
                left--;
                if(left<=leftt)
                    break;

            }while (pivot < data[left]);

            do {
                right++;
                if(right>=rightt)
                    break;

            }while(pivot > data[right]);


            if(left>=right){
                int temp = data[left];
                data[left] = data[right];
                data[right] = temp;

            }


        }
            data[leftt] = data[left];
            data[left]=pivot;






        return left;
    }
}
