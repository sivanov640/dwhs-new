package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.entity.Dropped;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class DroppedService {

    private final ElasticsearchTemplate elasticsearchTemplate;

    public long getCount() {
        return elasticsearchTemplate.count(Query.findAll(), Dropped.class);
    }

    public void save(String data, String type) {
        elasticsearchTemplate.save(Dropped.builder()
                .data(data)
                .type(type)
                .build());
    }
}