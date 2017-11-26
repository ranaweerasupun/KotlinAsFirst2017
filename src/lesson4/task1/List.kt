@file:Suppress("UNUSED_PARAMETER")
package lesson4.task1

import lesson1.task1.discriminant
import lesson1.task1.sqr
import sun.invoke.empty.Empty
import java.lang.Math.pow
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Найти все корни уравнения x^2 = y
 */
fun sqRoots(y: Double) =
        when {
            y < 0 -> listOf()
            y == 0.0 -> listOf(0.0)
            else -> {
                val root = Math.sqrt(y)
                // Результат!
                listOf(-root, root)
            }
        }

/**
 * Пример
 *
 * Найти все корни биквадратного уравнения ax^4 + bx^2 + c = 0.
 * Вернуть список корней (пустой, если корней нет)
 */
fun biRoots(a: Double, b: Double, c: Double): List<Double> {
    if (a == 0.0) {
        return if (b == 0.0) listOf()
        else sqRoots(-c / b)
    }
    val d = discriminant(a, b, c)
    if (d < 0.0) return listOf()
    if (d == 0.0) return sqRoots(-b / (2 * a))
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    return sqRoots(y1) + sqRoots(y2)
}

/**
 * Пример
 *
 * Выделить в список отрицательные элементы из заданного списка
 */
fun negativeList(list: List<Int>): List<Int> {
    val result = mutableListOf<Int>()
    for (element in list) {
        if (element < 0) {
            result.add(element)
        }
    }
    return result
}

/**
 * Пример
 *
 * Изменить знак для всех положительных элементов списка
 */
fun invertPositives(list: MutableList<Int>) {
    for (i in 0 until list.size) {
        val element = list[i]
        if (element > 0) {
            list[i] = -element
        }
    }
}

/**
 * Пример
 *
 * Из имеющегося списка целых чисел, сформировать список их квадратов
 */
fun squares(list: List<Int>) = list.map { it * it }

/**
 * Пример
 *
 * По заданной строке str определить, является ли она палиндромом.
 * В палиндроме первый символ должен быть равен последнему, второй предпоследнему и т.д.
 * Одни и те же буквы в разном регистре следует считать равными с точки зрения данной задачи.
 * Пробелы не следует принимать во внимание при сравнении символов, например, строка
 * "А роза упала на лапу Азора" является палиндромом.
 */
fun isPalindrome(str: String): Boolean {
    val lowerCase = str.toLowerCase().filter { it != ' ' }
    for (i in 0..lowerCase.length / 2) {
        if (lowerCase[i] != lowerCase[lowerCase.length - i - 1]) return false
    }
    return true
}

/**
 * Пример
 *
 * По имеющемуся списку целых чисел, например [3, 6, 5, 4, 9], построить строку с примером их суммирования:
 * 3 + 6 + 5 + 4 + 9 = 27 в данном случае.
 */
fun buildSumExample(list: List<Int>) = list.joinToString(separator = " + ", postfix = " = ${list.sum()}")

/**
 * Простая
 *
 * Найти модуль заданного вектора, представленного в виде списка v,
 * по формуле abs = sqrt(a1^2 + a2^2 + ... + aN^2).
 * Модуль пустого вектора считать равным 0.0.
 */
fun abs(v: List<Double>): Double {
    val coefficientsList = v.map { sqr(it) }
    val sumCoefficients = coefficientsList.sum()
    return sqrt(sumCoefficients)




}


/**
 * Простая
 *
 * Рассчитать среднее арифметическое элементов списка list. Вернуть 0.0, если список пуст
 */
fun mean(list: List<Double>): Double {
    if(list.isEmpty()) return 0.0
    val sumOfterms = list.sum()
    return (sumOfterms / list.size)


}

