package com.tradingview.lightweightcharts.api.series.models

import com.google.gson.annotations.SerializedName

data class PriceFormat(
    val formatter: String? = null,
    val type: Type? = null,
    val precision: Int? = null,
    val minMove: Float? = null
) {

    enum class Type {
        @SerializedName("price")
        PRICE,
        @SerializedName("volume")
        VOLUME,
        @SerializedName("percent")
        PERCENT,
        @SerializedName("custom")
        CUSTOM
    }

    companion object {

        fun priceFormatBuiltIn(type: Type, precision: Int, minMove: Float): PriceFormat {
            return PriceFormat(type = type, precision = precision, minMove = minMove)
        }

        fun priceFormatCustom(formatter: String, minMove: Float): PriceFormat {
            return PriceFormat(formatter = formatter, minMove = minMove, type = Type.CUSTOM)
        }

    }
}