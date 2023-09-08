package com.ardidong.ticketingapp.data.core.destination.mapper

import com.ardidong.ticketingapp.data.core.destination.model.DestinationFirebaseResponse
import com.ardidong.ticketingapp.domain.common.extension.orMinus
import com.ardidong.ticketingapp.domain.common.mapper.ResponseToModel
import com.ardidong.ticketingapp.domain.destination.model.Destination

class DestinationFirebaseMapper :
    ResponseToModel<DestinationFirebaseResponse, Destination>
{
    override fun toModel(response: DestinationFirebaseResponse): Destination {
        return Destination(
            destinationId = response.destinationId.orMinus(),
            destinationName = response.destinationName.orEmpty(),
            destinationDescription = response.destinationDescription.orEmpty(),
            destinationAddress = response.destinationAddress.orEmpty(),
            destinationImageUrl = response.destinationImageUrl.orEmpty(),
            destinationOpen = response.destinationOpen.orEmpty(),
            destinationClose = response.destinationClose.orEmpty(),
            latitude = response.latitude.orMinus(),
            longitude = response.longitude.orMinus(),
            tag = response.tag?.map { it.orEmpty() }.orEmpty()
        )
    }
}