package yug.ramoliya.credassignment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    private val viewModel: GridViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    GridScreen(viewModel)
                }
            }
        }
    }
}

@Composable
fun GridScreen(viewModel: GridViewModel) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier.size(300.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {

                itemsIndexed(viewModel.numbers) { index, value ->
                    GridBox(
                        value = value,
                        onClick = { viewModel.onBoxClick(index) }
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { viewModel.resetGrid() }
            ) {
                Text("Reset Grid")
            }
        }
    }
}

@Composable
fun GridBox(value: Int, onClick: () -> Unit) {

    val isLocked = value >= 15

    val bgColor = when {
        isLocked -> Color.Red
        value % 2 == 0 -> Color(0xFFE0E0E0)
        else -> Color(0xFF1A237E)
    }

    val textColor = when {
        isLocked -> Color.White
        value % 2 != 0 -> Color.White
        else -> Color.Black
    }

    Box(
        modifier = Modifier
            .size(80.dp)
            .shadow(4.dp, RoundedCornerShape(4.dp))
            .background(bgColor, RoundedCornerShape(4.dp))
            .clickable(enabled = !isLocked) { onClick() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = value.toString(),
            fontSize = 22.sp,
            color = textColor
        )
    }
}
