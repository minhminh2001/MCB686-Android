package com.mc.books.fragments.home.dashboad;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.mc.adapter.BookSectionAdapter;
import com.mc.books.R;
import com.mc.books.fragments.home.booktab.BookTabFragment;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.models.home.DialogBookMenuItem;
import com.mc.utilities.FragmentUtils;
import com.mc.utilities.MenuUtil;
import com.skydoves.powermenu.CustomPowerMenu;
import com.skydoves.powermenu.OnMenuItemClickListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


public class DashboardFragment extends BaseMvpFragment<IDashboardView, IDashboardPresenter<IDashboardView>> implements IDashboardView {
    @BindView(R.id.rvBook)
    RecyclerView rvBook;
    @BindView(R.id.fbCreateBook)
    LinearLayout fbCreateBook;
    @BindView(R.id.rlDashbroad)
    RelativeLayout rlDashbroad;

    private SectionedRecyclerViewAdapter sectionAdapter;
    private CustomPowerMenu dialogBookMenu;

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
        bindButterKnife(view);

        sectionAdapter = new SectionedRecyclerViewAdapter();
        List<String> categoryBook = new ArrayList<>();
        categoryBook.add("1");
        categoryBook.add("2");
        categoryBook.add("3");

        sectionAdapter.addSection(new BookSectionAdapter("Tiếng Anh", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder);
        }, cvConsunmer -> this.goToBookTab()));
        sectionAdapter.addSection(new BookSectionAdapter("Kinh dị", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder);
        }, cvConsunmer -> this.goToBookTab()));
        sectionAdapter.addSection(new BookSectionAdapter("Ngôn Tình", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder);
        }, cvConsunmer -> this.goToBookTab()));

        rvBook.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
        rvBook.setAdapter(sectionAdapter);

        dialogBookMenu = MenuUtil.getBookMenu(getAppContext(), this, onBookmenuListener);
    }

    private void goToBookTab() {
        FragmentUtils.replaceFragment(getActivity(), BookTabFragment.newInstance());
    }

    @Override
    public int getTitleId() {
        return R.string.my_book;
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

    private OnMenuItemClickListener<DialogBookMenuItem> onBookmenuListener = (position, item) -> {
        Log.e("DialogBookMenuItem", "" + position);
        presenter.showDialog(false, null);
    };

    @OnClick(R.id.fbCreateBook)
    public void onViewClicked() {

    }

    @Override
    public void onShowDialog(boolean isShow, View dialog) {
        if (isShow)
            dialogBookMenu.showAsDropDown(dialog, -350, 0);
        else
            dialogBookMenu.dismiss();
    }
}
