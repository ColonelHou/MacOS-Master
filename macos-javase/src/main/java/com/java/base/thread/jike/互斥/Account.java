package com.java.base.thread.jike.互斥;

/**
 * A, B, C帐户都有200全元
 * A => B 100
 * B => C 100
 * 因为锁的不是同一个对象
 */
public class Account {
    private int balance;
    // 转账
    void transfer(
            Account target, int amt){
        if (this.balance > amt) {
            this.balance -= amt;
            target.balance += amt;
        }
    }
}


/**
 * 创建一个共享资源, 几个对象共享
 */
class AccountT {
    private Object lock；
    private int balance;
//    private AccountT();
    // 创建 Account 时传入同一个 lock 对象
    public AccountT(Object lock) {
        this.lock = lock;
    }
    // 转账
    void transfer(Account target, int amt){
        // 此处检查所有对象共享的锁
        synchronized(lock) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}


/**
 * 或者用类锁
 */
class AccountTT {
    private int balance;
    // 转账
    void transfer(Account target, int amt){
        synchronized(Account.class) {
            if (this.balance > amt) {
                this.balance -= amt;
                target.balance += amt;
            }
        }
    }
}

/**
 * 细粒度锁: 多个人相互等待, 会发生死锁
 */
class Account {
    private int balance;
    // 转账
    void transfer(Account target, int amt){
        // 锁定转出账户
        synchronized(this) {
            // 锁定转入账户
            synchronized(target) {
                if (this.balance > amt) {
                    this.balance -= amt;
                    target.balance += amt;
                }
            }
        }
    }
}


