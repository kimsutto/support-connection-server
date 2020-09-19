package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sp.supportconnection.dto.SupportDetailResponse;
import sp.supportconnection.dto.SupportResponse;
import sp.supportconnection.entity.Support;
import sp.supportconnection.entity.User;
import sp.supportconnection.entity.SupportDetail;
import sp.supportconnection.repository.SupportRepository;
import sp.supportconnection.repository.UserRepository;
import sp.supportconnection.repository.SupportDetailRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupportService {
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;
    private final SupportDetailRepository supportDetailRepository;


    public List<SupportResponse> getSupports(Long id){
        Optional<User> user = userRepository.findById(id);
        List<Support> supports= user.get().getSupports();
        // Stream 변경
        List<SupportResponse> results = new ArrayList<>();
        for(Support support : supports){
            SupportResponse response = new SupportResponse();
            response.setSupportId(support.getId());
            response.setName(support.getName());
            response.setCategory(support.getCategory());
            response.setSite(support.getSite());
            response.setIsLocal(support.getIsLocal());
            response.setType(support.getType());
            response.setAmount(support.getAmount());
            results.add(response);
        }

        return results;
    }

    public SupportDetailResponse getSupport(Long id){
        Optional<Support> support = supportRepository.findSupportBySupportDetailId(id);
        Optional<SupportDetail> supportDetail = supportDetailRepository.findById(id);

        SupportDetailResponse result = new SupportDetailResponse();
        result.setSupportId(support.get().getId());
        result.setName(support.get().getName());
        result.setCategory(support.get().getCategory());
        result.setSite(support.get().getSite());
        result.setIsLocal(support.get().getIsLocal());
        result.setType(support.get().getType());
        result.setAmount(support.get().getAmount());
        result.setQualification(supportDetail.get().getQualification());
        result.setInfo(supportDetail.get().getInfo());
        result.setApplyInfo(supportDetail.get().getApplyInfo());
        result.setRequiredDocuments(supportDetail.get().getRequiredDocuments());
        result.setDeadline(supportDetail.get().getDeadline());
        result.setUrl(supportDetail.get().getUrl());
        result.setContact(supportDetail.get().getContact());

        return result;
    }

}
