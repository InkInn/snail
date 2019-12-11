package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author rcli
 * Created on 2019/11/24.
 */
public class StringRank {


    public static void main(String[] args) {
        checkInclusion("ab", "eidbaooo");
    }


    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> sourceMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            if (sourceMap.containsKey(s1.charAt(i))) {
                sourceMap.put(s1.charAt(i), sourceMap.get(s1.charAt(i)) + 1);
            } else {
                sourceMap.put(s1.charAt(i), 1);
            }
        }

        for (int j = 0; j < s2.length() - s1.length() + 1; j++) {
            Map<Character, Integer> targetMap = new HashMap<>();
            for (int i = j; i < s1.length() + j; i++) {
                if (targetMap.containsKey(s2.charAt(i))) {
                    targetMap.put(s2.charAt(i), targetMap.get(s2.charAt(i)) + 1);
                } else {
                    targetMap.put(s2.charAt(i), 1);
                }
            }
            if (judge(sourceMap, targetMap)) return true;
        }
        return false;
    }


    private static boolean judge(Map<Character, Integer> sourceMap, Map<Character, Integer> targetMap) {
        if (sourceMap.size() != targetMap.size()) return false;
        for (Map.Entry<Character, Integer> entry : sourceMap.entrySet()) {
            if (!targetMap.containsKey(entry.getKey())) return false;
            if (!entry.getValue().equals(targetMap.get(entry.getKey()))) return false;
        }

        for (Map.Entry<Character, Integer> entry : targetMap.entrySet()) {
            if (!sourceMap.containsKey(entry.getKey())) return false;
            if (!entry.getValue().equals(sourceMap.get(entry.getKey()))) return false;
        }
        return true;
    }

}
