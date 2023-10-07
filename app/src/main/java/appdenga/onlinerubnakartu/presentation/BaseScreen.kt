package appdenga.onlinerubnakartu.presentation

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import appdenga.onlinerubnakartu.R

import appdenga.onlinerubnakartu.presentation.ui.theme.Background
import appdenga.onlinerubnakartu.presentation.ui.theme.BackgroundCard
import appdenga.onlinerubnakartu.presentation.ui.theme.Orange
import appdenga.onlinerubnakartu.presentation.ui.theme.Rose
import appdenga.onlinerubnakartu.presentation.ui.theme.White

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    viewModel: MainViewModel = hiltViewModel()
) {
    val state = viewModel.state.collectAsState()
    val context = LocalContext.current
    if (state.value.error!=null) {
        Toast.makeText(context, state.value.error, Toast.LENGTH_LONG).show()
    }
    val colors = listOf(Rose, Orange)
    if (state.value.isLoading) {
        Box(modifier = modifier
            .fillMaxSize()
            .background(color = Background)) {
            CircularProgressIndicator(
                modifier = modifier
                    .align(alignment = Alignment.Center)
                    .size(100.dp),
                color = BackgroundCard
            )
        }
    } else {
        Column(
            modifier = modifier
                .fillMaxSize()
                .background(color = Background)
        ) {
            Text(
                modifier = modifier
                    .fillMaxWidth()
                    .background(brush = Brush.horizontalGradient(colors = colors))
                    .padding(vertical = 18.dp),
                textAlign = TextAlign.Center,
                color = White,
                text = stringResource(id = R.string.name),
                fontSize = 18.sp,
                fontFamily = FontFamily(Font(R.font.montserrat)),
                fontWeight = FontWeight(800)
            )
            Spacer(modifier = modifier.height(30.dp))
            LazyColumn(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp),
                verticalArrangement = Arrangement.spacedBy(30.dp)
            ) {
                items(state.value.moneyList) { loan ->
                    ItemLoan(loan = loan)
                }
            }
        }
    }
}