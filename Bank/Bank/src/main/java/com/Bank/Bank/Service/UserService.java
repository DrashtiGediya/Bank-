package com.Bank.Bank.Service;

import com.Bank.Bank.Model.AccountDetails;
import com.Bank.Bank.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public void createAccount(AccountDetails accountDetails){
        UUID uuid = UUID.randomUUID();
        long num = Math.abs(uuid.toString().replaceAll("-","").hashCode());

        Random random = new Random(10);
        while (String.valueOf(num).length() < 10){
            num = num*10+ Math.abs(random.nextInt());
        }
        if(String.valueOf(num).length() > 10){
            num = Long.parseLong(String.valueOf(num).substring(0,10));
        }

        accountDetails.setAccountNo(num);
        userRepository.save(accountDetails);

//        Random random=new Random();
//        long accNo;
//        accNo = random.nextLong(Long.SIZE-1) + 1234567890;
//        accountDetails.setAccountNo(accNo);
//        userRepository.save(accountDetails);
    }

    public String Deposite(long accountNumber,double amount) {
        AccountDetails currUser = new AccountDetails();
        String s = "";
        if (userRepository.existsById(accountNumber)) {
            currUser = userRepository.findById(accountNumber).get();
            double currBalance = currUser.getInitialBalance();
            currBalance += amount;
            currUser.setInitialBalance(currBalance);
            userRepository.save(currUser);

            s="your amount is deposit successfully";
        }else {
            s = "No User found !!";
        }
        return s;
    }

    public String withdraw(long accountNumber,double amount){
        AccountDetails user = new AccountDetails();
        String s = "";
        if(userRepository.existsById(accountNumber)){
            user = userRepository.findById(accountNumber).get();
            if(user.getInitialBalance() - amount < 10000){
                s = "inefficient balance";
            }else{
               double currBalance = user.getInitialBalance() - amount;
               user.setInitialBalance(currBalance);
               userRepository.save(user);

               s = "withdraw successfully";
            }
        }else {
            s = "No User found !!";
        }
        return s;
    }

    // we can also apply transfer using DTO class 
    public String  Transfer(long fromAccount,long ToAccount,double amount){
        String s = "";
        if(userRepository.existsById(fromAccount) && userRepository.existsById(ToAccount)){
            AccountDetails user1 = new AccountDetails();
            AccountDetails user2 = new AccountDetails();

            user1 = userRepository.findById(fromAccount).get();
            user2 = userRepository.findById(ToAccount).get();

            if(user1.getInitialBalance() - amount < 10000){
                s = "inefficient balance";
            }else{
               double user1AmountAfterTransaction =  user1.getInitialBalance() - amount;
               user1.setInitialBalance(user1AmountAfterTransaction);
               userRepository.save(user1);

                double user2AmountAfterTransaction =  user2.getInitialBalance() + amount;
                user2.setInitialBalance(user2AmountAfterTransaction);
                userRepository.save(user2);

                s = "Transaction Successfully";
            }
        }else {
            s = "No user Found !!";
        }

        return s;
    }
    public AccountDetails ShowBalance(long accountNumber){
        if (userRepository.existsById(accountNumber)) {
            AccountDetails user = new AccountDetails();
            user = userRepository.findById(accountNumber).get();
            return user;
        }else {
            return null;
        }
    }
}
