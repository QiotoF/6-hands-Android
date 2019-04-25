package org.styleru.the6hands.domain.repository;

import org.styleru.the6hands.domain.entities.Image;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Single;

public interface IImageRepository {

    Observable getImageList();
    Single getImageById(int id);
    Completable addImage(Image image);
    Completable editImage(int id, Image image);
    Completable deleteImage(int id);
}
