package com.jmc.paymentapp.navigation

import com.jmc.amount.AmountNavGraph
import com.jmc.banks.view.BanksNavGraph
import com.jmc.finished.SuccessNavGraph
import com.jmc.installments.view.InstallmentsNavGraph
import com.jmc.payment.view.PaymentNavGraph
import com.jmc.splash.SplashNavGraph
import com.ramcosta.composedestinations.spec.DestinationSpec
import com.ramcosta.composedestinations.spec.NavGraphSpec

object RootNavGraph : NavGraphSpec {
    override val route = "root"

    override val destinationsByRoute = emptyMap<String, DestinationSpec<*>>()

    override val startRoute = SplashNavGraph

    override val nestedNavGraphs = listOf(
        AmountNavGraph,
        PaymentNavGraph,
        InstallmentsNavGraph,
        SuccessNavGraph,
        BanksNavGraph,
//        PeopleNavGraph,
        SplashNavGraph,
//        SettingsNavGraph,
//        LoginNavGraph
    )
}
