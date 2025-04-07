import scala.io.StdIn


object ejercicios

def numeroMayor() =
    var menor: Int = 0
    println("Introduce el primer número a comparar")
    val num1: Int = StdIn.readInt()
    println("Introduce el segundo número a comparar")
    val num2: Int = StdIn.readInt()
    println("Introduce el tercer número a comparar")
    val num3: Int = StdIn.readInt()
    if num1 < num2 then
        if num1 < num3 then
            menor = num1
        else
            menor = num1
    else
        if num2 < num3 then
            menor = num2
        else
            menor = num3
    println("El número menor es:" + menor)

def letraEnFrase() =
    println("Introduce una frase")
    val frase: String = StdIn.readLine()
    println("Introduce la letra a buscar")
    val letra: Char = StdIn.readChar()
    var cont = 0
    for x <- frase do
        if x == letra then
            cont+=1
    println(s"La letra $letra aparece $cont veces en la frase")

def sumaResta() =
    println("Introduce el primer número para operar")
    val num1: Int = StdIn.readInt()
    println("Introduce el segundo número para operar")
    val num2: Int = StdIn.readInt()
    println("Introduce + para sumar o - para restar")
    val opera: String = StdIn.readLine()
    if opera == "+" then
        println(s"El resultado es = ${num1+num2}")
        else if opera == "-" then
            println(s"El resultado es = ${num1-num2}")
        else
            println("Operación incorrecta")

def userPass() =
    val usuario = "Paco"
    val clave = "12345"
    var ok: Byte = 0
    var intentos = 0
    while ok == 0 && intentos < 3 do
        intentos += 1
        println("Introduce usuario")
        val usupp: String = StdIn.readLine()
        println("Introduce contraseña")
        val passpp: String = StdIn.readLine()
        if usupp == usuario && passpp == clave then 
            println("Bienvenido al sistema")
            ok = 1
        else
            println("Fallaste")

def letraClave() =
    println("Introduce una letra")
    val letra: String = StdIn.readLine()
    letra match
        case "a" => println("7")
        case "b" => println("9")
        case "c" => println("101")
        case _  => println("Sigue buscando, hay miles de premios")
    


def main(args: Array[String]): Unit = 
    print("\u001b[2J")
    var opc = 1
    while opc != 0 do
        println("0º Salir")
        println("1º Solicita al usuario tres números enteros e indícale cuál es el menor.")
        println("2º Solicita al usuario una frase y una letra y muestra la cantidad de veces que aparece la letra en la frase.")
        println("3º Suma o resta (según elija el usuario) dos números reales")
        println("4º Almacena en dos variables datos de validación (usuario y contraseña) correctos y permite que el usuario valide (dispone de 3 intentos)")
        println("5º Solicita al usuario una letra, si inserta una a muestra el número 7, si es una b, el 9, si es una c el 101 y si no es ninguno de los tres, indícale que se ha equivocado de letra")
        opc = StdIn.readInt()
        opc match
            case 1 => numeroMayor()
            case 2 => letraEnFrase()
            case 3 => sumaResta()
            case 4 => userPass()
            case 5 => letraClave()
            case 0 => println ("Chao pescao")

