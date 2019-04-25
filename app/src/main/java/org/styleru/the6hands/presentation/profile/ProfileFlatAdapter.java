package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
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

    @Inject
    ProfileFlatAdapter(Context context){
        this.context = context;
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

//        Здесь нужно получить через id квартиры Image и презентер должен вернуть адрес картинки
//        Glide.with(viewHolder.itemView.getContext())
//                .load()
//                .placeholder(R.drawable.picture_loading_background)
//                .error(R.drawable.picture_loading_background)
//                .into(viewHolder.profileFlatPicture);
        Log.d("Adapter", String.valueOf(R.color.metro1_sokolnicheskaya));
        switch (apartment.getMetroBranch()){
            case 1: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro1_sokolnicheskaya)));
            case 2: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro2_zamoskvoretskaya)));
            case 3: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro3_arbatsko_pokrovskaya)));
            case 4: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro4_philevskaya)));
            case 5: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro5_koltsevaya)));
            case 6: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro6_kaluzhsko_rizhskaya)));
            case 7: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro7_tagansko_krasnopresnenskaya)));
            case 8: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro8_kalininsko_solntsevskaya)));
            case 9: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro9_serpuhovsko_timyryazevskaya)));
            case 10: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro10_lublinskaya)));
            case 11: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro11_BKL)));
            case 12: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro12_butovskaya)));
            case 13: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro13_monorels)));
            case 14: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro14_MTsK)));
            case 15: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro15_nekrasovka)));
            case 16: viewHolder.metroCircle.setBackgroundTintList(ColorStateList.valueOf(context
                    .getResources().getColor(R.color.metro16_comunarskaya)));
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
