@JvmInline
value class StudentId(val id: Int) {
    init {
        require(isValid(id)) {
            "Student Id '$id' is not valid"
        }
    }

    companion object {
        private fun isValid(id: Int) = id in 1000000L..9999999
    }
}

data class Student (
    val id: StudentId,
    val name: String,
)
