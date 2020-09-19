package sp.supportconnection.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import sp.supportconnection.repository.AssetRepository;
import sp.supportconnection.entity.Asset;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class MeService {
    private final AssetRepository assetRepository;

    public Asset updateMyAsset(Asset assetToUpdate, int newMyAsset, int newAnnualIncome) {
        assetToUpdate.setMyAsset(newMyAsset);
        assetToUpdate.setAnnualIncome(newAnnualIncome);

        Asset newAsset = assetRepository.save(assetToUpdate);
        return newAsset;
    }

    public Asset updateMyLoan(Asset assetToUpdate, int newLoan, int newInterestRate){
        assetToUpdate.setLoan(newLoan);
        assetToUpdate.setInterestRate(newInterestRate);

        Asset newAsset = assetRepository.save(assetToUpdate);
        return newAsset;
    }

    public Asset updateMySupportRemain(Asset assetToUpdate, int newSupportRemain, Date newSupportDeadline){
        assetToUpdate.setSupportRemain(newSupportRemain);
        assetToUpdate.setSupportDeadline(newSupportDeadline);

        Asset newAsset = assetRepository.save(assetToUpdate);
        return newAsset;
    }
}
