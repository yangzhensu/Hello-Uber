package com.interview.testimport;

import com.squareup.moshi.Json;

import java.util.List;

public class NewsResponse {

    public final Item items;

    public NewsResponse(Item items) {
        this.items = items;
    }

    public static class Item {
        @Json(name = "result")
        public final List<NewsModel> news;

        public Item(List<NewsModel> news) {
            this.news = news;
        }
    }
}
