package com.interview.testimport;

import com.squareup.moshi.Json;

public class NewsModel {

    public final String uuid;
    public final String title;
    @Json(name = "published_at")
    public final long publishedAt;
    public final String summary;
    public final String link;
    @Json(name = "main_image")
    public final MainImage mainImage;

    public NewsModel(String uuid, String title, long publishedAt, String summary, String link, MainImage mainImage) {
        this.uuid = uuid;
        this.title = title;
        this.publishedAt = publishedAt;
        this.summary = summary;
        this.link = link;
        this.mainImage = mainImage;
    }

    public static class MainImage {
        @Json(name = "original_url")
        public final String url;

        public MainImage(String url) {
            this.url = url;
        }
    }
}
