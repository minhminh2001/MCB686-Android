package com.mc.books.fragments.more.profile;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.AppCompatSpinner;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.bon.customview.button.ExtButton;
import com.bon.customview.edittext.ExtEditText;
import com.mc.books.R;
import com.mc.common.fragments.BaseMvpFragment;
import com.nguyenhoanglam.imagepicker.model.Config;
import com.nguyenhoanglam.imagepicker.model.Image;
import com.nguyenhoanglam.imagepicker.ui.imagepicker.ImagePicker;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.OnClick;

import static android.app.Activity.RESULT_OK;

public class UserProfileFragment extends BaseMvpFragment<IUserProfileView, IUserProfilePresenter<IUserProfileView>> implements IUserProfileView {
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
    private ArrayList<Image> images = new ArrayList<>();

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
    public void initToolbar(@NonNull ActionBar supportActionBar) {
        supportActionBar.setDisplayHomeAsUpEnabled(true);
        supportActionBar.setHomeAsUpIndicator(R.drawable.ic_arrow_right);
        supportActionBar.setTitle(R.string.title_toolbar);
        mActivity.getAppSupportActionBar().show();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        imgAvartar=(ImageView)view.findViewById(R.id.imgAvartar) ;
        imgAvartar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectAvatar();
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @OnClick({R.id.imgAvartar,R.id.spDateofBirth, R.id.spSex, R.id.spCity, R.id.spCounty, R.id.btnSaveProfile})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.imgAvartar:
//                selectAvatar();
                break;
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

    private void selectAvatar() {
        ImagePicker.with(this)
                .setCameraOnly(false)
                .setFolderTitle("Download")
                .setImageTitle("Galleries")
                .setSelectedImages(images)
                .setMaxSize(10)
                .setKeepScreenOn(true)
                .start();

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == Config.RC_PICK_IMAGES && resultCode == RESULT_OK && data != null) {
            images = data.getParcelableArrayListExtra(Config.EXTRA_IMAGES);

        }
        super.onActivityResult(requestCode, resultCode, data);
    }


}
