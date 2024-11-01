package lotto.service

import lotto.model.Lotto
import lotto.model.MatchType

class LottoMatchService {

    fun checkMatchCount(userLotto: Lotto, winningNumbers: List<Int>, bonusNumber: Int): MatchType {
        val matchCount = matchWinningNumbers(userLotto, winningNumbers)
        val isBonusMatch = matchBonusNumber(userLotto, bonusNumber)
        return getMatchType(matchCount, isBonusMatch)
    }

    private fun getMatchType(matchCount: Int, isBonusMatch: Boolean): MatchType {
        return when (matchCount) {
            3 -> MatchType.THREE
            4 -> if (isBonusMatch) MatchType.FIVE_WITH_BONUS else MatchType.FOUR
            5 -> MatchType.FIVE_NOT_BONUS
            6 -> MatchType.SIX
            else -> MatchType.NONE
        }
    }

    private fun matchWinningNumbers(userLotto: Lotto, winningNumbers: List<Int>): Int {
        return userLotto.getNumbers().count { it in winningNumbers }
    }

    private fun matchBonusNumber(userLotto: Lotto, bonusNumber: Int): Boolean {
        return userLotto.getNumbers().contains(bonusNumber)
    }
}