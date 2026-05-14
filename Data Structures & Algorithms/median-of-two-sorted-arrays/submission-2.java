class Solution {
    //
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int first = 0;
        int second = 0;
        int index = 0;
        while(first < len1 && second < len2){
            if(nums1[first] < nums2[second]){
                arr[index] = nums1[first];
                first++;
            } else {
                arr[index] = nums2[second];
                second++;
            }
            index++;
        }
        if(first >= len1){
            while(second < len2){
                arr[index] = nums2[second];
                index++;
                second++;
            }
        }
        if(second >= len2){
            while(first < len1){
                arr[index] = nums1[first];
                index++;
                first++;
            }
        }
        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + ", ");
        }
        if((len1 + len2) % 2 == 0){
            return ((double)arr[(len1 + len2 - 1)/2] + (double)arr[(len1 + len2)/2])/2;
        } else return arr[(len1 + len2 - 1)/2];
    }
}
