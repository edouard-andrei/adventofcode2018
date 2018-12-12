import java.io.File

fun parseFileToInt(fileName: String): List<Int> {
    val intList = mutableListOf<Int>()

    try {
        File(fileName).forEachLine {
            try {
                val maybeInteger = it.toInt()
                intList.add(maybeInteger)
            } catch (err:Exception) {
                error("Can't process: $it")
            }
        }
    } catch (err: Exception) {
        error("Error reading input")
    }

    return intList.toList()
}

fun main() {
    val intList = parseFileToInt("input.txt")
    var sum = 0
    intList.forEach {
        sum += it
    }
    print("Sum: $sum \n")
    val set = mutableSetOf<Int>()
    sum = 0
    var index = 0
    while(true) {
        sum += intList[index]
        if(set.contains(sum)) {
            print("First sum to repeat: $sum")
            break
        }
        set.add(sum)
        index++
        if(index == intList.size) {
            index = 0
        }
    }
}