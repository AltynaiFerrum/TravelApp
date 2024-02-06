package com.jyldyzferr.travelapp.domain.models

data class ImageDomain(
    val type: String,
    val name: String,
    val url: String
) {
    companion object {
        val unknown = ImageDomain(
            type = String(),
            name = String(),
            url = String(),
        )
    }
}