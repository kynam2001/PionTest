package com.vigelos.piontest.data.model

import com.google.gson.annotations.SerializedName

data class DetailJson(
    @SerializedName("document_id") var documentId: String?,
    @SerializedName("title") var title: String?,
    @SerializedName("description") var description: String?,
    @SerializedName("published_date") var publishedDate: String?,
    @SerializedName("origin_url") var originUrl: String?,
    @SerializedName("publisher") var publisher: Publisher?,
    @SerializedName("template_type") var templateType: String?,
    @SerializedName("sections") var sections: ArrayList<Section>
)

data class PreviewImage (
    @SerializedName("href") var href: String?,
    @SerializedName("main_color") var mainColor: String?,
    @SerializedName("width") var width: Int?,
    @SerializedName("height") var height: Int?
)

data class Markup(
    val markup_type: Int,
    val start: Int,
    val end: Int,
    val href: String? = null
)

sealed class DetailContent {
    data class TextContent(
        val text: String,
        val markups: List<Markup> = emptyList()
    ) : DetailContent()

    data class VideoContent(
        val href: String,
        val caption: String,
        val duration: Int,
        val preview_image: PreviewImage
    ) : DetailContent()

    data class ImageContent(
        val href: String,
        val caption: String,
        val main_color: String,
        val original_width: Int,
        val original_height: Int
    ) : DetailContent()
}

data class Section(
    val section_type: Int,
    val content: DetailContent
)