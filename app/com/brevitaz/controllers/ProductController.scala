package com.brevitaz.controllers

import com.brevitaz.Repository.ProductRepository
import com.brevitaz.models.Product
import io.swagger.annotations._
import javax.inject._
import play.api.libs.json.{JsError, JsValue, Json}
import play.api.mvc._
import play.mvc.Http


@Api(value = "Product")
class ProductController @Inject()(cc: ControllerComponents,repo: ProductRepository) extends AbstractController(cc) {


  @ApiOperation(
    nickname = "Create product",
    value = "Add new product to application",
    notes = "Api for creating new product",
    httpMethod = Http.HttpVerbs.POST,
    response = classOf[Product],
    produces = Http.MimeTypes.JSON
  )
  @ApiImplicitParams(Array(
    new ApiImplicitParam(
      value = "Product object that needs to be added to the application",
      required = true,
      dataType = "com.brevitaz.models.Product",
      paramType = "body"
    ))
  )
  @ApiResponses(Array(
    new ApiResponse(code = Http.Status.BAD_REQUEST, message = "Bad request"),
    new ApiResponse(code = Http.Status.NOT_FOUND, message = "Page not found"),
    new ApiResponse(code = Http.Status.INTERNAL_SERVER_ERROR, message = "Internal error")))
  def addProduct = Action(parse.json) { implicit request:Request[JsValue] =>

    val productRequest = request.body.validate[Product]
    productRequest.fold(
      errors => BadRequest(Json.obj("status" -> "KO", "message" -> JsError.toJson(errors))),
      product => Ok(Json.toJson(repo.createProduct(product)))
    )
  }

  @ApiOperation(
    nickname = "All product",
    value = "List of all product",
    notes = "Api will return list of all product",
    httpMethod = Http.HttpVerbs.GET,
    response = classOf[Product],
    responseContainer = "List",
    produces = Http.MimeTypes.JSON
  )
  @ApiResponses(Array(
    new ApiResponse(code = Http.Status.BAD_REQUEST, message = "Bad request"),
    new ApiResponse(code = Http.Status.NOT_FOUND, message = "Page not found"),
    new ApiResponse(code = Http.Status.INTERNAL_SERVER_ERROR, message = "Internal error")))
  def getAllProduct = Action { implicit request =>
    Ok(Json.toJson(repo.listAllProduct()))
  }


  @ApiOperation(
    nickname = "Find product",
    value = "Find product by id",
    notes = "Api will search product by its id",
    httpMethod = Http.HttpVerbs.GET,
    response = classOf[Product],
    produces = Http.MimeTypes.JSON
  )
  @ApiResponses(Array(
    new ApiResponse(code = Http.Status.BAD_REQUEST, message = "Bad request"),
    new ApiResponse(code = Http.Status.NOT_FOUND, message = "Product not found"),
    new ApiResponse(code = Http.Status.INTERNAL_SERVER_ERROR, message = "Internal error")))
  def getPersonById(@ApiParam(value = "Id of product") id: Long) = Action { implicit request =>
    repo.findProductById(id) match {
      case Some(person) => Ok(Json.toJson(person))
      case None => NotFound(Json.obj(
        "status" -> false,
        "message" -> "The product you're looking for, is not in the DB."
      ))
    }
  }
}
