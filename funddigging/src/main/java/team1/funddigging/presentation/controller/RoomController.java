package team1.funddigging.presentation.controller;


import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.dto.RoomDto;
import team1.funddigging.application.service.FundingService;
import team1.funddigging.application.service.RoomService;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Funding_amount;
import team1.funddigging.domain.entity.Room;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeFundingInfoRequest;
import team1.funddigging.presentation.request.AddRoomRequest;
import team1.funddigging.presentation.response.FundingInfoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team1.funddigging.presentation.response.Funding_amountInfoResponse;
import team1.funddigging.presentation.response.RoomInfoResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class RoomController {
    @Autowired
    private final RoomService roomService;

    @PostMapping("/room/{user_id}/{category_id}")
    public ResponseEntity<Long> save(@RequestBody AddRoomRequest request, @PathVariable Long user_id, @PathVariable Long category_id) {
        Long savedId = roomService.addRoom(RoomDto.toAdd(request), user_id, category_id);
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/room/{room_id}")
    public ResponseEntity<RoomInfoResponse> getOneFunding(@PathVariable Long room_id) {

        Room room = roomService.getOneRoom(room_id);
        return ResponseEntity.ok(RoomInfoResponse.fromOneRoom(room));
    }

    @GetMapping("/room/room-list")
    public ResponseEntity<List<RoomInfoResponse>> getAllRoomList() {
        List<RoomDto> roomDtoList = roomService.getAllRoomList();
        List<RoomInfoResponse> response = roomDtoList.stream()
                .map(RoomInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
