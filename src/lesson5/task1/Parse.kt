@file:Suppress("UNUSED_PARAMETER")
package lesson5.task1

/**
 * Пример
 *
 * Время представлено строкой вида "11:34:45", содержащей часы, минуты и секунды, разделённые двоеточием.
 * Разобрать эту строку и рассчитать количество секунд, прошедшее с начала дня.
 */
fun timeStrToSeconds(str: String): Int {
    val parts = str.split(":")
    var result = 0
    for (part in parts) {
        val number = part.toInt()
        result = result * 60 + number
    }
    return result
}

/**
 * Пример
 *
 * Дано число n от 0 до 99.
 * Вернуть его же в виде двухсимвольной строки, от "00" до "99"
 */
fun twoDigitStr(n: Int) = if (n in 0..9) "0$n" else "$n"

/**
 * Пример
 *
 * Дано seconds -- время в секундах, прошедшее с начала дня.
 * Вернуть текущее время в виде строки в формате "ЧЧ:ММ:СС".
 */
fun timeSecondsToStr(seconds: Int): String {
    val hour = seconds / 3600
    val minute = (seconds % 3600) / 60
    val second = seconds % 60
    return String.format("%02d:%02d:%02d", hour, minute, second)
}

/**
 * Пример: консольный ввод
 */
