package Algorithms;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        //Kiểm tra mảng rỗng hoặc không có chuỗi nào thì trả về chuỗi rỗng
        if(strs == null || strs.length == 0){
            return "";
        }
        //Giả định chuỗi đâu tiền là tiền tố chung
        String prefix = strs[0];

        //Duyệt qua từng chuỗi trong mảng, bắt đầu từ chuỗi thứ 2
        for(int i = 1; i < strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                //Trong khi tiền tố không khớp với chuỗi hiện tại
                prefix = prefix.substring(0, prefix.length() - 1);
                //Nếu tiền tố bị rút hết trả về chuỗi rỗng
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;
    }

    public static void main(String[] args) {
        // Ví dụ 1

        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        String[] strs1 = {"flower", "flow", "flight"};
        System.out.println("Tiền tố chung dài nhất: " + longestCommonPrefix.longestCommonPrefix(strs1));  // Kết quả: "fl"

        // Ví dụ 2
        String[] strs2 = {"dog", "racecar", "car"};
        System.out.println("Tiền tố chung dài nhất: " + longestCommonPrefix.longestCommonPrefix(strs2));  // Kết quả: ""
    }
}
