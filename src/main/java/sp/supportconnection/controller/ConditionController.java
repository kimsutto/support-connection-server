package sp.supportconnection.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.entity.Condition;
import sp.supportconnection.service.ConditionService;
import sp.supportconnection.service.UserService;

import javax.persistence.Column;

@RestController
@RequiredArgsConstructor
public class ConditionController {
    private final ConditionService conditionService;

    @PutMapping(value = "/condition", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity updateCondition(@RequestBody ConditionRequest request){
        conditionService.updateCondition(request);
        return ResponseEntity.ok("변경완료");
    }



}
