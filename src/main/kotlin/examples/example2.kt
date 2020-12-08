package examples

import getExampleData

val allLines = getExampleData(2);
val pwObjs = allLines.map{
    val policy = it.substringBefore(':').trim()
    val minMaxString = policy.substringBefore(' ');
    val min = minMaxString.substringBefore('-').trim().toInt()
    val max = minMaxString.substringAfter('-').trim().toInt()
    val policyChar = policy.last();

    val password = it.substringAfter(':').trim()
    Password(Policy(min, max, policyChar), password)
}

class Password(var policy: Policy, var password: String){}
class Policy(var min: Int, var max: Int, var policyChar: Char){}

fun countOccurrences(s: String, ch: Char): Int {
    return s.filter { it == ch }.count()
}

fun getAnswer3(): String{
    var validCounter = 0
    pwObjs.forEach{
        val occurences = countOccurrences(it.password, it.policy.policyChar)
        if(occurences >= it.policy.min && occurences <= it.policy.max){
            validCounter++
        }
    }
    return validCounter.toString();
}

fun getAnswer4(): String{
    var validCounter = 0
    pwObjs.forEach{
        if((it.password[(it.policy.min-1)] == it.policy.policyChar) xor
            (it.password[(it.policy.max-1)] == it.policy.policyChar)){
            validCounter++
        }
    }
    return validCounter.toString();
}

