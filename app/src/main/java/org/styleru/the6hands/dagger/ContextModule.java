package org.styleru.the6hands.dagger;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ContextModule {

    private Context context;

    public ContextModule(){
        context = context;
    }

    @Provides
    @Singleton
    public Context context(){
        return context.getApplicationContext();
    }
}
