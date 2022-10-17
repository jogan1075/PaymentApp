package com.jmc.paymentapp.features.sucess

import android.os.Build
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.jmc.paymentapp.R
import com.jmc.paymentapp.navigation.Screens
import com.jmc.theme.PearlLightGray
import com.jmc.theme.colorPrimary
import com.jmc.theme.white

@Composable
fun SucessScreen(
     navController: NavHostController,
     monto: String,
     namePayment: String,
     nameBank: String,
     image: String,
     nameRecomendMessage: String
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {

        Scaffold(topBar = {
            TopAppBar(
                title = { Text(text = stringResource(R.string.title_resume)) },
                backgroundColor = colorPrimary,
                navigationIcon = {

                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            contentDescription = null,
                            tint = white
                        )
                    }

                })

        }, content = {
            Column {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(R.string.subtitle_resume),
                        style = MaterialTheme.typography.h6.copy(fontSize = 18.sp),
                        modifier = Modifier
                            .padding(top = 10.dp),
                        color = Color.Black
                    )
                }

                Spacer(modifier = Modifier.padding(10.dp))

                Card(
                    modifier = Modifier
                        .wrapContentHeight()
                        .padding(start = 50.dp, end = 50.dp, bottom = 50.dp),
                    elevation = 4.dp,
                ) {
                    Column(
                        modifier = Modifier
                            .wrapContentSize()
                            .padding(start = 10.dp, bottom = 50.dp)
                    ) {
                        Text(
                            text = "Monto:",
                            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = "$ $monto",
                            style = MaterialTheme.typography.subtitle1.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Row(
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            val tintColor = if (MaterialTheme.colors.isLight) Color.Gray else Color.DarkGray
                            val imageLoader = ImageLoader.Builder(LocalContext.current)
                                .components {
                                    if (Build.VERSION.SDK_INT >= 28) {
                                        add(ImageDecoderDecoder.Factory())
                                    } else {
                                        add(GifDecoder.Factory())
                                    }
                                }
                                .build()

                            val painter = rememberAsyncImagePainter(
                                model = image,
                                error = rememberVectorPainter(Icons.Filled.BrokenImage),
                                placeholder = rememberVectorPainter(Icons.Default.Movie),
                                imageLoader = imageLoader
                            )
                            val colorFilter = when (painter.state) {
                                is AsyncImagePainter.State.Loading -> ColorFilter.tint(tintColor)
                                is AsyncImagePainter.State.Error -> ColorFilter.tint(tintColor)
                                else -> null
                            }

                            Image(
                                painter = painter,
                                contentDescription = null,
                                modifier = Modifier.width(50.dp).height(50.dp)
                            )

                            Text(
                                text = namePayment,
                                style = MaterialTheme.typography.subtitle1.copy(fontSize = 14.sp),
                                modifier = Modifier
                                    .padding(start = 5.dp),
                                color = PearlLightGray
                            )
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = "Banco:",
                            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = nameBank,
                            style = MaterialTheme.typography.subtitle1.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = PearlLightGray
                        )
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = "Cuotas:",
                            style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = Color.Black
                        )
                        Text(
                            text = nameRecomendMessage,
                            style = MaterialTheme.typography.subtitle1.copy(fontSize = 14.sp),
                            modifier = Modifier
                                .padding(top = 10.dp),
                            color = PearlLightGray
                        )
                        Spacer(modifier = Modifier.padding(10.dp))


                        Button(
                            onClick = {
                                navController.navigate(
                                    Screens.AmountScreen.route
                                )
                            },
                            colors = ButtonDefaults.buttonColors(backgroundColor = colorPrimary),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    top = 30.dp
                                ),
                            shape = RoundedCornerShape(16.dp)
                        ) {
                            Text(
                                text = "Confirmar",
                                color = white,
                                style = MaterialTheme.typography.button,
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp)
                            )
                        }
                    }
                }

            }

        }

        )
    }
}
