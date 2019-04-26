package org.styleru.the6hands;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import org.parceler.Parcels;
import org.styleru.the6hands.domain.entities.Apartment;
import org.styleru.the6hands.presentation.apartment.ApartmentFragment;
import org.styleru.the6hands.presentation.authscreen.AuthActivity;
import org.styleru.the6hands.presentation.mainscreen.MainActivity;
import org.styleru.the6hands.presentation.profile.ProfileFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {
    public static final class AuthScreen extends SupportAppScreen {
        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, AuthActivity.class);
        }
    }

    public static final class MainScreen extends SupportAppScreen {

        @Override
        public Intent getActivityIntent(Context context) {
            return new Intent(context, MainActivity.class);
        }
    }

    public static final class ProfileScreen extends SupportAppScreen {

        @Override
        public Fragment getFragment() {
            Bundle bundle = new Bundle();
            ProfileFragment profileFragment = new ProfileFragment();
            profileFragment.setArguments(bundle);
            return profileFragment;
        }
    }

    public static final class ApartmentScreen extends SupportAppScreen {

        private final Apartment apartment;

        public ApartmentScreen(Apartment apartment){
            this.apartment = apartment;
        }

        @Override
        public Fragment getFragment() {
            Bundle bundle = new Bundle();
            bundle.putParcelable("Flat", Parcels.wrap(apartment));
            ApartmentFragment apartmentFragment = new ApartmentFragment();
            apartmentFragment.setArguments(bundle);
            return apartmentFragment;
        }
    }
}
