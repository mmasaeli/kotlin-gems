package myapp.jpa

import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Import
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.data.repository.findByIdOrNull

@DataJpaTest
@Import(PersonRepositoryExtended::class)
class PersonRepositoryJpaTest {

    @Configuration
    @EnableJpaRepositories(basePackages = ["myapp.jpa"])
    @EntityScan(basePackages = ["myapp.jpa"])
    class TestConfig

    @Autowired
    private lateinit var personRepository: PersonRepository

    @Autowired
    private lateinit var personRepositoryExtended: PersonRepositoryExtended

    private lateinit var savedIds: List<Int>

    @BeforeEach
    fun setup() {
        // Create and persist a test person before each test
        val (johnId) = personRepository.save(Person(id = 0, name = "John Doe"))
        val (janeId) = personRepositoryExtended.save(Person(id = 0, name = "Jane Doe"))
        savedIds = listOf(johnId, janeId)
    }

    @Test
    fun `should retrieve all`() {
        // Assertions
        personRepository.findAll() shouldHaveSize 2
        personRepositoryExtended.findAll() shouldHaveSize 2
    }

    @Test
    fun `should retrieve person`() {
        // Retrieve the person
        val retrievedPerson = personRepository.findByIdOrNull(savedIds.first())

        // Assertions
        retrievedPerson!!.name shouldBe "John Doe"
        personRepositoryExtended.findByIdOrNull(savedIds.first()) shouldBe retrievedPerson
    }

    @Test
    fun `sayHello should return greeting for existing person`() {
        // Act
        val greeting = personRepositoryExtended.sayHello(savedIds.first())

        // Assert
        greeting shouldBe "Hello John Doe"
    }

    @Test
    fun `sayHello should return null for non-existing person`() {
        // Act
        val greeting = personRepositoryExtended.sayHello(9999)

        // Assert
        greeting shouldBe null
    }
}