/**
 * Средняя
 *
 * Центрировать заданный список list, уменьшив каждый элемент на среднее арифметическое всех элементов.
 * Если список пуст, не делать ничего. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun center(list: MutableList<Double>): MutableList<Double> {
    val mean = mean(list)
    var element:Double
    if(list is Empty){ return list }

    for (i in 0 until list.size){
        element = list[i] - mean
        list[i] = element


    }


return list


}

/**
 * Средняя
 *
 * Найти скалярное произведение двух векторов равной размерности,
 * представленные в виде списков a и b. Скалярное произведение считать по формуле:
 * C = a1b1 + a2b2 + ... + aNbN. Произведение пустых векторов считать равным 0.0.
 */
fun times(a: List<Double>, b: List<Double>): Double {
    if (a.isEmpty() && b.isEmpty()) return 0.0
    val listofMultipies = mutableListOf<Double>()

    for (i in 0..a.size-1 ){
        listofMultipies.add(a[i] * b[i])



    }

    return listofMultipies.sum()

}

/**
 * Средняя
 *
 * Рассчитать значение многочлена при заданном x:
 * p(x) = p0 + p1*x + p2*x^2 + p3*x^3 + ... + pN*x^N.
 * Коэффициенты многочлена заданы списком p: (p0, p1, p2, p3, ..., pN).
 * Значение пустого многочлена равно 0.0 при любом x.
 */
fun polynom(p: List<Double>, x: Double): Double {
    val setofTerms = mutableListOf<Double>()
    for(i in 0..p.size-1){
        val newElement = p[i] * pow(x,i.toDouble())
        setofTerms.add(newElement)


    }


return setofTerms.sum()


}

/**
 * Средняя
 *
 * В заданном списке list каждый элемент, кроме первого, заменить
 * суммой данного элемента и всех предыдущих.
 * Например: 1, 2, 3, 4 -> 1, 3, 6, 10.
 * Пустой список не следует изменять. Вернуть изменённый список.
 *
 * Обратите внимание, что данная функция должна изменять содержание списка list, а не его копии.
 */
fun accumulate(list: MutableList<Double>): MutableList<Double> {
    for (i in 0 until list.size-1){
        val elementi = list[i] + list[i+1]
        list[i+1] = elementi



    }


return list


}

/**
 * Средняя
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде списка множителей, например 75 -> (3, 5, 5).
 * Множители в списке должны располагаться по возрастанию.
 */
fun factorize(n: Int): List<Int> = TODO()

/**
 * Сложная
 *
 * Разложить заданное натуральное число n > 1 на простые множители.
 * Результат разложения вернуть в виде строки, например 75 -> 3*5*5
 */
fun factorizeToString(n: Int): String = TODO()

/**
 * Средняя
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием base > 1.
 * Результат перевода вернуть в виде списка цифр в base-ичной системе от старшей к младшей,
 * например: n = 100, base = 4 -> (1, 2, 1, 0) или n = 250, base = 14 -> (1, 3, 12)
 */
fun convert(n: Int, base: Int): List<Int> {
    var m = n
    val listDigits = mutableListOf<Int>()
    val listDigits2 = mutableListOf<Int>()
    if (n < base) {
        listDigits.add(n)
        return listDigits


    }else {


        while (m >= base) {
            val digit = m % base
            listDigits.add(digit)

            m /= base

        }
        listDigits.add(m)
    }


    for (i in 0 until listDigits.size){
        val element = listDigits[listDigits.size-1-i]
        listDigits2.add(element)


    }



    return listDigits2


}

/**
 * Сложная
 *
 * Перевести заданное целое число n >= 0 в систему счисления с основанием 1 < base < 37.
 * Результат перевода вернуть в виде строки, цифры более 9 представлять латинскими
 * строчными буквами: 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: n = 100, base = 4 -> 1210, n = 250, base = 14 -> 13c
 */
fun convertToString(n: Int, base: Int): String {
    val alphabet = mutableListOf<String>()
    val value = mutableListOf<String>()
    val ABCD = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val IntABCD = listOf(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37)
    var m = n
    while (m != 0) {
        val element = m % base
        if( element < 10){
            value.add(element.toString())


        }else
        value.add(ABCD[IntABCD.indexOf(element)])

        m /= base


    }
    for(i in 0 until value.size){
        val eleList1 = value[value.size-1-i]
        alphabet.add(eleList1)

    }


    return alphabet.joinToString(separator = "",prefix = "",postfix = "")  //using jointoString
}

