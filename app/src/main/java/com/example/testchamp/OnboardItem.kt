package com.example.testchamp

data class OnboardItem(val image: Int, val text: String)

object OnboardQueue {
    private val queue = mutableListOf<OnboardItem>()

    fun initialize(images: List<Int>, texts: List<String>) {
        queue.clear()
        queue.addAll(images.zip(texts) { image, text -> OnboardItem(image, text) })
    }

    fun getNextItem(): OnboardItem? {
        return if (queue.isNotEmpty()) {
            queue.removeAt(0)
        } else {
            null
        }
    }

    fun isEmpty(): Boolean {
        return queue.isEmpty()
    }
}

object OnboardScreen {
    private var currentItem: OnboardItem? = null

    fun showNextItem() {
        currentItem = OnboardQueue.getNextItem()
        if (currentItem != null) {
            // логика отображения изображения и текста с анимацией проявления
        }
    }

    fun skipOnboard() {
        // логика при нажатии на кнопку "Skip"
        // переход на экран "Holder", сохранение информации и очистка очереди
    }

    fun signUp() {
        if (OnboardQueue.isEmpty()) {
            // переход на экран "Holder"
        } else {
            // логика при нажатии на кнопку "Sign Up" при наличии элементов в очереди
        }
    }

    fun signIn() {
        if (OnboardQueue.isEmpty()) {
            // переход на экран "Holder"
        } else {
            // логика при нажатии на кнопку "Sign In" при наличии элементов в очереди
        }
    }
}
