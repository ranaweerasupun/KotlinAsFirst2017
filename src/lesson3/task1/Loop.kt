@file:Suppress("UNUSED_PARAMETER")
package lesson3.task1

import lesson1.task1.numberRevert
import java.lang.Math.pow
import java.lang.Math.sqrt

/**
 * Пример
 *
 * Вычисление факториала
 */
fun factorial(n: Int): Double {
    var result = 1.0
    for (i in 1..n) {
        result = result * i // Please do not fix in master
    }
    return result
}

/**
 * Пример
 *
 * Проверка числа на простоту -- результат true, если число простое
 */
fun isPrime(n: Int): Boolean {
    if (n < 2) return false
    for (m in 2..Math.sqrt(n.toDouble()).toInt()) {
        if (n % m == 0) return false
    }
    return true
}

/**
 * Пример
 *
 * Проверка числа на совершенность -- результат true, если число совершенное
 */
fun isPerfect(n: Int): Boolean {
    var sum = 1
    for (m in 2..n/2) {
        if (n % m > 0) continue
        sum += m
        if (sum > n) break
    }
    return sum == n
}

/**
 * Пример
 *
 * Найти число вхождений цифры m в число n
 */
fun digitCountInNumber(n: Int, m: Int): Int =
        when {
            n == m -> 1
            n < 10 -> 0
            else -> digitCountInNumber(n / 10, m) + digitCountInNumber(n % 10, m)
        }

/**
 * Тривиальная
 *
 * Найти количество цифр в заданном числе n.
 * Например, число 1 содержит 1 цифру, 456 -- 3 цифры, 65536 -- 5 цифр.
 */
fun digitNumber(n: Int): Int {
    var count = 1
    var x = n / 10
    while ( x >= 1){
        count += 1
        x /= 10


    }

return count
}

//fun pow(m: Int): Int {}

/**
 * Простая
 *
 * Найти число Фибоначчи из ряда 1, 1, 2, 3, 5, 8, 13, 21, ... с номером n.
 * Ряд Фибоначчи определён следующим образом: fib(1) = 1, fib(2) = 1, fib(n+2) = fib(n) + fib(n+1)
 */
fun fib(n: Int): Int  {
    var i :Int = 3
    var n2:Int = 1
    var n1:Int = 1
    if (n < 2) return 1

    while(i <= n ){
       var n3:Int;
        n3 = n1 + n2
        n1 = n2
        n2 = n3
        i++

    }


return n2

}

/**
 * Простая
 *
 * Для заданных чисел m и n найти наименьшее общее кратное, то есть,
 * минимальное число k, которое делится и на m и на n без остатка
 */
fun lcm(m: Int, n: Int): Int {
        val mn = m * n
        var m:Int = m
        var n:Int = n
        var q1:Int;
        var q2:Int;
        var r1:Int;
        var r2:Int;
        if (m > n) {
            while(n > 0){
                q1 = m / n
                r1 = m - q1 * n

                m = n
                n = r1



            }
            return mn / m


        } else if (n > m){
            while(m > 0){
                q2 = n / m
                r2 = n - q2 * m

                n = m
                m = r2



            }
            return mn / n


        } else return m
    }
/**
 * Простая
 *
 * Для заданного числа n > 1 найти минимальный делитель, превышающий 1
 */
fun minDivisor(n: Int): Int {
    var r:Int =2
    var t:Int;
    while (r <= n){
        t = n % r
        if (t != 0) r++ else break


    }

  return r

}

/**
 * Простая
 *
 * Для заданного числа n > 1 найти максимальный делитель, меньший n
 */
fun maxDivisor(n: Int): Int  {
    var i = n-1
    while (i >= 1) {
        var t = n % i
        if (t == 0) break else i -= 1
    }

    return i

}

/**
 * Простая
 *
 * Определить, являются ли два заданных числа m и n взаимно простыми.
 * Взаимно простые числа не имеют общих делителей, кроме 1.
 * Например, 25 и 49 взаимно простые, а 6 и 8 -- нет.
 */
fun isCoPrime(m: Int, n: Int): Boolean {
 var k = (m*n)/lcm(m,n)
    return k==1

}

/**
 * Простая
 *
 * Для заданных чисел m и n, m <= n, определить, имеется ли хотя бы один точный квадрат между m и n,
 * то есть, существует ли такое целое k, что m <= k*k <= n.
 * Например, для интервала 21..28 21 <= 5*5 <= 28, а для интервала 51..61 квадрата не существует.
 */
