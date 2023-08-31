package com.ardidong.ticketingapp.data.core.group.di

import com.ardidong.ticketingapp.data.core.group.GroupRemoteSource
import com.ardidong.ticketingapp.data.core.group.GroupRemoteSourceImpl
import com.ardidong.ticketingapp.data.core.group.GroupRepositoryImpl
import com.ardidong.ticketingapp.data.core.group.mapper.GroupMapper
import com.ardidong.ticketingapp.domain.group.GroupRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class GroupDataModule {

    @Binds
    abstract fun bindGroupRemoteSource(
        groupRemoteSourceImpl: GroupRemoteSourceImpl
    ): GroupRemoteSource

    @Binds
    abstract fun bindGroupRepository(
        groupRepositoryImpl: GroupRepositoryImpl
    ): GroupRepository
}