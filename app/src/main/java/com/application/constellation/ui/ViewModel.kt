package com.application.constellation.ui

import androidx.lifecycle.ViewModel
import com.application.constellation.data.DataHolder

class ViewModel(): ViewModel() {

    private lateinit var item: DataHolder

    fun setItem(dataHolder: DataHolder) {
        item = dataHolder
    }

    fun showDetails(): DataHolder = item

}