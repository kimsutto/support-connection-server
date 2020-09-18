package sp.supportconnection.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.dto.SupportResponse;
import sp.supportconnection.service.SupportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class SupportController {
    private final SupportService supportService;

    //예상 지원금 전체 보기 -> id는 user id
    @GetMapping("/supports/{id}")
    public ResponseEntity getSupports(@PathVariable("id") Long id){
        List<SupportResponse> supportResponses = supportService.getSupports(id);
        return ResponseEntity.ok(supportResponses);
    }


}
