package lotto.view

import camp.nextstep.edu.missionutils.Console
import lotto.controller.InputValidator

class InputView(private val inputValidator: InputValidator) {
    fun getLottoPurchasePrice(): String {
        println(MSG_INPUT_LOTTO_PURCHASE_PRICE)
        return Console.readLine()
    }

    fun getWinningNumbers(): String {
        println(MSG_INPUT_WINNING_NUMBERS)
        return Console.readLine()
    }

    fun getBonusNumber(): String {
        println(MSG_INPUT_BONUS_NUMBER)
        return Console.readLine()
    }

    fun validateInputPrice(price: String) {
        inputValidator.validatePriceInput(price)
    }

    fun validateInputWinningNumbers(numbers: String) {
        inputValidator.validateWinningNumbers(numbers)
    }

    fun validateInputBonusNumber(bonusNumber: String) {
        inputValidator.validateBonusNumberInput(bonusNumber)
    }

    companion object {
        const val MSG_INPUT_LOTTO_PURCHASE_PRICE = "구입금액을 입력해 주세요."
        const val MSG_INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요."
        const val MSG_INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요."
    }
}