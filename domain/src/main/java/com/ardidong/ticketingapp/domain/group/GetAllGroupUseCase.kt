package com.ardidong.ticketingapp.domain.group

import com.ardidong.ticketingapp.domain.common.ResultOf

interface GetAllGroupUseCase {
    suspend operator fun invoke(): ResultOf<List<GroupModel>>
}