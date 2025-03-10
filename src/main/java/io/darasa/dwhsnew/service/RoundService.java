package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.response.PageResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoundService extends BaseService {

    public RoundService() {
        super(Type.ROUND);
    }

    public PageResponse getAll(int page, int size, String id, String gameId, String startTime, String endTime) {
        List<Criteria> criteriaList = new ArrayList<>();
        if (id != null) {
            criteriaList.add(Criteria.where(ColumnName.Round.ROUND_ID).is(id));
        }
        if (gameId != null) {
            criteriaList.add(Criteria.where(ColumnName.Round.GAME_ID).is(gameId));
        }
        if (startTime != null) {
            addCriteriaDefinitionsForDateTime(ColumnName.Round.START_TIME, startTime, criteriaList);
        }
        if (endTime != null) {
            addCriteriaDefinitionsForDateTime(ColumnName.Round.END_TIME, endTime, criteriaList);
        }

        return getAll(page, size, criteriaList);
    }

}