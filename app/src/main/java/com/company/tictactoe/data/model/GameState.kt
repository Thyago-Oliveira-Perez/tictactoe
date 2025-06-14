package com.company.tictactoe.data.model

data class GameState(
    val board: List<Player?> = List(9) { null },
    val currentPlayer: Player = Player.X,
    val gameStatus: GameStatus = GameStatus.ONGOING,
    val xWins: Int = 0,
    val oWins: Int = 0
) {
    enum class Player { X, O }
    enum class GameStatus { ONGOING, X_WON, O_WON, DRAW }
}