package com.tradingview.lightweightcharts.api.options.models

import com.tradingview.lightweightcharts.api.options.common.HistogramStyleOptions
import com.tradingview.lightweightcharts.api.series.enums.LineStyle
import com.tradingview.lightweightcharts.api.series.enums.LineWidth
import com.tradingview.lightweightcharts.api.series.models.PriceFormat

data class HistogramSeriesOptions(
    override val title: String? = null,
    override val lastValueVisible: Boolean? = null,
    override val priceLineVisible: Boolean? = null,
    override val priceLineWidth: LineWidth? = null,
    override val priceLineColor: String? = null,
    override val priceLineStyle: LineStyle? = null,
    override val priceFormat: PriceFormat? = null,
    override val baseLineVisible: Boolean? = null,
    override val baseLineColor: String? = null,
    override val baseLineWidth: LineWidth? = null,
    override val baseLineStyle: LineStyle? = null,

    override val color: String? = null,
    override val base: Float? = null,
    override val overlay: Boolean = false,
    override val scaleMargins: PriceScaleMargins? = null
): SeriesOptionsCommon, HistogramStyleOptions
