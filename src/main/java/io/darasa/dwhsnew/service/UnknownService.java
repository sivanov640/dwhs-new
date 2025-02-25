package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.UnknownDto;
import io.darasa.dwhsnew.entity.Unknown;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UnknownService extends BaseService<Unknown, String, UnknownDto> {

    public UnknownService() {
        super(Type.UNKNOWN);
    }

    public long getCount() {
        return cassandraTemplate.count(Unknown.class);
    }
}