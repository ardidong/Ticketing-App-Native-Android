package com.ardidong.ticketingapp.data.core.destination

import com.ardidong.ticketingapp.data.core.destination.model.DestinationFirebaseResponse
import com.ardidong.ticketingapp.domain.common.ResultOf

interface GetDestinationRemoteSource {
    suspend operator fun invoke(): ResultOf<List<DestinationFirebaseResponse>>
}