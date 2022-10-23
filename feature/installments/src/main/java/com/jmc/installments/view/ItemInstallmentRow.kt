package com.jmc.installments.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ChainStyle
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import com.jmc.paymentapp.features.installments.domain.model.PayerCostUI

@Composable
fun ItemInstallmentRow(item: PayerCostUI, onItemClicked: (String) -> Unit = {}) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp).padding(5.dp),
        elevation = 4.dp,
        shape = RoundedCornerShape(14.dp),
        backgroundColor = Color.White,
        onClick = { onItemClicked(item.recommendedMessage) }
    ) {

        ConstraintLayout() {
            val (image, title, subtitle, subtitle2, btnClose) = createRefs()
            createVerticalChain(
                title,
                subtitle,
                subtitle2,
                chainStyle = ChainStyle.Packed
            )
            Text(
                text = item.recommendedMessage,
                style = MaterialTheme.typography.h6.copy(fontSize = 14.sp),
                modifier = Modifier
                    .padding(top = 10.dp)
                    .constrainAs(title) {
                        start.linkTo(parent.start,10.dp)
                        top.linkTo(parent.top, 10.dp)
                        end.linkTo(btnClose.start)
                        width = Dimension.fillToConstraints
                    },
                color = Color.Black
            )

            Image(
                painter = painterResource(id = com.jmc.utils.R.drawable.ic_baseline_arrow_forward_ios_24),
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