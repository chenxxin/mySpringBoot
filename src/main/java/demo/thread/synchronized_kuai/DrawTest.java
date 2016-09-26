package demo.thread.synchronized_kuai;

/**
 * Created by CHENXINXIN on 2016/9/7.
 */
public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("1234567", 1000);
        new DrawThread("甲",account,800).start();
        new DrawThread("乙",account,800).start();
    }
}
