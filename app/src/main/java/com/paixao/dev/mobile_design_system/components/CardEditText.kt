package com.paixao.dev.mobile_design_system.components

import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.util.Locale

@Composable
fun CardEditText(
    hint: String = ""
) {
    EditTextWithPriority(hint = hint)
}

@Composable
private fun EditTextWithPriority(
    value: String = "",
    hint: String = "teste",
    hasRequired: Boolean = false,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    onChange: (String) -> Unit = {}
) {
    var showHint by remember { mutableStateOf(value.isEmpty()) }
    var hasFocused by remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        keyboardOptions = keyboardOptions,
        visualTransformation = visualTransformation,
        decorationBox = { innerTextField ->
            Box(
                Modifier
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color.White)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                if (hasRequired) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(10.dp, 5.dp),
                        contentAlignment = Alignment.TopEnd
                    ) {
                        Box(
                            modifier = Modifier
                                .clip(RoundedCornerShape(20.dp))
                                .background(Color.Blue)
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
                }

                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(10.dp, 5.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    if (showHint) {
                        Text(
                            text = hint.capitalize(locale = Locale.getDefault()),
                            color = Color.Gray
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
}

@Preview
@Composable
private fun CardEditTextPreview(){
    CardEditText( hint = "hint")
}