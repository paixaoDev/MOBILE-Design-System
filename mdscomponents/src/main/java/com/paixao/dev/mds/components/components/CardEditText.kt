package com.paixao.dev.mds.components.components

import android.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.paixao.dev.mdsfoundation.theme.MobileDesignSystemTheme

import java.util.Locale

@Composable
fun CardEditText(
    value: String = "",
    description: String = "",
    hint: String = "",
    required: Boolean = false,
    error: Boolean = false,
    enabled: Boolean = true,
    errorText: String = "",
    errorIcon: Painter? = null,
    cardColor: Color = MaterialTheme.colorScheme.background,
    disabledColor: Color = MaterialTheme.colorScheme.surfaceVariant,
    errorColor: Color = MaterialTheme.colorScheme.error,
    requiredColor: Color = MaterialTheme.colorScheme.onBackground,
    textColor: Color = MaterialTheme.colorScheme.onBackground,
    hintTextColor: Color = MaterialTheme.colorScheme.onBackground,
    disabledTextColor: Color = MaterialTheme.colorScheme.onError,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onChange: (String) -> Unit = {},
) {
    EditTextWithPriority(
        value = value,
        hint = hint,
        description = description,
        cardEnabled = enabled,
        hasRequired = required,
        hasError = error,
        errorText = errorText,
        errorIcon = errorIcon,
        cardColor = cardColor,
        disabledColor = disabledColor,
        errorColor = errorColor,
        requiredColor = requiredColor,
        textColor = textColor,
        hintTextColor = hintTextColor,
        disabledTextColor = disabledTextColor,
        visualTransformation = visualTransformation,
        keyboardOptions = keyboardOptions,
        onChange = onChange
    )
}

@Composable
private fun EditTextWithPriority(
    value: String,
    hint: String,
    description: String,
    cardEnabled: Boolean,
    hasRequired: Boolean,
    hasError: Boolean,
    errorText: String,
    errorIcon: Painter?,
    cardColor: Color,
    disabledColor: Color,
    errorColor: Color,
    requiredColor: Color,
    textColor: Color,
    hintTextColor: Color,
    disabledTextColor: Color,
    visualTransformation: VisualTransformation,
    keyboardOptions: KeyboardOptions,
    onChange: (String) -> Unit
) {
    var showHint by remember { mutableStateOf(value.isEmpty()) }
    var hasFocused by remember { mutableStateOf(false) }

    Column {
        BasicTextField(
            value = value,
            keyboardOptions = keyboardOptions,
            visualTransformation = visualTransformation,
            decorationBox = { innerTextField ->
                Box(
                    Modifier
                        .clip(RoundedCornerShape(10.dp))
                        .background(if (cardEnabled) cardColor else disabledColor)
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    if (hasRequired || hasError) {
                        Box(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(10.dp, 5.dp),
                            contentAlignment = Alignment.TopEnd
                        ) {
                            Row {
                                if (hasRequired) {
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(20.dp))
                                            .background(if (cardEnabled) if (hasError) errorColor else requiredColor else disabledColor)
                                            .padding(6.dp, 2.dp)
                                            .focusable(false),
                                    ) {

                                        Text(
                                            text = if (hasFocused) "i" else "importante",
                                            fontSize = 8.sp,
                                            color = Color.White
                                        )
                                    }
                                }

                                if (hasError && cardEnabled) {
                                    if (errorIcon == null) {
                                        Box(
                                            modifier = Modifier
                                                .clip(RoundedCornerShape(20.dp))
                                                .background(errorColor)
                                                .padding(6.dp, 2.dp)
                                                .focusable(false),
                                        ) {

                                            Text(
                                                text = if (hasFocused) "e" else "errado",
                                                fontSize = 8.sp,
                                                color = Color.White
                                            )
                                        }
                                    } else {
                                        Image(
                                            modifier = Modifier.size(15.dp),
                                            painter = errorIcon, contentDescription = ""
                                        )
                                    }
                                }
                            }
                        }
                    }

                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp, 5.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        if (showHint) {
                            Text(
                                text = hint.replaceFirstChar {
                                    if (it.isLowerCase()) it.titlecase(
                                        locale = Locale.getDefault()
                                    ) else it.toString()
                                },
                                color = if (cardEnabled) hintTextColor else disabledTextColor,
                            )
                        }
                        innerTextField()
                    }

                }
            },
            modifier = Modifier.onFocusChanged {
                hasFocused = it.isFocused
            },
            onValueChange = {
                showHint = it.isEmpty()
                onChange.invoke(it)
            }
        )

        if (hasError && errorText.isNotBlank()) {
            Text(
                text = errorText,
                color = errorColor,
                style = MaterialTheme.typography.bodyMedium
            )
        } else if (description.isNotBlank()) {
            Text(
                text = description,
                color = if (cardEnabled) (if (hasError) errorColor else textColor) else disabledColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CardEditTextPreview() {
    MobileDesignSystemTheme {
        Column {
            CardEditText(
                hint = "normal card - hint",
                description = "card description"
            )
            Spacer(modifier = Modifier.size(10.dp))
            CardEditText(
                hint = "disabled card - hint",
                description = "card description",
                enabled = false
            )
            Spacer(modifier = Modifier.size(10.dp))
            CardEditText(
                hint = "required card - hint",
                description = "card description",
                enabled = true,
                required = true
            )
            Spacer(modifier = Modifier.size(10.dp))
            CardEditText(
                hint = "error card - hint",
                description = "card description",
                errorText = "you make a error here",
                enabled = true,
                error = true,
            )
            Spacer(modifier = Modifier.size(10.dp))
            CardEditText(
                hint = "required error card - hint",
                description = "card description",
                errorText = "you make a error here",
                enabled = true,
                error = true,
                required = true,
                errorIcon = painterResource(id = R.drawable.ic_delete)
            )
        }
    }
}