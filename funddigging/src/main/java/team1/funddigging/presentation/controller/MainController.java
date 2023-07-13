package team1.funddigging.presentation.controller;


import team1.funddigging.application.dto.CategoryDto;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.dto.RoomDto;
import team1.funddigging.application.service.MainService;
//import team1.funddigging.presentation.request.ChangeFundingInfoRequest;
import team1.funddigging.presentation.response.CategoryInfoResponse;
import team1.funddigging.presentation.response.FundingInfoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team1.funddigging.presentation.response.RoomInfoResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class MainController {

    @Autowired
    private final MainService mainService;

    @GetMapping("/funding-allList")
    public ResponseEntity<List<FundingInfoResponse>> getAllFundingList() {
        List<FundingDto> roomDtoList = mainService.getAllFundingList();
        List<FundingInfoResponse> response = roomDtoList.stream()
                .map(FundingInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/category-list")
    public ResponseEntity<List<CategoryInfoResponse>> getCategoryList() {
        List<CategoryDto> categoryDtoList = mainService.getCategoryList();
        List<CategoryInfoResponse> response = categoryDtoList.stream()
                .map(CategoryInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("/room-top4")
    public ResponseEntity<List<RoomInfoResponse>> getTop4RoomList() {
        List<RoomDto> roomDtoList = mainService.getTop4RoomList();
        List<RoomInfoResponse> response = roomDtoList.stream()
                .map(RoomInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }




}
