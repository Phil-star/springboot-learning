package top.philxin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.philxin.bean.Account;
import top.philxin.mapper.AccountMapper;
import top.philxin.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    AccountMapper accountMapper;

    @Transactional
    @Override
    public boolean transferMoney(int fromId, int destId, double money) {
        Account fromAccount = accountMapper.selectByPrimaryKey(fromId);
        Account destAccount = accountMapper.selectByPrimaryKey(fromId);

        accountMapper.updateMoneyById(destId,money);
        int i = 1 / 0;
        accountMapper.updateMoneyById(fromId,-money);
        return true;
    }
}
