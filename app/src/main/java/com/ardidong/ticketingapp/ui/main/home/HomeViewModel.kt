package com.ardidong.ticketingapp.ui.main.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ardidong.ticketingapp.domain.group.GetAllGroupUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllGroupUseCase: GetAllGroupUseCase
) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO){
            getAllGroupUseCase().fold(
                success = {
                    it.forEach{
                        Log.d("TELO",it.toString())
                    }
                },
                failure = {}
            )
        }
    }
}