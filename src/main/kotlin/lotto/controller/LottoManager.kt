package lotto.controller

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Winning

class LottoManager() {

    private var _userLottoNumbers: MutableList<Lotto> = mutableListOf()
    val userLottoNumbers: List<Lotto> get() = _userLottoNumbers

    fun generateUserLottoNumbers(count: Int) {
        repeat(count) {
            _userLottoNumbers.add(Lotto(generateRandomNumber()))
        }
    }

    fun checkWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        _userLottoNumbers.forEach {
            val winning = it.checkWinningCount(winningNumbers, bonusNumber)
            incrementWinningCount(winning)
        }
    }

    fun calculateEarningRate(count: Int): Double {
        var revenue = Winning.entries.sumOf {
            if (it.getCount() > 0) it.price else 0
        }
        return ((revenue / (count * 1000)) * 100).toDouble()
    }

    fun incrementWinningCount(winning: Winning) {
        winning.increase()
    }

    fun clearLottoManager() {
        clearUserLottoNumbers()
        clearWinningCounts()
    }

    private fun clearUserLottoNumbers() {
        _userLottoNumbers.clear()
    }

    private fun clearWinningCounts() {
        Winning.entries.forEach { it.clear() }
    }

    fun generateRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
    }
}