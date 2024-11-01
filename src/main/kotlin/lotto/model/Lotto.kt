package lotto.model

import lotto.util.ErrorType

class Lotto(private val numbers: List<Int>) {

    init {
        require(numbers.size == 6) { ErrorType.LOTTO_NUMBER_COUNT_CONDITION }
        require(numbers.all { it in 1..45 }) { ErrorType.LOTTO_NUMBER_RANGE_CONDITION }
        require(numbers.distinct().size == 6) { ErrorType.LOTTO_NUMBER_DUPLICATION }
    }

    fun getNumbers(): List<Int> = numbers
}