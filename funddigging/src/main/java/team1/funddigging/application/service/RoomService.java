package team1.funddigging.application.service;


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
    private final CategoryRepository categoryRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Transactional
    public Long addRoom(RoomDto dto, Long user_id, Long category_id){


        Category category = categoryRepository.findById(category_id).orElseThrow(() -> new IllegalArgumentException("no such Category"));
        //Room room = roomRepository.findById(room_id).orElseThrow(() -> new IllegalArgumentException("no such room"));
        Member user = userRepository.findById(user_id).orElseThrow(() -> new IllegalArgumentException("no such user"));


        Room newRoom = roomRepository.save(Room.toRoom(dto, user, category));
        return newRoom.getRoom_id();
    }

    @Transactional
    public Room getOneRoom(Long room_id){

        Room room = roomRepository.findById(room_id).orElseThrow(() -> new IllegalArgumentException("no such room"));
        List<Funding> fundingList = fundingRepository.findAll();
        List<Funding> fundingListInRoom = new ArrayList<>();

        for(Funding f : fundingList){
            if(f.getRoom_id().getRoom_id() == room_id){
                fundingListInRoom.add(f);
                System.out.println(f.getRoom_id());
            }
        }

        room.setFundingList(fundingListInRoom);
        return room;
    }

    @Transactional
    public List<RoomDto> getAllRoomList(){
        List<Room> fundingList = roomRepository.findAll();

        return fundingList.stream().map(RoomDto::from).collect(Collectors.toList());
    }

}
