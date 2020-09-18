package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sp.supportconnection.entity.Condition;
import sp.supportconnection.entity.Support;
import sp.supportconnection.entity.User;
import sp.supportconnection.repository.SupportRepository;
import sp.supportconnection.repository.UserRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SupportService {
    private final SupportRepository supportRepository;
    private final UserRepository userRepository;

    /*
    public List<SupportResponse> getSupports(Long id){
        List<Support> supports = supportRepository.findAll();
        Optional<User> user = userRepository.findById(id);
        Condition condition = user.get().getCondition();

        List<SupportResponse> results = supports.stream().map(
                support -> {
                    SupportResponse supportResponse = new SupportResponse();
                    if(support.getCondition()==condition) {
                        supportResponse.setId(support.getId());
                    }
                    return supportResponse;
                }).collect(Collectors.toList());
        return results;
    }*/

    public void getSupports(Long id){
        Optional<User> user = userRepository.findById(id);
        List<Support> supports = user.get().getSupports();
        //map

    }


}
