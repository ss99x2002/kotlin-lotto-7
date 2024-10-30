package lotto.controller

class InputValidator {

    fun validatePriceInput(price: String) {
        require(price.isNotEmpty()) { "구입 금액은 빈 값이 될 수 없습니다. " }
        price.validateNumberInput()
        require(price.toInt() % LOTTO_PRICE_UNIT == ZERO) { "구입 금액은 1000원 단위로 입력되어야 합니다. " }
    }

    fun validateWinningNumbers(winningNumbers: String) {
        val splitNumber = winningNumbers.split(",")
        splitNumber.forEach {
            it.validateNumberInput() // 숫자 맞는지
        }
        require(splitNumber.distinct().size == LOTTO_NUMBER_COUNT_CONDITION) { "6개 중복 x"} // 사이즈 6개 맞는지
    }

    fun validateBonusNumberInput(bonusNumber: String) {
        bonusNumber.validateNumberInput()
        require(bonusNumber.toInt() in MIN_LOTTO_NUMBER_CONDITION..MAX_LOTTO_NUMBER_CONDITION) { "보너스 번호는 1 ~ 45 숫자 범위만 입력 가능합니다." }
    }

    fun String.validateNumberInput() {
        if (!(this.isNumeric()))
            throw IllegalArgumentException()
        if (isDecimalNumber())
            throw IllegalArgumentException()
        if (this.isNegativeNumber())
            throw IllegalArgumentException()
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
        const val NUMERIC_REGEX_PATTERN = "\"^-?\\\\d+(\\\\.\\\\d+)?\$\""
    }
}