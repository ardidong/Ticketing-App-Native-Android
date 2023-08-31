package com.ardidong.ticketingapp.domain.common.mapper

interface SnapshotToResponse<S, R> {
    fun toResponse(snapshot: S): R
}