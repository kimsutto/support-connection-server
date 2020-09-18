package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sp.supportconnection.dto.ConditionRequest;
import sp.supportconnection.entity.AvailableSupport;
import sp.supportconnection.entity.Condition;
import sp.supportconnection.entity.Support;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.AvailableSupportRepository;
import sp.supportconnection.repository.ConditionRepository;
import sp.supportconnection.repository.SupportRepository;
import sp.supportconnection.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConditionService {
    private final ConditionRepository conditionRepository;
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;
    private final AvailableSupportRepository availableSupportRepository;

    @Transactional
    public void updateCondition(ConditionRequest request) {
        Long id = request.getUserId();
        User user = userRepository.findById(id).get();
        Long conditionId = user.getCondition().getId();
        Long availableId = user.getAvailableSupport().getId();

        Optional<Condition> condition = conditionRepository.findById(conditionId);

        condition.get().setProvince(request.getProvince());
        condition.get().setDistrict(request.getDistrict());
        condition.get().setIncomeGroup(request.getIncomeGroup());
        condition.get().setAnnualIncome(request.getAnnualIncome());
        condition.get().setIsMarried(request.getIsMarried());
        condition.get().setHaveChild(request.getHaveChild());
        condition.get().setMinChildAge(request.getMinChildAge());
        condition.get().setMaxChildAge(request.getMaxChildAge());
        condition.get().setIsPregnant(request.getIsPregnant());
        condition.get().setOccupation(request.getOccupation());
        condition.get().setIsTemporary(request.getIsTemporary());
        condition.get().setIsUnemployed(request.getIsUnemployed());
        condition.get().setBusinessType(request.getBusinessType());
        condition.get().setBusinessScale(request.getBusinessScale());
        condition.get().setAnnualSale(request.getAnnualSale());

        user.setCondition(condition.get());

        conditionRepository.save(condition.get()); // update로 바꾸기


        //usersupport delete
        user.getSupports().clear();
        userRepository.save(user);


        //연관 관계 설정 update하기 -> user-support table도 같이 업데이트
        List<Support> supports = supportRepository.findAll();
        supports.stream().filter(support -> matching(support.getCondition(),condition.get()));


        //나중에 .. 함수 분리 하겠슴다..

        int totalAmount = 0;
        int cashAmount = 0;
        int financialAmount = 0;

        for(Support support : supports){
            user.getSupports().add(support);
            totalAmount += support.getAmount();
            if(support.getType().equals("현금")){
                cashAmount += support.getAmount();
            }else{
                financialAmount += support.getAmount();
            }
        }
        Optional<AvailableSupport> availableSupport = availableSupportRepository.findById(availableId);
        availableSupport.get().setTotalAmount(totalAmount);
        availableSupport.get().setCashAmount(cashAmount);
        availableSupport.get().setFinancialAmount(financialAmount);

        user.setAvailableSupport(availableSupport.get());

        availableSupportRepository.save(availableSupport.get());
        userRepository.save(user);

        return;
    }

    boolean matching(Condition a, Condition b){
        return true;
    }



}