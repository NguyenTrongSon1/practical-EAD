package com.example.practicalead.api;

import com.example.practicalead.entity.Loan;
import com.example.practicalead.entity.LoanTenure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/loans")
@CrossOrigin
public class LoanAPI {
    @RequestMapping(method = RequestMethod.POST,path = "calculateInterest")
    public ResponseEntity<Object> calculateRateOfInterest(@RequestBody Loan loan) {
        double loanAmount =  loan.getLoan();
        double rateOfInterest =  loan.getRate() / 100 / 12;
        double tenure =  loan.getTenure();

        double mathPow = Math.pow((1 + rateOfInterest), tenure);

        double totalLoanAmount = loanAmount * rateOfInterest
                * (mathPow / (mathPow - 1));

        return new ResponseEntity<>(totalLoanAmount, HttpStatus.CREATED);
    }
    @RequestMapping(method = RequestMethod.POST,path = "calculateTotalLoanToBePaid")
    public ResponseEntity<Object> calculateTotalLoanToBePaidBeforeEndOfTenure(@RequestBody LoanTenure loanTenure) {
        double loanLeftToPay = loanTenure.getLoan();
        double rateOfEarlySettleMent = loanTenure.getRate() / 100;
        double totalLoanToPay = loanLeftToPay * (1 + rateOfEarlySettleMent);

        return new ResponseEntity<>(totalLoanToPay, HttpStatus.OK);
    }
}
