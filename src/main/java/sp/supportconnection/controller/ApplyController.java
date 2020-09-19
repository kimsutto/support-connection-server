package sp.supportconnection.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.dto.SupportDetailResponse;
import sp.supportconnection.dto.SupportResponse;
import sp.supportconnection.service.SupportService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApplyController {
    private final SupportService supportService;

    // 쉬운 지원금 신청 전체 보기
    @GetMapping("/apply/supports/user/{id}")
    public ResponseEntity getSupports(@PathVariable("id") Long id){
        List<SupportResponse> supportResponses = supportService.getSupports(id);
        return ResponseEntity.ok(supportResponses);
    }

    // 쉬운 지원금 신청 개별 보기 -> id 는 support id
    @GetMapping("/apply/supports/{id}")
    public ResponseEntity getSupport(@PathVariable("id") Long id){
        SupportDetailResponse supportDetailResponse = supportService.getSupport(id);
        return ResponseEntity.ok(supportDetailResponse);
    }

}
