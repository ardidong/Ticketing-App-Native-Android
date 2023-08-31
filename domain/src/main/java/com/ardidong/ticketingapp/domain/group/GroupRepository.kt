package com.ardidong.ticketingapp.domain.group

import com.ardidong.ticketingapp.domain.common.ResultOf

interface GroupRepository {
    suspend fun getAllGroup(): ResultOf<List<GroupModel>>
}