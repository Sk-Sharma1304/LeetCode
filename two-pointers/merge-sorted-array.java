class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int gap = (m + n + 1) / 2;

        while (gap > 0) {

            int l = 0;
            int r = l + gap;

            while (r < m + n) {

                if (l < m && r < m) {

                    if (nums1[l] > nums1[r]) {
                        swap(nums1, l, r);
                    }
                }

                else if (l < m && r >= m) {

                    if (nums1[l] > nums2[r - m]) {

                        int temp = nums1[l];
                        nums1[l] = nums2[r - m];
                        nums2[r - m] = temp;
                    }
                }

                else {

                    if (nums2[l - m] > nums2[r - m]) {
                        swap(nums2, l - m, r - m);
                    }
                }

                l++;
                r++;
            }

            if (gap == 1) {
                break;
            }

            gap = (gap + 1) / 2;
        }

        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}