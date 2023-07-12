package team1.funddigging.presentation.controller;

import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.service.FundingService;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.domain.entity.Funding_amount;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeFundingInfoRequest;
import team1.funddigging.presentation.response.FundingInfoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import team1.funddigging.presentation.response.Funding_amountInfoResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/funding")
@RequiredArgsConstructor
public class FundingController {

    @Autowired
    private final FundingService fundingService;

    @PostMapping("/{room_id}/{user_id}")
    public ResponseEntity<Long> save(@RequestBody AddFundingRequest request, @PathVariable Long room_id, @PathVariable Long user_id) {
        Long savedId = fundingService.addFunding(FundingDto.toAdd(request), room_id, user_id);
        return ResponseEntity.ok(savedId);
    }

    @GetMapping("/{funding_id}")
    public ResponseEntity<FundingInfoResponse> getOneFunding(@PathVariable Long funding_id) {

        Funding funding = fundingService.getOneFunding(funding_id);
        return ResponseEntity.ok(FundingInfoResponse.fromOneFunding(funding));
    }



    @GetMapping("/funding-list/{room_id}")
    public ResponseEntity<List<FundingInfoResponse>> getAllFundingInRoomList(@PathVariable Long room_id) {
        List<FundingDto> roomDtoList = fundingService.getAllFundingInRoomList(room_id);
        List<FundingInfoResponse> response = roomDtoList.stream()
                .map(FundingInfoResponse::from)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }

    @GetMapping("amount/{funding_id}")
    public ResponseEntity<Funding_amountInfoResponse> getOneFunding_amount(@PathVariable Long funding_id) {

        Funding_amount funding_amount = fundingService.getOneFunding_amount(funding_id);
        return ResponseEntity.ok(Funding_amountInfoResponse.fromOneFunding_amount(funding_amount));
    }

}
