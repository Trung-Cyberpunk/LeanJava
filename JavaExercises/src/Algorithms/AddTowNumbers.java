package Algorithms;


/*
Bạn được cung cấp hai danh sách liên kết không rỗng biểu diễn hai số nguyên không âm. Các chữ số được lưu trữ theo thứ tự ngược
lại và mỗi nút của chúng chứa một chữ số duy nhất. Cộng hai số và trả về tổng dưới dạng danh sách liên kết.
Bạn có thể cho rằng hai số này không chứa số 0 nào ở đầu, ngoại trừ chính số 0.
Ví dụ 1:

[ 2 - 4 - 3 ]

[ 5 - 6 - 4 ]

 = [ 7 - 0 - 8 ]

Đầu vào: 11 = [2,4,3], 12 = [5,6,4]
Đầu ra: [7,0,8]
Giải thích: 342 + 465 = 807.

Ví dụ 2:
Đầu vào: 11 = [0], 12 = [0]
Đầu ra: [0]

Ví dụ 3:
Đầu vào: 11 = [9,9,9,9,9,9,9], 12 = [9,9,9,9]
Đầu ra: [8,9,9,9,0,0,0,1]*/

public class AddTowNumbers {


    // Tạo một Node với giá trị không âm để sử dụng cộng hai soos
    public static class ListNode{
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
/*
    public ListNode addTowNumbers(ListNode l1, ListNode l2 ){
        //Xây dựng nút giả để dễ dàng xây dựng danh sách kết quả

        ListNode dummyHead = new ListNode(0); //Nút Giả
        ListNode current = dummyHead; //Con trỏ nút giả
        int carry = 0;

        //Duyệt qua 2 mảng L1, l2
        while (l1 != null || l2 != null || carry != 0){
            int sum = carry; // Bắt đầu với carry trước đó

            //Theem giá trị từ l1 nếu có
            if( l1 != null){
                sum += l1.val;
                l1 = l1.next; // Di chuyển tới nút tiếp theo
            }

            if( l2 != null){
                sum += l2.val;
                l2 = l2.next; // Di chuyển tới nút tiếp theo
            }

            carry = sum / 10; // chia lấy phần dư để cộng vào nút tiếp theo

            current.next = new ListNode(sum % 10); //Cập nhật giá trị vào LIstnode
            current = current.next; // Di chuyển tới nút tiếp theo
        }

        return dummyHead.next; // Trả về danh sách kết quả(bỏ qua nút giả)
    }*/


//Tối ưu lại bộ nhớ

    public ListNode addTowNumbers(ListNode l1, ListNode l2 ){
// Khởi tạo nút giả để dễ dàng xây dựng danh sách kết quả
        ListNode ExampleList = new ListNode(0);
        ListNode curr = ExampleList;

        int z = 0;

        while(l1 != null || l2 != null || z != 0){
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;

            int sum = x + y + z;
            z = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if( l1 != null)
                l1 = l1.next;
            if(l2 != null)
                l2 = l2.next;
        }
        return ExampleList.next;
    }

    public static void main(String[] args) {
// Tạo các danh sách liên kết cho ví dụ 1: 342 + 465
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3))); // 342
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4))); // 465

        AddTowNumbers solution = new AddTowNumbers();
        ListNode result = solution.addTowNumbers(l1, l2);

        // In kết quả
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}
