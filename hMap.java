import java.util.*;

//W2 作業2
//學號：A1083357
//姓名：洪麗珵
public class hMap {
    public static void main(String[] args) throws Exception {

        var hmap = new HashMap<>();
        hmap.put(1, "January");
        hmap.put(2, "February");
        hmap.put(3, "March");
        hmap.put(4, "April");
        hmap.put(5, "May");
        hmap.put(6, "June");
        hmap.put(7, "July");
        hmap.put(8, "August");
        hmap.put(9, "September");
        hmap.put(10, "October");
        hmap.put(11, "November");
        hmap.put(12, "December");

        while (true) {
            System.out.print("請輸入1~12?");
            Scanner sc = new Scanner(System.in);
            String str = sc.next();
            boolean isNumeric = true;
            for (int i = 0; i < str.length(); i++) {
                if (!Character.isDigit(str.charAt(i))) {
                    isNumeric = false;
                }
            }
            if (isNumeric) {
                int input = Integer.parseInt(str);
                if (input >= 1 && input <= 12) {
                    Object hamp;
                    System.out.println("第" + input + "月的英文單字為" + hmap.get(input));
                    break;
                } else {
                    System.out.println("範圍錯誤!");
                }
            } else {
                System.out.println("格式錯誤!");
            }
        }
    }

}