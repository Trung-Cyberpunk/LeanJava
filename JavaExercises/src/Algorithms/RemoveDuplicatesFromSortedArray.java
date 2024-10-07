package Algorithms;

public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        //Bước 1 nếu mảng trống trả về 0
        if(nums.length == 0) return 0;

        //bước 2 ử dụng con trỏ 'i' để theo dỗi vị tr của phần tử duy nhất tiếp theo

        int i = 1;

        //Duyệt mảng với con trỏ 'j'
        for(int j = i; j < nums.length; j++){
            //Nếu phần tủ hiện tại khoong gióng phần tử như trước đó
            if(nums[j] != nums[j - 1]){
                //Gán hần tử tại j vào vị trí của i
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }
}

