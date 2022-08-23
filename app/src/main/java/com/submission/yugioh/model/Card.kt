package com.submission.yugioh.model

import android.os.Parcelable
import com.beust.klaxon.*
import kotlinx.parcelize.Parcelize

private val klaxon = Klaxon()

data class DataResponse (
    val data: List<Card>,
    val meta: Meta
) {
    public fun toJson() = klaxon.toJsonString(this)

    companion object {
        public fun fromJson(json: String) = klaxon.parse<DataResponse>(json)
    }
}

@Parcelize
data class Card (
    val id: Long,
    val name: String,
    val type: String,
    val desc: String,
    val atk: Long? = null,
    val def: Long? = null,
    val level: Long? = null,
    val race: String? = null,
    val attribute: String? = null,
    val archetype: String? = null,

    @Json(name = "card_images")
    val card_images: List<CardImage>? = null,

    @Json(name = "card_prices")
    val card_prices: List<CardPrice>? = null
): Parcelable

@Parcelize
data class CardImage (
    val id: Long,

    @Json(name = "image_url")
    val image_url: String,

    @Json(name = "image_url_small")
    val image_url_small: String
): Parcelable

@Parcelize
data class CardPrice (
    @Json(name = "cardmarket_price")
    val cardmarket_price: String,

    @Json(name = "tcgplayer_price")
    val tcgplayer_price: String,

    @Json(name = "ebay_price")
    val ebay_price: String,

    @Json(name = "amazon_price")
    val amazon_price: String,

    @Json(name = "coolstuffinc_price")
    val coolstuffinc_price: String
): Parcelable

@Parcelize
data class Meta (
    @Json(name = "current_rows")
    val current_rows: Long,

    @Json(name = "total_rows")
    val total_rows: Long,

    @Json(name = "rows_remaining")
    val rows_remaining: Long,

    @Json(name = "total_pages")
    val total_pages: Long,

    @Json(name = "pages_remaining")
    val pages_remaining: Long,

    @Json(name = "next_page")
    val next_page: String,
): Parcelable