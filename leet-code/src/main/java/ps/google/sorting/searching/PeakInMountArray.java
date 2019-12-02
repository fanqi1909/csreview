package ps.google.sorting.searching;

/**
 * When one mid point is not sufficient for determining the trend, use mid and mid-1 for detecting such trend.
 * Here we assume accessing mid and mid-1 is constant cost. If accessing mid and mid-1 is expensive, we can use
 * Gold-section method to reduce the cost of accessing
 */
public class PeakInMountArray {
    public int peakIndexInMountainArray(int[] A) {

        int l = 0, r = A.length - 1;

        while (l < r) {
            int mid = (l + r + 1) >>> 1;
            if(mid == 0) {
                //mid can never be 0
                return -1;
            }
            if (A[mid] <= A[mid - 1]) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        PeakInMountArray pia = new PeakInMountArray();
        System.out.println(pia.peakIndexInMountainArray(new int[]{0, 1, 0}));
        System.out.println(pia.peakIndexInMountainArray(new int[]{0, 2, 1, 0}));
    }
}
