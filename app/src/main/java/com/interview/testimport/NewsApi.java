package com.interview.testimport;

import io.reactivex.Single;
import retrofit2.http.GET;

public interface NewsApi {

    @GET("/v2/homerun/newsfeed")
    Single<NewsResponse> getNews();
}
