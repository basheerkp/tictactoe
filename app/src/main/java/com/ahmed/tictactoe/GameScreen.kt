package com.ahmed.tictactoe

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import kotlin.math.abs

enum class Players {
    NULL, TIC, TOE
}

@Composable
fun GameBox(modifier: Modifier = Modifier, stateChanger: (winner: String) -> Unit) {
    val totalTurns = remember { mutableIntStateOf(0) }
    val gridVals = remember { mutableStateListOf(*Array(9) { Players.NULL }) }
    var gameEnd by remember { mutableStateOf(false) }
    when (totalTurns.intValue) {
        in 5..8 -> {
            if (gameEnd) {
                if (totalTurns.intValue % 2 == 0)
                    stateChanger("CIRCLE WON THE GAME NIGGA")
                else
                    stateChanger("CROSS WON THE GAME NIGGA")
            }
        }

        9 -> stateChanger("THE GAME IS A DRAW NIGGA")
    }
    LazyColumn(
        modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(listOf(1, 2, 3)) { num1 ->
            Box {
                Row {
                    LazyRow {
                        items(listOf(1, 2, 3)) { num2 ->
                            val id = (abs(1 - num1) * 3) + num2
                            Box(
                                Modifier
                                    .border(1.dp, Color.White)
                                    .size(125.dp, 125.dp)
                                    .clickable(gridVals[id - 1] == Players.NULL) {
                                        totalTurns.intValue++
                                        if (totalTurns.intValue % 2 == 0) gridVals[id - 1] =
                                            Players.TIC
                                        else gridVals[id - 1] = Players.TOE
                                        if (totalTurns.intValue > 4) {
                                            gameEnd = checkWinner(gridVals, id)
                                        }
                                    }, Alignment.Center
                            ) {
                                if (gridVals[id - 1] == Players.TIC) Icon(
                                    painterResource(R.drawable.ic_launcher_foreground), null
                                )
                                else if (gridVals[id - 1] == Players.TOE) Icon(
                                    painterResource(R.drawable.ic_launcher_background), null
                                )
                                else Text(gridVals[id - 1].toString())
                            }

                        }
                    }
                }
            }
        }

    }


}
