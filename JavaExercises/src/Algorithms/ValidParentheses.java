package Algorithms;
/*Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:
Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Every close bracket has a corresponding open bracket of the same type.

        Example 1:
        Input: s = "()"
        Output: true

        Example 2:
        Input: s = "()[]{}"
        Output: true

        Example 3:
        Input: s = "(]"
        Output: false

        Example 4:
        Input: s = "([])"
        Output: true

        Constraints:

        1 <= s.length <= 104
        s consists of parentheses only '()[]{}'.*/

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static boolean isValid(String s) {
            //Tạo ngăn xếp để lưu các dấu ngoăc mở
        Stack<Character> stack = new Stack<>();

        //Bản đồ ánh xạ các dấu ngoặc đóng tới dấu ngoặc mở tương ứng
        HashMap<Character, Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');

        //Duyệt qua từng ký tự có trong chuỗi
        for(char ch : s.toCharArray()){
            //Nếu là dấu ngoặc đóng
            if(map.containsKey(ch)){
                //lấy dấu ngoặc ở đầu ngăn xếp nếu ngăn xếp không rỗng
                //Nếu không thì gán một giá trị tạm
                char topElement = stack.isEmpty() ? '#' : stack.pop();

                //Kiểm tra xem dấu ngoặc lấy ra có khớp với dấu ngoặc mở tương ứng hhay không
                if(topElement != map.get(ch)){
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }



    //Cách 2
    /*
    public static boolean isValid(String s) {
        // Tạo ngăn xếp để lưu các dấu ngoặc mở
        Stack<Character> stack = new Stack<>();

        // Duyệt qua từng ký tự trong chuỗi s
        for (char ch : s.toCharArray()) {
            // Nếu là dấu ngoặc mở, đẩy vào ngăn xếp
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            // Nếu là dấu ngoặc đóng
            else {
                // Nếu ngăn xếp rỗng, nghĩa là không có dấu ngoặc mở để ghép
                if (stack.isEmpty()) {
                    return false; // Chuỗi không hợp lệ
                }

                // Lấy dấu ngoặc mở trên cùng của ngăn xếp
                char top = stack.pop();

                // Kiểm tra xem dấu ngoặc mở có khớp với dấu ngoặc đóng hay không
                if ((ch == ')' && top != '(') ||
                        (ch == '}' && top != '{') ||
                        (ch == ']' && top != '[')) {
                    return false; // Chuỗi không hợp lệ
                }
            }
        }

        // Kiểm tra cuối cùng: nếu ngăn xếp vẫn còn dấu ngoặc mở, chuỗi không hợp lệ
        return stack.isEmpty();
    }
*/
    public static void main(String[] args) {
        System.out.println(isValid("()"));      // Kết quả: true
        System.out.println(isValid("()[]{}"));  // Kết quả: true
        System.out.println(isValid("(]"));      // Kết quả: false
        System.out.println(isValid("([])"));    // Kết quả: true
    }
}
