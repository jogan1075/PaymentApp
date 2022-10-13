package com.jmc.paymentapp.features.payment.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jmc.paymentapp.R

@Preview(showBackground = true)
@Composable
fun ItemPaymentRow() {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight(),
        elevation = 4.dp,
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White
    ) {

        ConstraintLayout() {
            val (image, title, subtitle, subtitle2,  btnClose) = createRefs()
            createVerticalChain(
                title,
                subtitle,
                subtitle2,
                chainStyle = ChainStyle.Packed
            )

            Image(
                painter = painterResource(id = R.drawable.ic_product_without_image),
                contentDescription = "",
                modifier = Modifier
                    .width(60.dp)
                    .height(90.dp)
                    .constrainAs(image) {
//                        linkTo(start = parent.start, end = title.start)
                        top.linkTo(anchor = title.top)
                        start.linkTo(parent.start, 10.dp)
                        bottom.linkTo(anchor = subtitle2.bottom)
                    }
            )

            Text(
                text = "item.author",
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

            Text(
                text = "item.text",
                style = MaterialTheme.typography.subtitle2,
                maxLines = 2,
                modifier = Modifier
                    .constrainAs(subtitle2) {
                        start.linkTo(image.end, 10.dp)
                        end.linkTo(btnClose.start)
                        bottom.linkTo(parent.bottom)
//                        linkTo(start = title.start, end = starButton.start)
                        width = Dimension.fillToConstraints
                    }
                    .alpha(0.6f),
                color = Color.Black,
                fontSize = 10.sp
            )


            Image(
                painter = painterResource(id = R.drawable.ic_baseline_arrow_forward_ios_24),
                contentDescription = "",
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