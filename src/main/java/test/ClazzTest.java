package test;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;

public class ClazzTest {

    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now().minusHours(-6);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HH");
        System.out.println(simpleDateFormat.format(localDateTime.toInstant(ZoneOffset.of("+8")).toEpochMilli()));
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



}
