package com.mc.books.fragments.home.booktab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.mc.books.R;
import com.mc.books.fragments.home.infomationBook.InformationBookFragment;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.utilities.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BookTabFragment extends BaseMvpFragment<IBookTabView, IBookTabPresenter<IBookTabView>> implements IBookTabView {

    @BindView(R.id.imgBookInformation)
    ImageView imgBookInformation;
    @BindView(R.id.imgBookLesson)
    ImageView imgBookLesson;
    @BindView(R.id.imgBookSubject)
    ImageView imgBookSubject;

    public static BookTabFragment newInstance() {
        Bundle args = new Bundle();
        BookTabFragment fragment = new BookTabFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindButterKnife(view);
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
    public void initToolbar(@NonNull ActionBar supportActionBar) {
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_right);
    }

    @Override
    public String getTitleString() {
        return "300 bài hát thiếu nhi";
    }

    @OnClick({R.id.imgBookInformation, R.id.imgBookLesson, R.id.imgBookSubject})
    public void onViewClicked(View view) {
        BaseMvpFragment fragment = null;
        switch (view.getId()) {
            case R.id.imgBookInformation:
                fragment = InformationBookFragment.newInstance();
                break;
            case R.id.imgBookLesson:
                break;
            case R.id.imgBookSubject:
                break;
        }
        FragmentUtils.replaceFragment(getActivity(), fragment);
    }
}
