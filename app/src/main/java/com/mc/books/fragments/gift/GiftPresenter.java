package com.mc.books.fragments.gift;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;

public class GiftPresenter<V extends IGiftView> extends BaseDataPresenter<V> implements IGiftPresenter<V> {

    protected GiftPresenter(AppComponent appComponent) {
        super(appComponent);
    }
}
