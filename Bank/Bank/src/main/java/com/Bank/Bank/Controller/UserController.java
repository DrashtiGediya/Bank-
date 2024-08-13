package com.Bank.Bank.Controller;

import com.Bank.Bank.Model.AccountDetails;
import com.Bank.Bank.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("bank")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("create")
    public void createAccount(@RequestBody AccountDetails accountDetails){

        userService.createAccount(accountDetails);
    }

//    @PutMapping("deposite/{accountNo}/{amount}")
//    public void deposite(@PathVariable("accountNo") long accountNo,
//                          @PathVariable("amount") double amount ){
//        userService.Deposite(accountNo,amount);
//    }

    @PutMapping("deposite")
    public String deposite(@RequestParam long accountNo,
                          @RequestParam double amount){
       return userService.Deposite(accountNo,amount);
    }

    @PutMapping("withdraw")
    public String withdraw(@RequestParam long accountNo,
                            @RequestParam double amount){
        return userService.withdraw(accountNo,amount);
    }

    @GetMapping("getBalance/{accountNo}")

    public AccountDetails ShowBalance(@PathVariable long accountNo){

        return userService.ShowBalance(accountNo);
    }

    @PutMapping("transfer")
    public String transfer(@RequestParam long fromAccount,
                           @RequestParam long toAccount,
                           @RequestParam double amount){
        return userService.Transfer(fromAccount,toAccount,amount);
    }
}
