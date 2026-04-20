class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int column = matrix[0].length;
        int target_row = findRow(matrix, target, 0, row - 1);
        if(target_row != -1)
        {return binary(matrix[target_row], target, 0, column - 1);}
        else return false;
    }

    private int findRow(int[][] matrix, int target, int top, int bottom){
        if(bottom < top) return -1;
        int mid = top + (bottom - top) / 2;
        if(matrix[mid][0] <= target && matrix[mid][matrix[0].length - 1] >= target){
            return mid;
        }
        if(matrix[mid][0] > target){
            return findRow(matrix, target, top, mid - 1);
        } else {
            return findRow(matrix, target, mid + 1, bottom);
        }
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
