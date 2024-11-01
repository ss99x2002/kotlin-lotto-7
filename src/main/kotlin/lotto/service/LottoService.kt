package lotto.service

import camp.nextstep.edu.missionutils.Randoms
import lotto.model.Lotto
import lotto.model.MatchType

class LottoService(
    private val lottoCounterService: LottoCounterService,
    private val lottoMatchService: LottoMatchService
) {

    private val _userLottoNumbers: MutableList<Lotto> = mutableListOf()
    val userLottoNumbers: List<Lotto> get() = _userLottoNumbers

    fun generateUserLottoNumbers(count: Int) {
        repeat(count) {
            _userLottoNumbers.add(Lotto(generateRandomNumber()))
        }
    }

    fun checkWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        _userLottoNumbers.forEach {
            val result = lottoMatchService.checkMatchCount(it, winningNumbers, bonusNumber)
            lottoCounterService.incrementResult(result)
        }
    }

    fun getMatchResult(): Map<MatchType, Int> = lottoCounterService.getResultMap()

    fun calculateEarningRate(buyCount: Int): Double {
        val totalEarning = MatchType.entries.sumOf { type ->
            val count = lottoCounterService.getResultMap()[type] ?: 0
            type.prize * count
        }
        return ((totalEarning).toDouble() / (buyCount * 1000) * 100)
    }

    fun clearLottoManager() {
        _userLottoNumbers.clear()
    }

    private fun generateRandomNumber(): List<Int> {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6).sortedBy { it }
    }
}