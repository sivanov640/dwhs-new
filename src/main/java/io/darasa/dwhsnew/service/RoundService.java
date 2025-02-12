package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.constants.Type;
import io.darasa.dwhsnew.dto.request.RoundDto;
import io.darasa.dwhsnew.entity.Round;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class RoundService extends BaseService<Round, String, RoundDto> {

    public RoundService() {
        super(Type.ROUND);
    }
}