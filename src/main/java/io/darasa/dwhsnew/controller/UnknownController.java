package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.service.UnknownService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("unknown")
@Tag(name = "Unknown Controller")
public class UnknownController {

    private final UnknownService unknownService;

    @GetMapping("/count")
    @Operation(summary = "Get count of unknowns")
    public long getUnknownCount() {
        return unknownService.getCount();
    }

}
