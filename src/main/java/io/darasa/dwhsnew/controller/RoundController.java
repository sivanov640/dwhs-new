package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.service.RoundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("round")
@Tag(name = "Round Controller")
public class RoundController {

    private final RoundService roundService;

    @GetMapping
    @Operation(summary = "Get rounds")
    public PageResponse<RoundDto> getRounds(@RequestParam(defaultValue = "1", required = false) int page,
                                            @RequestParam(defaultValue = "10", required = false) int size,
                                            @RequestParam(required = false, value = ColumnName.Round.ROUND_ID) String roundId,
                                            @Parameter(description = "Round start date and time in ISO format (yyyy-MM-ddTHH:mm:ss.SSS±TZ) or interval (yyyy-MM-ddTHH:mm:ss.SSS±TZ_yyyy-MM-ddTHH:mm:ss.SSS±TZ)")
                                            @RequestParam(required = false, value = ColumnName.Round.START_TIME) String startTime,
                                            @Parameter(description = "Round end date and time in ISO format (yyyy-MM-ddTHH:mm:ss.SSS±TZ) or interval (yyyy-MM-ddTHH:mm:ss.SSS±TZ_yyyy-MM-ddTHH:mm:ss.SSS±TZ)")
                                            @RequestParam(required = false, value = ColumnName.Round.END_TIME) String endTime) {
        return roundService.getAll(page, size, roundId, startTime, endTime);
    }

}
