package com.jmc.paymentapp.features.amount

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.jmc.paymentapp.features.amount.contract.AmountContract
import com.jmc.paymentapp.navigation.Screens
import com.jmc.theme.colorPrimary
import com.jmc.theme.dark_gray
import com.jmc.theme.light_gray
import com.jmc.theme.white
import com.jmc.uicomponent.TextField

//@Preview(showBackground = true)
@Composable
fun AmountScreen(navController: NavHostController) {
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
                text = "Ingrese el monto",
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
                    navController.navigate(Screens.PaymentMethodScreen.route +"?param=${state.amount.toString()}")
//                    Toast.makeText(contextGral, "Test", Toast.LENGTH_SHORT).show()
//                            validateUserPass(mAuth, navController, useremail, password, activity)
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
                    text = "Forma de Pago",
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

    TextField(hint = "Ingrese monto aqui", label = "Monto", onValueChange = {
        onEventSent(AmountContract.Event.AmountChanged(it))
    }, keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number))


   /* TextField(
        leadingIcon = {
            Row(
                modifier = Modifier.wrapContentWidth(),
                verticalAlignment = Alignment.CenterVertically,
                content = {
                    Icon(
                        imageVector = Icons.Default.AttachMoney,
                        contentDescription = null,
                        tint = colorPrimary
                    )
                    Canvas(
                        modifier = Modifier
                            .height(24.dp)
                            .padding(start = 10.dp)
                    ) {
                        drawLine(
                            color = light_gray,
                            start = Offset(0f, 0f),
                            end = Offset(0f, size.height),
                            strokeWidth = 2.0F
                        )
                    }
                }
            )
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = white,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent
        ),
        modifier = Modifier
            .fillMaxWidth(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        label = { Text(text = "Monto") },
        shape = RoundedCornerShape(8.dp),
        onValueChange = {
//                    amount = it
            AmountContract.Event.AmountChanged(it)
        }
    )*/
}