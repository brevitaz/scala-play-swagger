package com.brevitaz.Repository

import com.brevitaz.models.Product
import scala.collection.mutable.ListBuffer

object Products {

  private val random = scala.util.Random
  var products = new ListBuffer[Product]()

  for (i <- 1 to 5){
    products += Product(i, s"title-$i", s"description-$i", random.nextInt(5)+1, random.nextDouble()*1000)
  }

}
