package Ejercicios

// Clase abstracta de donde heredaran atributos las subclases de empleados
abstract class Employee(
    val firstName: String,
    val lastName: String,
    val age: Short,
) {
    //Funcion para calcular el pago del empleado
    abstract fun calculatePayment(): Double
    //Para poder usar la función sin crear una instancia del objeto abstracto
    companion object {
        // Funcion para mostrar todos los empleados
        fun displayAllEmployees(fullTimeEmployees: List<FullTimeEmployee>, partTimeEmployees: List<PartTimeEmployee>) {
            println("Empleados a tiempo completo:")
            fullTimeEmployees.forEach { employee ->
                println("Nombre: ${employee.firstName} ${employee.lastName} \n sueldo: ${employee.calculatePayment()}")
            }

            println("\nEmpleado a tiempo parcial:")
            partTimeEmployees.forEach { employee ->
                println("Nombre: ${employee.firstName} ${employee.lastName} \n sueldo: ${employee.calculatePayment()}")
            }
        }
    }
}

// Sub Clase empleado a tiempo completo
class FullTimeEmployee(
    firstName: String,
    lastName: String,
    age: Short,
    val hoursWorked: Int,
    val hourlyRate: Double
) : Employee(firstName, lastName, age) {
    // Calculo del pago de empleado a tiempo completo
    override fun calculatePayment(): Double {
        return hoursWorked * hourlyRate
    }
}

// Sub clase empleado a tiempo parcial
class PartTimeEmployee(
    firstName: String,
    lastName: String,
    age: Short,
    val hoursWorked: Int,
    val hourlyRate: Double,
    val daysWorked: Int
) : Employee(firstName, lastName, age) {
    // Calculo del pago de empleado a tiempo parcial
    override fun calculatePayment(): Double {
        return (hoursWorked * hourlyRate) * daysWorked
    }
}

fun tercerEJercicio() {
    val fullTimeEmployee1 = FullTimeEmployee("Pepito", "Perez", 20, 48, 30.0)
    val fullTimeEmployee2 = FullTimeEmployee("Pepita", "Perez", 20, 48, 33.0)
    val partTimeEmployee1 = PartTimeEmployee("Juanito", "Perez", 23, 5, 23.0, 5)
    val partTimeEmployee2 = PartTimeEmployee("Juanita", "Perez", 18, 5, 18.0, 5)
    Employee.displayAllEmployees(listOf(fullTimeEmployee1, fullTimeEmployee2), listOf(partTimeEmployee1, partTimeEmployee2))

}