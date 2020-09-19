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

import java.util.ArrayList;
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
        condition.get().setMinAge(request.getMinAge());
        condition.get().setMaxAge(request.getMaxAge());
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
        List<Support> matchingSupports = new ArrayList<>();
        for(Support support : supports){
            if(matching(support.getCondition(),condition.get())){
                matchingSupports.add(support);
            }
        }

        //supports.stream().filter(support -> matching(support.getCondition(),condition.get()));


        //나중에 .. 함수 분리 하겠슴다..

        int totalAmount = 0;
        int cashAmount = 0;
        int financialAmount = 0;

        for(Support support : matchingSupports){
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

        if(a.getMaxAge()<b.getMaxAge())
            return false;

        if(a.getIncomeGroup()>0 && b.getIncomeGroup()==0)
            return false;

        if(a.getAnnualIncome()>0 && b.getAnnualIncome()>a.getAnnualIncome())
            return false;

        if(a.getIsMarried()!=b.getIsMarried())
            return false;

        if(a.getIsPregnant()!=b.getIsPregnant())
            return false;

        if(a.getHaveChild()==1){
            if(b.getHaveChild()==0 || b.getMaxChildAge()>a.getMaxChildAge())
                return false;
        }

        if(!a.getProvince().isEmpty()){
            if(!a.getProvince().equals(b.getProvince())){
                return false;
            }else{
                if(!a.getDistrict().isEmpty() && !a.getDistrict().equals(b.getDistrict()))
                    return false;
            }
        }
        if(a.getOccupation()<4){
            if(a.getOccupation()==0){
                if(b.getOccupation()!=0)
                    return false;
            }
            if(a.getOccupation()==1){
                if(a.getIsTemporary()!=b.getIsTemporary() || b.getOccupation()!=1)
                    return false;
            }else if(a.getOccupation()==2){
                if(a.getIsUnemployed()!=b.getIsUnemployed() || b.getOccupation()!=2)
                    return false;
            }else if(a.getOccupation()==3){
                if(b.getOccupation()!=3)
                    return false;
                if(a.getBusinessType()!=null && !a.getBusinessType().isEmpty() ){
                    if(!a.getBusinessType().equals(b.getBusinessType()))
                        return false;
                }
                if(a.getBusinessScale()!=4 && a.getBusinessScale()!=b.getBusinessScale())
                    return false;
                if(a.getAnnualSale()!=0 && a.getAnnualSale() < b.getAnnualSale())
                    return false;
            }
        }

        return true;
    }


}