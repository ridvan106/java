/**
 * Created by oem on 2/20/18.
 */
public class insertion {

    public void sort(Integer [] var){
        for (int i = 1; i < var.length ; i++) {
            Integer temp = var[i];
            int j = i-1;
            while(j>=0){
                if(temp<var[j]) {
                    var[j + 1] = var[j];
                    j--;
                }
                else{
                    break;
                }


            }
            var[j+1] = temp;

        }


    }
}
