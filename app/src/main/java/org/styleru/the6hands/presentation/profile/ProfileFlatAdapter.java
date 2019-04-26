package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.styleru.the6hands.R;
import org.styleru.the6hands.dagger.ContextModule;
import org.styleru.the6hands.domain.entities.Apartment;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileFlatAdapter extends RecyclerView.Adapter<ProfileFlatAdapter.ViewHolder> {

    private List<Apartment> data = new ArrayList<>();
    private Context context;
    private ProfilePresenter profilePresenter;
    private IApartmentClick listener;

    @Inject
    ProfileFlatAdapter(Context context, ProfilePresenter profilePresenter, IApartmentClick listener){
        this.context = context;
        this.profilePresenter = profilePresenter;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProfileFlatAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.profile_flat, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileFlatAdapter.ViewHolder viewHolder, int i) {
        Apartment apartment = data.get(i);
        viewHolder.flatInfo.get(0).setText(apartment.getMetroStation());
        viewHolder.flatInfo.get(1).setText(String.valueOf(apartment.getNumberOfRooms()));
        viewHolder.flatInfo.get(2).setText(String.valueOf(apartment.getPrice()));

        viewHolder.profileFlatPicture.setOnClickListener(view -> {
            listener.onApartmentClick(data.get(i));
        });
//        Здесь нужно получить через id квартиры Image и презентер должен вернуть адрес картинки
//        Glide.with(viewHolder.itemView.getContext())
//                .load(profilePresenter.getImage(apartment.getId()).getPath())
//                .placeholder(R.drawable.picture_loading_background)
//                .error(R.drawable.picture_loading_background)
//                .into(viewHolder.profileFlatPicture);
        Log.d("Adapter", String.valueOf(context.getDrawable(R.drawable.circle_metro1)));
        switch (apartment.getMetroBranch()){
            case 1: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro1));
            case 2: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro2));
            case 3: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro3));
            case 4: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro4));
            case 5: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro5));
            case 6: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro6));
            case 7: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro7));
            case 8: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro8));
            case 9: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro9));
            case 10: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro10));
            case 11: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro11));
            case 12: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro12));
            case 13: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro13));
            case 14: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro14));
            case 15: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro15));
            case 16: viewHolder.metroCircle.
                    setBackground(context.getDrawable(R.drawable.circle_metro16));
        }
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<Apartment> newData){
        data.addAll(newData);
        notifyDataSetChanged();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindViews({R.id.profile_flat_dot, R.id.profile_flat_guideline3,
                R.id.profile_flat_guideline4, R.id.profile_flat_browsings,
                R.id.profile_flat_new_browsings})
        List<View> constantFields;

        @BindView(R.id.profile_flat_edit_button)
        LinearLayoutCompat editButton;

        @BindView(R.id.profile_flat_picture)
        ImageView profileFlatPicture;

        @BindView(R.id.profile_flat_metro_circle)
        View metroCircle;

        @BindViews({R.id.profile_flat_metro_station,
                R.id.profile_flat_number_rooms, R.id.profile_flat_price,
                R.id.profile_flat_number_of_browsings,
                R.id.profile_flat_number_of_new_browsings})
        List<TextView> flatInfo;
        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    @OnClick(R.id.profile_flat_edit_button)
    void onEditButtonClicked(){

    }
}
