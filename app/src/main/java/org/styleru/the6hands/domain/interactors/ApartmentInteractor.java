package org.styleru.the6hands.domain.interactors;

import org.styleru.the6hands.data.repository.ApartFacRepository;
import org.styleru.the6hands.data.repository.FlatRepository;
import org.styleru.the6hands.domain.entities.ApartFac;
import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.Image;
import org.styleru.the6hands.domain.repository.IApartFacRepository;
import org.styleru.the6hands.domain.repository.IFlatRepository;
import org.styleru.the6hands.domain.repository.IImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class ApartmentInteractor {

    private IFlatRepository flatRepository;
    private IImageRepository imageRepository;


    @Inject
    ApartmentInteractor(IFlatRepository flatRepository, IImageRepository imageRepository) {
        this.flatRepository = flatRepository;
        this.imageRepository = imageRepository;
    }

    public Single<Apartment> getApartmentById(int id) {
        return flatRepository.getApartmentById(id);
    }

    public Observable<List<Apartment>> getApartmentList(){
        return flatRepository.getApartmentsList();
    }

    public Single<Image> getImageById(int id){
        return imageRepository.getImageById(id);
    }

}
