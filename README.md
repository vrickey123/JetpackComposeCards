
# JetpackComposeCards

<img src="https://github.com/vrickey123/JetpackComposeCards/blob/develop/docs/cards-compressed.gif" width="360">

This is a proof of concept for a Jetpack Compose card system with JSON-driven card layouts and text styles.

## Card and Text Style Variants
This is expands on the older [AdapterDelegateCards](https://github.com/vrickey123/AdapterDelegateCards) project which used RecyclerView Card Components to acheive the same goal: reuse three card layouts with many text styles to compose variants. 

Many of the **design engineering principles such as [separating layout and text style](https://github.com/vrickey123/AdapterDelegateCards#separating-layout-style-and-text-style)** sill apply, so check out AdapterDelegateCards docs for reference. 

This app uses the [Basil Material Theme](https://material.io/design/material-studies/basil.html#color) as a foundation for its color and typography.

| [BasilCardTypes](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/BasilCardTypes.kt)  | [BasilTextStyles](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/BasilTextStyle.kt)  |
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

### Examples
#### Material Card x Overline Text x H5 Title Text x Body1 Text
![Material Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/docs/material-card-1.png)

#### Thumbnail Card x Overline Text x H5 Serif Light Title Text x Body1Sans Text
![Thumbnail Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/docs/thumbnail-card-3.png)

#### Visual Card x H6 Sans Bold Inverse Title Text
![Visual Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/docs/visual-card-2.png)

## [Card Model](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/Card.kt)
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

### [TextComponent](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/data/model/TextComponent.kt)
The TextComponent contains the text displayed to the user and the BasilTextStyle key discussed below.

```kotlin
data class TextComponent(
    val text: String,
    val textStyleKey: BasilTextStyle
)
```

### Cards.json and PolymorphicJsonAdapterFactory
The Material, Thumbnail, and Visual cards are represented in [JSON](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/assets/cards.json) below. They are parsed into their concrete types using Moshi's [PolymorphicJsonAdapterFactory](https://github.com/vrickey123/JetpackComposeCards/blob/51c918d2c4bcf6d91fedc7c255664dbce4a9afe4/app/src/main/java/com/vrickey123/jetpackcomposecards/data/Serialization.kt#L53-L57).
```json
  {
    "id": 1,
    "type": "material",
    "title": {
      "text": "Lorem ipsum",
      "textStyleKey": "h5"
    },
    "body": {
      "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      "textStyleKey": "body1"
    },
    "overline": {
      "text": "Birds of Paradise",
      "textStyleKey": "overline"
    }
  },
  {
    "id": 2,
    "type": "visual",
    "title": {
      "text": "Lorem ipsum",
      "textStyleKey": "h6SansBoldInverse"
    }
  },
  {
    "id": 3,
    "type": "thumbnail",
    "title": {
      "text": "Lorem ipsum",
      "textStyleKey": "h5SerifLight"
    },
    "body": {
      "text": "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
      "textStyleKey": "body1Sans"
    },
    "overline": {
      "text": "Friends",
      "textStyleKey": "overline"
    }
  },
```

## Jetpack Compose Card UI
The Composable functions for each of the `Card` types takes `TextComponent`'s as their parameters which set the user-facing text and text style in the implementation. 

### [Material Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/ui/cards/MaterialCard.kt)
```kotlin
@Composable
fun MaterialCard(
    overline: TextComponent,
    title: TextComponent,
    body: TextComponent
) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column {
            // 3/2 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(1.5F),
                painter = painterResource(id = R.drawable.bird_of_paradise),
                contentDescription = "Bird of paradise stretching wings on a tree branch",
                contentScale = ContentScale.FillBounds
            )
            // An inner column is needed to set the padding for the text content
            // so that the image is full-bleed
            Column(
                modifier = Modifier.padding(
                    horizontal = MaterialInnerHorizontalPadding,
                    vertical = MaterialInnerVerticalPadding
                )
            ) {
                Text(text = overline.text, style = TextStyle.build(overline.textStyleKey))
                Text(text = title.text, style = TextStyle.build(title.textStyleKey))
                Text(text = body.text, style = TextStyle.build(body.textStyleKey))
            }
        }
    }
}
```
### [Thumbnail Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/ui/cards/ThumbnailCard.kt)
```kotlin
@Composable
fun ThumbnailCard(
    overline: TextComponent,
    title: TextComponent,
    body: TextComponent
) {
    Card(Modifier.fillMaxWidth()) {
        Row(
            Modifier.padding(
                horizontal = MaterialInnerHorizontalPadding,
                vertical = MaterialInnerVerticalPadding
            )
        ) {
            Column() {
                Image(
                    modifier = Modifier
                        .height(75.dp)
                        .width(75.dp),
                    painter = painterResource(id = R.drawable.bird_parrots_hugging),
                    contentScale = ContentScale.Crop,
                    contentDescription = "Two green parrots hugging",
                )
            }
            Spacer(modifier = Modifier.width(20.dp))
            Column {
                Text(text = overline.text, style = TextStyle.build(overline.textStyleKey))
                Text(text = title.text, style = TextStyle.build(title.textStyleKey))
                Text(text = body.text, style = TextStyle.build(body.textStyleKey))
            }
        }
    }
}
```
### [Visual Card](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/ui/cards/VisualCard.kt)
```kotlin

@Composable
fun VisualCard(
    title: TextComponent
) {
    val verticalGradientBrush = Brush.verticalGradient(
        colors = listOf(
            Color.Transparent,
            Color(0xeeeeee),
            Color(0xee000000),
        )
    )
    Card() {
        Box(contentAlignment = Alignment.BottomStart) {
            // 4/3 aspect ratio
            Image(
                modifier = Modifier
                    .aspectRatio(0.75F),
                painter = painterResource(id = R.drawable.bird_green_parrot),
                contentScale = ContentScale.Crop,
                contentDescription = "Green parrot looking at camera on a tree branch"
            )
            Box(modifier = Modifier.background(verticalGradientBrush)
                .matchParentSize()
                .zIndex(2f))
            Text(
                modifier = Modifier.zIndex(3f)
                    .padding(
                        horizontal = MaterialInnerHorizontalPadding,
                        vertical = MaterialInnerHorizontalPadding
                    ),
                text = title.text,
                style = TextStyle.build(title.textStyleKey)
            )
        }
    }
}
```

## Jetpack Compose Text Style
### [BasilTypography](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/ui/theme/typography/Type.kt) Extends MaterialTypography
To add new text styles and extend from ones that already exist in the Compose UI Material library, `BasilType` wraps Material `Typography`.

```kotlin
@Immutable
data class BasilType(
    val materialTypography: Typography = Typography,
    val h5SerifLight: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Normal
    ),
    val h5SerifLightItalic: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Light,
        fontStyle = FontStyle.Italic
    ),
    val h5Serif: TextStyle = Typography.h5.copy(
        fontFamily = Merriweather,
        fontWeight = FontWeight.Normal,
        fontStyle = FontStyle.Normal,
    ),
...
```

### [TextStyle Extension Function](https://github.com/vrickey123/JetpackComposeCards/blob/develop/app/src/main/java/com/vrickey123/jetpackcomposecards/extensions/TextStyleExtensions.kt) Maps BasilTextStyle
A `TextStyle#build` extension function maps the `BasilTextStyle` to a static Compose `TextStyle` resource. This is how a `TextComponent#textStyleKey` drives a style.

```kotlin
fun TextStyle.Companion.build(
    textStyleKey: BasilTextStyle
): TextStyle {
    return when (textStyleKey) {
        BasilTextStyle.H5 -> BasilTypography.materialTypography.h5
        BasilTextStyle.H5_SERIF -> BasilTypography.h5Serif
        BasilTextStyle.H5_SERIF_LIGHT -> BasilTypography.h5SerifLight
        BasilTextStyle.H5_SERIF_ITALIC -> BasilTypography.h5SerifItalic
        BasilTextStyle.H5_SANS_BOLD -> BasilTypography.h6SansBold
        BasilTextStyle.H6_SANS_BOLD_INVERSE -> BasilTypography.h6SansBoldInverse
        BasilTextStyle.BODY1 -> BasilTypography.materialTypography.body1
        BasilTextStyle.BODY1_SERIF -> BasilTypography.body1Serif
        BasilTextStyle.BODY1_SANS -> BasilTypography.body1Sans
        BasilTextStyle.OVERLINE -> Typography.overline
    }
}
```

## Client-side vs Server-side styles
This concept can easily be extended to drive styles from the sever by adding fields that could be used to build a Compose TextStyle on the fly. For example:

```json
 {
    "id": 1,
    "type": "material",
    "title": {
      "text": "Lorem ipsum",
      "textStyle": {
        "fontFamily": "Merriweather",
        "fontWeight": 300,
        "fontStyle": "Normal",
        "fontSize": 24,
        "lineHeight": 26
      }
    },
```

The tradoff with this approach compared to the `enum BasilTextStyle` text style key used by this sample app is that you would be unable to use any of the static Compose UI Material Theme or Compose Typography features from the Compose libraries. Instead all of the styles would be dynamically generated. This could have some consequences for your themes and make your app harder to maintain.
