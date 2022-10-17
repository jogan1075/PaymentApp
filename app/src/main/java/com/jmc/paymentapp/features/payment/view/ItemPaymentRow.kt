package com.jmc.paymentapp.features.payment.view

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrokenImage
import androidx.compose.material.icons.filled.Movie
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import coil.ImageLoader
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.jmc.paymentapp.R
import com.jmc.paymentapp.features.payment.domain.model.PaymentModelUi

@Composable
fun ItemPaymentRow(item: PaymentModelUi, onItemClicked: (String, String) -> Unit = { _, _ -> }) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(start = 10.dp, end = 10.dp, bottom = 5.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        onClick = { onItemClicked(item.id, item.name) }
    ) {

        ConstraintLayout() {
            val tintColor = if (MaterialTheme.colors.isLight) Color.Gray else Color.DarkGray
            val (image, title, subtitle, subtitle2, btnClose) = createRefs()
            createVerticalChain(
                title,
                subtitle,
                subtitle2,
                chainStyle = ChainStyle.Packed
            )
            val imageLoader = ImageLoader.Builder(LocalContext.current)
                .components {
                    if (SDK_INT >= 28) {
                        add(ImageDecoderDecoder.Factory())
                    } else {
                        add(GifDecoder.Factory())
                    }
                }
                .build()

            val painter = rememberAsyncImagePainter(
                model = item.secureThumbnail,
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
                contentScale = ContentScale.Fit,
                modifier = Modifier
                    .size(80.dp)
                    .clip(CircleShape)
                    .border(2.dp, Color.Gray, CircleShape)
                    .constrainAs(image) {
                        top.linkTo(anchor = title.top)
                        start.linkTo(parent.start, 10.dp)
                        bottom.linkTo(anchor = subtitle2.bottom)
                    }
            )

            Text(
                text = item.name,
                style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(title) {
                        start.linkTo(image.end, 10.dp)
                        top.linkTo(parent.top, 10.dp)
                        end.linkTo(btnClose.start)
                        width = Dimension.fillToConstraints
                    },
                color = Color.Black
            )

            Image(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                contentDescription = null,
                modifier = Modifier
                    .wrapContentSize()
                    .padding(top = 10.dp)
                    .constrainAs(btnClose) {
                        end.linkTo(parent.end, 10.dp)
                        top.linkTo(anchor = title.top)
                        bottom.linkTo(anchor = subtitle2.bottom)
                    }
            )

        }

    }


}