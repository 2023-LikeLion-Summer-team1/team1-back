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

        return newBacker.getBacker_id();
    }

}
