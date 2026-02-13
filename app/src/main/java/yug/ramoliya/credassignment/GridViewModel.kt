package yug.ramoliya.credassignment

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel

class GridViewModel : ViewModel() {
    val numbers = mutableStateListOf(0,0,0,0,0,0,0,0,0)

    fun onBoxClick(index: Int) {
        if (numbers[index] >= 15) return

        numbers[index] += 1
        val newValue = numbers[index]

        val row = index / 3
        val col = index % 3

        if (newValue % 3 == 0 && col < 2) {
            val rightIndex = index + 1

            if (numbers[rightIndex] < 15) {
                numbers[rightIndex] -= 1
            }
        }

        if (newValue % 5 == 0 && row < 2) {
            val belowIndex = index + 3

            if (numbers[belowIndex] < 15) {
                numbers[belowIndex] += 2
            }
        }
    }

    fun resetGrid() {
        for (i in numbers.indices) {
            numbers[i] = 0
        }
    }
}