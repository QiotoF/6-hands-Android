package org.styleru.the6hands.presentation.apartment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import javax.inject.Inject;

@InjectViewState
public class ApartmentPresenter extends MvpPresenter<ApartmentView> {

    @Inject
    ApartmentPresenter() {
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
    }

}
