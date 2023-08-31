package com.ardidong.ticketingapp.data.core.group

import com.ardidong.ticketingapp.data.core.group.mapper.GroupMapper
import com.ardidong.ticketingapp.data.core.group.model.GroupFirebaseResponse
import com.ardidong.ticketingapp.domain.common.ErrorEntity
import com.ardidong.ticketingapp.domain.common.PathKey
import com.ardidong.ticketingapp.domain.common.ResultOf
import com.google.firebase.firestore.FirebaseFirestore
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class GroupRemoteSourceImpl @Inject constructor(
    private val firestore: FirebaseFirestore,
) : GroupRemoteSource {
    private val mapper = GroupMapper()
    override suspend fun invoke(): ResultOf<List<GroupFirebaseResponse>> = suspendCoroutine{ continuation ->
        firestore.collection(PathKey.GROUP)
            .get()
            .addOnSuccessListener { result ->
                val list = mutableListOf<GroupFirebaseResponse>()
                result.documents.forEach { document ->
                    list.add(mapper.toResponse(document))
                }

                continuation.resume(ResultOf.Success(list))
            }
            .addOnFailureListener {
                it.printStackTrace()
                continuation.resume(ResultOf.Failure(ErrorEntity.RequestFailedError(it.localizedMessage.orEmpty())))
            }
    }
}