fun squareBetweenExists(m: Int, n: Int): Boolean {
  var k = 1
    for(i in m..n )
    {
        var t = (Math.sqrt(i.toDouble()) ).toInt()
        if ( t*t==i) return true
        else k = 1
    }
    return k!= 1
}

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * sin(x) = x - x^3 / 3! + x^5 / 5! - x^7 / 7! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun sin(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Для заданного x рассчитать с заданной точностью eps
 * cos(x) = 1 - x^2 / 2! + x^4 / 4! - x^6 / 6! + ...
 * Нужную точность считать достигнутой, если очередной член ряда меньше eps по модулю
 */
fun cos(x: Double, eps: Double): Double = TODO()

/**
 * Средняя
 *
 * Поменять порядок цифр заданного числа n на обратный: 13478 -> 87431.
 * Не использовать строки при решении задачи.
 */
fun revert(n: Int): Int {
        var t1: Int = n
        var t2: Int;
        var t3: Int;
    t3 = 0
    while (t1 != 0){
        t2 = t1 % 10
        t3 = (t3 * 10)+t2
        t1 = t1 / 10



    }

return t3
}

/**
 * Средняя
 *
 * Проверить, является ли заданное число n палиндромом:
 * первая цифра равна последней, вторая -- предпоследней и так далее.
 * 15751 -- палиндром, 3653 -- нет.
 */
fun isPalindrome(n: Int): Boolean {
    val r = revert(n)
    if (r == n) return true



return false
}

/**
 * Средняя
 *
 * Для заданного числа n определить, содержит ли оно различающиеся цифры.
 * Например, 54 и 323 состоят из разных цифр, а 111 и 0 из одинаковых.
 */
fun hasDifferentDigits(n: Int): Boolean {
    var r = n
    var t:Int;
    val p = r % 10
    while (r > 1){
        t = r % 10
        r = r / 10
        if (p == t) continue else return true



    }
return false

}

/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из квадратов целых чисел:
 * 149162536496481100121144...
 * Например, 2-я цифра равна 4, 7-я 5, 12-я 6.
 */
fun squareSequenceDigit(n: Int): Int {
    if (n < 4) {
        if (n==1) return 1
        if (n==2) return 4
        if (n==3) return 9
    }
    var i = 3
    var c = 3
    var t: Int = 0
    var t2:Int = 0
    var rt:Int = 0
    var x: Int = 0

   bottle@ while (rt != 1) {
        i++
        t = i * i
        t2 = (t * 10) + 1
        rt = revert(t2)
        ant@ while (rt >= 10){
        x = rt % 10
        ++c
        if (c == n) {break@bottle
        }
        rt /= 10
        if (rt >= 10){
            continue@ant
        }
        if (rt == 1) {
            rt = 0
            continue@bottle
        }
        }
   }
    return x
}


/**
 * Сложная
 *
 * Найти n-ю цифру последовательности из чисел Фибоначчи (см. функцию fib выше):
 * 1123581321345589144...
 * Например, 2-я цифра равна 1, 9-я 2, 14-я 5.
 */
fun fibSequenceDigit(n: Int): Int {
    /* var a:Int = 5
    var b:Int = 8
    var x:Int = a + b
    var x2:Int = x * 10 + 1
    var rx:Int = revert(x2)
    var c:Int = 6*/

    if (n <= 6) {
        if (n == 1) return 1
        if (n == 2) return 1
        if (n == 3) return 2
        if (n == 4) return 3
        if (n == 5) return 5
        if (n == 6) return 8

    }


    var x: Int = 0
    var x2 = 0
    var rx: Int = 0
    var c = 6
    var a: Int = 5
    var b: Int = 8
    var y = 0


    ball@ while (rx != 1) {

        x = a + b
        x2 = (x * 10) + 1
        rx = revert(x2)
        bat@ while (rx >= 10) {
            y = rx % 10
            c++
            if (c == n) break@ball
            rx /= 10
            if (rx >= 10) {
                continue@bat

            }
            if (rx == 1) {
                rx = 0
                a = b
                b = x
                continue@ball
            }

        }

    }
 return y
}

fun main (arg: Array<String>){

    val d = digitNumber(222222)
    println("$d")
   /* val e = fib(5)
    println("$e")*/
    /*val r = maxDivisor(12)
    println("$r")*/
    val y = revert(568465655)
    println("$y")
    val g = hasDifferentDigits(22222)
    println("$g")
    val o = maxDivisor(9863)
    println("$o")
    val oo = fib(5)
    println ("$oo")
    val pld = isPalindrome(45654)
    println("$pld")
    val  lcm = lcm(2,8)
    println("$lcm")
    val p = isCoPrime(25,49)
    println("$p")
    val hj = squareSequenceDigit(7)
    println("sq = $hj")
    val gh = fibSequenceDigit(8)
    println("gh  =$gh")





}
