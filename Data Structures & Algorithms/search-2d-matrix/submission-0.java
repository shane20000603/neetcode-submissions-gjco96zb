class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        for(int i = 0; i < row; i++){
            if(matrix[i][0] <= target && matrix[i][column - 1] >= target){
                return binary(matrix[i], target, 0, column - 1);
            }
        }
        return false;
    }

    private boolean binary(int[] arr, int target, int left, int right){
        if(left > right) return false;
        int mid = left + (right - left)/2;
        if(arr[mid] == target) return true;
        if(arr[mid] > target){
            return binary(arr, target, left, mid - 1);
        } else {
            return binary(arr, target, mid + 1, right);
        }
    }
}
