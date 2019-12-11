package offer;

import java.util.Stack;

/**
 * @author rcli
 * Created on 2019/12/1.
 */
public class ReverseWords {

    public static void main(String[] args) {
        String s = "  hello world!  ";
        System.out.println(reverseWords(s));
    }

    public static String reverseWords(String s) {
        Stack<Character> stack = new Stack<>();
        StringBuilder result = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == ' ') {
                if (stack.size() == 0) continue;
                StringBuilder stringBuilder = new StringBuilder();
                int len = stack.size();
                for (int j = 0; j < len; j++) {
                    stringBuilder.append(stack.pop());
                }
                result.append(stringBuilder.toString()).append(' ');
            } else {
                stack.push(s.charAt(i));
            }
        }
        if (stack.size() != 0) {
            StringBuilder stringBuilder = new StringBuilder();
            int len = stack.size();
            for (int j = 0; j < len; j++) {
                stringBuilder.append(stack.pop());
            }
            result.append(stringBuilder.toString());
        } else {
            if(result.length() > 0) {
                result.delete(result.length() - 1, result.length());
            }
        }
        return result.toString().trim();
    }
}
