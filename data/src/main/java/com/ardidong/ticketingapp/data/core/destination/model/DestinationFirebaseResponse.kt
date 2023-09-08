package com.ardidong.ticketingapp.data.core.destination.model

data class DestinationFirebaseResponse(
	val destinationClose: String? = null,
	val destinationDescription: String? = null,
	val destinationAddress: String? = null,
	val destinationName: String? = null,
	val destinationOpen: String? = null,
	val latitude: Double? = null,
	val tag: List<String?>? = null,
	val destinationId: Int? = null,
	val destinationImageUrl: String? = null,
	val longitude: Double? = null
)

