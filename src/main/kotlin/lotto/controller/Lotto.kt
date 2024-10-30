package lotto.controller

class Lotto(private val numbers: List<Int>) {
    // numbers를 하나 샀을 때 1개 구매 6개 숫자라 생각 -> 판단 로직으로 들어가기
    init {
        require(numbers.size == 6) { "[ERROR] 로또 번호는 6개여야 합니다." }
    }



    // TODO: 추가 기능 구현
}
