package com.realTime.Insight;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlphaVantageService {

    private final String API_KEY = "XKDGJDIDC1AN6H4Q"; // 여기에 Alpha Vantage API 키를 입력하세요
    private final String BASE_URL = "https://www.alphavantage.co/query";

    public String getStockData(String symbol) {
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "?function=TIME_SERIES_INTRADAY&symbol=" + symbol + "&interval=1min&apikey=" + API_KEY;
        return restTemplate.getForObject(url, String.class);
    }
}
