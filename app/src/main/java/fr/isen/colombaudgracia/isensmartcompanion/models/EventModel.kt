package fr.isen.colombaudgracia.isensmartcompanion.models

import java.io.Serializable

data class EventModel(
    val id: String,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val category: String): Serializable
{
    companion object {
        // Fake Events list
        fun fakeEvents(): List<EventModel> {
            return listOf(
                EventModel(
                    "1a2b3c4d5e6f",
                    "Fake Event",
                    "That's a fake event.",
                    "31 February 1992",
                    "Toulon",
                    "Fake"
                ),
                EventModel(
                    "f6e5d4c3b2a1",
                    "Event Fake",
                    "That's an event fake.",
                    "31 February 2991",
                    "Marseille",
                    "Reverse Fake"
                ),
            )
        }
    }
}