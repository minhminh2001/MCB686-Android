package com.mc.books.fragments.profile;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bon.customview.button.ExtButton;
import com.bon.customview.edittext.ExtEditText;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;

import butterknife.BindView;
import butterknife.OnClick;

public class UserProfileFragment extends BaseMvpFragment<IUserProfileView, IUserProfilePresenter<IUserProfileView>> implements IUserProfileView {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.imgAvartar)
    ImageView imgAvartar;
    @BindView(R.id.edUserName)
    ExtEditText edUserName;
    @BindView(R.id.edDateofBirth)
    EditText edDateofBirth;
    @BindView(R.id.spDateofBirth)
    AppCompatSpinner spDateofBirth;
    @BindView(R.id.edPhoneNumber)
    ExtEditText edPhoneNumber;
    @BindView(R.id.edSex)
    EditText edSex;
    @BindView(R.id.spSex)
    AppCompatSpinner spSex;
    @BindView(R.id.edEmail)
    ExtEditText edEmail;
    @BindView(R.id.edCity)
    EditText edCity;
    @BindView(R.id.spCity)
    AppCompatSpinner spCity;
    @BindView(R.id.edCounty)
    EditText edCounty;
    @BindView(R.id.spCounty)
    AppCompatSpinner spCounty;
    @BindView(R.id.edAddress)
    ExtEditText edAddress;
    @BindView(R.id.btnSaveProfile)
    ExtButton btnSaveProfile;

    public static UserProfileFragment newInstance() {
        Bundle args = new Bundle();
        UserProfileFragment fragment = new UserProfileFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public IUserProfilePresenter<IUserProfileView> createPresenter() {
        return new UserProfilePresenter<>(getAppComponent());
    }

    @Override
    public void onShowProfile() {

    }

    @Override
    public int getResourceId() {
        return R.layout.user_profile_fragment;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.spDateofBirth, R.id.spSex, R.id.spCity, R.id.spCounty, R.id.btnSaveProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.spDateofBirth:
                break;
            case R.id.spSex:
                break;
            case R.id.spCity:
                break;
            case R.id.spCounty:
                break;
            case R.id.btnSaveProfile:
                break;
        }
    }

    @Override
    public void initToolbar(@NonNull ActionBar supportActionBar) {
        super.initToolbar(supportActionBar);

    }
}
