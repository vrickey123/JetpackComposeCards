package com.vrickey123.jetpackcomposecards.data.model

sealed class Card(
    var type: String
) {
    abstract val id: Int
    abstract val title: TextComponent

    data class Material(
        override val id: Int,
        override val title: TextComponent,
        val overline: TextComponent,
        val body: TextComponent
    ): Card(BasilCardTypes.material.name)

    data class Thumbnail(
        override val id: Int,
        override val title: TextComponent,
        val overline: TextComponent,
        val body: TextComponent
    ): Card(BasilCardTypes.thumbnail.name)

    data class Visual(
        override val id: Int,
        override val title: TextComponent,
    ): Card(BasilCardTypes.visual.name)
}
