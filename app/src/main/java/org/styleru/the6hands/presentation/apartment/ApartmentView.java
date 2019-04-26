package org.styleru.the6hands.presentation.apartment;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import org.styleru.the6hands.domain.entities.Apartment;

;

public interface ApartmentView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void showApartment();
}
