package org.styleru.the6hands.data.repository.Api;

import org.styleru.the6hands.domain.entities.ApartFac;

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

public interface ApartFacApi {

    @GET("apartFac")
    Observable<List<ApartFac>> getApartFacList();

    @GET("apartFac/{id}")
    Single<ApartFac> getApaprtFacById(@Path("id") int id);

    @POST("apartFac")
    Completable addApartFac(@Body ApartFac apartFac);

    @PUT("apartFac/{id}")
    Completable editApartFac(@Path("id") int id, @Body ApartFac apartFac);

    @DELETE("apartFac/{id}")
    Completable deleteApartFac(@Path("id") int id);
}
