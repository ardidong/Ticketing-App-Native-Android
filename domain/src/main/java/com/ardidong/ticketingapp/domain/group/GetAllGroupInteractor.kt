package com.ardidong.ticketingapp.domain.group

import com.ardidong.ticketingapp.domain.common.ResultOf
import javax.inject.Inject

class GetAllGroupInteractor @Inject constructor(
    private val repository: GroupRepository
): GetAllGroupUseCase {
    override suspend fun invoke(): ResultOf<List<GroupModel>> {
       return repository.getAllGroup()
    }
}