package lotto.validator

import lotto.util.ErrorType

object NumberValidator {

    fun validateInteger(input: String) {
        if (!input.isNumeric()) throw IllegalArgumentException(ErrorType.INPUT_NOT_NUMBER)
        if (input.all { it == '0' }) throw IllegalArgumentException(ErrorType.INPUT_ZERO)
        if (input.isDecimalNumber()) throw IllegalArgumentException(ErrorType.INPUT_DECIMAL)
        if (input.isNegativeNumber()) throw IllegalArgumentException(ErrorType.INPUT_NEGATIVE_NUMBER)
        input.toIntOrNull() ?: throw NumberFormatException(ErrorType.INPUT_OVER_MAX_INTEGER)
    }

    private fun String.isNumeric(): Boolean =
        Regex(NUMERIC_REGEX_PATTERN).matches(this)

    private fun String.isNegativeNumber(): Boolean =
        this.toInt() < 0

    private fun String.isDecimalNumber(): Boolean =
        this.contains(".")

    private const val NUMERIC_REGEX_PATTERN = "^-?\\d+(\\.\\d+)?$"
}