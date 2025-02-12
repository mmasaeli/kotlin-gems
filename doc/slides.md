---
theme: "@xebia/slidev-theme-xebia"
title: "Kotlin Gems: Features I Wish I Discovered Sooner"
author: M. Masood Masaeli
date: 2025-02-09
description: Enhancing Kotlin development with advanced features
---

# Kotlin Gems 💎
## Features I Wish I Discovered Sooner
### By M. Masood Masaeli

---
layout: intro
speakerImage: /20230905-154735-JTI.jpg
transition: fade-out
---

::speaker::

## M.M. Masaeli (Masood)

### Full time father / half-time Software Consultant

Development lead in DSM-Firmenich via Xebia

Java/Kotlin/.NET/Angular/React/K8s

Architecture, Design, Automation, cat pics

---

# Introduction 🚀

Kotlin's rise in popularity 📈

Journey from
<img src="https://upload.wikimedia.org/wikipedia/en/3/30/Java_programming_language_logo.svg" width="22" style="display:inline">
➡️
<img src="https://upload.wikimedia.org/wikipedia/commons/7/74/Kotlin_Icon.png" width="22" style="display:inline">

Hidden 💎 to improve coding experience ⊂(◉‿◉)つ

---

# Outline (ʘ‿ʘ)╯

**Variables and Immutability:** Use val over var, data classes, and immutable collections for safer, more predictable code.

**Inline Value Classes:** Boost performance by wrapping primitives or single-property classes without the overhead of a full class.

**Notes on Null Safety Operators:** Master ?., !!, and ?: for better null safety.

**Delegations:** Reduce boilerplate by delegating parts of your implementation to other classes or properties.

**Forever Now!:** Keep your tests consistent by freezing time.

**JSON Assertions:** Make your tests cleaner and more reliable with JSON-based assertions.

**and more!**

---
layout: two-cols
---

# Variables and Immutability 🔒

## The `val` / `var` dilemma

`val` ❤️

`var` ⚠️

## Immutable Collections: safer, clearer code

::right::

#

## Data Classes

`equals()`, `hashCode()`, `toString()`, `operator componentN()`, and `copy()`

### 🚨 Default Constructor properties only 🚨

```kotlin
data class Person(val name: String, val age: Int) {
    var mood = "happy"
}

val jack = Person(name = "Jack", age = 1)
val upsetJack = jack.copy()
upsetJack.mood = "upset"
jack == upsetJack // ✅ (ᕗ ͠° ਊ ͠° )ᕗ
```

---

# Demo Variables and Immutability 🔒

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---
layout: two-cols
---

# Inline Value Classes 📦

- Primitive Types ... ⚖️📜🚀

- Wrap It Inside a Class ... 🐌

- Type Alias ... 📜🚀=

::right::

#

## Inline Value Class ... 🚀❤️୧(▲ᴗ▲)ノ

### 🚨 Name Mangling 🚨

Jackson

JPA and Hibernate

OpenApi Docs

...

<!--
Primitive: invalid value / convey meaning
Wrap inside a class: heap allocation / no runtime optimization
Type Alais: assignment-compatible/ no invalid value restriction



@operation
-->

---

# Demo Inline Value Classes 📦

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---
layout: two-cols
---

# Notes on Null Safety 🙈

<img src="./elvis-presley-side-profile-png-ovd-1npls81gp6sjt4v6.png" width=100 style="display:inline">**Operator**

**`!!`** ➡️ <img src="./DALL·E 2025-02-09 23.28.08 - A colorful unicorn with a playful, vibrant mane and horn, lying on the ground with its body lifeless. The unicorn has X&apos;s for eyes, symbolizing it is .webp" width=100 style="display:inline">

<div>&nbsp</div>

**Safe Casts (`as?`)**: Prevent class cast exceptions

::right::

#

<div>&nbsp</div>

```kotlin
val dateOfBirth = student?.dateOfBirth ?: throw ...
```

<div>&nbsp</div>
<div>&nbsp</div>


```kotlin
val dateOfBirth = student!!.dateOfBirth // (ᕗ ͠° ਊ ͠° )ᕗ
```

<div>&nbsp</div>
<div>&nbsp</div>

```kotlin
val person: Person? = if (student is Person) student as Person else null
val person: Person? = student as? Person
```

---

# Demo Notes on Null Safety 🙈

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---

# Class Delegation in Kotlin 🤝

## Class Delegation: Reduce boilerplate

```kotlin
@Repository  
interface StudentRepository : JpaRepository<Student, Int> {
      // fun sayHello() = findAll().map { "Hello ${it.name}" } ❌
}
@Component  
class StudentExtendedRepository(jpaRepo: StudentRepository) : StudentRepository ➡️by⬅️ jpaRepo {  
  fun sayHello() = findAll().map { "Hello ${it.name}" }  
}
...
// This works
studentExtendedRepository.sayHello()
// So does
studentExtendedRepository.findAll()
```

---

# Demo Class Delegation in Kotlin 🤝

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---
layout: two-cols
---

# Property Delegation in Kotlin 🤝

## Property Delegation

Observable Properties

<div>&nbsp</div><div>&nbsp</div><div>&nbsp</div><div>&nbsp</div><div>&nbsp</div><div>&nbsp</div><div>&nbsp</div><div>&nbsp</div>
<div>&nbsp</div>

Delegating to Another Property

::right::

#

<div>&nbsp</div>

```kotlin
class User {
    var name: String by observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }
}
val user = User()
user.name = "first" // prints <no name> -> first
user.name = "second" // prints first -> second
```

```kotlin
var delegatedToMember: Int by this::memberInt
...
```

---

# Demo Property Delegation in Kotlin 🤝

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---

# Freeze Time with Kotest Extensions

```kotlin
val foreverNow = LocalDateTime.now()
withConstantNow(foreverNow) {
  LocalDateTime.now() shouldBe foreverNow ✅
  delay(10) // Code is taking a small amount of time to execute, but `now` changed!
  LocalDateTime.now() shouldBe foreverNow ✅
}
```

---

# Demo Freeze Time with Kotest Extensions

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---

# JSON Assertions for clearer test validations

```kotlin
val json = "{"name":"Alice", "land": "Wonderland"}"
json shouldEqualJson "{"land": "Wonderland", "name":"Alice"}" ✅
```

---

# Demo JSON Assertions

<img src='./bit.ly_kotlin-gems-masood.svg' width="300px">

---

# Other Noteworthy Features 🌟

**Coroutines**: Simplify async operations

**Ktor**: Lightweight web framework

**Kotlin Native**: Compile to native code

**Dokka**: Auto-generate documentation

**Inline functions**

**Infix functions**

**Operators**

**...**

---
layout: thank-you
---

# Q&A 🗣️
Let's discuss and learn together!
