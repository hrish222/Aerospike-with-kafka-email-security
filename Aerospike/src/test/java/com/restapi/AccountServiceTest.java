package com.restapi;

import com.restapi.Model.Account;
import com.restapi.Repository.AccountRepository;
import com.restapi.Service.AccountService;
import io.micronaut.test.annotation.MockBean;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.stream.Collectors;
import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


@MicronautTest
public class AccountServiceTest {



        @Inject
        private AccountRepository accountRepository;

        @Inject
        private AccountService accountService;
    private long accoNo;

    @MockBean(AccountRepository.class)
        AccountRepository accountRepository() {
            return mock(AccountRepository.class);
        }


        @Test
        public void getAllAccount() {
            when(accountRepository.getAllAccount()).thenReturn(Stream.of(new Account(),
                    new Account(),
                    new Account()).collect(Collectors.toList()));

            Assertions.assertEquals(3, accountService.getAllAccount().size());
        }

        @Test
        public void addAccount() {

            Account account = new Account(11234);

            when(accountService.addAccount(account)).thenReturn("Account Created Successfully..!");

            String result = accountService.addAccount(account);

            assertEquals(result, accountService.addAccount(account));
        }


//
//        @Test
//        public void deleteByAccoNumber() {
//
//            Account account = new Account(123234);
//            Account account1 = new Account(12345,1234566)
//            account.setAccoNo(123234);
//
//            when(accountService.deleteByAccoNumber(123234)).thenReturn("Account deleted successfully with account number :");
//
//            Account result = (accountService.getAccountByAccNumber(123234));
//
//            assertEquals(result, accountService.deleteByAccoNumber(123234));
//        }

    }
