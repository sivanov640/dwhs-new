package io.darasa.dwhsnew.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

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

    public PageResponse<T> mapRecords(Function<T, T> mapper) {
        this.records = this.records.stream()
                .map(mapper)
                .collect(Collectors.toList());
        return this;
    }

}
