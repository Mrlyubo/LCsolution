/**There are two sorted arrays nums1 and nums2 of size m and n respectively.

        Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

        Example 1:
        nums1 = [1, 3]
        nums2 = [2]

        The median is 2.0
        Example 2:
        nums1 = [1, 2]
        nums2 = [3, 4]

        The median is (2 + 3)/2 = 2.5
 */


public class Median {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {// swap , make sure nums2 is longer.
            int[] temp = nums1;nums1 = nums2;nums2 = temp;
            int temp1 = m;m = n;n = temp1;
        }
        int iMin = 0, iMax = m;
        int i = 0, j = 0;
        double res = 0;
        int leftMax = 0, rightMin = 0;

        while (iMin <= iMax) { // < is not enough.

            i = (iMin + iMax) / 2;
            j = (m + n + 1) / 2 - i;

            if (i > 0 && nums1[i - 1] > nums2[j]) iMax -= 1; // where i is too large;
            else if (i < m && nums2[j - 1] > nums1[i]) iMin += 1;// where i is too small;
            else {i = (iMin + iMax) / 2;j = (m + n + 1) / 2 - i;break;}//where i is perfect. Update i and j.

        }
            if (i == 0) leftMax = nums2[j - 1];
            else if (j == 0) leftMax = nums1[i - 1];
            else leftMax = Math.max(nums2[j - 1], nums1[i - 1]);

            if (i == m &&  j != n) rightMin = nums2[j];
            else if (j == n && i != m) rightMin = nums1[i];
            else if (i == m && j == n)rightMin = nums2[j-1];//design for corner case : {}{5}
            else rightMin = Math.min(nums1[i], nums2[j]);

            if ((m + n) % 2 == 0) {
                res = (leftMax + rightMin)/2.0;// double = int / double;

            } else {
                res = leftMax;
            }
            return res;
    }

        public static void main (String[]args){
            Median Launcher = new Median();
            Launcher.start();
        }
        public void start () {

            ///int n = 3, m = 2;
            //double median = ( n + m ) / 2;
            //System.out.print(median);

            int[] nums1 = new int[]{3,4,5};
            int[] nums2 = new int[]{1,2};
            System.out.print(findMedianSortedArrays(nums1, nums2));
        }
    }
