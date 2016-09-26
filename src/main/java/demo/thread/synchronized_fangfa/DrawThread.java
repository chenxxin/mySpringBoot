package demo.thread.synchronized_fangfa;


/**
 * Created by CHENXINXIN on 2016/9/7.
 */

public class DrawThread extends Thread {

    private final Account account;

    // 待取的金额
    private double drawAmount;

    public DrawThread(String name, Account account, double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    /**
     * draw()方法是同步方法
     * 同步方法的同步监视器是 this ，也就是调用该方法的对象，即 account
     */
    @Override
    public void run() {
        account.draw(drawAmount);
    }
}
