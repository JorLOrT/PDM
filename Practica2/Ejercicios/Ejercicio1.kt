package Ejercicios

class BankAccount(private var balance: Double = 1000.0, private val limit: Double = 500.0) {

    //Establece el saldo de la cuenta.
    fun setBalance(newBalance: Double) {
        if (newBalance < 0) {
            throw IllegalArgumentException("El saldo no puede ser negativo.")
        }
        balance = newBalance
        println("Saldo actualizado: $$balance")
    }

    //Obtiene el saldo de la cuenta.
    fun getBalance(): Double {
        return balance
    }

    //Realiza un retiro de la cuenta.
    fun withdraw(amount: Double): Boolean {
        if(amount > balance || amount > limit) {
            println("No se puede realizar el retiro. Verifica el monto o el limite de retiro.")
            return false
        }
        balance -= amount
        println("Retiro exitoso. Saldo restante: $$balance")
        return true
    }

    //Realiza un deposito en la cuenta
    fun deposit(amount: Double): Boolean {
        balance += amount
        println("Deposito exitoso. Saldo actual: $$balance")
        return true
    }

    // Solicitar monto a depositar
    fun askAmount(operation: String):Double {
        // Bucle para repetir la solicitud hasta que se ingrese un monto valido.
        while (true) {
            print("Ingrese el monto a $operation: ")
            // Verifica que se trate de un valor valido
            try {
                // Se le pide al usuario que ingrese el monto de la operacion
                val amount:Double = readln().toDouble()
                if (amount > 0) {
                    // Si el monto es positivo, retornar el valor.
                    return amount
                } else {
                    // Si no lo es, muestra el mensaje de error
                    println("El monto debe ser un numero positivo.")
                }
            } catch (e: NumberFormatException) {
                // Si la entrada no es valida
                println("Entrada invalida. Intente nuevamente.")
            }
        }
    }
}

fun showMenu(myAccount: BankAccount){
    while (true) {
        println("**Menú de operaciones**")
        println("1. Consultar saldo")
        println("2. Depositar")
        println("3. Retirar")
        println("4. Salir")
        print("Seleccione una opción: ")

        val option = readln().toIntOrNull()

        if (option == null || option !in 1..4) {
            println("Opción inválida. Ingrese un número del 1 al 4.")
            continue
        }

        when (option) {
            1 -> {
                println("Saldo actual: $${myAccount.getBalance()}")
            }
            2 -> {
                val amount:Double = myAccount.askAmount("depositar")
                myAccount.deposit(amount)
            }
            3 -> {
                val amount:Double = myAccount.askAmount("retirar")
                myAccount.withdraw(amount)
            }
            4 -> {
                println("Gracias por usar la aplicación.")
                break
            }
        }
    }
}

// Funcion principal
fun primerEjercicio() {
    val myAccount = BankAccount()
    try {
        myAccount.setBalance(1500.0)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
    showMenu(myAccount)
}