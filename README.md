# JetpackComposeCards

This is a proof of concept for a Jetpack Compose card system with JSON-driven card layouts and text styles.

## Card and Text Style Variants
This is expands on the older [AdapterDelegateCards](https://github.com/vrickey123/AdapterDelegateCards) project which used RecyclerView Card Components to acheive the same goals. Many of the Design principles such as separating layout and text style sill apply, so check out the design docs there for reference. It uses the [Basil Material Theme](https://material.io/design/material-studies/basil.html#color) as a foundation for its color and typography.

| [BasilCardTypes](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/BasilCardTypes.kt)  | [BasilTextStyle](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/BasilTextStyle.kt)  |
|---|---|
| Material  | H5  |
| Thumbnail  | H5_SERIF  |
| Basil  | H5_SERIF_LIGHT  |
|   | H5_SERIF_ITALIC  |
|   | H5_SANS_BOLD  |
|   | H6_SANS_BOLD_INVERSE  |
|   |  BODY1 |
|   | BODY1_SERIF  |
|   | BODY1_SANS  |
|   | OVERLINE  |

```kotlin
```

## Card Model
The three Card layouts types - Material, Thumbnail, and Visual - are modeled by a data classes in sealed Card class.

```kotlin
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
```

### TextComponent
The TextComponent contains the text displayed to the user and the BasilTextStyle key discussed below.

```kotlin
data class TextComponent(
    val text: String,
    val textStyleKey: BasilTextStyle
)
```

## Jetpack Compose Card UI
### Material Card
### Thumbnail Card
### Visual Card

## Jetpack Compose Text Style
### BasilTypography Extends MaterialTypography
### TextStyle Extension Function Maps BasilTextStyle

## Client-side vs Server-side styles
This concept can easily be extended to drive styles from the sever by adding fields that could be used to build a Compose TextStyle on the fly. For example:

While very powful, the tradoff with this approach compared to the enum BasilTextStyle text style key used by this sample app is that you would be unable to use any of the static Compose UI Material Theme or Compose Typography features from the Compose libraries.
