package org.styleru.the6hands.presentation.apartment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.interactors.ApartmentInteractor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@InjectViewState
public class ApartmentPresenter extends MvpPresenter<ApartmentView> {

//    private final ApartmentInteractor apartmentInteractor;

    @Inject
    ApartmentPresenter(/*ApartmentInteractor apartmentInteractor*/) {
//        this.apartmentInteractor = apartmentInteractor;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        //TODO: realize obtaining of apartment from the previous screen
        getViewState().showApartment();
//        Disposable disposable = apartmentInteractor.getApartmentById()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    flat -> getViewState().showApartment(flat),
//                        e -> {}
//                );
    }



}
