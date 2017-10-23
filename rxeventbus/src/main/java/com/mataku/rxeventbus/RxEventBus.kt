package com.mataku.rxeventbus

import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject


// singleton instance
object RxEventBus {

    private val subject = PublishSubject.create<Any>()

    fun post(event: Any) {
        subject.onNext(event)
    }

    // Return Observable
    // Using ofType method to filter only events specified
    // RxEventBus.stream(SomeEvent::class.java).subscribe({ someMethod })
    fun <T> stream(event: Class<T>): Observable<T> = subject.hide().ofType(event)
}
