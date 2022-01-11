package com.company.DesignPatterns.Kotlin

import org.junit.Test
import java.io.File

/**
 * The builder pattern is a design pattern designed to provide a flexible solution to various
 * object creation problems in object-oriented programming.
 * The intent of the Builder design pattern is to separate the construction of a complex object from its representation.
 * */

class Dialog {
    fun setTitle(text: String) = println("Setting title text $text")
    fun setTitleColor(color: String) = println("Setting title color $color")
    fun setImage(bitmapBytes : ByteArray) = println("Setting image with size ${bitmapBytes.size}")

    fun show() = println("Showing dialog $this")
}

class DialogBuilder() {
    constructor(init: DialogBuilder.() -> Unit) : this() {
        init()
    }

    private var titleHolder: TextView? = null
    private var messageHolder: TextView? = null
    private var imageHolder: File? = null

    fun title(attributes : TextView.() -> Unit){
        titleHolder = TextView().apply {
            attributes()
        }
    }

    fun message(attributes : TextView.() -> Unit){
        messageHolder = TextView().apply {
            attributes()
        }
    }

    fun image(attributes : () ->  File){
        imageHolder = attributes()
    }

    fun build(): Dialog {
        println("Building...")
        val dialog = Dialog()

        titleHolder?.apply {
            dialog.setTitle(text)
            dialog.setTitleColor(color)
        }
        messageHolder?.apply {
            dialog.setTitle(text)
            dialog.setTitleColor(color)
        }
        imageHolder?.apply {
            dialog.setImage(readBytes())
        }

        return dialog

    }
    class TextView {
        var text: String = ""
        var color: String = "#00000"
    }
}

fun dialog(init : DialogBuilder.() -> Unit) : Dialog = DialogBuilder(init).build()

class BuilderTest {
    @Test
    fun builder() {
        println("Building Dialog...")
        val dialog : Dialog = dialog {
            title {
                text = "Dialog Title"
            }
            message {
                text = "Dialog Message"
                color = "#333333"
            }
            image {
                File.createTempFile("image","jpg")
            }
        }

        println("Showing dialog...")
        dialog.show()
    }
}