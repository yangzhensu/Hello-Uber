package com.interview.testimport;

import io.reactivex.Single;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.moshi.MoshiConverterFactory;

public class NewsRepository {

    private static NewsRepository sInstance;
    private static final String BASE_URL = "https://mobile-homerun-yql.media.yahoo.com";

    public static NewsRepository getInstance() {
        if (sInstance == null) {
            synchronized (NewsRepository.class) {
                if (sInstance == null) {
                    sInstance = new NewsRepository();
                }
            }
        }
        return sInstance;
    }

    private NewsRepository() {

    }

    private OkHttpClient buildHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        // set your desired log level
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        // add your other interceptors …

        // add logging as last interceptor
        httpClient.addInterceptor(logging);  // <-- this is the important line!
        return httpClient.build();
    }

    private Retrofit buildRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(MoshiConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(buildHttpClient())
                .build();
    }

    public Single<NewsResponse> getNews() {
        return buildRetrofit()
                .create(NewsApi.class)
                .getNews();
    }

}
