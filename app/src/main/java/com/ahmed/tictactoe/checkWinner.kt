package com.ahmed.tictactoe

import androidx.compose.runtime.snapshots.SnapshotStateList

fun checkWinner(gridVals: SnapshotStateList<Players>, id: Int): Boolean {
    var retVal = false
    val row = (id - 1) / 3
    val col = (id - 1) % 3
    if (col == 1 && row == 1) {
        if (gridVals[id] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id - 2]) {
            retVal = true
        } else if (gridVals[id - 4] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id + 2]) {
            retVal = true
        } else if (gridVals[id - 5] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id + 3]) {
            retVal = true
        } else if (gridVals[id - 1] == gridVals[id + 1] && gridVals[id - 1] == gridVals[id - 2]) {
            retVal = true
        }
    } else if (row == 1) {
        if (col == 0) {
            if (gridVals[id - 1] == gridVals[id - 4] && gridVals[id - 1] == gridVals[id + 2]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id + 1] && gridVals[id - 1] == gridVals[id]) {
                retVal = true
            }
        } else if (col == 2) {
            if (gridVals[id - 1] == gridVals[id - 4] && gridVals[id - 1] == gridVals[id + 2]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id - 2] && gridVals[id - 1] == gridVals[id - 3]) {
                retVal = true
            }
        }
    } else if (col == 1) {
        if (row == 0) {
            if (gridVals[id - 1] == gridVals[id + 2] && gridVals[id - 1] == gridVals[id + 5]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id] && gridVals[id - 1] == gridVals[id - 2]) {
                retVal = true
            }
        } else if (row == 2) {
            if (gridVals[id - 1] == gridVals[id - 4] && gridVals[id - 1] == gridVals[id - 7]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id - 2] && gridVals[id - 1] == gridVals[id]) {
                retVal = true
            }
        }
    } else if (row == 0) {
        if (col == 0) {
            if (gridVals[id - 1] == gridVals[id + 1] && gridVals[id - 1] == gridVals[id]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id + 2] && gridVals[id - 1] == gridVals[id + 5]) {
                retVal = true
            } else if (gridVals[id + 3] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id + 8]) {
                retVal = true
            }
        } else if (col == 2) {
            if (gridVals[id - 1] == gridVals[id + 5] && gridVals[id - 1] == gridVals[id + 2]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id - 2] && gridVals[id - 1] == gridVals[id - 3]) {
                retVal = true
            } else if (gridVals[id + 1] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id + 3]) {
                retVal = true
            }
        }
    } else if (row == 2) {
        if (col == 0) {
            if (gridVals[id - 1] == gridVals[id - 4] && gridVals[id - 1] == gridVals[id - 7]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id + 1] && gridVals[id - 1] == gridVals[id]) {
                retVal = true
            } else if (gridVals[id - 3] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id - 5]) {
                retVal = true
            }
        } else if (col == 2) {
            if (gridVals[id - 1] == gridVals[id - 4] && gridVals[id - 1] == gridVals[id - 7]) {
                retVal = true
            } else if (gridVals[id - 1] == gridVals[id - 2] && gridVals[id - 1] == gridVals[id - 3]) {
                retVal = true
            } else if (gridVals[id - 5] == gridVals[id - 1] && gridVals[id - 1] == gridVals[id - 9]) {
                retVal = true
            }
        }
    }

    return retVal
}