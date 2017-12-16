@file:Suppress("UNUSED_PARAMETER")
package lesson2.task1
import lesson1.task1.discriminant
import lesson1.task1.sqr
import lesson4.task1.abs

/**
 * Пример
 *
 * Найти наименьший корень биквадратного уравнения ax^4 + bx^2 + c = 0
 */
fun minBiRoot(a: Double, b: Double, c: Double): Double {
    // 1: в главной ветке if выполняется НЕСКОЛЬКО операторов
    if (a == 0.0) {
        if (b == 0.0) return Double.NaN // ... и ничего больше не делать
        val bc = -c / b
        if (bc < 0.0) return Double.NaN // ... и ничего больше не делать
        return -Math.sqrt(bc)
        // Дальше функция при a == 0.0 не идёт
    }
    val d = discriminant(a, b, c)   // 2
    if (d < 0.0) return Double.NaN  // 3
    // 4
    val y1 = (-b + Math.sqrt(d)) / (2 * a)
    val y2 = (-b - Math.sqrt(d)) / (2 * a)
    val y3 = Math.max(y1, y2)       // 5
    if (y3 < 0.0) return Double.NaN // 6
    return -Math.sqrt(y3)           // 7
}

/**
 * Простая
 *
 * Мой возраст. Для заданного 0 < n < 200, рассматриваемого как возраст человека,
 * вернуть строку вида: «21 год», «32 года», «12 лет».
 */
fun ageDescription(age: Int): String{
   if (age in 1..199) {
       if (age % 10 == 1 && age % 100 != 11) return "$age год"
       if ((age % 10 == 2 || age % 10 == 3 || age % 10 == 4) && (age % 100 != 12 && age % 100 != 13 && age % 100 != 14)) return "$age года"

       else return "$age лет"

   }
return "Not an age"
}

/**
 * Простая
 *
 * Путник двигался t1 часов со скоростью v1 км/час, затем t2 часов — со скоростью v2 км/час
 * и t3 часов — со скоростью v3 км/час.
 * Определить, за какое время он одолел первую половину пути?
 */
fun timeForHalfWay(t1: Double, v1: Double,
                   t2: Double, v2: Double,
                   t3: Double, v3: Double): Double {
    val halfDistance=(v1*t1+v2*t2+v3*t3)/2
    return when {
        halfDistance <= v1 * t1 -> halfDistance / v1
        halfDistance <= ((v1 * t1)+(v2 * t2)) -> t1 + ( (halfDistance - v1 * t1) / v2)
        else -> t1 + t2 + ((halfDistance - (v1 * t1) - (v2 * t2)) / v3)
    }


}

/**
 * Простая
 *
 * Нa шахматной доске стоят черный король и две белые ладьи (ладья бьет по горизонтали и вертикали).
 * Определить, не находится ли король под боем, а если есть угроза, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от первой ладьи, 2, если только от второй ладьи,
 * и 3, если угроза от обеих ладей.
 * Считать, что ладьи не могут загораживать друг друга
 */
fun whichRookThreatens(kingX: Int, kingY: Int,
                       rookX1: Int, rookY1: Int,
                       rookX2: Int, rookY2: Int):Int{

    if ((rookX1 != rookX2 || rookY2 != rookY1) && (kingX != rookX1 || kingY != rookY1) && (kingX != rookX2 || kingY != rookY2)) {
        val rookOnethreat = (kingX == rookX1 || kingY == rookY1)
        val rookTwotheat = (kingX == rookX2 || kingY == rookY2)
        return when {
            rookOnethreat && rookTwotheat -> 3
            rookOnethreat -> 1
            rookTwotheat -> 2
            else -> 0
        }
    }
    return -1

}
/*if ((rookX1 != rookX2 || rookY2 != rookY1) && (kingX != rookX1 || kingY != rookY1) && (kingX != rookX2 || kingY != rookY2)) {
    */


