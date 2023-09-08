package com.ardidong.ticketingapp.domain.destination

import com.ardidong.ticketingapp.domain.common.ResultOf
import com.ardidong.ticketingapp.domain.destination.model.Destination
import javax.inject.Inject

class GetDestinationInteractor  @Inject constructor(
    private val repository: DestinationRepository
) : GetDestinationUseCase {
    override suspend fun invoke(): ResultOf<List<Destination>> {
        return repository.getDestinations()
    }
}