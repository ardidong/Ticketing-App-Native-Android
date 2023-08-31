package com.ardidong.ticketingapp.domain.common.mapper

interface ResponseToModel<R,M> {
    fun toModel(response: R): M
}