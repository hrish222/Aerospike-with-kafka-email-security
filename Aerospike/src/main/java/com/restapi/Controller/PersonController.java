package com.restapi.Controller;

import com.restapi.BankStatement.BalanceTransfer;
import com.restapi.BankStatement.ResponseDto;
import com.restapi.BankStatement.Transaction;
import com.restapi.BankStatement.commonDateutils;
import com.restapi.Model.Account;
import com.restapi.Model.CustomResponse;
import com.restapi.Model.Person;
import com.restapi.Service.AccountService;
import com.restapi.Service.PersonService;
import com.restapi.Service.TransactionService;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.inject.Inject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;


/**
 * The type Person controller.
 */
@Controller("/person")
@Tag(name = "Person Details")
@SecurityRequirement(name = "Authorization")

//@Secured({SecurityRule.IS_AUTHENTICATED})

public class PersonController {
    private static Logger logger = (Logger) LogManager.getLogger(PersonController.class.getName());
    /**
     * The Employee service.
     */
    @Inject
    PersonService employeeService;
    /**
     * The Transaction service.
     */
    @Inject
    TransactionService transactionService;
    /**
     * The Account service.
     */
    @Inject
    AccountService accountService;
    /**
     * The Response dto.
     */
    ResponseDto responseDto = new ResponseDto();

