package org.styleru.the6hands.data.repository;

import org.styleru.the6hands.data.repository.Api.FacilitiesApi;
import org.styleru.the6hands.domain.entities.Facilities;
import org.styleru.the6hands.domain.repository.IFacilitiesRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class FacilitiesRepository implements IFacilitiesRepository {
    private FacilitiesApi facilitiesApi;

    @Inject
    FacilitiesRepository(Retrofit retrofit){
        this.facilitiesApi = retrofit.create(FacilitiesApi.class);
    }


    @Override
    public Observable<List<Facilities>> getFacilitiesList() {
        return facilitiesApi.getFacilitiesList();
    }

    @Override
    public Single<Facilities> getFacilities(int id) {
        return facilitiesApi.getFacilitiesById(id);
    }

    @Override
    public Completable deleteFacilities(int id) {
        return facilitiesApi.deleteFacilities(id);
    }
}
