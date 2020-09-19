package sp.supportconnection.service;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sp.supportconnection.entity.Asset;
import sp.supportconnection.entity.AvailableSupport;
import sp.supportconnection.entity.Condition;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.AssetRepository;
import sp.supportconnection.repository.AvailableSupportRepository;
import sp.supportconnection.repository.ConditionRepository;
import sp.supportconnection.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {
    private final UserRepository userRepository;
    private final AssetRepository assetRepository;
    private final AvailableSupportRepository availableSupportRepository;
    private final ConditionRepository conditionRepository;

    @Transactional
    public Long join(User user){
        Optional<User> findUser = userRepository.findByPhoneNumber(user.getPhoneNumber());
        if(findUser.isPresent()){
            return findUser.get().getId();
        }else {
            userRepository.save(user);
            Optional<User> findUser2 = userRepository.findByPhoneNumber(user.getPhoneNumber());
            Long userId = findUser2.get().getId();

            Asset asset = new Asset(0,0,0,0,0.0f,3);
            assetRepository.save(asset);

            AvailableSupport availableSupport = new AvailableSupport(0,0,0);
            availableSupportRepository.save(availableSupport);

            Condition condition = new Condition();
            conditionRepository.save(condition);

            user.setAsset(asset);
            user.setAvailableSupport(availableSupport);
            user.setCondition(condition);
            userRepository.save(user);

            return userId;

        }
    }

    public UserInfoResponse getMyinfo(Long id){
        Optional<User> user = userRepository.findById(id);
        UserInfoResponse userInfoResponse = new UserInfoResponse();
        if(user.isPresent()){
            userInfoResponse.setName(user.get().getName());
            userInfoResponse.setTotalAmount(user.get().getAvailableSupport().getTotalAmount());
            userInfoResponse.setCashAmount(user.get().getAvailableSupport().getCashAmount());
            userInfoResponse.setFinancialAmount(user.get().getAvailableSupport().getFinancialAmount());
            userInfoResponse.setMyAsset(user.get().getAsset().getMyAsset());
            userInfoResponse.setSupportRemain(user.get().getAsset().getSupportRemain());
            userInfoResponse.setAnnualIncome(user.get().getAsset().getAnnualIncome());
            userInfoResponse.setLoan(user.get().getAsset().getLoan());
            userInfoResponse.setInterestRate(user.get().getAsset().getInterestRate());
            userInfoResponse.setCreditRate(user.get().getAsset().getCreditRate());
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
        private int annualIncome;
        private int loan;
        private float interestRate;
        private int creditRate;
    }

    public Asset getAsset(Long userId){
        Optional<User> user = userRepository.findById(userId);
        Asset asset = user.get().getAsset();
        return asset;
    }

}
