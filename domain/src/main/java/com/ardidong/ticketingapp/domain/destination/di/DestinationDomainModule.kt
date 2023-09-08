package com.ardidong.ticketingapp.domain.destination.di

import com.ardidong.ticketingapp.domain.destination.GetDestinationUseCase
import com.ardidong.ticketingapp.domain.destination.GetDestinationInteractor
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DestinationDomainModule {

    @Binds
    abstract fun bindGetDestination(
        getDestinationInteractor: GetDestinationInteractor
    ): GetDestinationUseCase
}