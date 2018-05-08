package com.mc.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bon.customview.textview.ExtTextView;
import com.bon.eventbus.IEvent;
import com.bon.eventbus.RxBus;
import com.mc.books.R;
import com.mc.events.DashboadEvent;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionParameters;
import io.github.luizgrp.sectionedrecyclerviewadapter.StatelessSection;
import java8.util.function.Consumer;

public class BookSectionAdapter extends StatelessSection {

    private String categoryBook;
    private List<String> list;
    private RxBus<IEvent> bus;
    private Consumer<View> imgMoreConsumer;

    public BookSectionAdapter(String categoryBook, List<String> list, Consumer<View> imgMoreConsumer) {
        super(SectionParameters.builder()
                .itemResourceId(R.layout.item_book_content)
                .headerResourceId(R.layout.item_book_header)
                .build());
        this.categoryBook = categoryBook;
        this.list = list;
        this.imgMoreConsumer = imgMoreConsumer;
    }

    @Override
    public int getContentItemsTotal() {
        return list.size();
    }

    @Override
    public RecyclerView.ViewHolder getItemViewHolder(View view) {
        return new ItemViewHolder(view);
    }

    @Override
    public RecyclerView.ViewHolder getHeaderViewHolder(View view) {
        return new HeaderViewHolder(view);
    }

    @Override
    public void onBindItemViewHolder(RecyclerView.ViewHolder holder, int position) {
      ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.imgMore.setOnClickListener(view -> imgMoreConsumer.accept(itemViewHolder.imgMore));
    }

    @Override
    public void onBindHeaderViewHolder(RecyclerView.ViewHolder holder) {
      HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
      headerViewHolder.txtHeaderBook.setText(categoryBook);
    }

    class ItemViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imgMore)
        ImageView imgMore;
        @BindView(R.id.txtBookName)
        ExtTextView txtBookName;
        @BindView(R.id.txtBookAuthor)
        ExtTextView txtBookAuthor;
        @BindView(R.id.customProgress)
        ProgressBar customProgress;
        @BindView(R.id.txtProgress)
        ExtTextView txtProgress;
        @BindView(R.id.txtReadmore)
        ExtTextView txtReadmore;
        @BindView(R.id.imgNext)
        ImageView imgNext;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }

    class HeaderViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtHeaderBook)
        ExtTextView txtHeaderBook;

        public HeaderViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

    }
}
