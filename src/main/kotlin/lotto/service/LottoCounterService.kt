package lotto.service

import lotto.model.MatchType

class LottoCounterService {

    private val resultCountMap = mutableMapOf<MatchType, Int>().apply {
        MatchType.entries.forEach { type -> put(type, 0) }
    }

    fun incrementResult(type: MatchType) {
        resultCountMap[type] = resultCountMap.getOrDefault(type, 0) + 1
    }

    fun getResultMap(): Map<MatchType, Int> {
        return resultCountMap
    }
}