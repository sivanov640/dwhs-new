package io.darasa.dwhsnew.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse {
    @Builder.Default
    private List<Map<String, Object>> records = new ArrayList<>();
    @Builder.Default
    private boolean hasNext = false;
    @Builder.Default
    private int size = 0;

}
