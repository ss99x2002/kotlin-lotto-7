package lotto.controller

import lotto.util.ErrorType

class InputValidator {

    fun validatePriceInput(price: String) {
        require(price.isNotEmpty()) { ErrorType.PRICE_INPUT_NOT_EMPTY }
        price.validateNumberInput()
        require(price.toInt() % LOTTO_PRICE_UNIT == ZERO) { ErrorType.PRICE_INPUT_NOT_1000_UNIT }
    }

    fun validateWinningNumbers(winningNumbers: String) {
        val splitNumber = winningNumbers.split(",")
        splitNumber.forEach {
            it.validateNumberInput()
        }
        require(splitNumber.size == LOTTO_NUMBER_COUNT_CONDITION) { ErrorType.LOTTO_NUMBER_INPUT_COUNT_CONDITION } // 사이즈 6개 맞는지
        require(splitNumber.all { it.toInt() in 1..45 }) { ErrorType.LOTTO_NUMBER_INPUT_RANGE_CONDITION }
        require(splitNumber.distinct().size == 6) { ErrorType.LOTTO_NUMBER_INPUT_NOT_DUPLICATION }
    }

    fun validateBonusNumberInput(bonusNumber: String) {
        bonusNumber.validateNumberInput()
        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER_CONDITION..MAX_LOTTO_NUMBER_CONDITION) { ErrorType.BONUS_NUMBER_INPUT_RANGE_CONDITION }
    }

    fun String.validateNumberInput() {
        if (!(this.isNumeric()))
            throw IllegalArgumentException(ErrorType.INPUT_NOT_NUMBER)
        if (isDecimalNumber())
            throw IllegalArgumentException(ErrorType.INPUT_DECIMAL)
        if (this.isNegativeNumber())
            throw IllegalArgumentException(ErrorType.INPUT_NEGATIVE_NUMBER)
    }

    private fun String.isNumeric(): Boolean {
        return Regex(NUMERIC_REGEX_PATTERN).matches(this)
    }

    private fun String.isNegativeNumber(): Boolean =
        this.toInt() < ZERO

    private fun String.isDecimalNumber(): Boolean =
        this.toDouble() != this.toInt().toDouble()

    companion object {
        const val MIN_LOTTO_NUMBER_CONDITION = 1
        const val MAX_LOTTO_NUMBER_CONDITION = 45
        const val LOTTO_NUMBER_COUNT_CONDITION = 6
        const val LOTTO_PRICE_UNIT = 1000
        const val ZERO = 0
        const val NUMERIC_REGEX_PATTERN = "^-?\\d+(\\.\\d+)?$"
    }
}