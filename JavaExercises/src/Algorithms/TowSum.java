package Algorithms;


/*Cho một mảng các số nguyên và một số nguyên đích, trả về chỉ số của hai số sao cho chúng cộng lại với đích.
Bạn có thể giả định rằng mỗi đầu vào sẽ có chính xác một giải pháp và bạn không được sử dụng cùng một phần tử hai lần.
Bạn có thể trả lời câu trả lời theo bất kỳ thứ tự nào.
Ví dụ 1:

Đầu vào: nums = [2,7,11,15], target = 9
Đầu ra: [0,1]
Giải thích: Vì nums [0] + nums [1] trả về [0, 1]. 9, chúng tôi

Ví dụ 2:
Đầu vào: nums = [3,2,4], target = 6
Đầu ra: [1,2]

Ví dụ 3:
Đầu vào: nums = [3,3], target = 6
Đầu ra: [0,1]

Hạn chế:
2 <= số.độ dài <= 104
-109 <= số[i] <= 109
-109 <= mục tiêu <= 109
Chỉ có một câu trả lời hợp lệ tồn tại.*/


import java.util.HashMap;

public class TowSum {
    /*public int[] toSum(int[] nums, int target) {
        // Vòng lặp bên ngoài duyệt qua từng phần tử
        for (int i = 0; i < nums.length; i++) {
            // Vòng lặp bên trong bắt đầu từ phần tử tiếp theo để tránh kiểm tra cùng một phần tử
            for (int j = i + 1; j < nums.length; j++) {
                // Kiểm tra nếu tổng của hai phần tử bằng target
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j }; // Trả về cặp chỉ số
                }
            }
        }
        // Trả về giá trị null nếu không tìm thấy cặp nào (có thể xử lý tốt hơn nếu muốn)
        return null;
    }
    THỜI GIAN RUNTIME: 46ms
    */

    // Sử dụng hashmap để duyệt qua từng phần tử
    public int[] twoSum(int[] nums, int target) {

            HashMap<Integer, Integer> map = new HashMap<>();

            //Duyệt qua mảng
            for(int i = 0; i < nums.length; i++){
                //Tính phần tử bổ xung để đat target
                int complement = target - nums[i];

                //Nếu phần bổ xung đã tồn tại trong HashMap, trả về cặp chỉ số
                if(map.containsKey(complement)){
                    return  new int[]{map.get(complement), i};
                }

                //Nếu không thêm phần tử vào trong HashMap
                map.put(nums[i],i);
            }

            //Nếu không tìm thấy cặp nào
            throw new IllegalArgumentException("No tow sum solution");
    }

    // Thời gian runtime: 2ms




    public static void main(String[] args) {
        TowSum twoSum = new TowSum(); // Đúng chính tả của class
        int[] a = { 1, 2, 3, 5 };
        int target = 4;
        int[] result = twoSum.twoSum(a, target);

        if (result != null) {
            System.out.println("Kết quả: [" + result[0] + ", " + result[1] + "]");
        } else {
            System.out.println("Không tìm thấy cặp số nào có tổng bằng " + target);
        }

    }
}
