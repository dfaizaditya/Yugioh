package com.submission.yugioh

import androidx.lifecycle.ViewModel
import com.submission.yugioh.repository.Repository

class MainViewModel(private val repository: Repository): ViewModel() {
    fun getData() = repository.getData()
}