package org.styleru.the6hands.data.repository.Api;

import io.reactivex.Completable;
import io.reactivex.Observable;

import org.styleru.the6hands.domain.entities.Apartment;

import java.util.List;

import io.reactivex.Single;
import retrofit2.Response;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface FlatApi{

    @GET("apartment")
    Observable<List<Apartment>> getApartmentList();

    @GET("apartment/{id}")
    Single<Apartment> getApartment(@Path("id") int id);

    @POST("apartment")
    Completable addApartment(@Body Apartment apartment);

    @PUT("apartment/{id}")
    Completable changeApartment(@Path("id") int id, @Body Apartment apartment);

    @DELETE("apartment/{id}")
    Completable deleteApartment(@Path("id") int id);

}
