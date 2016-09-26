package demo.threadCommunication.traditional;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Account {
    // 账户编号
    private String accountNo;

    // 账户余额
    private double balance;

    // true 已经有钱，可以取钱； false 没钱，可以存钱
    private boolean flag = false;

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    /**
     * 取钱
     * 线程安全
     * 同步方法的同步监视器是 this ，也就是调用该方法的对象。（非 static 方法）
     */
    public synchronized void draw(double drawAmount) {
        try {
            if (!flag){ // false 没钱，取钱线程阻塞
                wait();
            }else {
                System.out.println("----" + Thread.currentThread().getName() + "取钱：" + drawAmount);
                balance -= drawAmount;
                System.out.println("----------账户余额为：" +  balance);

                flag = false;
                notifyAll(); // 唤醒其他线程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 存钱
     */
    public synchronized void deposit(double depositAmount) {
        try {
            if (flag){ // true 已经有钱，存钱线程阻塞
                wait();
            }else {
                System.out.println(Thread.currentThread().getName() + " 存款：" + depositAmount);
                balance += depositAmount;
                System.out.println("账户余额为：" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
