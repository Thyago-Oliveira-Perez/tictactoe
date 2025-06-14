package com.company.tictactoe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.company.tictactoe.data.model.GameState
import com.company.tictactoe.ui.components.GameBoard
import com.company.tictactoe.ui.components.GameDialog
import com.company.tictactoe.ui.viewmodel.GameViewModel

@Composable
fun MainScreen(viewModel: GameViewModel = viewModel()) {
    val gameState by viewModel.gameState.collectAsState()
    val showDrawDialog by viewModel.showDrawDialog.collectAsState()

    if (showDrawDialog) {
        GameDialog(
            title = "Empate!",
            message = "O jogo terminou sem vencedor",
            onDismiss = { viewModel.resetGame() }
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ScoreBoard(xWins = gameState.xWins, oWins = gameState.oWins)

        when (gameState.gameStatus) {
            GameState.GameStatus.X_WON -> GameDialog(
                title = "Vitória!",
                message = "Jogador X venceu!",
                onDismiss = { viewModel.resetGame() }
            )
            GameState.GameStatus.O_WON -> GameDialog(
                title = "Vitória!",
                message = "Jogador O venceu!",
                onDismiss = { viewModel.resetGame() }
            )
            else -> {}
        }

        GameBoard(
            board = gameState.board,
            onCellClick = { index -> viewModel.onCellClick(index) },
            enabled = gameState.gameStatus == GameState.GameStatus.ONGOING
        )

        Button(
            onClick = { viewModel.resetGame() },
            modifier = Modifier.padding(top = 16.dp)
        ) {
            Text("Reiniciar Jogo")
        }
    }
}

@Composable
fun ScoreBoard(xWins: Int, oWins: Int) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(
            text = "X: $xWins",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
        Text(
            text = "O: $oWins",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.secondary
        )
    }
}