/**
 * Средняя
 *
 * Перевести число, представленное списком цифр digits от старшей к младшей,
 * из системы счисления с основанием base в десятичную.
 * Например: digits = (1, 3, 12), base = 14 -> 250
 */
fun decimal(digits: List<Int>, base: Int): Int {
    val listofValues = mutableListOf<Int>()
    for (i in 0 until digits.size){
        val element = digits[i]
        val values = (element * pow(base.toDouble(),digits.size.toDouble()-1-i)).toInt()
        listofValues.add(values)


    }


    return  listofValues.sum()


}

/**
 * Сложная
 *
 * Перевести число, представленное цифровой строкой str,
 * из системы счисления с основанием base в десятичную.
 * Цифры более 9 представляются латинскими строчными буквами:
 * 10 -> a, 11 -> b, 12 -> c и так далее.
 * Например: str = "13c", base = 14 -> 250
 */
fun decimalFromString(str: String, base: Int): Int {
    val ABCD = listOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    val IntABCD = listOf(10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31,32,33,34,35,36,37)
    val Int123 = listOf(1,2,3,4,5,6,7,8,9,0)
    val string123 = listOf("1","2","3","4","5","6","7","8","9","0")
    val number = mutableListOf<Int>()
    for (i in 0 until str.length){
        val character =(str[str.length-1-i]).toString()
        if (character in ABCD){
           val value = IntABCD[ABCD.indexOf(character)] *( pow(base.toDouble(), i.toDouble())).toInt()
            number.add(value)
        }
        else if (character in string123 ){
            val value = Int123[string123.indexOf(character)] * ( pow(base.toDouble(), i.toDouble())).toInt()
            number.add(value)

        }


    }

return number.sum()


}

/**
 * Сложная
 *
 * Перевести натуральное число n > 0 в римскую систему.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: 23 = XXIII, 44 = XLIV, 100 = C
 */
fun roman(n: Int): String  {
    val listofAll = mutableListOf<String>()
    val listofDigits = mutableListOf<String>()
    val mainList = listOf<String>("I","IV","V","IX","X","XL","L","XC","C","CD","D","CM","M")
    val subList = listOf<String>("II","III","VI","VII","VIII","XX","XXX","LX","LXX","LXXX","CC","CCC","DC","DCC","DCCC","MM","MMM")
    val IntmainList = listOf<Int>(1,4,5,9,10,40,50,90,100,400,500,900,1000)
    val IntsubList = listOf<Int>(2,3,6,7,8,20,30,60,70,80,200,300,600,700,800,2000,3000)
    var m = n
    while (m != 0){
        var p = 10
        val value = m % p
        if (value in IntmainList){
            listofAll.add(mainList[IntmainList.indexOf(value)])

        }else if(value in IntsubList){
            listofAll.add(subList[IntsubList.indexOf(value)])


        }
        m -= value
        p *= 10



    }
    for (i in 0 until listofAll.size){
        val digit = listofAll[listofAll.size-1-i]
        listofDigits.add(digit)
    }



return listofDigits.joinToString(separator = "",prefix = "",postfix = "")   //using jointoString


}

/**
 * Очень сложная
 *
 * Записать заданное натуральное число 1..999999 прописью по-русски.
 * Например, 375 = "триста семьдесят пять",
 * 23964 = "двадцать три тысячи девятьсот шестьдесят четыре"
 */
fun russian(n: Int): String = TODO()


fun main (arg: Array<String>){
    val b = sqRoots(25.0)
    println("$b")
    val d = biRoots(1.0,5.0,6.0)
    println("$d")
   val v = negativeList(listOf(1,-5,4))
    println("$v")
    val f = invertPositives(mutableListOf(10,-6,5))
    println("$f")
    val roma = roman(645)
    println("$roma")






}
