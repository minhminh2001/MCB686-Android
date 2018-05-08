package com.mc.books.fragments.home.booktab;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.mc.books.MainActivity;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

public class BookTabFragment extends BaseMvpFragment<IBookTabView, IBookTabPresenter<IBookTabView>> implements IBookTabView{

    public static BookTabFragment newInstance() {
        Bundle args = new Bundle();
        BookTabFragment fragment = new BookTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ((MainActivity) getActivity()).getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public IBookTabPresenter<IBookTabView> createPresenter() {
        return new BookTabPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.booktab_fragment;
    }

    @Override
    public int getTitleId() {
        return super.getTitleId();
    }

    @Override
    public String getTitle() {
        return "300 bài hát thiếu nhi";
    }
}
