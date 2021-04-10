package com.vrickey123.jetpackcomposecards.data

import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.PolymorphicJsonAdapterFactory
import com.vrickey123.jetpackcomposecards.data.model.BasilCardTypes
import com.vrickey123.jetpackcomposecards.data.model.BasilTextStyle
import com.vrickey123.jetpackcomposecards.data.model.Card
import com.vrickey123.jetpackcomposecards.data.model.TextComponent

object Serialization {
    private const val OBJECT_TYPE = "type"

    private val defaultOverline = TextComponent(
        text = "Birds of Paradise",
        textStyleKey = BasilTextStyle.OVERLINE
    )

    private val defaultHeadline = TextComponent(
        text = "Lorem ipsum",
        textStyleKey = BasilTextStyle.H5
    )

    private val defaultBody = TextComponent(
        text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor " +
                "incididunt ut labore et dolore magna aliqua.",
        textStyleKey = BasilTextStyle.BODY1
    )

    private val defaultCard = Card.Material(
        id = -1,
        title = defaultHeadline,
        overline = defaultOverline,
        body = defaultBody
    )

    val moshi = buildMoshi()

    internal fun buildMoshi(): Moshi {
        return Moshi.Builder()
            .add(
                PolymorphicJsonAdapterFactory.of(Card::class.java, OBJECT_TYPE)
                    .withSubtype(Card.Material::class.java, BasilCardTypes.material.name)
                    .withSubtype(Card.Thumbnail::class.java, BasilCardTypes.thumbnail.name)
                    .withSubtype(Card.Visual::class.java, BasilCardTypes.visual.name)
                    .withDefaultValue(defaultCard)
            )
            .build()
    }
}