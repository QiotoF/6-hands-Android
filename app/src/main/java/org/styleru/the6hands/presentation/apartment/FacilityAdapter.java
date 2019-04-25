package org.styleru.the6hands.presentation.apartment;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import org.styleru.the6hands.R;
import org.styleru.the6hands.domain.entities.Facilities;

import java.util.List;

public class FacilityAdapter extends RecyclerView.Adapter<FacilityAdapter.FacilityViewHolder> {

    List<Facilities> facilities;

    public FacilityAdapter(List<Facilities> facilities) {
        this.facilities = facilities;
    }

    @NonNull
    @Override
    public FacilityViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_facility, viewGroup, false);
        return new FacilityViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FacilityViewHolder facilityViewHolder, int i) {
        facilityViewHolder.textView.setText(facilities.get(i).getName());
        facilityViewHolder.imageView.setImageDrawable(Drawable.createFromPath(facilities.get(i).getIcon()));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class FacilityViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textView;

        public FacilityViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_facility);
            textView = itemView.findViewById(R.id.tv_facility);
        }
    }
}