fun main(args: Array<String>) {
    println("Введите время в формате ЧЧ:ММ:СС")
    val line = readLine()
    if (line != null) {
        val seconds = timeStrToSeconds(line)
        if (seconds == -1) {
            println("Введённая строка $line не соответствует формату ЧЧ:ММ:СС")
        }
        else {
            println("Прошло секунд с начала суток: $seconds")
        }
    }
    else {
        println("Достигнут <конец файла> в процессе чтения строки. Программа прервана")
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15 июля 2016".
 * Перевести её в цифровой формат "15.07.2016".
 * День и месяц всегда представлять двумя цифрами, например: 03.04.2011.
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateStrToDigit(str: String): String {
    val months = listOf("января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря")
    val parts = str.split(" ")
    if(parts.size != 3 ) return ""
    val day = twoDigitStr(parts[0].toInt())
    val month = twoDigitStr(months.indexOf(parts[1])+1)
    val year = parts[2]
    return if ( month == "00" || day >"31"){
        ""
    } else {
        String.format("%s.%s.%s",day,month,year)
    }
}

/**
 * Средняя
 *
 * Дата представлена строкой вида "15.07.2016".
 * Перевести её в строковый формат вида "15 июля 2016".
 * При неверном формате входной строки вернуть пустую строку
 */
fun dateDigitToStr(digital: String): String {
    val months = listOf("января","февраля","марта","апреля","мая","июня","июля","августа","сентября","октября","ноября","декабря")
    val parts = digital.split(".")
    if (parts.size != 3 ) return ""
    try {
        val day = parts[0].toInt().toString()
        if (parts[1].toInt() !in 1..12) return ""
        val month = months[parts[1].toInt() - 1]
        val year = parts[2]
        return if (day > "31") {
            ""
        } else {
            String.format("%s %s %s", day, month, year)
        }
    }
    catch (e:NumberFormatException){
        return ""
    }
}

/**
 * Средняя
 *
 * Номер телефона задан строкой вида "+7 (921) 123-45-67".
 * Префикс (+7) может отсутствовать, код города (в скобках) также может отсутствовать.
 * Может присутствовать неограниченное количество пробелов и чёрточек,
 * например, номер 12 --  34- 5 -- 67 -98 тоже следует считать легальным.
 * Перевести номер в формат без скобок, пробелов и чёрточек (но с +), например,
 * "+79211234567" или "123456789" для приведённых примеров.
 * Все символы в номере, кроме цифр, пробелов и +-(), считать недопустимыми.
 * При неверном формате вернуть пустую строку
 */
fun flattenPhoneNumber(phone: String): String {
    val stringLength = phone.length
    val mark = listOf("(", ")", "-", " ")
    val in123 = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "0")
    var phoneNumber = ""
    try {


        if (phone[0] in in123.toString() + '+') {
            phoneNumber += phone[0]
        }
        for (i in 1 until stringLength) {
            when {
                phone[i].toString() in in123 -> phoneNumber += phone[i]
                phone[i].toString() in mark -> phoneNumber
                else -> return ""
            }


        }
        return phoneNumber
    }
    catch (e: StringIndexOutOfBoundsException){
        return ""

    }

}

/*
    try {
        for (i in 0..stringLength) {
            val element = phone[i].toString()
            if ((element !in mark) && (element in in123)) {
                phoneNumber + element

            }


        }
        return phoneNumber.toString()
    }
    catch (e: StringIndexOutOfBoundsException){
        throw ""
    }

**/


/**
 * Средняя
 *
 * Результаты спортсмена на соревнованиях в прыжках в длину представлены строкой вида
 * "706 - % 717 % 703".
 * В строке могут присутствовать числа, черточки - и знаки процента %, разделённые пробелами;
 * число соответствует удачному прыжку, - пропущенной попытке, % заступу.
 * Прочитать строку и вернуть максимальное присутствующее в ней число (717 в примере).
 * При нарушении формата входной строки или при отсутствии в ней чисел, вернуть -1.
 */
fun bestLongJump(jumps: String): Int {
    val validChar = " -%0123456789"
    for (char in jumps) {
        when (char) {
            !in validChar -> return -1
        }
    }
    val numbers = jumps.split(" ").filter { it != "-" && it != "%" }.map { it.toInt()}
    return if (numbers.isEmpty()) -1
    else numbers.max()!!

}



/**
 * Сложная
 *
 * Результаты спортсмена на соревнованиях в прыжках в высоту представлены строкой вида
 * "220 + 224 %+ 228 %- 230 + 232 %%- 234 %".
 * Здесь + соответствует удачной попытке, % неудачной, - пропущенной.
 * Высота и соответствующие ей попытки разделяются пробелом.
 * Прочитать строку и вернуть максимальную взятую высоту (230 в примере).
 * При нарушении формата входной строки вернуть -1.
 */
fun bestHighJump(jumps: String): Int {
    val validChar = " +-%0123456789"
    val termsList = jumps.split(" ")
    var heighest = 0
    for (i in 0 until validChar.length){
        if (validChar[i] !in validChar)
        return -1
    }
    if ( termsList.isEmpty() || termsList.size % 2 != 0) return -1
    return  try {
        for (i in 0 until termsList.size step 2){
            if (termsList[i].toInt() > heighest && "+" in termsList[i + 1]){
                heighest = termsList[i].toInt()}

        }
       heighest

    }
    catch (e: NumberFormatException){
        return -1
    }




}






/**
 * Сложная
 *
 * В строке представлено выражение вида "2 + 31 - 40 + 13",
 * использующее целые положительные числа, плюсы и минусы, разделённые пробелами.
 * Наличие двух знаков подряд "13 + + 10" или двух чисел подряд "1 2" не допускается.
 * Вернуть значение выражения (6 для примера).
 * Про нарушении формата входной строки бросить исключение IllegalArgumentException
 */
fun plusMinus(expression: String): Int {
    val terms = expression.split(" ")
    val mark = "+-"

    return try {
        var value = 0
        if (terms.size < 4)
            when (terms[terms.size - 1]) {
                "-" -> value = terms.first().toInt() - terms.last().toInt()
                "+" -> value = terms.first().toInt() + terms.last().toInt()

            }
        value



        if (terms.first() !in mark && terms.last() in mark && (terms.size - 1) % 4 == 0) {
            value += terms.first().toInt()
            for (i in 2 until terms.size step 3) {
                when {
                    terms[i - 1] == "-" -> value -= terms[i].toInt()
                    terms[i - 1] == "+" -> value += terms[i].toInt()
                    terms[i + 1] == "-" -> value -= terms[i + 2].toInt()
                    terms[i + 1] == "+" -> value += terms[i + 2].toInt()

                }


            }
             value
        }

        if (terms.first() !in mark && terms.last() in mark && (terms.size - 1) % 4 == 2) {
            value += terms.first().toInt()
            when (terms[terms.size - 1]) {
                "-" -> value -= terms.last().toInt()
                "+" -> value += terms.last().toInt()

            }
            for (i in 2..terms.size - 2 step 3) {
                when {
                    terms[i - 1] == "-" -> value -= terms[i].toInt()
                    terms[i - 1] == "+" -> value += terms[i].toInt()
                    terms[i + 1] == "-" -> value -= terms[i + 2].toInt()
                    terms[i + 1] == "+" -> value += terms[i + 2].toInt()

                }


            }
             value
        }


        if (terms.first() in mark && terms.last() in mark && terms.size % 4 == 0) {
            for (i in 1 until terms.size step 3) {
                when {
                    terms[i - 1] == "-" -> value -= terms[i].toInt()
                    terms[i - 1] == "+" -> value += terms[i].toInt()
                    terms[i + 1] == "-" -> value -= terms[i + 2].toInt()
                    terms[i + 1] == "+" -> value += terms[i + 2].toInt()

                }


            }
             value


        }

       else {
            when (terms[terms.size - 1]) {
                "-" -> value -= terms.last().toInt()
                "+" -> value += terms.last().toInt()

            }
            for (i in 1..terms.size - 2 step 3) when {
                    terms[i - 1] == "-" -> value -= terms[i].toInt()
                    terms[i - 1] == "+" -> value += terms[i].toInt()
                    terms[i + 1] == "-" -> value -= terms[i + 2].toInt()
                    terms[i + 1] == "+" -> {
                        value += terms[i + 2].toInt()
                    }

                }
             value


        }


    }
    catch (e: IllegalArgumentException){
        throw e
    }



}



/**
 * Сложная
 *
 * Строка состоит из набора слов, отделённых друг от друга одним пробелом.
 * Определить, имеются ли в строке повторяющиеся слова, идущие друг за другом.
 * Слова, отличающиеся только регистром, считать совпадающими.
 * Вернуть индекс начала первого повторяющегося слова, или -1, если повторов нет.
 * Пример: "Он пошёл в в школу" => результат 9 (индекс первого 'в')
 */
fun firstDuplicateIndex(str: String): Int {
    val words = str.toLowerCase().split(" ")
    var index = 0
    for (i in 1 until words.size){
        try {

            if (words[i - 1] == words[i]) return index
            val wordLength = words[i-1].length
            index += (wordLength + 1)
        }catch (e: IndexOutOfBoundsException){ -1}
    }
    return index - 1



}

/**
 * Сложная
 *
 * Строка содержит названия товаров и цены на них в формате вида
 * "Хлеб 39.9; Молоко 62.5; Курица 184.0; Конфеты 89.9".
 * То есть, название товара отделено от цены пробелом,
 * а цена отделена от названия следующего товара точкой с запятой и пробелом.
 * Вернуть название самого дорогого товара в списке (в примере это Курица),
 * или пустую строку при нарушении формата строки.
 * Все цены должны быть положительными
 */
fun mostExpensive(description: String): String {
    val list = description.split(";", " ")
    val prices = mutableListOf<Double>()
    for (i in 0 until list.size) {
        prices.add(i, 0.0)
    }
    for (i in 0 until list.size) {
        try {
            prices.add(i, list[i].toDouble())
        } catch (e: NumberFormatException) {
        }
    }

    return if (list.size > 1) list[ prices.indexOf(prices.max()) - 1]
    else list[ prices.indexOf(prices.max())]
}






/**
 * Сложная
 *
 * Перевести число roman, заданное в римской системе счисления,
 * в десятичную систему и вернуть как результат.
 * Римские цифры: 1 = I, 4 = IV, 5 = V, 9 = IX, 10 = X, 40 = XL, 50 = L,
 * 90 = XC, 100 = C, 400 = CD, 500 = D, 900 = CM, 1000 = M.
 * Например: XXIII = 23, XLIV = 44, C = 100
 */
fun fromRoman(roman: String): Int  {
    if (roman.isEmpty()) return -1
    val list2 = mutableListOf<Int>()
    val list1 = roman.split("")
    var sumOfterms = 0

    for (i in 0 until list1.size) {
        list2.add(i, 0)
        try {
            when {
                list1[i] == "I" -> list2[i] = 1
                list1[i] == "V" -> list2[i] = 5
                list1[i] == "X" -> list2[i] = 10
                list1[i] == "L" -> list2[i] = 50
                list1[i] == "C" -> list2[i] = 100
                list1[i] == "D" -> list2[i] = 500
                list1[i] == "M" -> list2[i] = 1000
            }
        } catch (e: IllegalArgumentException) {
            return -1
        }
    }

    list2.removeAt(0)
    list2.removeAt(list1.size - 2)
    for (i in 0 until list2.size)
        when {
            list2[i] == 0 -> return -1
            else -> {
                when {
                    i < list2.size - 1 && list2[i] < list2[i + 1] -> list2[i] = -list2[i]
                    else -> list2[i] = list2[i]
                }
                sumOfterms += list2[i]
            }
        }


    return sumOfterms
}

/**
 * Вернуть -1, если roman не является корректным римским числом
 *
 * Очень сложная
 *
 * Имеется специальное устройство, представляющее собой
 * конвейер из cells ячеек (нумеруются от 0 до cells - 1 слева направо) и датчик, двигающийся над этим конвейером.
 * Строка commands содержит последовательность команд, выполняемых данным устройством, например +>+>+>+>+
 * Каждая команда кодируется одним специальным символом:
 *	> - сдвиг датчика вправо на 1 ячейку;
 *  < - сдвиг датчика влево на 1 ячейку;
 *	+ - увеличение значения в ячейке под датчиком на 1 ед.;
 *	- - уменьшение значения в ячейке под датчиком на 1 ед.;
 *	[ - если значение под датчиком равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей следующей командой ']' (с учётом вложенности);
 *	] - если значение под датчиком не равно 0, в качестве следующей команды следует воспринимать
 *  	не следующую по порядку, а идущую за соответствующей предыдущей командой '[' (с учётом вложенности);
 *      (комбинация [] имитирует цикл)
 *  пробел - пустая команда
 *
 * Изначально все ячейки заполнены значением 0 и датчик стоит на ячейке с номером N/2 (округлять вниз)
 *
 * После выполнения limit команд или всех команд из commands следует прекратить выполнение последовательности команд.
 * Учитываются все команды, в том числе несостоявшиеся переходы ("[" при значении под датчиком не равном 0 и "]" при
 * значении под датчиком равном 0) и пробелы.
 *
 * Вернуть список размера cells, содержащий элементы ячеек устройства после завершения выполнения последовательности.
 * Например, для 10 ячеек и командной строки +>+>+>+>+ результат должен быть 0,0,0,0,0,1,1,1,1,1
 *
 * Все прочие символы следует считать ошибочными и формировать исключение IllegalArgumentException.
 * То же исключение формируется, если у символов [ ] не оказывается пары.
 * Выход за границу конвейера также следует считать ошибкой и формировать исключение IllegalStateException.
 * Считать, что ошибочные символы и непарные скобки являются более приоритетной ошибкой чем выход за границу ленты,
 * то есть если в программе присутствует некорректный символ или непарная скобка, то должно быть выброшено
 * IllegalArgumentException.
 * IllegalArgumentException должен бросаться даже если ошибочная команда не была достигнута в ходе выполнения.
 *
 */
fun computeDeviceCells(cells: Int, commands: String, limit: Int): List<Int> = TODO()
