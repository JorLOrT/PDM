package Ejercicios

class Store (private val products: MutableList<Product>){

    //Agregar productos a la tienda
    fun addProduct(product: Product) {
        products.add(product)
        println("${product.getName()} agregado a la tienda.")
    }

    // Imprime los productos en la tienda y su precio final
    fun getProducts(){
        println("Productos disponibles en la tienda: ")
        products.forEach { product -> println("${product.getName()} : ${product.calculateFinalPrice()}") }
    }
}

class Product(private var name: String, private var price: Double, private var discount: Double) {

    fun setName(newName:String){
        name = newName
    }

    fun getName():String{
        return name
    }

    // Establecer el precio
    fun setPrice(newPrice: Double) {
        if (newPrice >= 0) {
            price = newPrice
            println("${this.getName()}: Precio actualizado: $$price")
        } else {
            println("El precio no puede ser negativo.")
        }
    }

    // Obtener el precio
    fun getPrice(): Double {
        return price
    }

    // Establecer descuento
    fun setDiscount(newDiscount: Double) {
        if (newDiscount in 0.0..100.0) {
            discount = newDiscount
            println("${this.getName()}: Descuento actualizado: $discount%")
        } else {
            println("El descuento debe estar entre 0 y 100.")
        }
    }

    // Obtener descuento
    fun getDiscount(): Double {
        return discount
    }

    // Calcula el precio final
    fun calculateFinalPrice(): Double {
        val finalPrice = price * (1 - discount / 100)
        return finalPrice
    }
}

// Funcion principal
fun segundoEjercicio() {
    var mutableList = mutableListOf<Product>()
    val myStore = Store(mutableList)
    val myProduct = Product(name = "Mouse",price = 100.0, discount = 10.0)
    myProduct.setPrice(120.0)
    myProduct.setDiscount(15.0)
    myStore.addProduct(myProduct)
    val myProduct2 = Product(name = "Teclado",price = 500.0, discount = 15.0)
    myStore.addProduct(myProduct2)
    myStore.getProducts()
}