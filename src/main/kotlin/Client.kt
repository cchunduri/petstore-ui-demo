import kotlinx.browser.document
import react.create
import react.dom.render

fun main() {
    kotlinext.js.require("bootstrap/dist/css/bootstrap.css")

    val container = document.createElement("div")
    document.body!!.appendChild(container)

    render(petstore, container)
}