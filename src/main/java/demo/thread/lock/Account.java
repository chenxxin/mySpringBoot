package demo.thread.lock;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by CHENXINXIN on 2016/9/7.
 */

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private final ReentrantLock lock = new ReentrantLock();

    // 账户编号
    private String accountNo;

    // 账户余额
    private double balance;

    /**
     * 取钱
     */
    public void draw(double drawAmount){
        lock.lock();
        try {
            if (balance >= drawAmount){
                System.out.println(Thread.currentThread().getName() + "取钱成功！吐出钞票：" + drawAmount);

                // 修改余额
                balance -= drawAmount;
                System.out.println("------余额为：" + balance);
            }else {
                System.out.println(Thread.currentThread().getName() + "取钱失败！余额不足！");
            }
        }finally {
            lock.unlock();
        }
    }
}
