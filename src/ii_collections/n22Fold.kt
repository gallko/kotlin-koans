package ii_collections

fun example9() {
    val result = listOf(1, 2, 3, 4).fold(1, { partResult, element -> element * partResult })
    result == 24
}

// The same as
fun whatFoldDoes(): Int {
    var result = 1
    listOf(1, 2, 3, 4).forEach { element -> result = element * result}
    return result
}

fun Shop.getSetOfProductsOrderedByEveryCustomer(): Set<Product> {
    // Return the set of products ordered by every customer
    val allProduct = allOrderedProducts
    return customers.fold(allProduct, {
        orderedByAll, customer ->
        orderedByAll.intersect(customer.orders.flatMap { it.products })
    }) // use help
}
