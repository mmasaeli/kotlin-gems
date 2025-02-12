data class Person(val name: String, val age: Int) {
    var mood = "happy"
}

val jack = Person(name = "Jack", age = 1)
val upsetJack = jack.copy()
upsetJack.mood = "upset"

jack.toString()
jack == upsetJack

val (a, b) = jack