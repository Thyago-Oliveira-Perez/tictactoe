package com.company.tictactoe.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.company.tictactoe.data.model.GameState
import com.company.tictactoe.util.GameUtils
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class GameViewModel : ViewModel() {
    private val _gameState = MutableStateFlow(GameState())
    val gameState: StateFlow<GameState> = _gameState.asStateFlow()

    private val _showDrawDialog = MutableStateFlow(false)
    val showDrawDialog: StateFlow<Boolean> = _showDrawDialog.asStateFlow()

    fun onCellClick(index: Int) {
        val currentState = _gameState.value

        if (currentState.board[index] != null || currentState.gameStatus != GameState.GameStatus.ONGOING) {
            return
        }

        val newBoard = currentState.board.toMutableList().apply {
            this[index] = currentState.currentPlayer
        }

        val isWin = GameUtils.checkForWin(newBoard)
        val isDraw = GameUtils.checkForDraw(newBoard) || newBoard.all { it != null }

        val newStatus = when {
            isWin -> if (currentState.currentPlayer == GameState.Player.X)
                GameState.GameStatus.X_WON else GameState.GameStatus.O_WON
            isDraw -> GameState.GameStatus.DRAW
            else -> GameState.GameStatus.ONGOING
        }

        _gameState.update {
            it.copy(
                board = newBoard,
                currentPlayer = if (currentState.currentPlayer == GameState.Player.X)
                    GameState.Player.O else GameState.Player.X,
                gameStatus = newStatus,
                xWins = if (newStatus == GameState.GameStatus.X_WON) it.xWins + 1 else it.xWins,
                oWins = if (newStatus == GameState.GameStatus.O_WON) it.oWins + 1 else it.oWins
            )
        }

        if (isDraw) {
            _showDrawDialog.value = true
            viewModelScope.launch {
                delay(3000)
                resetGame()
                _showDrawDialog.value = false
            }
        }
    }

    fun resetGame() {
        _gameState.update {
            GameState(
                xWins = it.xWins,
                oWins = it.oWins
            )
        }
    }
}