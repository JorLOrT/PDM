package Ejercicios

/*
    Ejercicio 5
    Sistema de Gestión de Biblioteca
    Autor: Jorge Ortiz
    Fecha de creacion: 30/03
    Ultima modificacion: 30/03
 */

// Clase abstracta materiales
abstract class Material(
    val title: String,
    val author: String,
    val publicationYear: Int
) {
    abstract fun showDetails()
}

// Sub clase libros
class Book(
    title: String,
    author: String,
    publicationYear: Int,
    val genre: String,
    val pageCount: Int
) : Material(title, author, publicationYear) {
    override fun showDetails() {
        println("Detalles del libro:")
        println("Titulo: $title")
        println("Autor: $author")
        println("Fecha de publicacion: $publicationYear")
        println("Genero: $genre")
        println("Cantidad de paginas: $pageCount")
    }
}

// Sub clase revistas
class Magazine(
    title: String,
    author: String,
    publicationYear: Int,
    val issn: String,
    val volume: Int,
    val issueNumber: Int,
    val editorial: String
) : Material(title, author, publicationYear) {
    override fun showDetails() {
        println("Detalles de la revista:")
        println("Titulo: $title")
        println("Autor: $author")
        println("Fecha de publicacion: $publicationYear")
        println("ISSN: $issn")
        println("Volumen: $volume")
        println("Numero de serie: $issueNumber")
        println("Editorial: $editorial")
    }
}

// Clase usuario
class User(
    val firstName: String,
    val lastName: String,
    val age: Int
) {
    fun reserveMaterial(library: Library, material: Material) {
        if (library.availableMaterials.contains(material)) {
            library.availableMaterials.remove(material)
            library.registerReservation(material, this)
            println("$firstName $lastName ha reservado ${material.title}.")
        } else {
            println("${material.title} no está disponible para reservar.")
        }
    }

    fun returnMaterial(library: Library, material: Material) {
        if (library.registroReservas.contains(material)) {
            library.availableMaterials.add(material)
            library.registroReservas.remove(material, this)
            println("$firstName $lastName ha retornado ${material.title}.")
        } else {
            println("No tienes reservaciones de ${material.title}.")
        }
    }
}

// Library class
class Library {
    val availableMaterials = mutableListOf<Material>()
    val registeredUsers = mutableListOf<User>()
    val registroReservas = mutableMapOf<Material, User>()

    //Funcion para registrar nuevos usuarios
    fun registerNewUser(newUser: User){
        registeredUsers.add(newUser)
        println("\n Usuario ${newUser.firstName} registrado correctamente.")
    }
    //Funcion que imprime los libros y revistas disponibles
    fun showMaterials(){
        println("Materiales disponibles")
        availableMaterials.forEach { material: Material -> println("Titulo: ${material.title}, Autor: ${material.author}") }
    }

    //Funcion para mostrar los usuarios de la biblioteca
    fun showUsers(){
        println("Listado de usuarios de la biblioteca: ")
        registeredUsers.forEach { user: User -> println("${user.firstName} ${user.lastName}") }
    }
    //Funcion para registrar las operaciones
    fun registerReservation(material: Material, usuario: User) {
        registroReservas[material] = usuario
    }
}

fun quintoEjercicio() {
    //Creación del objeto libreria
    val library = Library()

    val book = Book("A dos metros de ti", "Rachael Lippincott", 2019, "Novela", 288)
    val magazine = Magazine("Mafalda", "Joaquin", 2022, "1234-5678", 100, 3, "alguna")

    val user = User("Pepita", "Perez", 21)

    library.availableMaterials.add(book)
    library.availableMaterials.add(magazine)
    println("Ejemplo de detalles de libro: \n")
    book.showDetails()
    println("Ejemplo de detalles de revista: \n")
    magazine.showDetails()

    library.registerNewUser(user)
    library.showUsers()

    user.reserveMaterial(library, book)
    library.showMaterials()
    user.returnMaterial(library, book)
    library.showMaterials()

}
