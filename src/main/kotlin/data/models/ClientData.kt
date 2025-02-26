package data.models

import domain.models.Client

object ClientData {
    val listClient = mutableListOf<Client>(
        Client("usuario@gmail.com", "usuario", 2.0, 1.0, 1.0, 1.6, 4.0),
        Client("juanluismatalop@gmail.com", "julu2003.", 2.0, 1.0, 1.0, 1.6, 4.0),
        Client("davidtienepitochico@gmail.com", "notengopito.", 2.0, 1.0, 1.0, 1.6, 4.0)
    )
}
