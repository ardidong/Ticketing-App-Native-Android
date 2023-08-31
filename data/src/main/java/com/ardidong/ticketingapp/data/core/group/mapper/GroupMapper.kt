package com.ardidong.ticketingapp.data.core.group.mapper

import com.ardidong.ticketingapp.data.core.group.model.GroupFirebaseResponse
import com.ardidong.ticketingapp.domain.common.mapper.ResponseToModel
import com.ardidong.ticketingapp.domain.common.mapper.SnapshotToResponse
import com.ardidong.ticketingapp.domain.group.GroupModel
import com.google.firebase.firestore.DocumentSnapshot

class GroupMapper :
    ResponseToModel<GroupFirebaseResponse, GroupModel>,
    SnapshotToResponse<DocumentSnapshot, GroupFirebaseResponse>
{
    override fun toModel(response: GroupFirebaseResponse): GroupModel {
        return GroupModel(
            groupId = response.id.orEmpty(),
            groupName = response.groupName.orEmpty(),
            groupDescription = response.groupDescription.orEmpty(),
            groupImageUrl = response.groupImageUrl.orEmpty(),
            groupAddress = response.groupAddress.orEmpty()
        )
    }

    override fun toResponse(snapshot: DocumentSnapshot): GroupFirebaseResponse {
        return GroupFirebaseResponse(
            id = snapshot.id,
            groupAddress = snapshot.getString("groupAddres").orEmpty(),
            groupName = snapshot.getString("groupName").orEmpty(),
            groupImageUrl = snapshot.getString("groupImageUrl").orEmpty(),
            groupDescription = snapshot.getString("groupDescription").orEmpty()
        )
    }

}