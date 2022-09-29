//W3 作業
//學號：A1083357
//姓名：洪麗珵
class tickClass implements Runnable {
    static int tick = 10000;
    static int tickC = 0;
    int tTick;
    Thread t;

    tickClass(String name) {
        tTick = 0;
        t = new Thread(this, name);
        t.start();
    }

    public void run() {
        while (grabGold() == true) {
            int plus = tickC - tick;
            tTick += plus;
        }
        System.out.println(t.getName() + "共賣出" + tTick + "章票");
    }

    synchronized private static boolean grabGold() {
        if (tick > 0) {
            int r = 0;
            r = (int) (Math.random() * 4) + 1;
            if (r > tick) {
                r = tick;
            }
            tickC = tick;
            tick = tick - r;
            return true;
        } else {
            return false;
        }
    }
}

public class threadHW {
    public static void main(String[] args) {
        tickClass mA = new tickClass("機台A");
        tickClass mB = new tickClass("機台B");
        tickClass mC = new tickClass("機台C");
        tickClass mD = new tickClass("機台D");
    }
}