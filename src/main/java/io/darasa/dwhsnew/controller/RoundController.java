package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.service.RoundService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("round")
@Tag(name = "Round Controller")
public class RoundController {

    private final RoundService roundService;

    @GetMapping
    @Operation(summary = "Get all rounds")
    public PageResponse<RoundDto> getRounds(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        return roundService.getAll(page, size);
    }

    @PostMapping
    @Operation(summary = "Save round")
    public String saveRound(@RequestBody RoundDto dto) {
        return roundService.save(dto);
    }

}
