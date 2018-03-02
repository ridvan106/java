/**
 * Created by oem on 3/2/18.
 */
public class merge {
    public void sorting(Integer [] arr){
        arr = helper(arr);






    }

    private Integer[] helper(Integer[] arr) {
        if(arr.length != 1){
            int mid = (int)arr.length/2;
            Integer [] left = left(arr,mid);
            Integer [] right = right(arr,mid);
            helper(left);
            helper(right);
            merging(left,right,arr);

        }
        return arr;
    }

    private void merging(Integer[] left, Integer[] right, Integer[] arr) {
        int l = 0;
        int r = 0;
        int i = 0;
        while(i < arr.length){

            if(l <left.length){
                if(r <right.length){
                    if(right[r] < left[l]) {
                        arr[i] = right[r];
                        r++;
                        i++;
                    }
                    else{
                        arr[i] = left[l];
                        l++;
                        i++;
                    }

                }
                else{
                    arr[i] = left[l];
                    l++;
                    i++;
                }

            }
            else{
                arr[i] = right[r];
                i++;
                r++;

            }


        }

    }

    private Integer[] right(Integer[] arrTemp, int mid) {
        Integer [] temp = new Integer[arrTemp.length - mid];
        for (int i = mid; i < arrTemp.length; i++) {
            temp[i-mid] = arrTemp[i];
        }
        return temp;
    }

    private Integer[] left(Integer[] arrTem,int mid) {
        Integer [] temp = new Integer[mid];
        for (int i = 0; i < mid; i++) {
            temp[i] = arrTem[i];
        }
        return temp;
    }
}
