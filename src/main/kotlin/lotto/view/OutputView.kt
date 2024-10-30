package lotto.view

import lotto.model.Lotto
import lotto.model.Winning

class OutputView {

    fun printLottoPurchaseCount(purchaseCount: Int) {
        printMessageWithNumber(MSG_OUTPUT_LOTTO_PURCHASE_COUNT, purchaseCount)
    }

    fun printLottoGenerateNumber(lottoNumbers: List<Lotto>) {
        lottoNumbers.forEach { line ->
            println(line.getNumbers())
        }
    }

    fun printLottoWinningStat(winning: Map<Winning, Int>) {
        println(MSG_OUTPUT_WINNING_STAT)
        winning.forEach { winningNumber, count ->
            printLottoWinningCount(winningNumber, count)
        }
    }

    fun printLottoEarningRate(earningRate: Double) {
        printMessageWithNumber(MSG_OUTPUT_EARNING_RATE, earningRate)
    }

    private fun printLottoWinningCount(winning: Winning, count: Int) {
        printMessageWithNumber(getWinningMessage(winning), count)
    }

    fun getWinningMessage(winning: Winning): String {
        return when (winning) {
            Winning.THREE -> MSG_OUTPUT_THREE_SAME
            Winning.FOUR -> MSG_OUTPUT_FOUR_SAME
            Winning.FIVE_NOT_BONUS -> MSG_OUTPUT_FIVE_SAME_NOT_BONUS
            Winning.FIVE_BONUS -> MSG_OUTPUT_FIVE_SAME_BONUS
            Winning.SIX -> MSG_OUTPUT_SIX_SAME
        }
    }

    private fun printMessageWithNumber(message: String, number: Number) {
        println(String.format(message, number))
    }

    companion object {
        const val MSG_OUTPUT_LOTTO_PURCHASE_COUNT = "%d개를 구매했습니다."
        const val MSG_OUTPUT_WINNING_STAT = "당첨 통계\n---"
        const val MSG_OUTPUT_THREE_SAME = "3개 일치 (5,000원) - %d개"
        const val MSG_OUTPUT_FOUR_SAME = "4개 일치 (50,000원) - %d개"
        const val MSG_OUTPUT_FIVE_SAME_NOT_BONUS = "5개 일치 (1,500,000원) - %d개"
        const val MSG_OUTPUT_FIVE_SAME_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val MSG_OUTPUT_SIX_SAME = "6개 일치 (2,000,000,000원) - %d개"
        const val MSG_OUTPUT_EARNING_RATE = "총 수익률은 %.2f%입니다."
    }
}