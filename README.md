# Desplegada Servicio

1. para compilar

      mvn clean install -DskipTests=true

2. para ejecutar Dockerfile 
 
      docker-compose up -d

# API REST

1. /home/signup

      -Metodo POST
      
      -Ejemplo request: {"usuario": "tenpo", "contrasena": "clave.nueva"}
          
2. /api/sumar?primero=4&segundo=2

      -Metodo GET
      
      -variable1 con el nombre "primero" y variable2 con el nombre "segundo"
      
      -variable1 y variable2 son los valores a sumar
      
3. /api/historial?inicio=1&cantidad=2

      -Metodo GET    
      
      -variable1 con el nombre "inicio" y variable2 con el nombre "cantidad"    
      
      -variable1 es el numero de la pagina y variable2 la cantidad de datos por pagina

4. /api/logout

      -Metodo POST
