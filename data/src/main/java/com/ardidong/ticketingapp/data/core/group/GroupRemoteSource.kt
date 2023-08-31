package com.ardidong.ticketingapp.data.core.group

import com.ardidong.ticketingapp.data.core.group.model.GroupFirebaseResponse
import com.ardidong.ticketingapp.domain.common.ResultOf

interface GroupRemoteSource {
    suspend operator fun invoke(): ResultOf<List<GroupFirebaseResponse>>
}