    /**
     * Add person http response.
     *
     * @param person the person
     * @return the http response
     */
    @Post(value = "/add")
    @Produces(MediaType.APPLICATION_JSON)
   // @ContinueSpan
    public HttpResponse<CustomResponse> addPerson(@Body Person person) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> addPerson(@Body Person person)");
        return HttpResponse.ok(new CustomResponse(employeeService.addPerson(person)));
    }

    /**
     * Gets all person.
     *
     * @return the all person
     */
    @Get(value = "/getallperson")
    public HttpResponse<List<Person>> getAllPerson() {
        logger.info(getClass().getName() + " .HttpResponse<List<Person>> getAllPerson()");
        List<Person> person = employeeService.getAllPerson();

        if (person.size() >= 0) {
            return HttpResponse.ok().body(person);
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Gets person by id.
     *
     * @param id the id
     * @return the person by id
     */
    @Get(value = "/getperson/{id}")
    public HttpResponse<Person> getPersonById(@PathVariable("id") int id) {
        logger.info(getClass().getName() + " .HttpResponse <Person> getPersonById(@PathVariable(id) int id)");
        Person person = employeeService.getPersonById(id);

        if (person != null) {
            return HttpResponse.ok().body(person);
        } else
            return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    /**
     * Update person http response.
     *
     * @param person the person
     * @param id     the id
     * @return the http response
     */
    @Put(value = "/update/{id}")
    public HttpResponse<CustomResponse> updatePerson(@Body Person person, @PathVariable("id") int id) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> updatePerson(@Body Person person ,@PathVariable(id) int id)");
        return HttpResponse.ok(new CustomResponse(employeeService.updatePerson(person, id)));

    }

    /**
     * Delete by id http response.
     *
     * @param id the id
     * @return the http response
     */
    @Delete(value = "/delete/{id}")
    public HttpResponse<CustomResponse> deleteById(int id) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> deleteById(int id)");

        return HttpResponse.ok(new CustomResponse(employeeService.deleteById(id)));
    }


//Account Controller as Follows:

    /**
     * Add account http response.
     *
     * @param account the account
     * @return the http response
     */
    @Post(value = "/account")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> addAccount(@Body Account account) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> addAccount(@Body Account account)");
        return HttpResponse.ok(new CustomResponse(accountService.addAccount(account)));
    }

    /**
     * Gets all account.
     *
     * @return the all account
     */
    @Get(value = "/getallaccount")
    public HttpResponse<List<Account>> getAllAccount() {
        logger.info(getClass().getName() + " .HttpResponse<List<Account>> getAllAccount()");
        List<Account> accounts = accountService.getAllAccount();

        if (accounts.size() >= 0) {
            return HttpResponse.ok().body(accounts);
        }
        return HttpResponse.status(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    /**
     * Gets account by acc number.
     *
     * @param accoNo the acco no
     * @return the account by acc number
     */
    @Get(value = "/getaccount/{accoNo}")
    public HttpResponse<Account> getAccountByAccNumber(@PathVariable("accoNo") long accoNo) {
        logger.info(getClass().getName() + " .HttpResponse <Account> getAccountByAccNumber(@PathVariable(accoNo) long accoNo)");
        Account account = accountService.getAccountByAccNumber(accoNo);

        if (account != null) {
            return HttpResponse.ok().body(account);
        } else
            return HttpResponse.status(HttpStatus.NOT_FOUND);
    }

    /**
     * Delete by acco number http response.
     *
     * @param accoNo the acco no
     * @return the http response
     */
    @Delete(value = "/deleteAccoNo/{accoNo}")
    public HttpResponse<CustomResponse> deleteByAccoNumber(long accoNo) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> deleteByAccoNumber(long accoNo)");

        return HttpResponse.ok(new CustomResponse(accountService.deleteByAccoNumber(accoNo)));
    }

    /**
     * Cash withdraw http response.
     *
     * @param accoNo         the acco no
     * @param withdrawAmount the withdraw amount
     * @return the http response
     */
    @Post(value = "/credit")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> cashWithdraw(@QueryValue long accoNo,@QueryValue  long withdrawAmount) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> cashWithdraw(@Body accoNo withdrawAmount)");
        return HttpResponse.ok(new CustomResponse(accountService.cashWithdraw(accoNo,withdrawAmount)));
    }

    /**
     * Cash deposit http response.
     *
     * @param accoNo        the acco no
     * @param depositAmount the deposit amount
     * @return the http response
     */
    @Post(value = "/debit")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> cashDeposit(@QueryValue long accoNo,@QueryValue  long depositAmount) {
        logger.info(getClass().getName() + " .HttpResponse<CustomResponse> cashWithdraw(@Body accoNo withdrawAmount)");
        return HttpResponse.ok(new CustomResponse(accountService.cashDeposit(accoNo,depositAmount)));
    }

    /**
     * Account state http response.
     *
     * @param accoNo    the acco no
     * @param startDate the start date
     * @param endDate   the end date
     * @return the http response
     */
    @Get("/statement")
    public HttpResponse<CustomResponse> accountState(@QueryValue long accoNo, @QueryValue String startDate, @QueryValue String endDate) {
        HashMap<String, List> hMap = new HashMap<>();
        List<Transaction> updList = new ArrayList<>();
        try {
            List<Transaction> txn = transactionService.account();
            Account account =  accountService.getAccountByAccNumber(accoNo);

            for (int i = 0; i < txn.size(); i++) {
                if (txn.get(i).getAccoNo() == (accoNo)) {
                    Date date = commonDateutils.dateFormat(txn.get(i).getTimePeriod());
                    if (commonDateutils.isWithinRange(date, commonDateutils.dateFormat(startDate), commonDateutils.dateFormat(endDate))) {
                        updList.add(txn.get(i));
                    }
                }
            }
            hMap.put("Account balance", Arrays.asList(account.getBalance()));
            hMap.put("Transaction History", updList);
            responseDto.setResult("SUCCESS");
            responseDto.setHistory(hMap);
            return HttpResponse.ok(new CustomResponse(responseDto));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    /**
     * Send money http response.
     *
     * @param transferBalanceRequest the transfer balance request
     * @return the http response
     */
    @Post(value = "/transferBalanceRequest")
    @Produces(MediaType.APPLICATION_JSON)
    public HttpResponse<CustomResponse> sendMoney(@Body BalanceTransfer transferBalanceRequest){
         return HttpResponse.ok(new CustomResponse(accountService.sendMoney(transferBalanceRequest)));
    }
}
