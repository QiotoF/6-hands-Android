package org.styleru.the6hands.domain.repository;

import org.styleru.the6hands.domain.entities.ApartFac;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface IApartFacRepository {

    Observable<List<ApartFac>> getApartFacList();
    Single<ApartFac> getApartFacById(int id);
    Completable addApartFac(ApartFac apartFac);
    Completable editApartFac(int id, ApartFac apartFac);
    Completable deleteApartFac(int id);
}
