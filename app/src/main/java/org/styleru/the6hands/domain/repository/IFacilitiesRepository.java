package org.styleru.the6hands.domain.repository;

import org.styleru.the6hands.domain.entities.Facilities;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface IFacilitiesRepository {

    Observable<List<Facilities>> getFacilitiesList();
    Single<Facilities> getFacilities(int id);
    Completable deleteFacilities(int id);
}
