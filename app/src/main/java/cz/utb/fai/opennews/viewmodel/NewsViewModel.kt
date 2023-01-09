package com.adastra_one.ageofempires.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import cz.utb.fai.opennews.model.News
import cz.utb.fai.opennews.repository.NewsRepository


class NewsViewModel: ViewModel() {

    var civilizationLiveData: MutableLiveData<News>? =  null

    fun getCivilizations(): LiveData<News>? {
        civilizationLiveData = NewsRepository.getNewsDataApiCall()
        return civilizationLiveData
    }
}