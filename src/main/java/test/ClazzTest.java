package test;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class ClazzTest {

    public static void main(String[] args) {
        list();;
//        LocalDateTime localDateTime = LocalDateTime.now().minusHours(-6);
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
//        System.out.println(simpleDateFormat.format(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()));
    }

    private static void testList() {
        List<String> list = new ArrayList<>();
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void testStreamList() {
        List<String> list = new ArrayList<>();
        list.stream().forEach(System.out::println);
    }

    private static void list(){
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set.iterator().next());
    }
}
