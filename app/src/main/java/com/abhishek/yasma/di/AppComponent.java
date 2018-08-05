package com.abhishek.yasma.di;

import com.abhishek.yasma.YASMApp;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {AndroidSupportInjectionModule.class,
        ActivityBuilder.class,
        AppModule.class})
public interface AppComponent extends AndroidInjector<YASMApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(YASMApp app);

        Builder database(DatabaseModule module);

        Builder network(NetworkModule module);



        AppComponent build();
    }

    @Override
    void inject(YASMApp instance);
}
