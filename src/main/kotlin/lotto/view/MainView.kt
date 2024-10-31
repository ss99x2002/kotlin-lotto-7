package lotto.view

import lotto.controller.InputValidator
import lotto.controller.LottoManager
import java.lang.IllegalStateException

class MainView(
    private val inputView: InputView = InputView(InputValidator()),
    private val outputView: OutputView = OutputView(),
    private val lottoManager: LottoManager = LottoManager(),
) {

    fun start() {
        while (true) {
            try {
                lottoManager.clearLottoManager()

                val count = inputPurchaseCount()
                outputView.printLottoPurchaseCount(count)

                lottoManager.generateUserLottoNumbers(count)
                outputView.printLottoGenerateNumber(lottoManager.userLottoNumbers)

                val winningNumbers = inputWinningNumbers()
                val bonusNumbers = inputBonusNumber()

                lottoManager.checkWinning(winningNumbers, bonusNumbers)
                outputView.printLottoWinningStat()
                outputView.printLottoEarningRate(lottoManager.calculateEarningRate(count))

            } catch (e: IllegalArgumentException) {
                println("[ERROR]" + e.message)
            } catch (e: IllegalStateException) {
                println("[ERROR]" + e.message)
            }
        }
    }

    fun inputPurchaseCount(): Int {
        while (true) {
            try {
                val purchasePrice = inputView.getLottoPurchasePrice()
                inputView.validateInputPrice(purchasePrice)
                return (purchasePrice.toInt() / 1000)
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun inputWinningNumbers(): List<Int> {
        while (true) {
            try {
                val winningNumbers = inputView.getWinningNumbers()
                inputView.validateInputWinningNumbers(winningNumbers)
                return winningNumbers.split(",").map { it.toInt() }
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    fun inputBonusNumber(): Int {
        while (true) {
            try {
                val bonusNumber = inputView.getBonusNumber()
                inputView.validateInputBonusNumber(bonusNumber)
                return bonusNumber.toInt()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }

    companion object {
    }
}