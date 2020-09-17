package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public Long join(User user){
        //회원 가입
        Optional<User> findUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findUser.isPresent()){
            return findUser.get().getId();
        }else {
            userRepository.save(user);
            Optional<User> findUser2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
            return findUser2.get().getId();

        }
    }
}
