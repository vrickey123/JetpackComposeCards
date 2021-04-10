# JetpackComposeCards

This is a proof of concept for a Jetpack Compose card system with JSON-driven card layouts and text styles.

This is expands on the older AdapterDelegateCards project which used RecyclerView Card Components to acheive the same goals. Many of the Design principles such as separating layout and text style sill apply, so check out the design docs there for reference.

## Card and Text Style Variants 

## Card Model

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
