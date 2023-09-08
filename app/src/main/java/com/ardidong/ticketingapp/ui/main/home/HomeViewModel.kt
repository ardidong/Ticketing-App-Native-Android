package com.ardidong.ticketingapp.ui.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardidong.ticketingapp.domain.group.GetAllGroupUseCase
import com.ardidong.ticketingapp.domain.group.GroupModel
import com.ardidong.ticketingapp.ui.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGroupUseCase: GetAllGroupUseCase
) : ViewModel() {

    private var _groupState: MutableStateFlow<UiState<List<GroupModel>>> = MutableStateFlow(UiState.Loading)
    val groupState: StateFlow<UiState<List<GroupModel>>> get() = _groupState.asStateFlow()

    init {
        viewModelScope.launch(Dispatchers.IO){
            getAllGroupUseCase().fold(
                success = {
                    _groupState.value = UiState.Success(it)
                },
                failure = {
                    _groupState.value = UiState.Error(it)
                }
            )
        }
    }
}