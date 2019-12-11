package leetcode.query;

/**
 * @author rcli
 * Created on 2019/11/10.
 */
public class BSearch {

    public static void main(String[] args) {

    }

    public int bFirstSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low = ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == 0) || a[mid - 1] != value) return mid;
                else high = mid - 1;
            }
        }
        return -1;
    }

    public int bLastSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low = ((high - low) >> 1);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = mid + 1;
            } else {
                if ((mid == (n - 1)) || a[mid + 1] != value) return mid;
                else low = mid + 1;
            }
        }
        return -1;
    }

    public int bFirstBigSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low = ((high - low) >> 1);
            if (a[mid] >= value) {
                if ((mid == 0) || (a[mid - 1] < value)) return mid;
                else high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }


    public int bLastSmallSearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low = ((high - low) >> 1);
            if (a[mid] <= value) {
                if ((mid == (n - 1)) || (a[mid + 1] > value)) return mid;
                else low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
