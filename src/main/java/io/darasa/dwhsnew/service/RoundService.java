package io.darasa.dwhsnew.service;

import io.darasa.dwhsnew.dto.request.CreateRoundDto;
import io.darasa.dwhsnew.dto.response.PageResponse;
import io.darasa.dwhsnew.dto.response.RoundDto;
import io.darasa.dwhsnew.entity.Round;
import io.darasa.dwhsnew.mapper.RoundMapper;
import io.darasa.dwhsnew.repository.RoundRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.cassandra.core.query.CassandraPageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class RoundService {

    private final RoundRepository roundRepository;

    private final RoundMapper roundMapper;

    public String create(CreateRoundDto dto) {
        return create(roundMapper.toEntity(dto));
    }

    public String create(Round round) {
        try {
            roundRepository.save(round);
            if (roundRepository.existsById(round.getId())) {
                return "Round " + round.getId() + " created successfully";
            } else {
                return "Error saving round to Cassandra!";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "Error saving round to Cassandra!";
        }
    }

    public String delete(UUID id) {
        if (id == null) {
            return "Round id is null";
        }
        try {
            roundRepository.deleteById(id);
            if (roundRepository.existsById(id)) {
                return "Error deleting round from Cassandra!";
            } else {
                return "Round " + id + " deleted from Cassandra";
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return "Error deleting round from Cassandra!";
        }
    }

    public PageResponse<RoundDto> getAll(int page, int size) {
        Slice<Round> slice = roundRepository.findAll(CassandraPageRequest.first(size));
        int currentPage = 0;
        while (slice.hasNext() && currentPage < page) {
            slice = roundRepository.findAll(slice.nextPageable());
            currentPage++;
        }
        Slice<RoundDto> all = slice.map(roundMapper::toDto);
        return PageResponse.<RoundDto>builder()
                .records(all.getContent())
                .hasNext(all.hasNext())
                .size(all.getSize())
                .build();
    }
}




















