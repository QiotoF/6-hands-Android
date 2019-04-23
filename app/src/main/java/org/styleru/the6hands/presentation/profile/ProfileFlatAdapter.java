package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.styleru.the6hands.R;
import org.styleru.the6hands.domain.entities.Flat;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ProfileFlatAdapter extends RecyclerView.Adapter<ProfileFlatAdapter.ViewHolder> {

    private List<Flat> data = new ArrayList<>();
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
        Flat flat = data.get(i);
        Glide.with(viewHolder.itemView.getContext())
                .load(flat.getFlatPhotoUrl())
                .into(viewHolder.profileFlatPicture);
        viewHolder.flatInfo.get(0).setBackgroundColor(
                context.getResources().getColor(flat.getMetroBranchColor()));
        viewHolder.flatInfo.get(1).setText(flat.getMetroStation());
        viewHolder.flatInfo.get(2).setText(String.valueOf(flat.getNumberRooms()));
        viewHolder.flatInfo.get(3).setText(String.valueOf(flat.getPrice()));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public void setItems(List<Flat> newData){
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

        @BindViews({R.id.profile_flat_metro_circle, R.id.profile_flat_metro_station,
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
