package com.jmc.paymentapp.features.installments.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jmc.paymentapp.features.installments.presentation.InstallmentViewModel
import com.jmc.paymentapp.features.installments.presentation.contract.InstallmentContract
import com.jmc.paymentapp.navigation.Screens
import com.jmc.theme.black
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen

//@Preview(showBackground = true)
@Composable
fun InstallmentScreen(
    navController: NavHostController,
    monto: String,
    idPayment: String,
    namePayment: String,
    issuerId: String,
    nameBank: String,
    image: String
) {
    val viewModel = hiltViewModel<InstallmentViewModel>()
    val state = viewModel.viewState.value

    if (state.list.isNullOrEmpty()) {
        viewModel.setEvent(
            InstallmentContract.Event.CallInstallments(
                amount = monto,
                idPayment = idPayment,
                issuerId = issuerId
            )
        )
    }
    LoadingScreen(isLoading = viewModel.state.isLoading) {
        Content(
            monto = monto,
            namePayment = namePayment,
            nameBank = nameBank,
            image = image,
            state = state,
            navController = navController
        )
    }
}

@Composable
private fun Content(
    monto: String,
    namePayment: String,
    nameBank: String,
    image: String,
    state: InstallmentContract.State,
    navController: NavHostController
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "Opciones de Cuotas") },
                backgroundColor = colorPrimary,
                navigationIcon = {

                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = white
                        )
                    }

                })

        }, content = {
            Column {
                Text(text = "Seleccione su opcion de cuotas", color = black)
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp)
                ) {
                    items(state.list?.size!!) { index ->
                        ItemInstallmentRow(item = state.list[index], onItemClicked = { msg ->
                            navController.navigate(
                                Screens.ResumeScreen.route +
                                        "?param=$monto,$namePayment,$nameBank,$image,$msg"
                            )
                        })
                    }
                }
            }

        }, bottomBar = {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                    .background(colorPrimary),
                elevation = 5.dp
            ) {
                Column(
                    modifier = Modifier
                        .background(colorPrimary)
                        .padding(start = 10.dp),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(text = "Monto: $monto Medio: $namePayment")
//                    Text(text = "asasasasas")

                }
            }
        }

        )
    }
}