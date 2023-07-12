package team1.funddigging.presentation.controller;

import team1.funddigging.application.dto.BackerDto;
import team1.funddigging.application.dto.FundingDto;
import team1.funddigging.application.service.BackerService;
import team1.funddigging.application.service.FundingService;
import team1.funddigging.domain.entity.Funding;
import team1.funddigging.presentation.request.AddBackerRequest;
import team1.funddigging.presentation.request.AddFundingRequest;
//import team1.funddigging.presentation.request.ChangeFundingInfoRequest;
import team1.funddigging.presentation.response.FundingInfoResponse;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/backer")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000")
public class BackerController {

    @Autowired
    private final BackerService backerService;

    @PostMapping("/{user_id}/{funding_id}")
    public ResponseEntity<Long> save(@RequestBody AddBackerRequest request, @PathVariable Long funding_id, @PathVariable Long user_id) {
        Long savedId = backerService.addBacker(BackerDto.toAdd(request), funding_id, user_id);
        return ResponseEntity.ok(savedId);
    }
}
