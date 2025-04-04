package com.vigelos.piontest.data.model

import com.google.gson.annotations.SerializedName

data class NewFeedJson(
    @SerializedName("items") val items: List<Item>
)

data class Item(
    @SerializedName("document_id") val documentId: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String?,
    @SerializedName("content_type") val contentType: String,
    @SerializedName("published_date") val publishedDate: String,
    @SerializedName("publisher") val publisher: Publisher,
    @SerializedName("origin_url") val originUrl: String,
    @SerializedName("avatar") val avatar: Image?,
    @SerializedName("images") val images: List<Image>?,
    @SerializedName("content") val content: Content?
)

data class Publisher(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("icon") val icon: String
)

data class Image(
    @SerializedName("href") val href: String,
    @SerializedName("main_color") val mainColor: String?,
    @SerializedName("width") val width: Int?,
    @SerializedName("height") val height: Int?
)

data class Content(
    val href: String,
    @SerializedName("preview_image") val previewImage: Image,
    val duration: Int
)


