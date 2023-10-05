package com.edurda77.presentation

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.edurda77.R
import com.edurda77.domain.model.Loan
import com.edurda77.presentation.ui.theme.BackgroundCard
import com.edurda77.presentation.ui.theme.Orange
import com.edurda77.presentation.ui.theme.Rose
import com.edurda77.presentation.ui.theme.TextColor
import com.edurda77.presentation.ui.theme.White

@Composable
fun ItemLoan(
    modifier: Modifier = Modifier,
    loan: Loan
) {
    val colors = listOf(Rose, Orange)
    val openLink = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.StartActivityForResult()
    ) { }
    val intent = Intent(Intent.ACTION_VIEW, Uri.parse(loan.url))
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clip(
                shape = RoundedCornerShape(
                    topEnd = 30.dp,
                    bottomStart = 30.dp
                )
            )
            .background(color = White)
            .padding(
                vertical = 30.dp,
                horizontal = 20.dp
            )
    ) {
        AsyncImage(
            modifier = modifier
                .fillMaxWidth()
                .clip(
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                )
                .border(
                    width = 5.dp,
                    color = BackgroundCard,
                    shape = RoundedCornerShape(
                        topEnd = 20.dp,
                        bottomStart = 20.dp
                    )
                ),
            model = loan.imageUrl,
            contentScale = ContentScale.FillWidth,
            contentDescription = ""
        )
        Spacer(modifier = modifier.height(30.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ItemData(
                modifier.weight(1f),
                name = stringResource(id = R.string.amount),
                content = loan.sumOne
            )
            Spacer(modifier = modifier.width(15.dp))
            ItemData(
                modifier.weight(1.3f),
                name = stringResource(id = R.string.bet),
                content = loan.percent
            )
        }
        Spacer(modifier = modifier.height(20.dp))
        Row(
            modifier = modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            ItemData(
                modifier.weight(1f),
                name = stringResource(id = R.string.days),
                content = loan.daysInfo
            )
            Spacer(modifier = modifier.width(15.dp))
            ItemData(
                modifier.weight(1.3f),
                name = stringResource(id = R.string.age),
                content = loan.age
            )
        }
        Spacer(modifier = modifier.height(36.dp))
        Button(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    Brush.horizontalGradient(
                        colors = colors
                    )
                ),
            onClick = { openLink.launch(intent) }) {
            Text(
                text = stringResource(id = R.string.go_to),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(700),
                    color = White
                )
            )
        }
    }
}


@Composable
fun ItemData(
    modifier: Modifier = Modifier,
    name: String,
    content: String
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Column(
            modifier = modifier
                .padding(start = 4.dp)
                .clip(
                    shape = RoundedCornerShape(
                        10.dp
                    )
                )
                .background(color = BackgroundCard)
                .padding(vertical = 8.dp, horizontal = 20.dp)
        ) {
            Text(
                text = name,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(700),
                    color = TextColor
                )
            )
            Spacer(modifier = modifier.height(5.dp))
            Text(
                text = content,
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.montserrat)),
                    fontWeight = FontWeight(700),
                    color = TextColor
                )
            )
        }
        Image(
            modifier = modifier.padding(top = 13.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.ellipse),
            contentDescription = ""
        )
    }
}
