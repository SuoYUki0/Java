import java.util.Map;
import java.util.TreeMap;

public class map {
    public static void main(String[] args) {
        Map<String,String> m = new TreeMap<>();
        m.put("林冲", "豹子头");
        m.put("鲁智深", "花和尚");
        m.put("武松", "行者");
        m.put("宋江", "及时雨");
        String str = m.put("李逵","黑旋风");
        System.out.println(m.size());
        System.out.println(m);
        str = m.put("无名", null);
        System.out.println(m);
        str = m.put("李逵", "铁牛");
        System.out.println(m.get("鲁智深"));
        System.out.println(m.get("史进"));
        System.out.println(m.getOrDefault("李逵", "铁牛"));
        System.out.println(m.getOrDefault("史进", "九纹龙"));
        System.out.println(m);
        System.out.println(m.containsKey("林冲"));
        System.out.println(m.containsKey("史进"));
        System.out.println(m.containsValue("豹子头"));
        System.out.println(m.containsValue("九纹龙"));
        for (String s:
             m.keySet()) {
            System.out.println(s+" ");

        }
        for (String s:
                m.values()) {
            System.out.print(s+" ");

        }

        }








}
