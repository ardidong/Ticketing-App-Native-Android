package com.ardidong.ticketingapp.data.core.destination.di

import com.ardidong.ticketingapp.data.core.destination.DestinationRepositoryImpl
import com.ardidong.ticketingapp.data.core.destination.GetDestinationRemoteSource
import com.ardidong.ticketingapp.data.core.destination.GetDestinationRemoteSourceImpl
import com.ardidong.ticketingapp.domain.destination.DestinationRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class DestinationDataModule {

    @Binds
    abstract fun bindGetDestinationRemoteSource(
        getDestinationRemoteSourceImpl: GetDestinationRemoteSourceImpl
    ) : GetDestinationRemoteSource

    @Binds
    abstract fun bindDestinationRepository(
        destinationRepositoryImpl: DestinationRepositoryImpl
    ): DestinationRepository
}