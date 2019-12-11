package offer;

/**
 * @author rcli
 * Created on 2019/11/26.
 */
public class StrNum {

    public static void main(String[] args) {
        System.out.println(multiply("123", "456"));
    }

    private static String add(String str1, String str2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = str1.length() - 1;
        int j = str2.length() - 1;
        while (i >= 0 || j >= 0 || carry != 0) {
            if (i >= 0) carry = carry + str1.charAt(i--) - '0';
            if (j >= 0) carry = carry + str2.charAt(j--) - '0';
            sb.append(carry % 10);
            carry = carry / 10;
        }
        return sb.reverse().toString();
    }

    private static String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0") ) return "0";
        String init = "0";
        for (int i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = num2.length() - 1; j >= 0; j--) {
                carry = carry + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                sb.append(carry % 10);
                carry = carry / 10;
            }
            if (carry > 0) {
                sb.append(carry);
            }
            sb = sb.reverse();
            for (int k = num1.length() - 1; k > i; k--) {
                sb.append("0");
            }
            init = add(init, sb.toString());
        }
        return init;
    }
}
