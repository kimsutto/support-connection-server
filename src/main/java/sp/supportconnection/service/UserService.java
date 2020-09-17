package sp.supportconnection.service;

import lombok.Data;
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
        Optional<User> findUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findUser.isPresent()){
            return findUser.get().getId();
        }else {
            userRepository.save(user);
            Optional<User> findUser2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
            return findUser2.get().getId();

        }
    }

    public UserInfoResponse getMyinfo(Long id){
        Optional<User> user = userRepository.findById(id);
        System.out.println(user);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        if(user.isPresent()){
            userInfoResponse.setName(user.get().getName());
            userInfoResponse.setTotalAmount(user.get().getAvailableSupport().getTotalAmount());
            userInfoResponse.setCashAmount(user.get().getAvailableSupport().getCashAmount());
            userInfoResponse.setFinancialAmount(user.get().getAvailableSupport().getFinancialAmount());
            userInfoResponse.setMyAsset(user.get().getAsset().getMyAsset());
            userInfoResponse.setSupportRemain(user.get().getAsset().getSupportRemain());
        }
        return userInfoResponse;
    }

    @Data
    static class UserInfoResponse{
        private String name;
        private int totalAmount;
        private int cashAmount;
        private int financialAmount;
        private int myAsset;
        private int supportRemain;
    }

}
