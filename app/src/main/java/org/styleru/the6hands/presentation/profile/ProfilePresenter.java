package org.styleru.the6hands.presentation.profile;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.Image;
import org.styleru.the6hands.domain.interactors.ApartmentInteractor;
import org.styleru.the6hands.domain.interactors.UserInfoInteractor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {


    private final List<Apartment> data = new ArrayList<>(3);
    private final UserInfoInteractor userInfoInteractor;
    private final ApartmentInteractor apartmentInteractor;

    @Inject
    ProfilePresenter(UserInfoInteractor userInfoInteractor, ApartmentInteractor apartmentInteractor) {
        this.userInfoInteractor = userInfoInteractor;
        this.apartmentInteractor = apartmentInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        Disposable disposable = userInfoInteractor.getUserFromVk()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                        user -> getViewState().setUser(user),
                        e -> {}
                );
//        Disposable disposable1 = apartmentInteractor.getApartmentList()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(flat -> getViewState().addFlats(flat),
//                e -> {});

        data.add(new Apartment(1, "1", 1, 1, 1, 1
        ,1, 1000, 1, 1, 1,
                1, 1, null, null, 1, "Славянский бульвар"));
        data.add(new Apartment(1, "1", 1, 1, 1, 1
                ,1, 1000, 1, 1, 1,
                1, 1, null, null, 2, "Славянский бульвар"));
        data.add(new Apartment(1, "1", 1, 1, 1, 1
                ,1, 1000, 1, 1, 1,
                1, 1, null, null, 3, "Славянский бульвар"));


        getViewState().addFlats(data);
    }

    public Image getImage(int id){
        final Image[] image = new Image[1];
        Disposable disposable = apartmentInteractor.getImageById(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(newImage -> {
                            image[0] = new Image(newImage.getId(), newImage.getIdUser(),
                                newImage.getIdApartment(), newImage.getPath());},
                e -> {});
        return image[0];
    }
}
