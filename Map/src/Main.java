public class Main {

    public static void main(String[] args) throws IllegalAccessException {
        System.out.println("Hello World!");
        map<String,Integer> mp = new map<>();
        mp.put("ali",1);
        mp.put("veli",700);
        mp.put("Osman",250);
        System.out.println(mp.get("veli"));
        mp.set("veli",780);
        System.out.println(mp.get("veli"));
        mp.remove("veli");
        System.out.println(mp.get("veli"));
        mp.put("veli",45);
        System.out.println(mp.get("veli"));

    }
}
