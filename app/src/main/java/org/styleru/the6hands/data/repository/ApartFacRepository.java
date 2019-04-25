package org.styleru.the6hands.data.repository;

import org.styleru.the6hands.data.repository.Api.ApartFacApi;
import org.styleru.the6hands.domain.entities.ApartFac;
import org.styleru.the6hands.domain.repository.IApartFacRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class ApartFacRepository implements IApartFacRepository {

    private ApartFacApi apartFacApi;

    @Inject
    ApartFacRepository(Retrofit retrofit){
        this.apartFacApi = retrofit.create(ApartFacApi.class);
    }


    @Override
    public Observable<List<ApartFac>> getApartFacList() {
        return apartFacApi.getApartFacList();
    }

    @Override
    public Single<ApartFac> getApartFacById(int id) {
        return apartFacApi.getApaprtFacById(id);
    }

    @Override
    public Completable addApartFac(ApartFac apartFac) {
        return apartFacApi.addApartFac(apartFac);
    }

    @Override
    public Completable editApartFac(int id, ApartFac apartFac) {
        return apartFacApi.editApartFac(id, apartFac);
    }

    @Override
    public Completable deleteApartFac(int id) {
        return apartFacApi.deleteApartFac(id);
    }
}
