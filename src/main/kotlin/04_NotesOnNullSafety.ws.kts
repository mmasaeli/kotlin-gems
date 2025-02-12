import java.time.LocalDate

open class Person

data class Student (
    val name: String,
    val dateOfBirth: LocalDate,
): Person()

var jack: Student? = null

jack = Student("jack", LocalDate.of(1990, 1, 1))

jack
fun dateOfBirth1(student: Student?) = if(student != null) student.dateOfBirth else throw IllegalStateException("some meaningful error message here")
fun dateOfBirth2(student: Student?) = student?.dateOfBirth ?: throw IllegalStateException("some meaningful error message here")

dateOfBirth1(jack)
dateOfBirth2(jack)

fun personof1(student: Any): Person? = if (student is Person) student as Person else null
fun personof2(student: Any): Person? = student as? Person

personof1(jack!!)
personof2(jack!!)

