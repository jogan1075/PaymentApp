package com.jmc.paymentapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.systemuicontroller.SystemUiController
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import com.jmc.paymentapp.navigation.AppNavigationProvider
import com.jmc.paymentapp.navigation.RootNavGraph
import com.jmc.theme.PaymentAppTheme
import com.jmc.theme.PaymentColors
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.dependency
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

//            val isDarkMode = viewModel.themeProvider().shouldUseDarkMode()

            val currentBackStackEntryAsState by navController.currentBackStackEntryAsState()
            val destination = currentBackStackEntryAsState?.destination?.route
                ?: RootNavGraph.startRoute.startRoute.route

            if (destination == RootNavGraph.startRoute.startRoute.route) {
                BackHandler { finish() }
            }

            PaymentAppTheme(darkTheme = false) {
                SetupSystemUi(rememberSystemUiController(), PaymentColors.primary)

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = PaymentColors.background
                ) {
                    DestinationsNavHost(
                        navController = navController,
                        navGraph = RootNavGraph,
                        dependenciesContainerBuilder = {
                            dependency(AppNavigationProvider(navController))
                        }
                    )
                }
            }

        }
    }
}

@Composable
fun SetupSystemUi(
    systemUiController: SystemUiController,
    systemColor: Color
) {
    SideEffect {
        systemUiController.setSystemBarsColor(color = systemColor)
    }
}