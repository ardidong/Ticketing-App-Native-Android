package com.ardidong.ticketingapp.data.core.destination

import com.ardidong.ticketingapp.data.core.destination.mapper.DestinationFirebaseMapper
import com.ardidong.ticketingapp.domain.common.ResultOf
import com.ardidong.ticketingapp.domain.destination.DestinationRepository
import com.ardidong.ticketingapp.domain.destination.model.Destination
import javax.inject.Inject

class DestinationRepositoryImpl @Inject constructor(
    private val getDestinationRemoteSource: GetDestinationRemoteSource
) : DestinationRepository {

    private val mapper = DestinationFirebaseMapper()
    override suspend fun getDestinations(): ResultOf<List<Destination>> {
        return getDestinationRemoteSource().fold(
            success = { list ->
                ResultOf.Success(list.map { mapper.toModel(it)})
            },
            failure = { ResultOf.Failure(it)} )
    }
}