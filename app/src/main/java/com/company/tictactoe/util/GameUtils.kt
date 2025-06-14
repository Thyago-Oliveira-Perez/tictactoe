package com.company.tictactoe.util

import com.company.tictactoe.data.model.GameState

object GameUtils {
    fun checkForWin(board: List<GameState.Player?>): Boolean {
        val winPatterns = listOf(
            listOf(0, 1, 2), listOf(3, 4, 5), listOf(6, 7, 8),
            listOf(0, 3, 6), listOf(1, 4, 7), listOf(2, 5, 8),
            listOf(0, 4, 8), listOf(2, 4, 6)
        )

        return winPatterns.any { pattern ->
            pattern.all { board[it] == board[pattern[0]] && board[it] != null }
        }
    }

    fun checkForDraw(board: List<GameState.Player?>): Boolean {
        if (board.any { it == null }) return false

        if (checkForWin(board)) return false

        val emptyIndices = board.indices.filter { board[it] == null }
        return emptyIndices.all { index ->
            val tempBoard = board.toMutableList()
            tempBoard[index] = GameState.Player.X
            checkForWin(tempBoard).not()
        }
    }
}