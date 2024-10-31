package lotto.controller

import lotto.model.Winning

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { " 로또 번호는 6개여야 합니다." }
    }

    fun checkWinningCount(winningNumbers: List<Int>, bonusNumber: Int): Winning {
        val matchCount = matchWinningNumber(winningNumbers)
        val isBonusMatch = numbers.contains(bonusNumber)
        return returnWinningCount(matchCount, isBonusMatch)
    }

    private fun returnWinningCount(matchCount: Int, isBonusMatch: Boolean): Winning {
        return when (matchCount) {
            3 -> Winning.THREE
            4 -> Winning.FOUR
            5 -> if (isBonusMatch) Winning.FIVE_BONUS else Winning.FIVE_NOT_BONUS
            6 -> Winning.SIX
            else -> Winning.NONE
        }
    }

    private fun matchWinningNumber(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun getNumbers(): List<Int> = numbers
}