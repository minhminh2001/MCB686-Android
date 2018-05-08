package com.mc.books.fragments.home.infomationBook;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bon.customview.textview.ExtTextView;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class InformationBookFragment extends BaseMvpFragment<IInformationBookView, IInformationBookPresenter<IInformationBookView>> implements IInformationBookView {

    @BindView(R.id.txtGeneral)
    ExtTextView txtGeneral;
    @BindView(R.id.txtReadMore)
    ExtTextView txtReadMore;
    Unbinder unbinder;

    public static InformationBookFragment newInstance() {
        Bundle args = new Bundle();
        InformationBookFragment fragment = new InformationBookFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IInformationBookPresenter<IInformationBookView> createPresenter() {
        return new InformationBookPresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.information_book_fragment;
    }

    @Override
    public int getTitleId() {
        return R.string.information_book;
    }

    @Override
    public void initToolbar(@NonNull ActionBar supportActionBar) {
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_right);
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

    @OnClick(R.id.txtReadMore)
    public void onViewClicked() {
        txtGeneral.setMaxLines(99);
        txtReadMore.setText(R.string.showLess);
    }
}
