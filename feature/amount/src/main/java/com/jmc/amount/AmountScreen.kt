package com.jmc.amount

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.jmc.amount.contract.AmountContract
import com.jmc.navigation.NavigationProvider
import com.jmc.theme.colorPrimary
import com.jmc.theme.dark_gray
import com.jmc.theme.white
import com.jmc.uicomponent.TextField
import com.jmc.utils.R.string
import com.ramcosta.composedestinations.annotation.Destination

@Destination(start = true)
@Composable
fun AmountScreen(navigator: NavigationProvider) {
    val viewModel = hiltViewModel<AmountViewModel>()
    val state = viewModel.viewState.value
    Box(
        modifier = Modifier
            .fillMaxSize(), contentAlignment = Alignment.Center
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(30.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(string.label_add_amount),
                style = MaterialTheme.typography.subtitle1,
                color = dark_gray,
                modifier = Modifier.padding(
                    top = 10.dp,
                    bottom = 20.dp
                )
            )

            InputAmount(viewModel::setEvent)

            Button(
                onClick = {
                    navigator.navigateToPayment(state.amount.toString())
                  /*  navController.navigate(
                        Screens.PaymentMethodScreen.route +
                                "?param=${state.amount.toString()}"
                    )*/
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(
                        top = 30.dp,
                        bottom = 34.dp
                    ),
                shape = RoundedCornerShape(16.dp)
            ) {
                Text(
                    text = stringResource(string.btn_next),
                    color = white,
                    style = MaterialTheme.typography.button,
                    modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                )
            }
        }
    }
}

@Composable
private fun InputAmount(onEventSent: (AmountContract.Event) -> Unit) {

    TextField(
        hint = stringResource(string.hint_input),
        label = stringResource(string.label_amount),
        onValueChange = {
            onEventSent(AmountContract.Event.AmountChanged(it))
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}