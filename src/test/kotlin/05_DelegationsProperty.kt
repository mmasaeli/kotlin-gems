import io.kotest.core.spec.style.FunSpec
import kotlin.properties.Delegates.observable

class `DelegationsProperty` : FunSpec({
    test("observable example") {
        class User {
            var name: String by observable("<no name>") { prop, old, new ->
                println("Property '$prop': $old -> $new")
            }
        }

        val user = User()
        user.name = "first" // prints <no name> -> first
        user.name = "second" // prints first -> second
    }

//
//// Delegating to Another Property
//

    test("delegate to another property") {
        val c = MyClass(1, ClassWithDelegate(2))

        println("c.memberInt: ${c.memberInt}")
        println("c.anotherClassInstance.anotherClassInt: ${c.anotherClassInstance.anotherClassInt}")
        println("c.delegatedToAnotherClass: ${c.delegatedToAnotherClass}")
        println("c.delegatedToMember: ${c.delegatedToMember}")
        println("c.delegatedToTopLevel: ${c.delegatedToTopLevel}")
        println("c.extDelegated: ${c.extDelegated}")
    }

    test("Be Mindful of Who Implements What") {
        val b = object : Base {
            override val message = "Base"
        }
        val derived = Derived(b)
        derived.print() // prints > Base
        println(derived.message) // prints > Derived
    }
})

var topLevelInt: Int = 0


class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt


interface Base {
    val message: String
    fun print() {
        println(message)
    }
}

class Derived(b: Base) : Base by b {
    override val message = "Derived"
}