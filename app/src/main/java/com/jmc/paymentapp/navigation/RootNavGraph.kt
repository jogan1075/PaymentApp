package com.jmc.paymentapp.navigation

import com.jmc.splash.SplashNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object RootNavGraph : NavGraphSpec {
    override val route = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute = SplashNavGraph

    override val nestedNavGraphs = listOf(
//        PaymentNa,
//        PeopleNavGraph,
        SplashNavGraph,
//        SettingsNavGraph,
//        LoginNavGraph
    )
}
