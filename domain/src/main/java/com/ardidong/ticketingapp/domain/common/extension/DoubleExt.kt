package com.ardidong.ticketingapp.domain.common.extension

fun Double?.orMinus() : Double = this ?: (-1).toDouble()