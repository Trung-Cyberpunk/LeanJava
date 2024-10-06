package Algorithms;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:


Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]
Example 2:

Input: list1 = [], list2 = []
Output: []
Example 3:

Input: list1 = [], list2 = [0]
Output: [0]


Constraints:

The number of nodes in both lists is in the range [0, 50].
        -100 <= Node.val <= 100
Both list1 and list2 are sorted in non-decreasing order.*/



public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        //Tạo nút giả
        ListNode dummy = new ListNode();
        ListNode current = dummy; //Con trỏ để xây dựng danh sách mới

        //Duyệt qua danh sách cả hai
        while(list1 != null && list2 != null){
            if(list1.val <= list2.val){
                current.next = list1;//Theme nut từ list 1
                list1 = list1.next; //Di chuyển đến nút tiếp theo list1
            }else {
                current.next = list2;//Theme nut từ list 2
                list2 = list2.next;//Di chuyển đến nút tieieps theo list2
            }
            current =current.next; // di chuyển đến con trỏ current
        }

        //Gắn các nút còn lại nếu có
        if(list1 != null){
            current.next = list1;
        }else {
            current.next = list2;
        }
        //Trả về danh sach đã hợp nhất từ bandđầu
        return dummy.next;
    }

    public static void main(String[] args) {
        // Tạo danh sách đầu tiên: 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // Tạo danh sách thứ hai: 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        // Hợp nhất các danh sách
        MergeTwoSortedLists solution = new MergeTwoSortedLists();
        ListNode mergedList = solution.mergeTwoLists(list1, list2);

        // In danh sách đã hợp nhất
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }


}

