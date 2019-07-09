package com.interview.testimport;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder> {

    private final List<NewsModel> mNewsList = new ArrayList<>();

    public void updateNews(List<NewsModel> newsList) {
        mNewsList.clear();
        mNewsList.addAll(newsList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_news, parent, false);
        return new NewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        holder.bind(mNewsList.get(position));
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }

    public static class NewsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        ImageView mainImage;
        TextView title;
        TextView time;

        public NewsViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.card_news_main_image);
            title = itemView.findViewById(R.id.card_news_title);
            time = itemView.findViewById(R.id.card_news_time);
        }

        public void bind(NewsModel item) {
            if (item.mainImage != null) {
                Glide.with(itemView)
                        .load(item.mainImage.url)
                        .into(mainImage);
            }
            title.setText(item.title);
            time.setText(String.valueOf(item.publishedAt));
        }

        @Override
        public void onClick(View v) {

        }
    }
}
