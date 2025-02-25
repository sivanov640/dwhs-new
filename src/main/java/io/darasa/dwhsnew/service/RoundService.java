package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.ColumnName;
import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.entity.Round;
import io.darasa.dwhsnew.entity.RoundPrimaryKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.CriteriaDefinition;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class RoundService extends BaseService<Round, RoundPrimaryKey, RoundDto> {

    public RoundService() {
        super(Type.ROUND);
    }

    public PageResponse<RoundDto> getAll(int page, int size, String id, String startTime, String endTime) {
        List<CriteriaDefinition> criteriaDefinitions = new ArrayList<>();
        if (id != null) {
            criteriaDefinitions.add(Criteria.where(ColumnName.Round.ROUND_ID).is(id));
        }
        if (startTime != null) {
            addCriteriaDefinitionsForDateTime(ColumnName.Round.START_TIME, startTime, criteriaDefinitions);
        }
        if (endTime != null) {
            addCriteriaDefinitionsForDateTime(ColumnName.Round.END_TIME, endTime, criteriaDefinitions);
        }

        return getAll(page, size, criteriaDefinitions);
    }

}