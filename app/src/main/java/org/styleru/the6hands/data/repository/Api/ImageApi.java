package org.styleru.the6hands.data.repository.Api;

import org.styleru.the6hands.domain.entities.Image;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface ImageApi {

    @GET("image")
    Observable<List<Image>> getImageList();

    @GET("image/{id}")
    Single<Image> getImageById(@Path("id") int id);

    @POST("image")
    Completable addImage(@Body Image image);

    @PUT("image/{id}")
    Completable editImage(@Path("id") int id, @Body Image image);

    @DELETE("image/{id}")
    Completable deleteImage(@Path("id") int id);
}
