package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.dto.request.CreateRoundDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.dto.response.RoundDto;
import io.darasa.dwhsnew.service.RoundService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("round")
public class RoundController {

    private final RoundService roundService;

    @GetMapping
    public PageResponse<RoundDto> getRounds(@RequestParam(defaultValue = "1") int page,
                                            @RequestParam(defaultValue = "10") int size) {
        return roundService.getAll(page, size);
    }

    @PostMapping
    public String createRound(@RequestBody CreateRoundDto dto) {
        return roundService.create(dto);
    }

    @DeleteMapping
    public String deleteRound(@RequestParam UUID id) {
        return roundService.delete(id);
    }

}
