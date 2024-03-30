package Ejercicios

/*
    Ejercicio 6
    Sistema de Alquiler de Vehículos
    Autor: Jorge Ortiz
    Fecha de creacion: 30/03
    Ultima modificacion: 30/03
 */

// Clase para vehículos
open class Vehicle(val brand: String, val model: String)

// Clase para coches
class Car(brand: String, model: String) : Vehicle(brand, model)

// Clase para motos
class Motorcycle(brand: String, model: String) : Vehicle(brand, model)

// Clase Dealership
class Dealership {
    val carRegistry = mutableListOf<Car>()
    val motorcycleRegistry = mutableListOf<Motorcycle>()
    val rentsRegistry = mutableMapOf<Vehicle, Customer>()

    fun addCar(car: Car) {
        carRegistry.add(car)
    }

    fun addMotorcycle(motorcycle: Motorcycle) {
        motorcycleRegistry.add(motorcycle)
    }

    fun showAvailableVehicles() {
        if (carRegistry.isEmpty()){
            println("No hay carros disponibles. \n")
        }
        else{
            println("Carros disponibles:")
            carRegistry.forEach { println("${it.brand} ${it.model}") }
            println()
        }

        if (motorcycleRegistry.isEmpty()){
            println("No hay motos disponibles. \n")
        }
        else{
            println("\nMotos disponibles:")
            motorcycleRegistry.forEach { println("${it.brand} ${it.model}") }
            println()
        }
    }

    fun registerReservation(vehicle: Vehicle, customer: Customer){
        rentsRegistry[vehicle] = customer
    }
}

// Clase Customer
class Customer(val name: String) {
    fun rentCar(dealership: Dealership, car: Car) {
        if(dealership.carRegistry.contains(car)){
            dealership.carRegistry.remove(car)
            dealership.registerReservation(car, this)
            println("$name ha reservado el carro: ${car.brand} ${car.model}")
        }
        else {
            println("${car.brand} ${car.model} no está disponible para reservar.")
        }
    }

    fun rentMotorcycle(dealership: Dealership, motorcycle: Motorcycle) {
        if(dealership.motorcycleRegistry.contains(motorcycle)){
            dealership.motorcycleRegistry.remove(motorcycle)
            dealership.registerReservation(motorcycle, this)
            println("$name ha reservado la moto: ${motorcycle.brand} ${motorcycle.model}")
        }
        else {
            println("${motorcycle.brand} ${motorcycle.model} no está disponible para reservar.")
        }
    }

    fun returnCar(dealership: Dealership, car: Car) {
        if(dealership.rentsRegistry.contains(car)){
            dealership.carRegistry.add(car)
            dealership.rentsRegistry.remove(car, this)
            println("$name ha retornado ${car.brand} ${car.model}.")
        }
        else{
            println("No hay registro que el vehiculo haya sido rentado.")
        }
    }
    fun returnMotorcycle(dealership: Dealership, motorcycle: Motorcycle) {
        if(dealership.rentsRegistry.contains(motorcycle)){
            dealership.motorcycleRegistry.add(motorcycle)
            dealership.rentsRegistry.remove(motorcycle, this)
            println("$name ha retornado ${motorcycle.brand} ${motorcycle.model}.")
        }
        else{
            println("No hay registro que el vehiculo haya sido rentado.")
        }
    }
}

fun sextoEjercicio(){
    val dealership = Dealership()
    val car1 = Car("Toyota", "Camry")
    val car2 = Car("Honda", "Civic")
    val motorcycle1 = Motorcycle("Harley-Davidson", "Sportster")
    val customer1 = Customer("Jaimito")
    val customer2 = Customer("Lupita")

    dealership.addCar(car1)
    dealership.addCar(car2)
    dealership.addMotorcycle(motorcycle1)

    dealership.showAvailableVehicles()

    customer1.rentCar(dealership, car1)
    customer2.rentMotorcycle(dealership,motorcycle1)

    dealership.showAvailableVehicles()

    customer1.returnCar(dealership, car1)

}