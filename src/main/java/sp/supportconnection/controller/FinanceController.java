package sp.supportconnection.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.service.UserService;

@RestController
@RequiredArgsConstructor
public class FinanceController {

    private final UserService userService;

    //금융 비용 줄이
    @GetMapping("/finance/asset/{id}")
    public ResponseEntity getReduceFinanceAsset(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getReduceFinance(id));
    }
}
