package com.jmc.banks.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jmc.banks.presentation.BankViewModel
import com.jmc.navigation.NavigationProvider
import com.jmc.paymentapp.features.banks.presentation.contract.BankContract
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen
import com.jmc.utils.R.string
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun BankScreen(
    navigator: NavigationProvider,
    idPayment: String,
    amount: String,
    namePayment: String
) {
    val viewModel = hiltViewModel<BankViewModel>()


    val state = viewModel.viewState.value
    if (state.list.isNullOrEmpty()) {
        viewModel.setEvent(BankContract.Event.IdPayment(idPayment))
    }
    LoadingScreen(isLoading = viewModel.state.isLoading) {
        Content(
            state = state,
            navigator = navigator,
            amount = amount,
            idPayment = idPayment,
            namePayment = namePayment
        )
    }
}

@Composable
private fun Content(
    state: BankContract.State,
    navigator: NavigationProvider,
    amount: String,
    idPayment: String,
    namePayment: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = stringResource(string.title_bank)) },
                backgroundColor = colorPrimary,
                navigationIcon = {

                    IconButton(onClick = { navigator.navigateUp() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = "Back",
                            tint = white
                        )
                    }

                })
        }, content = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(string.subtitle_bank),
                        style = MaterialTheme.typography.h6.copy(fontSize = 18.sp),
                        modifier = Modifier
                            .padding(top = 10.dp),
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(5.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp)
                ) {
                    items(state.list?.size!!) { index ->
                        ItemBankRow(
                            item = state.list[index],
                            onItemClicked = { idIssuer, img, nameBank ->

                                navigator.navigateToInstallments(
                                    idPayment,
                                    amount,
                                    idIssuer,
                                    namePayment,
                                    nameBank,
                                    img
                                )
                                /*navController.navigate(
                                    Screens.InstallmentsScreen.route +
                                            "?param=$idPayment,$amount,$idIssuer,$namePayment,$nameBank,$img"
                                )*/
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
                    Text(
                        text = stringResource(string.txt_amount) + amount
                                + " " + stringResource(string.txt_payment) + namePayment
                    )
                }
            }
        }

        )
    }
}