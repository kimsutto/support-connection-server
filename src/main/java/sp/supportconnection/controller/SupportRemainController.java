package sp.supportconnection.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import sp.supportconnection.service.UserService;

@RestController
@RequiredArgsConstructor
public class SupportRemainController {
    private final UserService userService;

    //남은 지원금 보기
    @GetMapping("/support-remain/{id}")
    public ResponseEntity getSupportRemain(@PathVariable("id") Long id){
        return ResponseEntity.ok(userService.getSupportRemain(id));
    }
}


