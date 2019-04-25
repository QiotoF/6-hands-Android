package org.styleru.the6hands.presentation.profile;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.arellomobile.mvp.presenter.ProvidePresenter;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import org.styleru.the6hands.R;
import org.styleru.the6hands.SixHandsApplication;
import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.domain.entities.User;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileFragment extends MvpAppCompatFragment implements ProfileView {

    @BindView(R.id.profile_name)
    TextView name;

    @BindView(R.id.profile_pic)
    ImageView profilePic;

    @BindView(R.id.vk_button)
    ImageView vk_button;

    @BindView(R.id.add_facebook_button)
    TextView addFacebookButton;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    @BindView(R.id.profile_recycler_view)
    RecyclerView recyclerView;

    @Inject
    @InjectPresenter
    ProfilePresenter profilePresenter;

    @ProvidePresenter
    ProfilePresenter provideProfilePresenter(){
        return profilePresenter;
    }

    private ProfileFlatAdapter adapter;

    @Override
    public void onAttach(Context context) {
        SixHandsApplication.getAppComponent().inject(this);
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new ProfileFlatAdapter(getContext());
        recyclerView.setAdapter(adapter);
        Glide.with(this)
                .load(R.drawable.ic_plus)
                .into(fab);
        Glide.with(this)
                .load(R.drawable.vk_logo_1)
                .apply(RequestOptions.circleCropTransform())
                .into(vk_button);
        return view;
    }

    @Override
    public void setUser(User user) {
        name.setText(user.getFirstName());
        Glide.with(this).load(user.getPhoto200Url())
                .apply(RequestOptions.circleCropTransform())
                .into(profilePic);
    }

    @Override
    public void showFlats(List<Apartment> data){
        adapter.setItems(data);
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy > 0) fab.hide();
                else fab.show();
            }
        });
    }

    @OnClick(R.id.change_profile_data)
    void onChangeDataClicked(){

    }

    @OnClick(R.id.fab)
    void onFABClicked(){

    }

    @OnClick(R.id.add_facebook_button)
    void onFacebookButtonClicked(){

    }

    @OnClick(R.id.vk_button)
    void onVKButtonClicked(){

    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
