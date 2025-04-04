package com.vigelos.piontest.utils

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import com.vigelos.piontest.data.model.Content
import com.vigelos.piontest.data.model.DetailContent
import com.vigelos.piontest.data.model.Section
import java.lang.reflect.Type

class SectionDeserializer : JsonDeserializer<Section> {
    override fun deserialize(json: JsonElement, typeOfT: Type, context: JsonDeserializationContext): Section {
        val jsonObject = json.asJsonObject
        val sectionType = jsonObject["section_type"].asInt
        val contentObj = jsonObject["content"]

        val detailContent: DetailContent = when (sectionType) {
            1 -> context.deserialize(contentObj, DetailContent.TextContent::class.java)
            2 -> context.deserialize(contentObj, DetailContent.VideoContent::class.java)
            3 -> context.deserialize(contentObj, DetailContent.ImageContent::class.java)
            else -> throw JsonParseException("Unknown section type: $sectionType")
        }

        return Section(section_type = sectionType, content = detailContent)
    }
}