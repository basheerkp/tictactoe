package com.ahmed.tictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ahmed.tictactoe.ui.theme.TicTacToeTheme

enum class GameState {
    ON, OFF, FINISH
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TicTacToeTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(
                        contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()
                    ) {
                        StartButton(
                            modifier = Modifier.padding(innerPadding)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun StartButton(modifier: Modifier = Modifier) {
    var winner by remember{ mutableStateOf("None") }
    var currentState by remember { mutableStateOf(GameState.OFF) }

    when (currentState) {
        GameState.OFF -> {
            TextButton(modifier = modifier.size(width = 185.dp, height = 80.dp), onClick = {
                currentState = GameState.ON
            }, content = { Text("START", fontSize = 30.sp) })
        }

        GameState.ON -> {
            GameBox(stateChanger = {winnerTemp->
                winner = winnerTemp
                currentState = GameState.FINISH
            })
        }

        GameState.FINISH -> {
            FinishScreen(modifier, { currentState = GameState.ON }, winner = winner)
        }
    }
}
