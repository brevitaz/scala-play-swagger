package com.brevitaz.Repository

import com.brevitaz.models.Product
import javax.inject.Inject
import scala.concurrent.ExecutionContext

class ProductRepository @Inject()(implicit ec: ExecutionContext) {

    private var products = Products.products

    def createProduct(product: Product) = {
      products += product
      product
    }

    def listAllProduct() = products

    def findProductById(id:Long) = products.filter(_.id == id).headOption
}
