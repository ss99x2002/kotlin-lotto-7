package lotto.util

object ErrorType {

    // 입력 숫자 검증
    val INPUT_NOT_NUMBER by lazy { "입력 값이 숫자가 아닙니다. 입력은 양의 정수여야 합니다." }
    val INPUT_ZERO by lazy { "입력 값이 0입니다. 입력은 양의 정수여야 합니다."}
    val INPUT_DECIMAL by lazy { "입력 값이 소수입니다. 입력은 양의 정수여야 합니다." }
    val INPUT_NEGATIVE_NUMBER by lazy { "입력 값이 음수입니다. 입력은 양의 정수여야 합니다." }
    val INPUT_OVER_MAX_INTEGER by lazy { "입력 값이 너무 큽니다. 입력의 최대는 ${Int.MAX_VALUE}입니다." }

    // 구입 금액
    val PRICE_EMPTY by lazy { "구입 금액은 빈 값이 될 수 없습니다." }
    val PRICE_NOT_1000_UNIT by lazy { "구입 금액은 1000원 단위로 입력되어야 합니다." }

    // 로또 번호
    val LOTTO_NUMBER_EMPTY by lazy { "로또 번호는 빈 값이 될 수 없습니다." }
    val LOTTO_NUMBER_COUNT_CONDITION by lazy { "로또 당첨 번호는 6개의 숫자만 가능합니다." }
    val LOTTO_NUMBER_RANGE_CONDITION by lazy { "로또 번호는 1부터 45 사이여야 합니다." }
    val LOTTO_NUMBER_DUPLICATION by lazy { "로또 번호는 중복될 수 없습니다." }

    // 보너스 번호
    val BONUS_NUMBER_EMPTY by lazy { "보너스 번호는 빈 값이 될 수 없습니다."}
    val BONUS_NUMBER_RANGE_CONDITION by lazy { "보너스 번호는 1 ~ 45 숫자 범위만 입력 가능합니다." }
    val BONUS_NUMBER_NOT_CONTAINS_WINNING_NUMBER by lazy { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
}