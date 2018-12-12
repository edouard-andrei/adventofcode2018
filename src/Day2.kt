import java.io.File
import java.util.*

fun main() {
    var two = 0
    var lineTwoDone = false
    var three = 0
    var lineThreeDone = false
    File("input.txt").forEachLine {
        var a = IntArray(26) { 0 }
        it.forEach {
            a[it - 'a']++
        }
        a.forEach {
            if (it == 2 && !lineTwoDone) {
                two++
                lineTwoDone = true
            }
            if (it == 3 && !lineThreeDone) {
                three++
                lineThreeDone = true
            }
        }
        print(Arrays.toString(a) + "\n")
        a = IntArray(26) { 0 }
        lineTwoDone = false
        lineThreeDone = false
    }
    print(two * three)
    // part 1
}