package team1.funddigging.application.service;


import team1.funddigging.application.dto.BackerDto;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.*;
import team1.funddigging.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BackerService {

    private final FundingRepository fundingRepository;
    private final Funding_amountRepository funding_amountRepository;
    private final CategoryRepository categoryRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;
    private final BackerRepository backerRepository;

    @Transactional
    public Long addBacker(BackerDto dto, Long funding_id, Long user_id){


        //Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new IllegalArgumentException("no such Category"));
        Funding funding = fundingRepository.findById(funding_id).orElseThrow(() -> new IllegalArgumentException("no such funding_id"));
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("no such user"));

        Backer newBacker = backerRepository.save(Backer.toBacker(dto, funding, user));

        Funding_amount funding_amount = funding_amountRepository.findById(newBacker.getFunding_id().getFunding_id()).orElseThrow(() -> new IllegalArgumentException("no such room"));
        funding_amount.setBackers_count( funding_amount.getBackers_count()+1);
        funding_amount.setCurrent_amount(funding_amount.getCurrent_amount()+newBacker.getContribution_amount());

        Funding_amount updatedFunding_amount = funding_amountRepository.save(funding_amount);



        return newBacker.getBacker_id();
    }

}
