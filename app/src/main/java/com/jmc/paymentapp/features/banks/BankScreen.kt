package com.jmc.paymentapp.features.banks

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
import com.jmc.paymentapp.features.banks.presentation.BankViewModel
import com.jmc.paymentapp.features.banks.presentation.contract.BankContract
import com.jmc.theme.black
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen

//@Preview(showBackground = true)
@Composable
fun BankScreen(navController: NavHostController, idPayment: String) {
    val viewModel = hiltViewModel<BankViewModel>()


    val state = viewModel.viewState.value
    if(state.list.isNullOrEmpty()) {
        viewModel.setEvent(BankContract.Event.IdPayment(idPayment))
    }
    LoadingScreen(isLoading = viewModel.state.isLoading) {
        Content(state = state, navController = navController)
    }
}

@Composable
private fun Content(state: BankContract.State, navController: NavHostController) {
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
                        ItemBankRow(item = state.list[index], onItemClicked = { /*id -> navController.navigate(
                            Screens.BankScreen.route + "?param={$id}")*/
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
                    Text(text = "Monto: $")
//                    Text(text = "asasasasas")

                }
            }
        }

        )
    }
}