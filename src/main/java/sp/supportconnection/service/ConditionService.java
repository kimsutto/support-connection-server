package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sp.supportconnection.dto.ConditionRequest;
import sp.supportconnection.entity.Condition;
import sp.supportconnection.entity.Support;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.ConditionRepository;
import sp.supportconnection.repository.SupportRepository;
import sp.supportconnection.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConditionService {
    private final ConditionRepository conditionRepository;
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;

    @Transactional
    public void updateCondition(ConditionRequest request) {
        Long id = request.getUserId();
        User user = userRepository.findById(id).get();
        Long conditionId = user.getCondition().getId();

        Optional<Condition> condition = conditionRepository.findById(conditionId);

        condition.get().setProvince(request.getProvince());
        condition.get().setDistrict(request.getDistrict());
        condition.get().setIncomeGroup(request.getIncomeGroup());
        condition.get().setAnnualIncome(request.getAnnualIncome());
        condition.get().setIsMarried(request.getIsMarried());
        condition.get().setHaveChild(request.getHaveChild());
        condition.get().setChildAge(request.getChildAge());
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
        supports.stream().filter(support -> support.getCondition().equals(condition));
        for(Support support : supports){
            user.getSupports().add(support);
        }

        userRepository.save(user);
        return;
    }

}