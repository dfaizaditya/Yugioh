package com.submission.yugioh.model

import com.beust.klaxon.*

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

data class Card (
    val id: Long,
    val name: String,
    val type: String,
    val desc: String,
    val atk: Long? = null,
    val def: Long? = null,
    val level: Long? = null,
    val race: String,
    val attribute: String? = null,
    val archetype: String,

    @Json(name = "card_images")
    val cardImages: List<CardImage>,

    @Json(name = "card_prices")
    val cardPrices: List<CardPrice>
)

data class CardImage (
    val id: Long,

    @Json(name = "image_url")
    val imageURL: String,

    @Json(name = "image_url_small")
    val imageURLSmall: String
)

data class CardPrice (
    @Json(name = "cardmarket_price")
    val cardmarketPrice: String,

    @Json(name = "tcgplayer_price")
    val tcgplayerPrice: String,

    @Json(name = "ebay_price")
    val ebayPrice: String,

    @Json(name = "amazon_price")
    val amazonPrice: String,

    @Json(name = "coolstuffinc_price")
    val coolstuffincPrice: String
)

data class Meta (
    @Json(name = "current_rows")
    val currentRows: Long,

    @Json(name = "total_rows")
    val totalRows: Long,

    @Json(name = "rows_remaining")
    val rowsRemaining: Long,

    @Json(name = "total_pages")
    val totalPages: Long,

    @Json(name = "pages_remaining")
    val pagesRemaining: Long,

    @Json(name = "next_page")
    val nextPage: String,
)