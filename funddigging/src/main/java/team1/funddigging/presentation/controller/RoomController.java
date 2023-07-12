package team1.funddigging.presentation.controller;


import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.dto.RoomDto;
import team1.funddigging.application.service.FundingService;
import team1.funddigging.application.service.RoomService;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Funding_amount;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeFundingInfoRequest;
import team1.funddigging.presentation.request.AddRoomRequest;
import team1.funddigging.presentation.response.FundingInfoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team1.funddigging.presentation.response.Funding_amountInfoResponse;

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
}
