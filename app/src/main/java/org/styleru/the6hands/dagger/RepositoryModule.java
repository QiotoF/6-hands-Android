package org.styleru.the6hands.dagger;

import android.content.Context;

import org.styleru.the6hands.data.repository.UserRepository;
import org.styleru.the6hands.domain.repository.IUserRepository;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;

@Module
abstract class RepositoryModule {

    @Binds
    abstract IUserRepository bindIUserRepository(UserRepository userRepository);
}
