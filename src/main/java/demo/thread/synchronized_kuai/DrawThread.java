package demo.thread.synchronized_kuai;

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

    @Override
    public void run() {
        /**
         * 同步监视器：account
         * 任何时刻只能有一个线程可以获得对同步监视器的锁定，当同步代码块执行完成后，该线程会释放同步监视器的锁定。
         * 即 加锁 -> 修改 -> 释放锁
         */
        synchronized (account){
            if (account.getBalance() >= drawAmount){
                System.out.println(getName() + "取钱成功！吐出钞票：" + drawAmount);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 修改余额
                account.setBalance(account.getBalance()-drawAmount);
                System.out.println("------余额为：" + account.getBalance());
            }else {
                System.out.println(getName() + "取钱失败！余额不足！");
            }
        }
    }
}
