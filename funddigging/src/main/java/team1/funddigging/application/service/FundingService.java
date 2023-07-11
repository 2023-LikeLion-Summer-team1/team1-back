package team1.funddigging.application.service;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundingService {

    private final FundingRepository fundingRepository;

    @Transactional
    public Long addFunding(FundingDto dto){
        Funding newFunding = fundingRepository.save(Funding.toFunding(dto));
        return newFunding.getFunding_id();
    }

    @Transactional
    public Funding getOneFunding(Long funding_id){

        Funding funding = fundingRepository.findById(funding_id).orElseThrow(() -> new IllegalArgumentException("no such funding"));
        return funding;
    }

    @Transactional
    public List<FundingDto> getAllFundingList(){
        List<Funding> roomList = fundingRepository.findAll();
        return roomList.stream().map(FundingDto::from).collect(Collectors.toList());
    }


}
