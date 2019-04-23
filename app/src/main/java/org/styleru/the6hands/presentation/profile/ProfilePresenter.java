package org.styleru.the6hands.presentation.profile;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.R;
import org.styleru.the6hands.domain.entities.Flat;
import org.styleru.the6hands.domain.interactors.UserInfoInteractor;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ProfilePresenter extends MvpPresenter<ProfileView> {


    private final List<Flat> data = new ArrayList<>(3);
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

        data.add(new Flat(1000, 4, 100, 50,
                "Славянский бульвар", R.color.metro3_arbatsko_pokrovskaya,
                R.drawable.flat));
        data.add(new Flat(1000, 4, 100, 50,
                "Сокольники", R.color.metro1_sokolnicheskaya,
                R.drawable.flat));
        data.add(new Flat(1000, 4, 100, 50,
                "Добрынинская", R.color.metro5_koltsevaya,
                R.drawable.flat));

        getViewState().showFlats(data);
    }
}