/**
 * Простая
 *
 * На шахматной доске стоят черный король и белые ладья и слон
 * (ладья бьет по горизонтали и вертикали, слон — по диагоналям).
 * Проверить, есть ли угроза королю и если есть, то от кого именно.
 * Вернуть 0, если угрозы нет, 1, если угроза только от ладьи, 2, если только от слона,
 * и 3, если угроза есть и от ладьи и от слона.
 * Считать, что ладья и слон не могут загораживать друг друга.
 */



fun rookOrBishopThreatens(kingX: Int, kingY: Int,
                          rookX: Int, rookY: Int,
                          bishopX: Int, bishopY: Int):Int{
    val rookThreat = (((kingX == rookX && kingY != rookY)||(kingX != rookX && kingY == rookY)) && ((bishopX != rookX) || (bishopY != rookY)))
    val bishopThreat = (((Math.abs(kingX - bishopX) == Math.abs(kingY - bishopY)) && ((bishopX != rookX) || (bishopY != rookY))))
    return when {
        rookThreat && bishopThreat -> 3
        rookThreat -> 1
        bishopThreat ->  2
        else -> 0
    }


}

/**
 * Простая
 *
 * Треугольник задан длинами своих сторон a, b, c.
 * Проверить, является ли данный треугольник остроугольным (вернуть 0),
 * прямоугольным (вернуть 1) или тупоугольным (вернуть 2).
 * Если такой треугольник не существует, вернуть -1.
 */
fun triangleKind(a: Double, b: Double, c: Double): Int {
    var x:Double;
    var a = a
    var b = b
    var c = c
    if (c > b){
        x=c
        c=b
        b=x
        x=0.0
    }
    if (b > a){
        x=b
        b=a
        a=x
        x=0.0
    }
    if (c > a){
        x=c
        c=a
        a=x
        x=0.0
    }
    if (b-c<a && a<b+c|| a-b<c && a+b >c || a-c<b && a+c >b){
        val k = (c*c)+(b*b)
        val l = (a*a)
        when {
            k==l -> return 1
            k<l -> return 2
            k>l -> return 0
            else -> {
            }
        }
    }
    return -1


}




    /*if(cb < sqr(a) || ca < sqr(b) || ab < sqr(c)) return 2
    else if (cb == sqr(a) || ca == sqr(b) || ab == sqr(c)) return 1
    else if (cb > sqr(a) || ca > sqr(b) || ab > sqr(c)) return 0
    else return -1

    */





/**
 * Средняя
 *
 * Даны четыре точки на одной прямой: A, B, C и D.
 * Координаты точек a, b, c, d соответственно, b >= a, d >= c.
 * Найти длину пересечения отрезков AB и CD.
 * Если пересечения нет, вернуть -1.
 */
fun segmentLength(a: Int, b: Int, c: Int, d: Int): Int {
    if (b >= a && d >= c){
        return when {
            d >= b && c in a..b -> b-c
            d in a..b && a >= c -> d-a
            c in a..b && d in a..b -> d-c
            a in c..d && b in c..d -> b-a
            else -> -1
        }

    }
    return -2

}



fun main(arg: Array<String>){

   /* val p = segmentLength(5,6,8,4)
    println("$p")*/
    val time= timeForHalfWay(3.0,2.0,1.0,5.0,4.0,1.0)
    println("Time for half way -> $time")
    val a = ageDescription(53)
    println("$a")

    val b = whichRookThreatens(1,2,3,4,5,6)
    val b1:String = when(b) {
        -1 -> "Invalid position"
        else -> "$b"

    }
    println("$b1")
    val rb= rookOrBishopThreatens(5,4,3,7,1,8)
    val rb1:String = when(rb) {
        5 -> "Invalid position - Use values only between 1 and 8"
     else -> "$rb"}
    println("$rb1")
    val t = triangleKind(5.0,3.0,4.0)
    println("TriangleKind -> $t")
    val seg = segmentLength(2,9,1,3)
    if (seg == -2) println("segmentLength -> Invalid number") else println("segmentLength = $seg")

}
