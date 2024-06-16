package com.paixao.dev.mobile_design_system.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview

enum class TitleSize {
    Small,
    Medium,
    Large
}

/**
 *  A **Title** and **Subtitle** component, the [TitleSize] determine the size of title and subtitle
 *  in same time. Modify the [CardExhibition] class in case
 *  to change the default values.
 *
 *  version 1.0.0
 */
@Composable
fun TitleSubTitle(
    title: String,
    description: String = "",
    size: TitleSize = TitleSize.Large,
    titleColor: Color = MaterialTheme.colorScheme.primary,
    descriptionColor: Color = MaterialTheme.colorScheme.secondary,
    titleSmallStyle: TextStyle = MaterialTheme.typography.titleSmall,
    titleMediumStyle: TextStyle = MaterialTheme.typography.titleMedium,
    titleLargeStyle: TextStyle = MaterialTheme.typography.titleLarge,
    subtitleSmallStyle: TextStyle = MaterialTheme.typography.bodySmall,
    subtitleMediumStyle: TextStyle = MaterialTheme.typography.bodyMedium,
    subtitleLargeStyle: TextStyle = MaterialTheme.typography.bodyLarge,
) {
    TittleAndSubtitleCompose(
        title = title,
        titleColor = titleColor,
        description = description,
        descriptionColor = descriptionColor,
        size = size,
        titleSmallStyle = titleSmallStyle,
        titleMediumStyle = titleMediumStyle,
        titleLargeStyle = titleLargeStyle,
        subtitleSmallStyle = subtitleSmallStyle,
        subtitleMediumStyle = subtitleMediumStyle,
        subtitleLargeStyle = subtitleLargeStyle
    )
}

@Composable
private fun TittleAndSubtitleCompose(
    title: String,
    titleColor: Color,
    description: String = "",
    descriptionColor: Color,
    size: TitleSize = TitleSize.Medium,
    titleSmallStyle: TextStyle,
    titleMediumStyle: TextStyle,
    titleLargeStyle: TextStyle,
    subtitleSmallStyle: TextStyle,
    subtitleMediumStyle: TextStyle,
    subtitleLargeStyle: TextStyle,
) {
    Column {
        Text(
            text = title,
            color = titleColor,
            style = when (size) {
                TitleSize.Small -> titleSmallStyle
                TitleSize.Medium -> titleMediumStyle
                TitleSize.Large -> titleLargeStyle
            }
        )
        if (description.isNotBlank()) {
            Text(
                text = description,
                color = descriptionColor,
                style = when (size) {
                    TitleSize.Small -> subtitleSmallStyle
                    TitleSize.Medium -> subtitleMediumStyle
                    TitleSize.Large -> subtitleLargeStyle
                }
            )
        }
    }
}

@Preview
@Composable
private fun TitleSubTitlePreview() {
    TitleSubTitle(
        title = "Olá Mundo",
        description = "Como vai amigão?"
    )
}