package org.styleru.the6hands.presentation.apartment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
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

import org.parceler.Parcels;
import org.styleru.the6hands.ExpandableTextView;
import org.styleru.the6hands.R;
import org.styleru.the6hands.SixHandsApplication;
import org.styleru.the6hands.domain.entities.Apartment;

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
    TextView metroNameTextView;

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

    @BindView(R.id.tv_price)
    TextView priceTextView;

    @BindView(R.id.tv_description)
    ExpandableTextView descriptionTextView;

    @BindView(R.id.recycler_facilities)
    RecyclerView facilitesRecyclerView;

    private Apartment apartment;

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
        apartment = Parcels.unwrap(savedInstanceState.getBundle("Flat"));
        ((AppCompatActivity) Objects.requireNonNull(getActivity())).setSupportActionBar(toolbar);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowTitleEnabled(false);
        collapsingToolbarLayout.setTitleEnabled(false);
        descriptionTextView.setTrimLength(200);

        facilitesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        facilitesRecyclerView.setAdapter(new FacilityAdapter(apartment.getFacilities()));
        return view;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.toolbar_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public void showApartment() {
        setAdress(apartment.getAddress());
        setPrice(apartment.getPrice());
        setMetro(apartment.getMetroStation());
//        setTime(apartment.getTime());
        setRoomsNumber(apartment.getNumberOfRooms());
        setArea(apartment.getLivingSpace());
        setFloor(apartment.getFloor());
        setOwnerName(String.valueOf(apartment.getIdUser()));
//        setOwnerAvatar(apartment.get);
//        setMutualFriendsNumber(apartment.getMutualFriendsNumber());
//        setDescription(apartment.getDescription());
    }

    private void setAdress(String adress) {
        adressTextView.setText(adress);
    }

    private void setPrice(int price) {
        priceTextView.setText(String.valueOf(price) + "$");
    }

    private void setMetro(String metro) {
        metroNameTextView.setText(metro);
    }

    private void setTime(String time) {
        timeTextView.setText(time);
    }

    private void setRoomsNumber(int roomsNumber) {
        roomsNumberTextView.setText(String.valueOf(roomsNumber));
    }

    private void setArea(int area) {
        areaTextView.setText(String.valueOf(area));
    }

    private void setFloor(int floor) {
        floorTextView.setText(String.valueOf(floor));
    }

    private void setOwnerAvatar() {

    }

    private void setOwnerName(String name) {
        ownerNameTextView.setText(name);
    }

    private void setMutualFriendsNumber(int number) {
        mutualFriendsNumberTextView.setText(String.valueOf(number));
    }

    private void setDescription(String description) {
        descriptionTextView.setText(description);
    }

    private void setFacilities() {
        Objects.requireNonNull(facilitesRecyclerView.getAdapter()).notifyDataSetChanged();
    }
}
