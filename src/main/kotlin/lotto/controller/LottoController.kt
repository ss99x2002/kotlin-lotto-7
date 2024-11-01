package lotto.controller

import lotto.model.Lotto
import lotto.model.MatchType
import lotto.service.LottoService

class LottoController(
    private val lottoService: LottoService
) {

    fun generateUserLottoNumbers(count: Int): List<Lotto> {
        lottoService.generateUserLottoNumbers(count)
        return lottoService.userLottoNumbers
    }

    fun checkWinning(winningNumbers: List<Int>, bonusNumber: Int) {
        lottoService.checkWinning(winningNumbers, bonusNumber)
    }

    fun getWinningResult(): Map<MatchType, Int> = lottoService.getMatchResult()

    fun calculateEarningRate(buyCount: Int): Double {
        return lottoService.calculateEarningRate(buyCount)
    }

    fun clearLottoNumbers() {
        lottoService.clearLottoManager()
    }
}