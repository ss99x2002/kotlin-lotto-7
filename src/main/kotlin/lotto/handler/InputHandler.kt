package lotto.handler

import lotto.validator.InputValidator
import lotto.view.InputView

class InputHandler(
    private val inputView: InputView,
    private val inputValidator: InputValidator
) {

    fun inputPurchaseCount(): Int {
        return inputWithRetry {
            val purchasePrice = inputView.getLottoPurchasePrice()
            inputValidator.validatePriceInput(purchasePrice)
            (purchasePrice.toInt() / 1000)
        }
    }

    fun inputWinningNumbers(): List<Int> {
        return inputWithRetry {
            val winningNumbers = inputView.getWinningNumbers()
            inputValidator.validateWinningNumbers(winningNumbers)
            winningNumbers.split(",").map { it.toInt() }
        }
    }

    fun inputBonusNumber(winningNumbers: List<Int>): Int {
        return inputWithRetry {
            val bonusNumber = inputView.getBonusNumber()
            inputValidator.validateBonusNumberInput(winningNumbers, bonusNumber)
            bonusNumber.toInt()
        }
    }

    private inline fun <T> inputWithRetry(block: () -> T): T {
        while (true) {
            try {
                return block()
            } catch (e: IllegalArgumentException) {
                println("[ERROR] ${e.message}")
            }
        }
    }
}