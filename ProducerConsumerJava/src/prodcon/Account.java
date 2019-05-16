package prodcon;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private final Lock lock = new ReentrantLock();
    private final Condition accountNotEmpty= lock.newCondition();

    private Integer balance;
    public void deposit(Integer value){

    }

    public void withdraw(Integer value){

    }
}
