package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sp.supportconnection.dto.SupportResponse;
import sp.supportconnection.entity.Support;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.SupportRepository;
import sp.supportconnection.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupportService {
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;


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


}
