package org.styleru.the6hands.domain.repository;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface IFacilitiesRepository {

    Observable getFacilitiesList();
    Single getFacilities(int id);
    Completable deleteFacilities(int id);
}
