package lotto.view

import lotto.model.Lotto
import lotto.model.MatchType
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
    }

    fun printLottoEarningRate(earningRate: Double) {
        printMessageWithNumber(MSG_OUTPUT_EARNING_RATE, earningRate.formatKoreaNumber())
    }

    fun printLottoWinningCount(matchType: MatchType, count: Int) {
        printMessageWinningCount(matchType, count)
    }

    private fun printMessageWithNumber(message: String, number: Any) {
        println(String.format(message, number))
    }

    private fun printMessageWinningCount(matchType: MatchType, userCount: Int) {
        println(
            String.format(
                if (matchType.isBonusMatch) MSG_OUTPUT_WINNING_BONUS_MATCH_COUNT
                else MSG_OUTPUT_WINNING_MATCH_COUNT,
                matchType.matchingCount,
                matchType.prize.formatKoreaNumber(), userCount
            )
        )
    }

    fun Number.formatKoreaNumber(): String {
        val numberFormat = NumberFormat.getInstance(Locale.KOREA).apply {
            maximumFractionDigits = 2 // 소수점 둘째 자리까지
        }
        return numberFormat.format(this)
    }

    companion object {
        const val MSG_OUTPUT_LOTTO_PURCHASE_COUNT = "\n%d개를 구매했습니다."
        const val MSG_OUTPUT_WINNING_STAT = "\n당첨 통계\n---"
        const val MSG_OUTPUT_WINNING_MATCH_COUNT = "%d개 일치 (%s원) - %d개"
        const val MSG_OUTPUT_WINNING_BONUS_MATCH_COUNT = "%d개 일치, 보너스 볼 일치 (%s원) - %d개"
        const val MSG_OUTPUT_EARNING_RATE = "총 수익률은 %s%%입니다.\n"
    }
}