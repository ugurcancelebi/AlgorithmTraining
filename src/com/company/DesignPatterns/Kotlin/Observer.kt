package com.company.DesignPatterns.Kotlin

import org.junit.Test
import kotlin.properties.Delegates

/**
 * The Observer pattern is a behavioral software pattern.
 * It was first described in the Design Patterns book written by the Gang Of Four.
 * The pattern shows the definition of a subscription mechanism that notifies multiple objects about any changes
 * that happen to the observed object. That’s why the Observer pattern is quite popular in distributed event-driven systems.
 */

interface OnTextChangedListener {
    fun onTextChanged(oldText : String, newText : String)
}

class PrintingTextChangedListener : OnTextChangedListener {
    var text = ""
    override fun onTextChanged(oldText: String, newText: String) {
        text = "Text is changed: $oldText -> $newText"
    }
}

class TextView {
    val listeners = mutableListOf<OnTextChangedListener>()
    var text: String by Delegates.observable("<empty>") { _, old, new ->
        listeners.forEach {
            it.onTextChanged(old, new)
        }
    }
}

class ListenerTest {
    @Test
    fun listener() {
        val listener = PrintingTextChangedListener()
        val textView = TextView().apply {
            listeners.add(listener)
        }
        with(textView) {
            text = "Lorem Ipsum"
            text = "Dolor Sit Amet"
        }
        print(listener.text)
        assert(listener.text == "Text is changed: Lorem Ipsum -> Dolor Sit Amet")
    }
}
