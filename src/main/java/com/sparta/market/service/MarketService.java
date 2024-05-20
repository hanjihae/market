package com.sparta.market.service;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.entity.MarketEntity;
import com.sparta.market.repository.MarketRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarketService {

    private final MarketRepository marketRepository;

    public MarketService(MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketResponseDto createItem(MarketRequestDto requestDto) {
        MarketEntity marketEntity = new MarketEntity(requestDto);
        MarketEntity saveItem = marketRepository.save(marketEntity);
        MarketResponseDto responseDto = new MarketResponseDto(saveItem);
        return responseDto;
    }

    public List<MarketResponseDto> getItems() {
        return marketRepository.findAll().stream().map(MarketResponseDto::new).toList();
    }

    @Transactional
    public Long updateItem(Long id, MarketRequestDto requestDto) {
        MarketEntity marketEntity = getItemById(id);
        marketEntity.update(requestDto);
        return id;
    }

    public Long deleteItem(Long id) {
        MarketEntity marketEntity = getItemById(id);
        marketRepository.delete(marketEntity);
        return id;
    }

    private MarketEntity getItemById(Long id) {
        return marketRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("선택한 게시글이 없습니다!")
        );
    }
}
