package com.mc.books.fragments.home.infomationBook;

import com.mc.common.presenters.BaseDataPresenter;
import com.mc.di.AppComponent;

public class InformationBookPresenter<V extends IInformationBookView> extends BaseDataPresenter<V> implements IInformationBookPresenter<V> {

    protected InformationBookPresenter(AppComponent appComponent) {
        super(appComponent);
    }
}
