package org.styleru.the6hands.domain.interactors;

import org.styleru.the6hands.data.repository.ApartFacRepository;
import org.styleru.the6hands.data.repository.FlatRepository;
import org.styleru.the6hands.domain.entities.ApartFac;
import org.styleru.the6hands.domain.entities.Apartment;

import javax.inject.Inject;

import io.reactivex.Single;

public class ApartmentInteractor {

    private ApartFacRepository apartFacRepository;

    @Inject
    ApartmentInteractor(ApartFacRepository apartFacRepository) {
        this.apartFacRepository = apartFacRepository;
    }

    public Single<ApartFac> getApartmentById(int id) {
        return apartFacRepository.getApartFacById(id);
    }

}
