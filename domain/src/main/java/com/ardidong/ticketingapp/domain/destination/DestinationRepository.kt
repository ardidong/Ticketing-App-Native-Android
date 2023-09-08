package com.ardidong.ticketingapp.domain.destination

import com.ardidong.ticketingapp.domain.common.ResultOf
import com.ardidong.ticketingapp.domain.destination.model.Destination

interface DestinationRepository {
    suspend fun getDestinations(): ResultOf<List<Destination>>
}