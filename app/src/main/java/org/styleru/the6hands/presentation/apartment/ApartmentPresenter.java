package org.styleru.the6hands.presentation.apartment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.styleru.the6hands.domain.interactors.ApartmentInteractor;

import javax.inject.Inject;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ru.terrakok.cicerone.Router;

@InjectViewState
public class ApartmentPresenter extends MvpPresenter<ApartmentView> {

    private Router router;

//    private final ApartmentInteractor apartmentInteractor;

    @Inject
    ApartmentPresenter(/*ApartmentInteractor apartmentInteractor*/Router router) {
//        this.apartmentInteractor = apartmentInteractor;
        this.router = router;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().showApartment();
//        Disposable disposable = apartmentInteractor.getApartmentById()
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(
//                    flat -> getViewState().showApartment(flat),
//                        e -> {}
//                );
    }

    public void onHomeClick() {
        router.exit();
    }


}
