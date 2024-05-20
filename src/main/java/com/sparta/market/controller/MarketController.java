package com.sparta.market.controller;

import com.sparta.market.dto.MarketRequestDto;
import com.sparta.market.dto.MarketResponseDto;
import com.sparta.market.service.MarketService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MarketController {

    private final MarketService marketService;

    public MarketController(MarketService marketService) {
        this.marketService = marketService;
    }

    @PostMapping("/post")
    public MarketResponseDto createItem(@RequestBody MarketRequestDto requestDto) {
        return marketService.createItem(requestDto);
    }

    @GetMapping("/post")
    public List<MarketResponseDto> getItems() {
        return marketService.getItems();
    }

    @PutMapping("/post/{id}")
    public Long updateItem(@PathVariable Long id, @RequestBody MarketRequestDto requestDto) {
        return marketService.updateItem(id, requestDto);
    }

    @DeleteMapping("/post/{id}")
    public Long deleteItem(@PathVariable Long id) {
        return marketService.deleteItem(id);
    }

}
