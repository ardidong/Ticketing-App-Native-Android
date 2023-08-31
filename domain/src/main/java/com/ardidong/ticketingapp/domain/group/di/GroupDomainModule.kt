package com.ardidong.ticketingapp.domain.group.di

import com.ardidong.ticketingapp.domain.group.GetAllGroupInteractor
import com.ardidong.ticketingapp.domain.group.GetAllGroupUseCase
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
abstract class GroupDomainModule {

    @Binds
    abstract fun bindGetAllGroupUseCase(
        getAllGroupInteractor: GetAllGroupInteractor
    ): GetAllGroupUseCase
}