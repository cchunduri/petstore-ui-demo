import csstype.Color
import csstype.px
import csstype.rem
import react.*
import react.css.css
import react.dom.html.ReactHTML
import react.dom.html.ReactHTML.button
import react.dom.html.ReactHTML.div
import react.dom.html.ReactHTML.span

external interface PetstoreProps : Props {
    var name: String
}

val PetstoreComponent = FC<PetstoreProps> { props ->

    var counter by useState<Int>(0)
    var storeData by useState<StoreResponse>()

    useEffect(storeData) {
        getStores().then {response ->
            storeData = response.data
        }
    }

    div {
        id = "app-header"
        css("navbar", "navbar-expand-lg", "navbar-light", "bg-dark") {}

        span {
            css {
                color = Color("#ffffff")
                padding = 5.px
            }
            + "Kotlin Petstore"
        }
    }

    button {
        onClick = {
            counter = counter + 1
        }
        + "Click Me"
    }

    div {
        + "Value of Counter $counter"
    }

    div {
        + "Welcome to ${props.name} Petstore "
    }

    if (storeData !== null) {
        div {
            css("card") {
                width = 20.rem
            }

            ReactHTML.img {
                css("card-img-top") {}
                src = "image-1.jpg"
            }

            div {
                css ("card-body") {}
                ReactHTML.h6 {
                    css("card-title") { }
                    +"Store Name ${storeData?.storeName ?: ""}"
                }
            }
        }
    }
}

val petstore = PetstoreComponent.create() {
    name = "Kotlin/JS "
}