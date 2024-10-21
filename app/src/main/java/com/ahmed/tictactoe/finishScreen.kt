package com.ahmed.tictactoe

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Popup

@Composable
fun FinishScreen(modifier: Modifier, gameRestart: () -> Unit,winner:String) {
    Popup(Alignment.Center) {
        Column(
            Modifier
                .background(Color.White)
                .defaultMinSize(minHeight = 375.dp)
                .fillMaxWidth(),
            Arrangement.Center,
            Alignment.CenterHorizontally
        ) {
            Text(winner, color = Color.Black)
            Spacer(Modifier.defaultMinSize(minHeight = 35.dp))
            TextButton(
                onClick = { gameRestart() },
                modifier = Modifier
                    .clip(MaterialTheme.shapes.extraLarge)
                    .border(
                        color = Color.Blue,
                        width = 2.dp,
                        shape = MaterialTheme.shapes.extraLarge
                    )
            ) { Text("RESTART GAME", fontSize = 25.sp) }
        }
    }
}