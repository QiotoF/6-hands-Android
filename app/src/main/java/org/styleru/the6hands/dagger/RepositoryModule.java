package org.styleru.the6hands.dagger;

import android.content.Context;

import com.vk.api.sdk.okhttp.LoggingInteceptor;

import org.styleru.the6hands.data.repository.FlatRepository;
import org.styleru.the6hands.data.repository.UserRepository;
import org.styleru.the6hands.domain.repository.IFlatRepository;
import org.styleru.the6hands.domain.repository.IUserRepository;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
abstract class RepositoryModule {

    @Singleton
    @Provides
    static Retrofit provideRetrofit(){
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.interceptors().add(new HttpLoggingInterceptor());
        return new Retrofit.Builder()
                .baseUrl("localhost:5000/api/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Binds
    abstract IFlatRepository bindIFlatRepository(FlatRepository flatRepository);

    @Binds
    abstract IUserRepository bindIUserRepository(UserRepository userRepository);
}
