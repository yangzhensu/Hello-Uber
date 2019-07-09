package com.interview.testimport;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;

public class NewsViewModel extends ViewModel {

    private static final String TAG = NewsViewModel.class.getSimpleName();

    public final MutableLiveData<List<NewsModel>> newsLiveData = new MutableLiveData<>();
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final NewsRepository newsRepository = NewsRepository.getInstance();

    public void getNews() {
        compositeDisposable.add(
                newsRepository.getNews()
                        .subscribeOn(Schedulers.io())
                        .subscribe(response -> {
                            if (response != null && response.items != null && response.items.news != null) {
                                newsLiveData.postValue(response.items.news);
                            }
                        }, throwable -> {
                            Log.e(TAG, "getNews: ", throwable);
                        })
        );

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.clear();
    }
}
