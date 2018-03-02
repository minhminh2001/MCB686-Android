package com.mc.di;

import android.content.Context;

import com.mc.application.AppContext;
import com.mc.interactors.IDataModule;
import com.mc.interactors.database.IDbModule;
import com.bon.eventbus.IEvent;
import com.bon.eventbus.RxBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by dangpp on 2/9/2018.
 */

@Module
public class AppModule {
    private final AppContext appContext;

    public AppModule(AppContext appContext) {
        this.appContext = appContext;
    }

    @Singleton
    @Provides
    public RxBus<IEvent> provideEvenBus() {
        return new RxBus<>();
    }

    @Singleton
    @Provides
    public Context provideContext() {
        return appContext.getApplicationContext();
    }

    @Singleton
    @Provides
    public IDataModule provideDataModule() {
        return new DataModule(appContext.getComponent());
    }

    @Singleton
    @Provides
    public IDbModule provideDbModule() {
        return new DbModule(appContext.getComponent());
    }
}
