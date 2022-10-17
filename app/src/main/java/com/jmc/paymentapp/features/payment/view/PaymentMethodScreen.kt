package com.jmc.paymentapp.features.payment.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jmc.paymentapp.features.payment.presentation.PaymentViewModel
import com.jmc.paymentapp.features.payment.presentation.contract.PaymentContract
import com.jmc.paymentapp.navigation.Screens
import com.jmc.theme.black
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen

//@Preview(showBackground = true)
@Composable
fun PaymentMethodScreen(navController: NavHostController, monto: String) {
    val viewModel = hiltViewModel<PaymentViewModel>()
    val state = viewModel.viewState.value

    LoadingScreen(isLoading = viewModel.state.isLoading) {
        Content(monto = monto, state = state, navController = navController)
    }
}

@Composable
private fun Content(monto: String, state: PaymentContract.State, navController: NavHostController) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = "ASASAS") },
                backgroundColor = colorPrimary,
                navigationIcon = {

                    IconButton(onClick = { }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = white
                        )
                    }

                })
        }, content = {
            Column {
                Text(text = "Seleccione el Medio de Pago", color = black)
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp)
                ) {
                    items(state.list?.size!!) { index ->
                        ItemPaymentRow(item = state.list[index], onItemClicked = { id, name ->
                            navController.navigate(
                                Screens.BankListScreen.route + "?param=${id},${name},${monto}"
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
                Column(modifier = Modifier.background(colorPrimary)) {
                    Text(text = "Monto: $" + monto)
//                    Text(text = "asasasasas")

                }
            }
        }

        )
    }
}