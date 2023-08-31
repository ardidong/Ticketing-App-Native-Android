package com.ardidong.ticketingapp.data.core.group

import com.ardidong.ticketingapp.data.core.group.mapper.GroupMapper
import com.ardidong.ticketingapp.domain.common.ResultOf
import com.ardidong.ticketingapp.domain.group.GroupModel
import com.ardidong.ticketingapp.domain.group.GroupRepository
import javax.inject.Inject

class GroupRepositoryImpl @Inject constructor(
    private val groupRemoteSource: GroupRemoteSource,
) : GroupRepository {
    private val mapper = GroupMapper()
    override suspend fun getAllGroup(): ResultOf<List<GroupModel>> {
        return groupRemoteSource().fold(
            success = { list ->
                ResultOf.Success(list.map { mapper.toModel(it) })
            },
            failure = {
                ResultOf.Failure(it)
            }
        )
    }
}