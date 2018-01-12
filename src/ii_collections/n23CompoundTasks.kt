package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product
//    todoCollectionTask()
    return this.customers.filter { (it.orders.flatMap { it.products }).intersect(setOf(product)).count() > 0 }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
//    todoCollectionTask()
    return this.orders.partition { it.isDelivered }.first.flatMap { it.products }.maxBy { it.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(product: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
//    todoCollectionTask()
    val allProduct = this.customers.flatMap { it.orders }.flatMap { it.products }
    val t = allProduct.filter { it == product }
    return t.count()
}
