package org.styleru.the6hands.data.repository.Api;

import org.styleru.the6hands.domain.entities.Facilities;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FacilitiesApi {
    @GET("facilities")
    Observable<List<Facilities>> getFacilitiesList();

    @GET("facilities/{id}")
    Single<Facilities> getFacilitiesById(@Path("id") int id);

    @DELETE("facilities/{id}")
    Completable deleteFacilities(@Path("id") int id);
}
