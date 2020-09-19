package sp.supportconnection.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.service.UserService;
import sp.supportconnection.service.MeService;
import sp.supportconnection.entity.Asset;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class MeController {
    private final UserService userService;
    private final MeService meService;

    // 나의 자산 입력하기
    @PostMapping(value = "/me/asset", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerMyAsset(@RequestBody MeController.RegisterMyAssetRequest request){
        Asset asset = userService.getAsset(request.getUserId());
        int newMyAsset = request.getMyAsset();
        int newAnnualIncome = request.getAnnualIncome();
        Asset newAsset = meService.updateMyAsset(asset, newMyAsset, newAnnualIncome);
        return ResponseEntity.ok(newAsset);
    }
    @Data
    static class RegisterMyAssetRequest{
        private Long userId;
        private int myAsset;
        private int annualIncome;
    }

    // 나의 대출 정보 입력하기
    @PostMapping(value = "/me/loan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerMyLoan(@RequestBody MeController.RegisterMyLoanRequest request){
        Asset asset = userService.getAsset(request.getUserId());
        int newLoan = request.getLoan();
        int newInterestRate = request.getInterestRate();
        int newCreditRate = request.getCreditRate();
        Asset newAsset = meService.updateMyLoan(asset, newLoan, newInterestRate, newCreditRate);
        return ResponseEntity.ok(newAsset);
    }
    @Data
    static class RegisterMyLoanRequest{
        private Long userId;
        private int loan;
        private int interestRate;
        private int creditRate;
    }

    // 나의 지원금 잔액 입력하기
    @PostMapping(value = "/me/support-remain", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity registerMySupportRemain(@RequestBody MeController.RegisterMySupportRemainRequest request){
        Asset asset = userService.getAsset(request.getUserId());
        int newSupportRemain = request.getSupportRemain();
        Date newSupportDeadline = request.getSupportDeadline();
        Asset newAsset = meService.updateMySupportRemain(asset, newSupportRemain, newSupportDeadline);
        return ResponseEntity.ok(newAsset);
    }
    @Data
    static class RegisterMySupportRemainRequest{
        private Long userId;
        private int supportRemain;
        private Date supportDeadline;
    }
}
