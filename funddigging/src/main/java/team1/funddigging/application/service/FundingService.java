package team1.funddigging.application.service;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.domain.entity.*;
import team1.funddigging.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDateTime;
import java.util.*;
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
        Member user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("no such user"));


        Funding newFunding = fundingRepository.save(Funding.toFunding(dto, room, user));
        return newFunding.getFunding_id();
    }



    @Transactional
    public Funding getOneFunding(Long funding_id){

        Funding funding = fundingRepository.findById(funding_id).orElseThrow(() -> new IllegalArgumentException("no such funding"));
        return funding;

    }



    @Transactional
    public List<FundingDto> getAllFundingInRoomList(Long room_id){
        List<Funding> fundingList = fundingRepository.findAll();
        List<Funding> fundingListInRoom = new ArrayList<>();

        for(Funding f : fundingList){
            if(f.getRoom_id().getRoom_id() == room_id){
                fundingListInRoom.add(f);
            }
        }

        return fundingListInRoom.stream().map(FundingDto::from).collect(Collectors.toList());
    }



}
