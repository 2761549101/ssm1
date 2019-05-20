package com.controller;

import com.domain.Account;
import com.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName AccountController
 * @Description 账户web
 * @Auther Google
 * @Date 2019/4/23 7:55
 * @Version 1.0
 */
@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private AccountService accountService;

    /**
     * 查询
     *
     * @param model
     * @return
     */
    @RequestMapping("/findAll")
    public String fingAll(Model model) {
        System.out.println("web层_查询所有账户");
        List<Account> list = accountService.findAll();
        model.addAttribute("list", list);
        return "/list.jsp";
    }

    @RequestMapping("/saveAccount")
    public String saveAccount(Account account, HttpServletRequest request, HttpServletResponse response) throws IOException {
        accountService.saveAccount(account);
        response.sendRedirect(request.getContextPath()+"/account/findAll");
        return "/list.jsp";
    }
}
