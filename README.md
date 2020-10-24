Developed by:
* Jazmin Villagra (jvillagra)
* Javier Heisecke (jheisecke)
* Yesshua Lopez (yedaloc)
* Matias Fare (matiasfare)

### Dependencias
* Java 8
* Postgres10

### Ejecutar Proyecto

1- Crear la BD **traceability** 

2- Ejecutar el script **scriptcreaciontablas.sql** en la BD

3- Ingresa al Directorio del proyecto

    $ cd traceability 

4- Ejecuta script de inicio

    $ ./run.sh

### Integración con Amazon Web Services

Se puede encontrar la aplicación levantada en la siguiente URL: http://traceability.us-west-2.elasticbeanstalk.com

#### Requests de prueba

Lista todos los proyectos

```
curl --request GET \
  --url http://traceability.us-west-2.elasticbeanstalk.com/api/proyectos
```

Inserta un ítem al proyecto 1

```
curl --request POST \
  --url http://traceability.us-west-2.elasticbeanstalk.com/api/item/save \
  --header 'content-type: application/json' \
  --data '{
    "idProyecto": 1,
    "id": null,
    "idFase": null,
    "nombre": "asasdasdf",
    "idItemPadre": null,
    "estado": "pendiente",
    "idLineaBase": null,
    "fechaAlta": null,
    "fechaModificacion": null,
    "observacion": "3fasef",
    "descripcion": "asdfad",
    "prioridad": "alto",
    "version":null
}'
```

Lista todos los ítems del proyecto 1

```
curl --request GET \
  --url http://traceability.us-west-2.elasticbeanstalk.com/api/item/1
```

### Stress tests

Ejecutar el archivo `traceability.jmx` con **Apache JMeter**
#### OBS: User administrador default
  
  user: admin
  pass: admin
