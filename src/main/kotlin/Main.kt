package org.example

// Задание 2: enum задаёт допустимые значения времени суток.
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

// Итоговый класс Event после изменения из задания 2.
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

// Задание 7: свойство расширения без изменения класса Event.
val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) "short" else "long"

fun demonstrateTask1() {
    // Локальный класс сохраняет исходное решение задания 1,
    // где время суток ещё представлено строкой.
    data class Event(
        val title: String,
        val description: String? = null,
        val daypart: String,
        val durationInMinutes: Int,
    )

    val event = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = "Evening",
        durationInMinutes = 15,
    )
    println(event)
}

fun main() {
    println("Task 1")
    demonstrateTask1()

    println("\nTask 2")
    val studyEvent = Event(
        title = "Study Kotlin",
        description = "Commit to studying Kotlin at least 15 minutes per day.",
        daypart = Daypart.EVENING,
        durationInMinutes = 15,
    )
    println(studyEvent)

    // Задание 3: изменяемый список хранит все шесть событий.
    val events = mutableListOf<Event>()
    events.add(Event("Wake up", "Time to get up", Daypart.MORNING, 0))
    events.add(Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15))
    events.add(Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30))
    events.add(Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60))
    events.add(Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10))
    events.add(Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45))

    println("\nTask 3")
    println("Total events: ${events.size}")
    events.forEach { println(it) }

    // Задание 4: короткое событие длится строго меньше 60 минут.
    println("\nTask 4")
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")

    // Задание 5: группировка событий по времени суток.
    println("\nTask 5")
    val groupedEvents = events.groupBy { it.daypart }
    groupedEvents.forEach { (daypart, eventsInDaypart) ->
        println("$daypart: ${eventsInDaypart.size} events")
    }

    // Задание 6: получение последнего элемента без вычисления индекса.
    println("\nTask 6")
    println("Last event of the day: ${events.last().title}")

    println("\nTask 7")
    println("Duration of first event of the day: ${events[0].durationOfEvent}")
}
