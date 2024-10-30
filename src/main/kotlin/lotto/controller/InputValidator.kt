package lotto.controller

class InputValidator {

    fun validatePriceInput(price: String) {
        require(price.isNotEmpty()) { "구입 금액은 빈 값이 될 수 없습니다. " }
        price.validateNumberInput()
        require(price.toInt() % 1000 == 0) { "구입 금액은 1000원 단위로 입력되어야 합니다. " }
    }

    fun validateWinningNumbers(winningNumbers: String) {
        val splitNumber = winningNumbers.split(",")
        require(winningNumbers.split(",").size == 6) // 사이즈 6개 맞는지
        splitNumber.forEach {
            it.validateNumberInput()
            require(it.toInt() in 1 .. 45 ) { "당첨 번호는 1 ~ 45 범위만 입력 가능합니다. "}
        } // 숫자 맞는지
    }

    fun validateBonusNumberInput(bonusNumber: String) {
        bonusNumber.validateNumberInput()
        require(bonusNumber.toInt() in 1..45) { "보너스 번호는 1 ~ 45 숫자 범위만 입력 가능합니다." }
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
        return Regex("^-?\\d+(\\.\\d+)?$").matches(this)
    }

    private fun String.isNegativeNumber(): Boolean =
        this.toInt() < 0

    private fun String.isDecimalNumber(): Boolean =
        this.toDouble() != this.toInt().toDouble()

    companion object {
        const val MAX_LENGTH_CONDITION = 5
    }
}