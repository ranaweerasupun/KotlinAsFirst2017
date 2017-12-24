@file:Suppress("UNUSED_PARAMETER")

package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
 *
 *
 * Лежит ли точка (x, y) внутри окружности с центром в (x0, y0) и радиусом r?
 */
fun pointInsideCircle(x: Double, y: Double, x0: Double, y0: Double, r: Double) =
        sqr(x - x0) + sqr(y - y0) <= sqr(r)

/**
 * Простая
 *
 * Четырехзначное число назовем счастливым, если сумма первых двух ее цифр равна сумме двух последних.
 * Определить, счастливое ли заданное число, вернуть true, если это так.
 */
fun isNumberHappy(number: Int): Boolean {
    val digits34 = number % 100
    val digits12 = (number - digits34) / 100
    val digit4 = digits34 % 10
    val digit3 = (digits34 - digit4) / 10
    val sumdigits34 = digit4 + digit3
    val digit2 = digits12 % 10
    val digit1 = (digits12 - digit2) / 10
    val sumdigits12 = digit1 + digit2
    return sumdigits12 == sumdigits34
}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {
    val x21 = Math.abs(x2 - x1)
    val y21 = Math.abs(y2 - y1)
    return when {
        y1 == y2 && x1 != x2 -> true
        x1 == x2 && y1 != y2 -> true
        x21 == y21 -> true
        else -> {
            false
        }
    }
}


/**
 * Средняя
 *
 * Проверить, лежит ли окружность с центром в (x1, y1) и радиусом r1 целиком внутри
 * окружности с центром в (x2, y2) и радиусом r2.
 * Вернуть true, если утверждение верно
 */
fun circleInside(x1: Double, y1: Double, r1: Double,
                 x2: Double, y2: Double, r2: Double): Boolean {
    val d = Math.sqrt((sqr(x1 - x2) + sqr(y1 - y2)))

    return (d <= r2 - r1)


}

/**
 * Средняя
 *
 * Определить, пройдет ли кирпич со сторонами а, b, c сквозь прямоугольное отверстие в стене со сторонами r и s.
 * Стороны отверстия должны быть параллельны граням кирпича.
 * Считать, что совпадения длин сторон достаточно для прохождения кирпича, т.е., например,
 * кирпич 4 х 4 х 4 пройдёт через отверстие 4 х 4.
 * Вернуть true, если кирпич пройдёт
 */
fun brickPasses(a: Int, b: Int, c: Int, r: Int, s: Int): Boolean {
    return when {
        s >= b && r >= c -> true
        s >= c && r >= b -> true
        s >= a && r >= b -> true
        s >= b && r >= a -> true
        s >= c && r >= a -> true
        s >= a && r >= c -> true
        else -> false
    }


}

fun main(arg: Array<String>) {
    val h = isNumberHappy(3763)
    println("$h")
    val q = queenThreatens(9, 3, 6, 8)
    println("$q")
    val c = circleInside(5.2, 6.1, 6.3, 1.3, 4.9, 18.1)
    println("$c")
    val b = brickPasses(2, 3, 6, 9, 1)
    println("$b")


}
