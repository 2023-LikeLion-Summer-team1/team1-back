package team1.funddigging.application.service;


import team1.funddigging.application.dto.CategoryDto;
import team1.funddigging.application.dto.FundingDto;
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
public class MainService {

    private final FundingRepository fundingRepository;
    private final CategoryRepository categoryRepository;
    private final RoomRepository roomRepository;
    private final UserRepository userRepository;

    @Transactional
    public List<FundingDto> getAllFundingList(){
        List<Funding> fundingList = fundingRepository.findAll();

        return fundingList.stream().map(FundingDto::from).collect(Collectors.toList());
    }

    @Transactional
    public List<CategoryDto> getCategoryList(){
        List<Category> categoryList = categoryRepository.findAll();

        return categoryList.stream().map(CategoryDto::from).collect(Collectors.toList());
    }

    @Transactional
    public List<RoomDto> getTop4RoomList(){
        List<Room> roomAllList = roomRepository.findAll();
        List<Room> roomTop4List = new ArrayList<>();


        // follower 값에 기반하여 roomAllList를 내림차순으로 정렬합니다.
        Collections.sort(roomAllList, Comparator.comparing(Room::getFollower).reversed());

        // roomAllList에서 상위 4개의 방을 가져와서 roomTop4List에 추가합니다.
        for (int i = 0; i < Math.min(4, roomAllList.size()); i++) {
            roomTop4List.add(roomAllList.get(i));
        }

        return roomTop4List.stream().map(RoomDto::from).collect(Collectors.toList());
    }
}
