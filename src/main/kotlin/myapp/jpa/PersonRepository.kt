package myapp.jpa

import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Component
import org.springframework.stereotype.Repository

@Repository
interface PersonRepository : CrudRepository<Person, Int> {
//    fun sayHelloFromRepo() {
//        println("Hello World!")
//    }
}

@Component
class PersonRepositoryExtended(personRepository: PersonRepository) : PersonRepository by personRepository {
    fun sayHello(id: Int): String? = findByIdOrNull(id)?.let {
        "Hello ${it.name}"
    }
}