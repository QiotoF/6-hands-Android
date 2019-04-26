package org.styleru.the6hands.dagger;

import android.content.Context;

import com.vk.api.sdk.okhttp.LoggingInteceptor;

import org.styleru.the6hands.data.repository.ApartFacRepository;
import org.styleru.the6hands.data.repository.FacilitiesRepository;
import org.styleru.the6hands.data.repository.FlatRepository;
import org.styleru.the6hands.data.repository.ImageRepository;
import org.styleru.the6hands.data.repository.UserRepository;
import org.styleru.the6hands.domain.repository.IApartFacRepository;
import org.styleru.the6hands.domain.repository.IFacilitiesRepository;
import org.styleru.the6hands.domain.repository.IFlatRepository;
import org.styleru.the6hands.domain.repository.IImageRepository;
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

    @Binds
    abstract IFlatRepository bindIFlatRepository(FlatRepository flatRepository);

    @Binds
    abstract IImageRepository bindIImageRepositpry(ImageRepository imageRepository);

    @Binds
    abstract IFacilitiesRepository bindIFacilitiesRepository(FacilitiesRepository facilitiesRepository);

    @Binds
    abstract IApartFacRepository bindIApartfFacRepository(ApartFacRepository apartFacRepository);

    @Binds
    abstract IUserRepository bindIUserRepository(UserRepository userRepository);
}
