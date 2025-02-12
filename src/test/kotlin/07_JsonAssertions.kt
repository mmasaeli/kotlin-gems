import io.kotest.assertions.json.shouldEqualJson
import io.kotest.assertions.json.shouldEqualSpecifiedJson
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class JsonAssertions : FunSpec({
    context("json assertions") {
        test("should be awesome") {
            result shouldEqualJson expectation
            result shouldEqualSpecifiedJson """{"user": {}, "weather": {"temperature": 72.5}}"""
        }
        test("report well beautifully") {
            result shouldEqualJson wrongExpectation
        }
        test("report well beautifully for a partial match") {
            result shouldEqualSpecifiedJson """{"user": {}, "weather": {"temperature": 60}}"""
        }
    }
    context("string assertions") {
        test("should not be awesome") {
            result shouldBe expectation
        }
        test("should report ugly") {
            result shouldBe wrongExpectation
        }
        test("report well ugly for a partial match") {
            result shouldEqualSpecifiedJson """{"user": {}, "weather": {"temperature": 60}}"""
        }
    }
})

val result = """
{
  "user": {
    "id": 7824,
    "name": "Alice Johnson",
    "age": 30,
    "email": "alice.j@example.com"
  },
  "order": {
    "orderNumber": "ORD-45691",
    "items": [
      {
        "productId": "SKU-8720",
        "name": "Wireless Headphones",
        "quantity": 1,
        "price": 89.99
      },
      {
        "productId": "SKU-5390",
        "name": "Phone Case",
        "quantity": 2,
        "price": 14.50
      }
    ],
    "totalAmount": 118.99,
    "shippingAddress": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62701"
    },
    "isGift": false
  },
  "weather": {
    "temperature": 72.5,
    "conditions": "Partly Cloudy",
    "humidity": 65,
    "windSpeed": 8.3
  }
}""".trimIndent()

val expectation = """
{
  "order": {
    "orderNumber": "ORD-45691",
    "items": [
      {
        "productId": "SKU-8720",
        "name": "Wireless Headphones",
        "quantity": 1,
        "price": 89.99
      },
      {
        "productId": "SKU-5390",
        "name": "Phone Case",
        "quantity": 2,
        "price": 14.50
      }
    ],
    "totalAmount": 118.99,
    "shippingAddress": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62701"
    },
    "isGift": false
  },
  "weather": {
    "temperature": 72.5,
    "conditions": "Partly Cloudy",
    "humidity": 65,
    "windSpeed": 8.3
  },
  "user": {
    "id": 7824,
    "name": "Alice Johnson",
    "age": 30,
    "email": "alice.j@example.com"
  }
}""".trimIndent()

val wrongExpectation = """
{
  "order": {
    "orderNumber": "ORD-45691",
    "items": [
      {
        "productId": "SKU-8720",
        "name": "Wireless Headphones",
        "quantity": 1,
        "price": 89.99
      },
      {
        "productId": "SKU-5390",
        "name": "Phone Case",
        "quantity": 2,
        "price": 14.50
      }
    ],
    "totalAmount": 118.99,
    "shippingAddress": {
      "street": "123 Main St",
      "city": "Springfield",
      "state": "IL",
      "zipCode": "62701"
    },
    "isGift": false
  },
  "weather": {
    "temperature": 60,
    "conditions": "Partly Cloudy",
    "humidity": 65,
    "windSpeed": 8.3
  },
  "user": {
    "id": 7824,
    "name": "Alice Johnson",
    "age": 30,
    "email": "alice.j@example.com"
  }
}""".trimIndent()
