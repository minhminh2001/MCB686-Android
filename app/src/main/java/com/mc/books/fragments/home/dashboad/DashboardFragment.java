package com.mc.books.fragments.home.dashboad;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mc.adapter.BookSectionAdapter;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


public class DashboardFragment extends BaseMvpFragment<IDashboardView, IDashboardPresenter<IDashboardView>> implements IDashboardView {
    @BindView(R.id.rvBook)
    RecyclerView rvBook;
    Unbinder unbinder;
    private SectionedRecyclerViewAdapter sectionAdapter;

    public static DashboardFragment newInstance() {
        Bundle args = new Bundle();
        DashboardFragment fragment = new DashboardFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IDashboardPresenter<IDashboardView> createPresenter() {
        return new DashboardPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.dashbroad_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sectionAdapter = new SectionedRecyclerViewAdapter();
        List<String> categoryBook = new ArrayList<>();
        categoryBook.add("1");
        categoryBook.add("2");
        categoryBook.add("3");

        sectionAdapter.addSection(new BookSectionAdapter("Tiếng Anh", categoryBook));
        sectionAdapter.addSection(new BookSectionAdapter("Kinh dị", categoryBook));
        sectionAdapter.addSection(new BookSectionAdapter("Ngôn Tình", categoryBook));

        rvBook.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBook.setAdapter(sectionAdapter);
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @Override
    public void onSignUpSuccess() {

    }

}
