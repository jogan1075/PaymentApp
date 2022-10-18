package com.jmc.paymentapp.features.banks.view

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
import androidx.navigation.NavHostController
import com.jmc.paymentapp.R
import com.jmc.paymentapp.features.banks.presentation.BankViewModel
import com.jmc.paymentapp.features.banks.presentation.contract.BankContract
import com.jmc.paymentapp.navigation.Screens
import com.jmc.theme.black
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen

@Composable
fun BankScreen(
    navController: NavHostController,
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
            navController = navController,
            amount = amount,
            idPayment = idPayment,
            namePayment = namePayment
        )
    }
}

@Composable
private fun Content(
    state: BankContract.State,
    navController: NavHostController,
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
                title = { Text(text = stringResource(R.string.title_bank)) },
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
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.subtitle_bank),
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
                                navController.navigate(
                                    Screens.InstallmentsScreen.route +
                                            "?param=$idPayment,$amount,$idIssuer,$namePayment,$nameBank,$img"
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
                    Text(
                        text = stringResource(R.string.txt_amount) + amount
                                + " " + stringResource(R.string.txt_payment) + namePayment
                    )
                }
            }
        }

        )
    }
}