package ii_collections

import util.TODO
import java.security.Key
import kotlin.coroutines.experimental.ContinuationInterceptor

fun todoTask24(): Nothing = TODO(
    """
        Task 24.
        The function should do the same as '_24_JavaCode.doSomethingStrangeWithCollection'.
        Replace all invocations of 'todoTask24()' with the appropriate code.
    """,
        references = { c: Collection<String> -> _24_JavaCode().doSomethingStrangeWithCollection(c) }
)

fun doSomethingStrangeWithCollection(collection: Collection<String>): Collection<String>? {
    val groupsByLength = collection.groupBy { it.length }
    val maximumSizeOfGroup = groupsByLength.values.map { it.size }.max()

    return groupsByLength.values.firstOrNull { it.size == maximumSizeOfGroup }
}

