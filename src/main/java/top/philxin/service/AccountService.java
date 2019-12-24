package top.philxin.service;

import org.springframework.stereotype.Service;

public interface AccountService {
    boolean transferMoney(int fromId, int destId, double money);
}
