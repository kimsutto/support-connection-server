package sp.supportconnection.controller;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sp.supportconnection.entity.User;
import sp.supportconnection.service.UserService;

import javax.persistence.Column;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    //로그인
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserRequest request){
        User user = new User();
        user.setName(request.getName());
        user.setAgency(request.getAgency());
        user.setPhoneNumber(request.getPhoneNumber());
        user.setAge(request.getAge());
        Long id = userService.join(user);
        return ResponseEntity.ok(id);
    }
    @Data
    static class UserRequest{
        private String name;
        private String agency;
        private String phoneNumber;
        private int age;
    }
}
