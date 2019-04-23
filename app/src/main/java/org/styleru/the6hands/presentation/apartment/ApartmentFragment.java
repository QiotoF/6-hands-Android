package org.styleru.the6hands.presentation.apartment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;

import org.styleru.the6hands.ExpandableTextView;
import org.styleru.the6hands.R;
import org.styleru.the6hands.SixHandsApplication;

import java.util.Objects;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ApartmentFragment extends MvpAppCompatFragment implements ApartmentView {

    @Inject
    @InjectPresenter
    ApartmentPresenter apartmentPresenter;

    @ProvidePresenter
    ApartmentPresenter provideFlatPresenter() {
        return apartmentPresenter;
    }

    @BindView(R.id.toolbar_layout)
    CollapsingToolbarLayout collapsingToolbarLayout;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.tv_adress)
    TextView adressTextView;

    @BindView(R.id.image_metro_color)
    View metroColorImage;

    @BindView(R.id.tv_metro_name)
    TextView mentroNameTextView;

    @BindView(R.id.image_clock)
    ImageView clockImage;

    @BindView(R.id.tv_time)
    TextView timeTextView;

    @BindView(R.id.tv_rooms_number)
    TextView roomsNumberTextView;

    @BindView(R.id.tv_area)
    TextView areaTextView;

    @BindView(R.id.tv_floor)
    TextView floorTextView;

    @BindView(R.id.tv_owner_name)
    TextView ownerNameTextView;

    @BindView(R.id.image_owner_avatar)
    TextView ownerAvatarImage;

    @BindView(R.id.tv_mutual_friends_number)
    TextView mutualFriendsNumberTextView;

    @BindView(R.id.tv_description)
    ExpandableTextView descriptionTextView;

    @Override
    public void onAttach(Context context) {
        SixHandsApplication.getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apartment, container, false);
        setHasOptionsMenu(true);
        ButterKnife.bind(this, view);

        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        collapsingToolbarLayout.setTitleEnabled(false);
        descriptionTextView.setTrimLength(200);

        return view;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }
}
