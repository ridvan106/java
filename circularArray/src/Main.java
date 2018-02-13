public class Main {

    public static void main(String[] args) {
        circularList<String> CL = new circularList<String>();
        CL.add("ridvan");
        CL.add("Osman");
        CL.add("ali");
        CL.add("furki");
        CL.add("burki");
        CL.remove(0);

        CL.remove(1);
        CL.add("aliye");
        CL.remove(4);

        System.out.print(CL);
    }
}
