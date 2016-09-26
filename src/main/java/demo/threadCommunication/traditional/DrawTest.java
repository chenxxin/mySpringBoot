package demo.threadCommunication.traditional;

public class DrawTest {
    public static void main(String[] args) {
        Account account = new Account("1234567",0);

        new DrawThread("取钱者",account,800).start();

        new DepositThread("存钱者甲",account,800).start();
        new DepositThread("存钱者乙",account,800).start();
        new DepositThread("存钱者丙",account,800).start();
    }
}

/**
 * 程序执行到最后，被阻塞，无法继续向下执行。
 * 原因：1个取钱线程只有100次取钱操作，而3个存钱线程有300次存钱操作
 * 程序执行到最后，取钱者线程已经执行结束，而存钱者线程只是在等待其他线程来取钱而已，
 * 并不是等待其他线程释放同步监视器，不属于死锁。
 * 死锁：多个线程互相等待对方释放资源
 */
