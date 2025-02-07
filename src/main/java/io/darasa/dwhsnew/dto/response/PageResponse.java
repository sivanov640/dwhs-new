package io.darasa.dwhsnew.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PageResponse<T> {
    @Builder.Default
    private List<T> records = new ArrayList<>();
    @Builder.Default
    private boolean hasNext = false;
    @Builder.Default
    private int size = 0;

}
