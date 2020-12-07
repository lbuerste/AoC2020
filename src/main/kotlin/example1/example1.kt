package example1

import getExampleData

val allNumbers = getExampleData(1).map {
    it.toInt()
}

fun getAnswer1(): String{

    return allNumbers
        .flatMap {
            allNumbers.filter {number -> (number + it) == 2020 }
        }
        .reduce { acc, i -> acc*i }.toString()
}

fun getAnswer2(): String{

    val resultList = allNumbers.flatMap {
        allNumbers.flatMap { number1 ->
            allNumbers.filter { number2 ->
                (number1 != number2 && number1 != it && number2 != it) &&
                        ((number1 + number2 + it) == 2020)
            }
        }
    }.distinct();

    return resultList.reduce { acc, i -> acc*i }.toString()
}