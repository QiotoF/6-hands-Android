package org.styleru.the6hands.domain.repository;

import org.styleru.the6hands.domain.entities.Apartment;

import java.util.List;

import javax.inject.Singleton;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface IFlatRepository {

    Observable<List<Apartment>> getApartmentsList();
    Single<Apartment> getApartmentById(int id);
    Completable addApartment(Apartment apartment);
    Completable changeApartment(int id, Apartment apartment);
    Completable deleteApartment(int id);

}
