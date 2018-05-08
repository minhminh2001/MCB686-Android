package com.mc.books.fragments.more;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bon.customview.textview.ExtTextView;
import com.mc.books.R;
import com.mc.books.fragments.profile.UserProfileFragment;
import com.mc.common.fragments.BaseMvpFragment;
import com.mc.utilities.FragmentUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import de.hdodenhof.circleimageview.CircleImageView;


public class MoreFragment extends BaseMvpFragment<IMoreView, IMorePresenter<IMoreView>> implements IMoreView {
    Unbinder unbinder;
    @BindView(R.id.imgAvartar)
    CircleImageView imgAvartar;
    @BindView(R.id.txtName)
    ExtTextView txtName;
    @BindView(R.id.llBooksname)
    LinearLayout llBooksname;
    @BindView(R.id.llCharts)
    LinearLayout llCharts;
    @BindView(R.id.llFanpage)
    LinearLayout llFanpage;
    @BindView(R.id.llSetting)
    LinearLayout llSetting;
    @BindView(R.id.llChangePassword)
    LinearLayout llChangePassword;
    @BindView(R.id.llUsermanual)
    LinearLayout llUsermanual;
    @BindView(R.id.llFeedback)
    LinearLayout llFeedback;
    @BindView(R.id.llLegal)
    LinearLayout llLegal;
    @BindView(R.id.llSupport)
    LinearLayout llSupport;
    @BindView(R.id.llSignout)
    LinearLayout llSignout;
    @BindView(R.id.imgNameChange)
    ImageView imgNameChange;

    public static MoreFragment newInstance() {
        Bundle args = new Bundle();
        MoreFragment fragment = new MoreFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IMorePresenter<IMoreView> createPresenter() {
        return new MorePresenter<>(getAppComponent());
    }

    @Override
    public int getResourceId() {
        return R.layout.more_fragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public int getTitleId() {
        return R.string.app_name;
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

    @OnClick({R.id.llBooksname, R.id.llCharts, R.id.llFanpage, R.id.llSetting, R.id.llChangePassword, R.id.llUsermanual, R.id.llFeedback, R.id.llLegal,
            R.id.llSupport, R.id.llSignout, R.id.imgNameChange, R.id.imgAvartar})
    public void onViewClicked(View view) {
        BaseMvpFragment fragment = null;
        switch (view.getId()) {
            case R.id.llBooksname:
                break;
            case R.id.llCharts:
                break;
            case R.id.llFanpage:
                break;
            case R.id.llSetting:
                break;
            case R.id.llChangePassword:
                break;
            case R.id.llUsermanual:
                break;
            case R.id.llFeedback:
                break;
            case R.id.llLegal:
                break;
            case R.id.llSupport:
                break;
            case R.id.llSignout:
                break;
            case R.id.imgNameChange:
                break;
            case R.id.imgAvartar:
                fragment = UserProfileFragment.newInstance();
                break;
        }
        FragmentUtils.replaceFragment(getActivity(), fragment);
    }
}
