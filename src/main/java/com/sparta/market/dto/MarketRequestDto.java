package com.sparta.market.dto;

import lombok.Data;

@Data
public class MarketRequestDto {
    private String title;
    private String content;
    private int price;
    private String username;
}
