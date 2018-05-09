package com.mc.books.fragments.home.dashboad;

import android.app.AlertDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bon.customview.edittext.ExtEditText;
import com.bon.util.DialogUtils;
import com.bon.util.ToastUtils;
import com.mc.adapter.BookSectionAdapter;
import com.mc.books.R;
import com.mc.books.dialog.DeleteBookDialog;
import com.mc.books.dialog.MessageBoxDialog;
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
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import io.github.luizgrp.sectionedrecyclerviewadapter.SectionedRecyclerViewAdapter;


public class DashboardFragment extends BaseMvpFragment<IDashboardView, IDashboardPresenter<IDashboardView>> implements IDashboardView {
    @BindView(R.id.rvBook)
    RecyclerView rvBook;
    Unbinder unbinder;
    @BindView(R.id.fbCreateBook)
    LinearLayout fbCreateBook;
    @BindView(R.id.rlDashbroad)
    RelativeLayout rlDashbroad;
    @BindView(R.id.edtSearch)
    ExtEditText edtSearch;

    private static final int DELETE_BOOK = 0;
    private static final int SHARE_BOOK = 1;

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
        sectionAdapter = new SectionedRecyclerViewAdapter();

        List<String> categoryBook = new ArrayList<>();
        categoryBook.add("1");
        categoryBook.add("2");
        categoryBook.add("3");
        sectionAdapter.addSection(new BookSectionAdapter("Tiếng Anh", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder, -1);
        }, cvConsunmer -> this.goToBookTab()));
        sectionAdapter.addSection(new BookSectionAdapter("Kinh dị", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder, -1);
        }, cvConsunmer -> this.goToBookTab()));
        sectionAdapter.addSection(new BookSectionAdapter("Ngôn Tình", categoryBook, imgMoreViewHolder -> {
            presenter.showDialog(true, imgMoreViewHolder, -1);
        }, cvConsunmer -> this.goToBookTab()));

        rvBook.setLayoutManager(new LinearLayoutManager(getContext()));
        rvBook.setAdapter(sectionAdapter);

        dialogBookMenu = MenuUtil.getBookMenu(getAppContext(), this, onBookmenuListener);

        edtSearch.setOnEditorActionListener((textView, actionId, event) -> {
            if ((actionId == EditorInfo.IME_ACTION_SEARCH) ||
                    ((event.isShiftPressed() == false) &&
                            (event.getKeyCode() == KeyEvent.KEYCODE_ENTER) &&
                            (event.getAction() == KeyEvent.ACTION_DOWN))) {

                if (!textView.getText().toString().equals(""))
                    presenter.onSearchBook(textView.getText().toString());
                return true;
            }
            return false;
        });
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    private OnMenuItemClickListener<DialogBookMenuItem> onBookmenuListener = (position, item) -> {
        Log.e("DialogBookMenuItem", "" + position);
        presenter.showDialog(false, null, position);
    };

    @OnClick(R.id.fbCreateBook)
    public void onViewClicked() {

    }

    @Override
    public void onShowDialog(boolean isShow, View dialog, int position) {
        if (isShow)
            dialogBookMenu.showAsDropDown(dialog, -350, 0);
        else {
            dialogBookMenu.dismiss();
            if (position == DELETE_BOOK) {
                DeleteBookDialog deleteBookDialog = new DeleteBookDialog(getActivity(), deleteConsumer -> ToastUtils.showToast(getActivity(), "Đã xóa"));
                deleteBookDialog.show();
//                MessageBoxDialog messageBoxDialog = new MessageBoxDialog(getActivity(), "Chúc mừng bạn 12312312");
//                messageBoxDialog.show();
            } else if (position == SHARE_BOOK) {
                //b
            }
        }
    }

    @Override
    public void onSearchSuccess() {

    }
}
