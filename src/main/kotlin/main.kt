import java.io.File
import java.nio.file.Paths

fun main(args: Array<String>) {
    println("Answer 1 of Example 1:" + example1.getAnswer1())
    println("Answer 2 of Example 1:" + example1.getAnswer2())
}

fun getExampleData(example: Int): List<String>{
    val path = Paths.get("").toAbsolutePath().toString()
    val pathToFile = "$path/src/main/resources/input_example_$example.txt"
    return File(pathToFile).readLines();
}