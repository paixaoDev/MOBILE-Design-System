package com.paixao.dev.mobile_design_system.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.DefaultAlpha
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.paixao.dev.mobile_design_system.ui.theme.MobileDesignSystemTheme
/**
 *  A card that's can exhibit a [Image] with a description [Text]. This can exhibit just with a
 *  background [Color] without a [Text]. Modify the **CardExhibition** class in case
 *  to change the default tokens.
 */
@Composable
fun CardExhibition(
    image: Painter? = null,
    description: String = "",
    enabled: Boolean = true,
    cardWidth: Dp = 300.dp,
    cardHeight: Dp = 150.dp,
    descriptionTextColor: Color = MaterialTheme.colorScheme.onBackground,
    disabledDescriptionTextColor: Color = MaterialTheme.colorScheme.tertiary,
    backgroundColor: Color = MaterialTheme.colorScheme.background,
    disabledColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    onClick: () -> Unit
) {
    CardExhibitionCompose(
        image = image,
        descriptionText = description,
        width = cardWidth,
        height = cardHeight,
        cardEnabled = enabled,
        descriptionTextColor = descriptionTextColor,
        disabledDescriptionTextColor = disabledDescriptionTextColor,
        backgroundColor = backgroundColor,
        disabledBackgroundColor = disabledColor
    ) {
        onClick.invoke()
    }
}

@Composable
private fun CardExhibitionCompose(
    image: Painter?,
    descriptionText: String,
    cardEnabled: Boolean,
    width: Dp,
    height: Dp,
    descriptionTextColor: Color,
    disabledDescriptionTextColor: Color,
    backgroundColor: Color,
    disabledBackgroundColor: Color,
    onClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .size(width, height)
            .clickable {
                onClick.invoke()
            },
        colors = CardDefaults.cardColors(
            containerColor = if (cardEnabled) backgroundColor else disabledBackgroundColor,
        )
    )
    {
        Box {
            image?.let {
                Image(
                    painter = image,
                    contentDescription = "",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                    alpha = if (cardEnabled) DefaultAlpha else 0.3f
                )
            }
            Box(modifier = Modifier.padding(10.dp)) {
                if (descriptionText.isNotBlank()) {
                    Text(
                        text = descriptionText,
                        color = if (cardEnabled) descriptionTextColor else disabledDescriptionTextColor,
                        style = MaterialTheme.typography.titleMedium
                    )
                }
            }
        }
    }
}


@Preview(apiLevel = 30)
@Composable
private fun CardExhibitionPreview() {
    MobileDesignSystemTheme {
        CardExhibition(
            description = "Olá mundo"
        ) {}
    }
}