package io.darasa.dwhsnew.controller;

import io.darasa.dwhsnew.service.DroppedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("dropped")
@Tag(name = "Dropped Controller")
public class DroppedController {

    private final DroppedService droppedService;

    @GetMapping("/count")
    @Operation(summary = "Get count of dropped")
    public long getDroppedCount() {
        return droppedService.getCount();
    }

}
