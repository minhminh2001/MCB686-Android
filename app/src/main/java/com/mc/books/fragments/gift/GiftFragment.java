package com.mc.books.fragments.gift;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.bon.customview.edittext.ExtEditText;
import com.mc.adapter.GiftAdapter;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.customize.ExpandableCardView;
import com.mc.models.gift.GiftResponse;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

public class GiftFragment extends BaseMvpFragment<IGiftView, IGiftPresenter<IGiftView>> implements IGiftView {

    @BindView(R.id.edtSearch)
    ExtEditText edtSearch;
    @BindView(R.id.rvGift)
    RecyclerView rvGift;
    @BindView(R.id.fbAddGift)
    LinearLayout fbAddGift;
    Unbinder unbinder;

    private GiftAdapter giftAdapter;

    public static GiftFragment newInstance() {
        Bundle args = new Bundle();
        GiftFragment fragment = new GiftFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IGiftPresenter<IGiftView> createPresenter() {
        return new GiftPresenter<>(getAppComponent());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<GiftResponse> giftResponseList = new ArrayList<>();
        giftResponseList.add(new GiftResponse("Quà tặng dành cho", 1));
        giftResponseList.add(new GiftResponse("Quà tặng dành cho sách học IELTS", 2));
        giftResponseList.add(new GiftResponse("Quà tặng dành cho sách học IELTS", 3));

        giftAdapter = new GiftAdapter(getAppContext());
        rvGift.setLayoutManager(new LinearLayoutManager(getAppContext(),LinearLayoutManager.VERTICAL, false ));
        rvGift.setAdapter(giftAdapter);
        giftAdapter.setDataList(giftResponseList);
    }

    @Override
    public int getResourceId() {
        return R.layout.gift_fragment;
    }

    @Override
    public int getTitleId() {
        return R.string.gift;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.fbAddGift)
    public void onViewClicked() {
    }
}
