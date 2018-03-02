public class Main {

    public static void main(String[] args) {
        Integer [] n ={875,10, 80, 30, 90, 40, 50, 70,20,-90};
        /*insertion sorting = new insertion();
        sorting.sort(n);*/
       /* quicksort qs = new quicksort();
        qs.sort(n);*/
       merge mrg = new merge();
        mrg.sorting(n);
        for (int i = 0; i < n.length; i++) {
            System.out.print(n[i]+" ");
        }

    }

}
