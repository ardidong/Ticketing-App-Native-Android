package com.ardidong.ticketingapp.domain.destination.model

data class Destination(
	val destinationClose: String,
	val destinationDescription: String,
	val destinationAddress: String,
	val destinationName: String,
	val destinationOpen: String,
	val latitude: Double,
	val tag: List<String>,
	val destinationId: Int,
	val destinationImageUrl: String,
	val longitude: Double
)

