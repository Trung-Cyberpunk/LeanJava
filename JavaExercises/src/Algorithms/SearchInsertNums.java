package Algorithms;

public class SearchInsertNums {
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length - 1;

        while(left <= right){
            int mid = left + (right - left)/ 2;

            //Nếu tì thấy target, trả về vị trí
            if(nums[mid] == target){
                return mid;
            }

            //nếu target nhỏ hơn giá trị tại mid di chuyển rigth về giữa
            else if(nums[mid] > target){
                right = mid -1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}
