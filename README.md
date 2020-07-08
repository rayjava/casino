# casino
Implementación conceptual de backend de una aplicación de un casino simplificado donde los jugadores pueden realizar apuestas y obtener ganancias.
realizando la  Implementación conceptual de backend de una aplicación de un casino simplificado donde losjugadores pueden realizar apuestas y obtener ganancias.

Tecnologia Utilizada:
.- Windows 10.
.- Spring Tool Suite 4.
.- Spring Boot Ver. 2.3.1
.- BD: h2 (com.h2database)
.- Maven ver: apache-maven-3.6.3
.- Host: Localhost:8080
Pruebas de las Api: App Postman.
1) Probamos las APÎ con Postman, las siguiente, al ejecutar el rest, se crean automaticos para las pruebas:Proveedores, Juegos y Configuracion.
2) Creamos Proveedores Colocamos Metodo:GET URI: http://localhost:8080/creaprov
	.- Tomamos un UUID de unos de los proveedores registrados, para validar probar el end point /jugador.
3) Creamos los Juegos Colocamos Metodo GET, URI: http://localhost:8080/creajuegos
4) Creamos las Configuraciones Metodo: GET, URI: http://localhost:8080/creaconfig
5) Creamos el fichero JSON de Jugador colocando los siguientes campos:
{ 
    "uuid": "",
    "usuario": "URDO",
    "tipojuego": "BLACKJACK",
    "balance": 50.0,
    "timePlay": 20,
    "fecha": "07/07/2020",
    "montoapuesta": 20.0,
    "descripcionapuesta": "21",
    "uuidproveedor": "",
    "mensajes": "Lo sentimos, haz perdido, vuelve a intentar.."
}
   En el campo "uuidproveedor",reemplazamos con el valor del campo que tomamos que tomamos del Json "Proveedores"(Punto 2). 
   Para procesar y colocado el formato Json en "Body", colocamos Metodo:POST URL:http://localhost:8080/jugador

6) Para listar los Movimientos: Metodo: GET, URI:localhost:8080/movimientos
7) Para listar los Jugadores: Metodo: GET, URI:localhost:8080/jugadores

Pantallas de las pruebas:
 
 
 
 
 
 
 






