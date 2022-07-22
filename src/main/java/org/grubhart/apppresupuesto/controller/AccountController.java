package org.grubhart.apppresupuesto.controller;

import org.grubhart.apppresupuesto.controller.request.DepositRequest;
import org.grubhart.apppresupuesto.domain.Account;
import org.grubhart.apppresupuesto.error.exception.InvalidCreateAccountRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    //private final AccountService accountService;


    //private final AccountRepository accountRepository;


    @PostMapping(value = { "/account"})
    @ResponseStatus(HttpStatus.OK)
    public Account create(@RequestBody Account account) {


        Account savedAccount = null;

        boolean validRequest = true;

        
        return account;

    }

    @GetMapping(value = {"/account/{nombreCuenta}"})
    @ResponseStatus(HttpStatus.OK)
    public Account getStatus(@PathVariable("nombreCuenta") String name){

        Account account = new Account(name, 30.0);
        return account;

    }

    @PostMapping(value = { "/account/{name}/deposit"})
    @ResponseStatus(HttpStatus.OK)
    public Account deposit(@RequestBody DepositRequest request, @PathVariable("name") String name) {

        Account account = new Account(name, 30.0);
        account.deposit(request.getAmount());

        return account;

    }

    @PostMapping(value = { "/account/{name}/withdraw"})
    @ResponseStatus(HttpStatus.OK)
    public Account withdraw(@RequestBody DepositRequest request, @PathVariable("name") String name) {

        Account account = new Account(name, 30.0);
        account.withdraw(request.getAmount());

        return account;

    }

    @PostMapping(value = { "/account/{name}/close"})
    @ResponseStatus(HttpStatus.OK)
    public Account close( @PathVariable("name") String name) {

        Account account = new Account(name, 30.0);
        account.setStatus(0);
        return account;
    }



}
