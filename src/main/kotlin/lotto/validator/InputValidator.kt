package lotto.validator

import lotto.util.ErrorType

class InputValidator {

    fun validatePriceInput(price: String) {
        if (price.isEmpty()) {
            throw IllegalStateException(ErrorType.PRICE_EMPTY)
        }

        NumberValidator.validateInteger(price)

        require(price.toInt() % LOTTO_PRICE_UNIT == 0) {
            ErrorType.PRICE_NOT_1000_UNIT
        }
    }

    fun validateWinningNumbers(winningNumbers: String) {
        if (winningNumbers.isEmpty()) {
            throw IllegalStateException(ErrorType.LOTTO_NUMBER_EMPTY)
        }

        val splitNumbers = winningNumbers.split(",").map { it.trim() }

        require(splitNumbers.size == LOTTO_NUMBER_COUNT) {
            ErrorType.LOTTO_NUMBER_COUNT_CONDITION
        }

        splitNumbers.forEach {
            NumberValidator.validateInteger(it)
        }

        require(splitNumbers.all { number ->
            number.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
        }) {
            ErrorType.LOTTO_NUMBER_RANGE_CONDITION
        }

        require(splitNumbers.distinct().size == LOTTO_NUMBER_COUNT) {
            ErrorType.LOTTO_NUMBER_DUPLICATION
        }
    }

    fun validateBonusNumberInput(winningNumbers: List<Int>, bonusNumber: String) {
        if (bonusNumber.isEmpty()) {
            throw IllegalStateException(ErrorType.BONUS_NUMBER_EMPTY)
        }

        NumberValidator.validateInteger(bonusNumber) // NumberValidator의 정수 검증 사용

        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
            ErrorType.BONUS_NUMBER_RANGE_CONDITION
        }

        require(bonusNumber.toInt() !in winningNumbers) {
            ErrorType.BONUS_NUMBER_NOT_CONTAINS_WINNING_NUMBER
        }
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45
        const val LOTTO_NUMBER_COUNT = 6
        const val LOTTO_PRICE_UNIT = 1000
    }
}