@file:Suppress("UNUSED_PARAMETER")
package lesson2.task2

import lesson1.task1.sqr

/**
 * Пример
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
fun isNumberHappy(number: Int):Boolean {
    val n1=number%100
    val n2=(number-n1)/100
    val n11=n1%10
    val n12=(n1-n11)/10
    val n8=n11+n12
    val n21=n2%10
    val n22=(n2-n21)/10
    val n9=n21+n22
    if (n8==n9) {
        return true
    }
return false


}

/**
 * Простая
 *
 * На шахматной доске стоят два ферзя (ферзь бьет по вертикали, горизонтали и диагоналям).
 * Определить, угрожают ли они друг другу. Вернуть true, если угрожают.
 * Считать, что ферзи не могут загораживать друг друга.
 */
fun queenThreatens(x1: Int, y1: Int, x2: Int, y2: Int): Boolean {

    val x21=Math.abs(x2-x1)
    val y21=Math.abs(y2-y1)
if (x1 in 1..8 && x2 in 1..8 && y1 in 1..8 && y2 in 1..8) {
    if (y1 == y2 && x1 != x2) return true

    if (x1 == x2 && y1 != y2) return true

    if (x21 == y21) return true
}

 return false


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
    val d=Math.sqrt((sqr(x1-x2)+sqr(y1-y2)))

    if (d <= r2-r1) return true

 return false




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
    if (s >= b && r >= c) return true
    if (s >= c && r >= b) return true
    if (s >= a && r >= b) return true
    if (s >= b && r >= a) return true
    if (s >= c && r >= a) return true
    if (s >= a && r >= c) return true

    return false


}

fun main(arg: Array<String>){
    val h= isNumberHappy(3763)
    println("$h")
    val q= queenThreatens(9,3,6,8)
    println("$q")
    val c= circleInside(5.2,6.1,6.3,1.3,4.9,18.1)
    println("$c")
    val b= brickPasses(2,3,6,9,1)
    println("$b")



}
