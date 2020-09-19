package sp.supportconnection.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.dto.SupportDetailResponse;
import sp.supportconnection.service.SupportService;

@RestController
@RequiredArgsConstructor
public class EstimateController {
    private final SupportService supportService;

    // 예상 지원금 개별 보기 -> id 는 support id
    @GetMapping("/estimate/supports/{id}")
    public ResponseEntity getSupports(@PathVariable("id") Long id){
        SupportDetailResponse supportDetailResponse = supportService.getSupport(id);
        return ResponseEntity.ok(supportDetailResponse);
    }

}
