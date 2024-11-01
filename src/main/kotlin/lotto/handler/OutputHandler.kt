package lotto.handler

import lotto.model.Lotto
import lotto.model.MatchType
import lotto.view.OutputView

class OutputHandler(
    private val outputView: OutputView
) {

    fun printPurchaseCount(count: Int) {
        outputView.printLottoPurchaseCount(count)
    }

    fun printGeneratedNumbers(lottoNumbers: List<Lotto>) {
        outputView.printLottoGenerateNumber(lottoNumbers)
    }

    fun printWinningStatistics(matchResult: Map<MatchType, Int>) {
        outputView.printLottoWinningStat()
        matchResult.forEach { (type, count) ->
            if (type != MatchType.NONE) {
                outputView.printLottoWinningCount(type, count)
            }
        }
    }

    fun printEarningRate(earningRate: Double) {
        outputView.printLottoEarningRate(earningRate)
    }
}