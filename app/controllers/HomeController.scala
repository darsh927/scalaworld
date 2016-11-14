package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._
import scala.io.Source
import play.api.libs.json.JsValue

  /**
  * This controller creates an `Action` to handle HTTP requests to the
  * application's home page.
  */
  @Singleton
  class HomeController @Inject() extends Controller {
  /**
   * Create an Action to render an HTML page with a welcome message.
   * The configuration in the `routes` file means that this method
   * will be called when the application receives a `GET` request with
   * a path of `/`.
   */
  def index = Action { Ok(views.html.index("Video game data analysis")) }

  //Can call this function to redirect to index page from wherever
  def redirect = Action { implicit request => Redirect(routes.HomeController.index()) }
 
  val source: String = Source.fromFile("app/assets/videogames.json").getLines.mkString
  val json: JsValue = Json.parse(source)
 
  //Function to load JSON in plain text in an html page
  def getNaSales = Action{ Ok(Json.prettyPrint(json)) }
  
  }