package com.jmc.paymentapp.features.payment.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavHostController
import com.jmc.theme.black
import com.jmc.theme.colorPrimary
import com.jmc.theme.white

//@Preview(showBackground = true)
@Composable
fun PaymentMethodScreen(navController: NavHostController, toString: String) {

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
            /*  Row(
                  modifier = Modifier
                      .padding(top = 16.dp)
                      .fillMaxWidth(),
                  horizontalArrangement = Arrangement.SpaceBetween,
                  verticalAlignment = Alignment.CenterVertically
              ) {
                  IconButton(onClick = { }) {
                      Icon(
                          modifier = Modifier.size(32.dp, 32.dp),
                          imageVector = Icons.Default.KeyboardArrowLeft,
                          contentDescription = "",
                          tint = black
                      )
                  }

                  Text(
                      text = "Register",
                      color = black,
                      modifier = Modifier
                          .padding(end = 48.dp)
                          .fillMaxWidth(),
                      fontWeight = FontWeight.Bold,
                      textAlign = TextAlign.Center,
                      fontSize = 16.sp,
                  )

              }*/
        }, content = {
            Column {
                Text(text = "Seleccione el Medio de Pago", color = black)
                Spacer(modifier = Modifier.padding(10.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(bottom = 50.dp)
                ) {
                    items(15) {
                        ItemPaymentRow()
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
                    Text(text = "asasasasas")
                    Text(text = "asasasasas")

                }
            }
        }

        )
    }
}