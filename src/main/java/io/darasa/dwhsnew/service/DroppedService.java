package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.DroppedDto;
import io.darasa.dwhsnew.entity.Dropped;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DroppedService extends BaseService<Dropped, DroppedDto> {

    public DroppedService() {
        super(Type.DROPPED);
    }

    public long getCount() {
        return elasticsearchTemplate.count(Query.findAll(), Dropped.class);
    }
}