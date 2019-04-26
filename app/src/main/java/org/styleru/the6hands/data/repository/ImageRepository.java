package org.styleru.the6hands.data.repository;

import org.styleru.the6hands.data.repository.Api.ImageApi;
import org.styleru.the6hands.domain.entities.Image;
import org.styleru.the6hands.domain.repository.IImageRepository;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Retrofit;

public class ImageRepository implements IImageRepository {

    private ImageApi imageApi;

    @Inject
    ImageRepository(Retrofit retrofit){
        this.imageApi = retrofit.create(ImageApi.class);
    }

    @Override
    public Observable<List<Image>> getImageList() {
        return imageApi.getImageList();
    }

    @Override
    public Single<Image> getImageById(int id) {
        return imageApi.getImageById(id);
    }

    @Override
    public Completable addImage(Image image) {
        return imageApi.addImage(image);
    }

    @Override
    public Completable editImage(int id, Image image) {
        return imageApi.editImage(id, image);
    }

    @Override
    public Completable deleteImage(int id) {
        return imageApi.deleteImage(id);
    }
}
