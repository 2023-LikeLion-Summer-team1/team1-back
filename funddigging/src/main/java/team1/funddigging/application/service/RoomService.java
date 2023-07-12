package team1.funddigging.application.service;


import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.dto.Funding_amountDto;
import team1.funddigging.application.dto.RoomDto;
import team1.funddigging.domain.entity.*;
import team1.funddigging.domain.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoomService {

    private final FundingRepository fundingRepository;
    private final Funding_amountRepository funding_amountRepository;
    private final CategoryRepository categoryRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addRoom(RoomDto dto, Long user_id, Long category_id){


        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new IllegalArgumentException("no such Category"));
        //Room room = roomRepository.findById(room_id).orElseThrow(() -> new IllegalArgumentException("no such room"));
        User user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("no such user"));


        Room newRoom = roomRepository.save(Room.toRoom(dto, user, category));
        return newRoom.getRoom_id();
    }

}
