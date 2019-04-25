package org.styleru.the6hands.data.repository;

import org.styleru.the6hands.data.repository.Api.FlatApi;
import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.repository.IFlatRepository;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class FlatRepository implements IFlatRepository {

    private FlatApi flatApi;
    @Inject
    FlatRepository(Retrofit retrofit){
        this.flatApi = retrofit.create(FlatApi.class);
    }

    @Override
    public Observable getApartmentsList() {
        return flatApi.getApartmentList();
    }

    @Override
    public Single getApartmentById(int id) {
        return flatApi.getApartment(id);
    }

    @Override
    public Completable addApartment(Apartment apartment) {
        return flatApi.addApartment(apartment);
    }

    @Override
    public Completable changeApartment(int id, Apartment apartment) {
        return flatApi.changeApartment(id, apartment);
    }

    @Override
    public Completable deleteApartment(int id) {
        return flatApi.deleteApartment(id);
    }
}
