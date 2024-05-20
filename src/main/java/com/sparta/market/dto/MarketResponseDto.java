package com.sparta.market.dto;

import com.sparta.market.entity.MarketEntity;
import lombok.Data;

@Data
public class MarketResponseDto {
    private long id;
    private String title;
    private String content;
    private int price;
    private String username;

    public MarketResponseDto(MarketEntity marketEntity) {
        this.id = marketEntity.getId();
        this.title = marketEntity.getTitle();
        this.username = marketEntity.getUsername();
        this.content = marketEntity.getContent();
        this.price = marketEntity.getPrice();
    }
}
