package com.tradingview.lightweightcharts.example.app.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tradingview.lightweightcharts.api.series.common.SeriesData
import com.tradingview.lightweightcharts.example.app.model.Data
import com.tradingview.lightweightcharts.example.app.model.SeriesDataType
import com.tradingview.lightweightcharts.example.app.repository.DynamicRepository
import com.tradingview.lightweightcharts.example.app.repository.StaticRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val staticRepository = StaticRepository()
    private val dynamicRepository = DynamicRepository()
    private var dataType: SeriesDataType = SeriesDataType.AREA

    private val data: MutableLiveData<Data> by lazy {
        MutableLiveData<Data>().also {
            loadData()
        }
    }

    val seriesData: LiveData<Data>
        get() = data

    val seriesFlow: Flow<SeriesData>
        get() = dynamicRepository.getListSeriesData()

    fun loadData() {
        viewModelScope.launch {
            when(dataType) {
                SeriesDataType.AREA -> {
                    val areaSeriesData = staticRepository.getListAreaSeriesData()
                    data.postValue(Data(areaSeriesData, SeriesDataType.AREA))
                }
                SeriesDataType.HISTOGRAM -> {
                    val histogramData = staticRepository.getListHistogramSeriesData()
                    data.postValue(Data(histogramData, SeriesDataType.HISTOGRAM))
                }
                SeriesDataType.BAR -> {
                    val barData = staticRepository.getListBarSeriesData()
                    data.postValue(Data(barData, SeriesDataType.BAR))
                }
                SeriesDataType.CANDLESTICK -> {
                    val candlestickData = staticRepository.getListCandlestickSeriesData()
                    data.postValue(Data(candlestickData, SeriesDataType.CANDLESTICK))
                }
                SeriesDataType.LINE -> {
                    val lineData = staticRepository.getListLineSeriesData()
                    data.postValue(Data(lineData, SeriesDataType.LINE))
                }
            }

        }
    }

    fun selectSeries(seriesDataType: SeriesDataType) {
        dataType = seriesDataType
        loadData()
    }
}