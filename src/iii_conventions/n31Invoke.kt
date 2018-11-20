package iii_conventions

import util.TODO


class Invokable{

    var numberOfInvocations_ = 0
        private set


    operator fun invoke(): Invokable {
        numberOfInvocations_++
        return this
    }

    fun getNumberOfInvocations(): Int = numberOfInvocations_
}

fun todoTask31(): Nothing = TODO(
    """
        Task 31.
        Change the class 'Invokable' to count the number of invocations:
        for 'invokable()()()()' it should be 4.
    """,
    references = { invokable: Invokable -> })



fun task31(invokable: Invokable): Int {

    return invokable()()()().getNumberOfInvocations()
}
