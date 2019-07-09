package com.interview.testimport;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsListFragment extends Fragment {

    private RecyclerView mNewsList;
    private NewsAdapter mNewsAdapter;
    private NewsViewModel mNewsViewModel;
    private Observer<List<NewsModel>> mNewsObserver;

    public NewsListFragment() {
        // Required empty public constructor
    }

    public static NewsListFragment newInstance() {
        return new NewsListFragment();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_news_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNewsList = view.findViewById(R.id.fragment_news_list);
        mNewsAdapter = new NewsAdapter();
        mNewsList.setLayoutManager(new LinearLayoutManager(view.getContext()));
        mNewsList.setAdapter(mNewsAdapter);

        mNewsObserver = newsList -> mNewsAdapter.updateNews(newsList);
        mNewsViewModel = ViewModelProviders.of(this).get(NewsViewModel.class);
        mNewsViewModel.newsLiveData.observe(this, mNewsObserver);
        mNewsViewModel.getNews();
    }

}
