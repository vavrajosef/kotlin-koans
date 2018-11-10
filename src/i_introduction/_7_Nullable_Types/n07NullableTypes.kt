package i_introduction._7_Nullable_Types

fun test() {
    val s: String = "this variable cannot store null references"
    val q: String? = null

    if (q != null) q.length      // you have to check to dereference
    val i: Int? = q?.length      // null
    val j: Int = q?.length ?: 0  // 0
}

fun todoTask7(client: Client?, message: String?, mailer: Mailer) {
    val email: String? = client?.personalInfo?.email
    if(email != null && message != null) {
        mailer.sendMessage(client.personalInfo.email, message)
    }
}

fun sendMessageToClient(
        client: Client?, message: String?, mailer: Mailer
) {
    todoTask7(client, message, mailer)
}

class Client (val personalInfo: PersonalInfo?)
class PersonalInfo (val email: String?)

interface Mailer {
    fun sendMessage(email: String, message: String)
}
