package team1.funddigging.application.service;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.Category;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.domain.entity.User;
import team1.funddigging.domain.repository.CategoryRepository;
import team1.funddigging.domain.repository.FundingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import team1.funddigging.domain.repository.RoomRepository;
import team1.funddigging.domain.repository.UserRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FundingService {

    private final FundingRepository fundingRepository;
    private final CategoryRepository categoryRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addFunding(FundingDto dto, Long room_id, Long user_id){


        //Category category = categoryRepository.findById(dto.getCategory_id()).orElseThrow(() -> new IllegalArgumentException("no such Category"));
        Room room = roomRepository.findById(room_id).orElseThrow(() -> new IllegalArgumentException("no such room"));
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("no such user"));

        Funding newFunding = fundingRepository.save(Funding.toFunding(dto, room, user));
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
