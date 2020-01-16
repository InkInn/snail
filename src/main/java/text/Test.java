package text;

import com.hankcs.hanlp.HanLP;
import offer.Node;

import java.util.List;
import java.util.Stack;

/**
 * @author rcli
 * Created on 2019/12/16.
 */
public class Test {

    public static void main(String[] args) {
        String str1 = "台湾艺人高以翔录节目时猝死 据爆料，其在凌晨录制跑步项目时摔倒在地";
        String str2 = "哀悼！艺人高以翔录节目时离世 媒体证实，艺人高以翔在录节目时晕倒，不幸离世";
        List<String> sentenceList1 = HanLP.extractPhrase(str1, 10);
        List<String> sentenceList2 = HanLP.extractPhrase(str2, 10);
        System.out.println(sentenceList1);
        System.out.println(sentenceList2);
    }


    public static Node reverse(Node node) {
        Stack<Node> stack = new Stack<>();
        Node tmp = node;
        while (tmp != null) {
            stack.push(tmp);
            tmp = tmp.next;
        }
        Node head = new Node(1);
        for (int i = 0; i < stack.size(); i++) {
            head.next = stack.pop();
            head = head.next;
        }
        return head.next;
    }
}
