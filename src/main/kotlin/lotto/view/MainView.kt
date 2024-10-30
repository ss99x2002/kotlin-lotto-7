package lotto.view

import lotto.controller.LottoManager
import java.lang.IllegalStateException

class MainView(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lotto: LottoManager,
) {

    fun start() {
        while (true) {
            try {
                val count = inputPurchaseCount()
                outputView.printLottoPurchaseCount(count)

                lotto.generateUserLottoNumbers(count)
                outputView.printLottoGenerateNumber(lotto.userLottoNumbers)

                val winningNumbers = inputWinningNumbers()
                val bonusNumbers = inputBonusNumber()



            } catch (e: IllegalArgumentException) {
                println(e.message)
            } catch (e: IllegalStateException) {
                println(e.message)
            }
        }
    }

    fun inputPurchaseCount(): Int {
        val purchasePrice = inputView.getLottoPurchasePrice()
        inputView.validateInputPrice(purchasePrice)
        return purchasePrice.toInt() / 1000
    }

    fun inputWinningNumbers(): List<Int> {
        val winningNumbers = inputView.getWinningNumbers()
        inputView.validateInputWinningNumbers(winningNumbers)
        return winningNumbers.split(",").map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        val bonusNumber = inputView.getBonusNumber()
        inputView.validateInputBonusNumber(bonusNumber)
        return bonusNumber.toInt()
    }

    companion object {
        const val LOTTO_TICKET_PRICE = 1000
    }
}