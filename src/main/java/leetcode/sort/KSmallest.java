package leetcode.sort;

/**
 * @author rcli
 * Created on 2019/11/1.
 */
public class KSmallest {

    public static void main(String[] args) {
        int[] num = {1, 4, 5, 2, 10};
        int location = 2;
        int result = kSmallest(num, 0, num.length - 1, location - 1);
        System.out.println(result);
    }

    private static int kSmallest(int[] a, int head, int tail, int location) {
        if (head >= tail) return 0;

        int sentry = partition(a, head, tail);
        if (sentry == location) return a[sentry];
        else if (location < sentry) return kSmallest(a, head, sentry - 1, location);
        else return kSmallest(a, sentry + 1, tail, location);
    }

    private static int partition(int[] a, int low, int high) {
        int sentry = a[high];
        while (low < high) {
            while (low < high && a[low] <= sentry) {
                low++;
            }
            a[high] = a[low];

            while (low < high && a[high] >= high) {
                high--;
            }
            a[low] = a[high];
        }
        a[low] = sentry;
        return low;
    }
}
