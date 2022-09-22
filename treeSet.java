import java.util.*;

//W2 作業1
//學號：A1083357
//姓名：洪麗珵
public class treeSet {
    public static void main(String[] args) throws Exception {

		System.out.println("電腦從1~100的整數中，亂術取出10個不重複的號碼....");
		var numbers = new TreeSet<>();
		int count = 1;
        while(count <= 10){
			int r = 0;
			r = (int)(Math.random()*100)+1;
			if(!numbers.contains(r)){
				numbers.add(r);
				System.out.println("第" + count + "個號碼：" + r);
				count ++;
			}
		}
		System.out.println("物件內元素個數為：" + numbers.size());
		System.out.println("物件內元素的內容：" + numbers);
        System.out.println("第一個元素內容為：" + numbers.first());
		System.out.println("最後一個元素內容：" + numbers.last());
		System.out.println("內容介於30~70者：" + numbers.subSet(30, 70));
    }

}