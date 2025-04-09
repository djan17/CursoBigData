import scala.io.StdIn


class Cuenta(private val _numeroCuenta: String, private var _saldo: Double):

  def this(numeroCuenta: String) = this(numeroCuenta, 0.0)

  def numeroCuenta: String = _numeroCuenta
  def saldo: Double = _saldo

  def saldo_=(cantidad: Double): Unit = _saldo = cantidad

  def depositar(cantidad: Double): Unit = _saldo +=  cantidad

  def retirar(cantidad: Double): Unit =
    if (saldo-cantidad < 0) then
        println("No dispones de saldo suficiente")
    else
        _saldo -= cantidad

  def consultarSaldo(): Unit = println("Saldo actual: " + _saldo + "€")


object CCCApp:
  def main(args: Array[String]): Unit =


    def pedirCantidad(): Double =
        var cantidad = -1.0
        while (cantidad<10.0)
            println("Introduce cantidad (mínimo 10€)")
            cantidad = StdIn.readDouble()
        cantidad


    val cuenta = new Cuenta("1250 14 1221 1231 8487")
    var opc = "1"
    while opc != "3" do
        println("======= Operaciones de caja =======")
        println()
        cuenta.consultarSaldo()
        println("1. Retirada de efectivo")
        println("2. Ingreso de efectivo")
        println("3. Salir")
        opc = StdIn.readLine()
        opc match
          case "1" => cuenta.retirar(pedirCantidad())
          case "2" => cuenta.depositar(pedirCantidad())
          case "3" => println("Gracias por usar nuestros cajeros")
          case _ => println("Opción incorrecta")

