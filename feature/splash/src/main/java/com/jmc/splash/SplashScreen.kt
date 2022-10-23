package com.jmc.splash

import android.view.animation.OvershootInterpolator
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.jmc.navigation.NavigationProvider
import com.jmc.theme.PaymentAppTheme
import com.ramcosta.composedestinations.annotation.Destination
import kotlinx.coroutines.delay


@Destination(start = true)
@Composable
fun SplashScreenView(navigator: NavigationProvider) {
    val scale = remember {
        Animatable(0f)
    }
    val overshootInterpolator = remember {
        OvershootInterpolator(2f)
    }
    LaunchedEffect(key1 = true) {
        scale.animateTo(
            targetValue = 0.5f,
            animationSpec = tween(
                durationMillis = 500,
                easing = {
                    overshootInterpolator.getInterpolation(it)
                }
            )
        )
        delay(0L)
        navigator.navigateToAmount()
    }
    DefaultPreviewLogin()
}


@Preview(showBackground = true, backgroundColor = 0xFFFFFFFF)
@Composable
fun DefaultPreviewLogin() {
    PaymentAppTheme(darkTheme = false) {

        Scaffold(backgroundColor = MaterialTheme.colors.primary,
            content = {
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "PAYMENTAPP",
                        style = MaterialTheme.typography.h4,
                        color = MaterialTheme.colors.secondary,
                        textAlign = TextAlign.Center,

                    )

                }
            }
        )
    }
}