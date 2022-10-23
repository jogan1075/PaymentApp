package com.jmc.payment.view

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
import com.jmc.navigation.NavigationProvider
import com.jmc.payment.presentation.PaymentViewModel
import com.jmc.payment.presentation.contract.PaymentContract
import com.jmc.theme.colorPrimary
import com.jmc.theme.white
import com.jmc.uicomponent.LoadingScreen
import com.jmc.utils.R.string
import com.ramcosta.composedestinations.annotation.Destination

@Composable
@Destination(start = true)
fun PaymentMethodScreen(navigator: NavigationProvider, amount: String) {
    val viewModel = hiltViewModel<PaymentViewModel>()
    val state = viewModel.viewState.value
    if (state.list.isNullOrEmpty()) {
        viewModel.setEvent(PaymentContract.Event.CallService)
    }
    LoadingScreen(isLoading = viewModel.state.isLoading) {
        Content(amount = amount, state = state, navigator = navigator)
    }
}

@Composable
private fun Content(
    amount: String,
    state: PaymentContract.State,
    navigator: NavigationProvider
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = stringResource(string.title_payment)) },
                backgroundColor = colorPrimary,
                navigationIcon = {

                    IconButton(onClick = {navigator.navigateUp() }) {
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
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(string.subtitle_payment),
                        style = MaterialTheme.typography.h6.copy(fontSize = 18.sp),
                        modifier = Modifier
                            .padding(top = 10.dp),
                        color = Color.Black
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp)
                ) {
                    val listOrder = state.list?.sortedBy { it.name }
                    items(listOrder?.size!!) { index ->
                        ItemPaymentRow(item = listOrder[index], onItemClicked = { id, name ->

                            navigator.navigateToBankList(id,name,amount)
                           /* navController.navigate(
                                Screens.BankListScreen.route + "?param=${id},${name},${amount}"
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
                    )
                }
            }
        }

        )
    }
}