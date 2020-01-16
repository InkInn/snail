package offer;

import java.util.Arrays;

/**
 * @author rcli
 * Created on 2019/12/14.
 */
public class Test {


    public void reverse(Node head) {
        Node pNode = head;
        Node pPre = null;

        while (pNode != null) {
            Node pNext = pNode.next;
            pNode.next = pPre;
            pPre = pNode;
            pNode = pNext;
        }
    }

    public boolean xunHuan(Node head) {
        if (head == null) {
            return false;
        }
        Node fast = head;
        Node slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    public Node findStart(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) break;
        }

        if (fast == null || fast.next == null) return null;
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public static int maxSubArray(int[] arr) {
        int nAll = arr[0];
        int nEnd = arr[0];
        for (int value : arr) {
            nEnd = Math.max(nEnd + value, value);
            nAll = Math.max(nEnd, nAll);
        }
        return nAll;
    }

    private static int begin = 0;
    private static int end = 0;

    public static int maxSubArrayWithIndex(int[] arr) {
        int maxSum = Integer.MIN_VALUE;
        int nSum = 0;
        int nStart = 0;
        for (int i = 0; i < arr.length; i++) {
            if (nSum < 0) {
                nSum = arr[i];
                nStart = i;
            } else {
                nSum = nSum + arr[i];
            }
            if (nSum > maxSum) {
                maxSum = nSum;
                begin = nStart;
                end = i;
            }
        }
        System.out.println(begin + " " + end);
        return maxSum;
    }

    public static void findSum(int[] a, int sum) {
        Arrays.sort(a);
        int begin = 0;
        int end = a.length - 1;
        while (begin < end) {
            if (a[begin] + a[end] < sum) {
                begin++;
            } else if (a[begin] + a[end] > sum) {
                end--;
            } else {
                System.out.println(a[begin] + "," + a[end]);
                begin++;
                end--;
            }
        }
    }

    public static void reverse(int a[], int b, int e) {
        for (; b < e; b++, e--) {
            int temp = a[e];
            a[e] = a[b];
            a[b] = temp;
        }
    }

    public static void shiftK(int a[], int k) {
        int n = a.length;
        k = k % n;
        reverse(a, n - k, n - 1);
        reverse(a, 0, n - k - 1);
        reverse(a, 0, n - 1);
    }

    public static int findOnce(int a[], int appearTimes) {
        int n = a.length;
        int[] bitCount = new int[32];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 32; j++) {
                bitCount[j] = bitCount[j] + ((a[i] >> j) & 1);
            }
        }
        int appearOne = 0;
        for (int i = 0; i < 32; i++) {
            if (bitCount[i] % appearTimes != 0)
                appearOne = appearOne + (1 << i);
        }
        return appearOne;
    }


    public static void main(String[] args) {
        int array[] = {1, 2, 1, 2, 4, 2, 4, 4, 1, 3};
        int num = findOnce(array, 3);
        System.out.println(num);
    }

//    public Node add(Node l1, Node l2){
//        Node head = new Node(0);
//        Node p = l1, q = l2, curr = head;
//        int carry = 0;

//    }

    public int mySqrt(int x) {
        if (x == 1 || x == 0) return x;
        int start = 1;
        int end = x / 2 + 1;
        int mid = 0;
        while (start <= end) {
            mid = start + (end - start) / 2;
            if (mid <= x / mid && (mid + 1) > x / (mid + 1)) return mid;
            if (mid > x / mid) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return mid;
    }


}
