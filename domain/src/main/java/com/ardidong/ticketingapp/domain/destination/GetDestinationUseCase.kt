package com.ardidong.ticketingapp.domain.destination

import com.ardidong.ticketingapp.domain.common.ResultOf
import com.ardidong.ticketingapp.domain.destination.model.Destination

interface GetDestinationUseCase {
    suspend operator fun invoke(): ResultOf<List<Destination>>
}