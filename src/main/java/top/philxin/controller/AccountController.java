package top.philxin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.philxin.bean.DataVo;
import top.philxin.bean.TransCondition;
import top.philxin.service.AccountService;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping("account/transfer")
    public DataVo transferMoney(TransCondition transCondition) {
        accountService.transferMoney(transCondition.getFromId(), transCondition.getDestId(), transCondition.getMoney());
        return DataVo.success();
    }
}
