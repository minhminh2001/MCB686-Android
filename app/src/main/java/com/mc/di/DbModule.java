package com.mc.di;

import com.mc.interactors.database.IDbModule;
import com.qslib.eventbus.IEvent;
import com.qslib.eventbus.RxBus;

import javax.inject.Inject;

import dagger.Module;

/**
 * Created by dangpp on 2/9/2018.
 */

@Module
public class DbModule implements IDbModule {
    private static final String TAG = DbModule.class.getSimpleName();

    @Inject
    RxBus<IEvent> bus;

    public DbModule(AppComponent component) {
        component.inject(this);
    }
}
