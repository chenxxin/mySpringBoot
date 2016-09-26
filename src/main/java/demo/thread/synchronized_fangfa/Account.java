package demo.thread.synchronized_fangfa;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by CHENXINXIN on 2016/9/7.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    // 账户编号
    private String accountNo;

    // 账户余额
    private double balance;

    /**
     * 取钱
     * 线程安全
     * 同步方法的同步监视器是 this ，也就是调用该方法的对象。（非 static 方法）
     */
    public synchronized void draw(double drawAmount){
        if (balance >= drawAmount){
            System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // 修改余额
            balance -= drawAmount;
            System.out.println("------余额为：" + balance);
        }else {
            System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
        }
    }
}
