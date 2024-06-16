package com.paixao.dev.mobile_design_system

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.paixao.dev.mobile_design_system.components.CardExhibition
import com.paixao.dev.mobile_design_system.components.TitleSubTitle
import com.paixao.dev.mobile_design_system.ui.theme.MobileDesignSystemTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MobileDesignSystemTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Column {
                        CardExhibition(backgroundColor = MaterialTheme.colorScheme.primary)
                        Spacer(modifier = Modifier.size(10.dp))
                        TitleSubTitle(title = "Olá mundo")
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MobileDesignSystemTheme {
        Column {
            CardExhibition(backgroundColor = MaterialTheme.colorScheme.primary)
            TitleSubTitle(title = "Olá mundo")
        }
    }
}