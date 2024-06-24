## Proyecto final AOUTH2_Y_JWT
- Este proyecto contiene la union de todos los demas proyectos.
- tambien tiene un proyecto que es el servidor de accesos.
- 1.-correr primero oauth.server
- 2.-correr SpringBootRest3

### Datos
- Usuario:jgomez
- Contraseña:12345678
- Client_Id:oauth-client
- Client_Secret:12345678

### Test
```
C:\SpringBootRest3\>mvnw test -X
```

### End-Points GET
- http://localhost:8080/api/v1/users
- http://localhost:8080/api/v1/users/10001


- http://localhost:8080/api/v1/security/authorized


- http://localhost:8080/api/v1/products
- http://localhost:8080/api/v1/products/101


- http://localhost:8080/api/v1/pokemon/ditto
- http://localhost:8080/api/v1/pokemon/mindata/ditto
- http://localhost:8080/api/v1/pokemon/alldata/ditto


- http://localhost:8080/api/v1/makers
- http://localhost:8080/api/v1/makers/100


- http://localhost:8080/api/v1/home



### End-Points POST
- http://localhost:8080/api/v1/users
```json
{
  "firstName": "Nombre",
  "lastName": "Apellidos",
  "email": "correo@dominio.com"	
}
```


- http://localhost:8080/api/v1/users/filter
```json
{
	"firstName":"",
	"lastName":"ez",
	"email":""
}
```
- http://localhost:8080/api/v1/products
```json
{
	"name":"Monitor LCD 19",
	"price":"236.25",
	"maker":{"id":100}
}

```
- http://localhost:8080/api/v1/makers
```json
{
	"name":"LG"
}
```
- http://localhost:8080/api/v1/security/encrypt
```json
{
	"textclear":"Prueba de encriptacion JGomez"
}
```
- http://localhost:8080/api/v1/security/decrypt
```json
{
	"textencrypt":"+41q7Y0nuMHoKZXf7RTHraUBDpg71rfxgmmE3Y5fF/E="
}
```

### End-Points PUT
- http://localhost:8080/api/v1/users/10001
```json
{
  "firstName": "Nombre Dos",
  "lastName": "Apellidos Dos",
  "email": "correodos@dominio.com"	
}
```
- http://localhost:8080/api/v1/products/101
- http://localhost:8080/api/v1/makers/100

### End-Points DELETE
- http://localhost:8080/api/v1/users/10001
- http://localhost:8080/api/v1/products/101
- http://localhost:8080/api/v1/makers/100

### End-Points OAUTH
- http://127.0.0.1:8080/login/oauth2/code/oauth-client
- http://127.0.0.1:9000/oauth2/token
- http://127.0.0.1:9000/oauth2/authorize 



## Proyectos Java
- Se crean diferentes proyectos demos con distintas configuracioners para crear el proyecto final.
- Se añade proyecto en SoapUi para probar los end-points.
### Crud
- Se trabaja unicamente el crud de un catalogo.
### Filtro
- Se añade un filtro.
### Pokemon
- Se implementa el uso de servicios rest externos.
### Encriptado
- Se realiza la implementación de la encriptación y desecncriptación de la cadena encriptada.
### AOUTH2_GOOGLE
- Se implementa el inicio de sesión con google o GitHub.