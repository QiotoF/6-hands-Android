package org.styleru.the6hands.presentation.profile;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.entities.Apartment;
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

    @Inject
    ProfilePresenter(UserInfoInteractor userInfoInteractor) {
        this.userInfoInteractor = userInfoInteractor;
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

        data.add(new Apartment(1, "1", 1, 1, 1, 1
        ,1, 1000, 1, 1, 1,
                1, 1, null, 1, null, 1, "Sokolniki"));
        data.add(new Apartment(1, "1", 1, 1, 1, 1
                ,1, 1000, 1, 1, 1,
                1, 1, null, 1, null, 2, "Sokolniki"));
        data.add(new Apartment(1, "1", 1, 1, 1, 1
                ,1, 1000, 1, 1, 1,
                1, 1, null, 1, null, 3, "Sokolniki"));



        getViewState().showFlats(data);
    }
}
