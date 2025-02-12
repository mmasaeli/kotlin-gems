import java.time.LocalDate
import java.time.Period

data class Student (
    val name: String,
    val dateOfBirth: LocalDate,
)

fun calculateAge(student: Student?): Period? {
    if (student == null) return null
    return LocalDate.now().until(student.dateOfBirth)
}

fun calculateAgeWithLet(student: Student?) = student?.let {
    LocalDate.now().until(it.dateOfBirth)
}

fun calculateAgeWithRun(student: Student?) = student?.run {
    LocalDate.now().until(this.dateOfBirth)
}

fun calculateAgeWithLetAndLog(student: Student?): Period? = student?.let {
    LocalDate.now().until(it.dateOfBirth)
}?.also { println("Student '$student' is '$it' old.") }

val jack = Student("Jack", LocalDate.of(1990, 1, 1))

calculateAge(jack)
calculateAgeWithLet(jack)
calculateAgeWithRun(jack)
calculateAgeWithLetAndLog(jack)

jack.run { println(this) }
run { println(this) }
