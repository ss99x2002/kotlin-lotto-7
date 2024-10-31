package lotto.view

import lotto.controller.Lotto
import lotto.model.Winning
import java.text.NumberFormat
import java.util.*

class OutputView {

    fun printLottoPurchaseCount(purchaseCount: Int) {
        printMessageWithNumber(MSG_OUTPUT_LOTTO_PURCHASE_COUNT, purchaseCount)
    }

    fun printLottoGenerateNumber(lottoNumbers: List<Lotto>) {
        lottoNumbers.forEach { line ->
            println(line.getNumbers())
        }
    }

    fun printLottoWinningStat() {
        println(MSG_OUTPUT_WINNING_STAT)
        Winning.entries.forEach { entry ->
            printLottoWinningCount(entry, entry.getCount())
        }
    }

    fun printLottoEarningRate(earningRate: Double) {
        printMessageWithNumber(MSG_OUTPUT_EARNING_RATE, earningRate.formatKoreaNumber())
        println("\n")
    }

    private fun printLottoWinningCount(winning: Winning, count: Int) {
        if (winning != Winning.NONE) {
            printMessageWithNumber(getWinningMessage(winning), count)
        }
    }

    fun getWinningMessage(winning: Winning): String {
        return when (winning) {
            Winning.THREE -> MSG_OUTPUT_THREE_SAME
            Winning.FOUR -> MSG_OUTPUT_FOUR_SAME
            Winning.FIVE_NOT_BONUS -> MSG_OUTPUT_FIVE_SAME_NOT_BONUS
            Winning.FIVE_BONUS -> MSG_OUTPUT_FIVE_SAME_BONUS
            Winning.SIX -> MSG_OUTPUT_SIX_SAME
            Winning.NONE -> ""
        }
    }

    private fun printMessageWithNumber(message: String, number: Any) {
        println(String.format(message, number))
    }

    fun Double.formatKoreaNumber(): String {
        val numberFormat = NumberFormat.getInstance(Locale.KOREA).apply {
            maximumFractionDigits = 2 // 소수점 둘째 자리까지
            minimumFractionDigits = 2 // 최소 소수점 자리도 둘째 자리로
        }
        return numberFormat.format(this)
    }

    companion object {
        const val MSG_OUTPUT_LOTTO_PURCHASE_COUNT = "\n%d개를 구매했습니다."
        const val MSG_OUTPUT_WINNING_STAT = "\n당첨 통계\n---"
        const val MSG_OUTPUT_THREE_SAME = "3개 일치 (5,000원) - %d개"
        const val MSG_OUTPUT_FOUR_SAME = "4개 일치 (50,000원) - %d개"
        const val MSG_OUTPUT_FIVE_SAME_NOT_BONUS = "5개 일치 (1,500,000원) - %d개"
        const val MSG_OUTPUT_FIVE_SAME_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개"
        const val MSG_OUTPUT_SIX_SAME = "6개 일치 (2,000,000,000원) - %d개"
        const val MSG_OUTPUT_EARNING_RATE = "총 수익률은 %s%%입니다."
    }
}