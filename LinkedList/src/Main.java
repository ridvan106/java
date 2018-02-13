public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        LinkList<String> datas = new LinkList<>();
        datas.fillInFile("deneme.txt");
        System.out.println(datas);
        System.out.println("\naranan: happy "+datas.search("happy"));
        System.out.println("*************************");
        System.out.println("gelen "+datas.get(5));
        datas.set(5,"unsleeping");
        System.out.println("gelen "+datas.get(5));

        datas.remove("sleepy");


        System.out.println(datas);

        System.out.println("\naranan: happy "+datas.search("happy"));

    }
}
