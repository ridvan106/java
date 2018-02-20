public class Main {

    public static void main(String[] args) {
       /* openAdressing<String,Integer> oa = new openAdressing<>();
        System.out.println(("ali".hashCode())%19);
        oa.put("ali",4);
        oa.put("ali",15);

        System.out.println(oa.get("ali"));
        System.out.println(oa.remove("ali"));*/
       chaning<String,Integer> ch = new chaning<>();
        ch.put("ali",4);
        System.out.println(ch.get("ali"));
        ch.put("ali",41);
        ch.put("veli",4030);
        System.out.println(ch.get("ali"));
        System.out.println(ch.get("veli"));
        System.out.println(ch.remove("ali"));

    }
}
