package com.company.tictactoe.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.company.tictactoe.data.model.GameState

@Composable
fun GameBoard(
    board: List<GameState.Player?>,
    onCellClick: (Int) -> Unit,
    enabled: Boolean
) {
    Column(
        modifier = Modifier
            .aspectRatio(1f)
            .padding(8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        repeat(3) { row ->
            Row(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                repeat(3) { col ->
                    val index = row * 3 + col
                    BoardCell(
                        player = board[index],
                        onClick = { onCellClick(index) },
                        enabled = enabled && board[index] == null
                    )
                }
            }
        }
    }
}