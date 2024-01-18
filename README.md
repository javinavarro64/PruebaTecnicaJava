


# ![Logo](https://www.intricom.es/wp-content/uploads/2020/03/cropped-icono.png) Prueba técnica para desarrollador java


## Instrucciones

1. Clonar este repositorio en vuestra cuenta de github
2. Dar permiso a la cuenta ***desarrollo@intricom.es*** para dicho repositorio
3. Descargarse el servidor JBOSS-7.2 [desde este enlace](https://intricomressources-my.sharepoint.com/:u:/g/personal/bserapio_intricom_es/EfRQTAllZhRPuYdkx76dEkQBsSuDPWte7IX3_uyo7I9HTw?e=lh53D4). Contiene un JBOSS con los drivers de Oracle y Postgress instalados, además de tener la ruta de los archivos de properties ya configurados en standalone.xml
4. Poner el archivo .zip dentro de la carpeta **.deployment/docker/jboss**
5. Dentro de la carpeta del punto anterior, vereis un DOCKERFILE que monta la imagen de docker
6. Dentro de la misma carpeta teneis una carpeta de properties, si ncesitais meter alguna variable de entorno para cargarla se pone en uno de esos .properties y se regenera la imágen.
7. Hacer commits descriptivos para ir viendo la evolución del mismo
8. Rellenar este documento con las instrucciones para el despliegue.

***Observaciones***

Dentro de la carpeta scripts tienes 3 subcarpetas

* ***bbdd***: Esta carpeta contendrá los scripts necesarios para montar la base de datos ( tablas,secuencias , permisos, etc..)
* ***configuracion***: Esta carpeta contiene 2 archivos de configuración, que a la hora de montar la aplicación si se quiere se pueden usar y tienen que ser instanciadas en standalone.xml de ***jboss***. Si se van a usar necesito que se especifique en las instrucciones para poder desplegarlo.
* ***datasources***: Esta carpeta contiene la configuración de la base de datos. Contiene el nombre de la base de datos , el usuario y contraseña. Para poder usar la DB una vez levantado JBOSS se puede añadir este XML como nueva aplicación y JBOSS será capaz de interpretar este archivo.

Para poder montar un entorno de desarrollo , se puede seguir [la siguiente guía](https://www.caib.es/sites/dgtic/es/estandards_de_desenvolupament/archivopub.do?ctrl=MCRST299ZI339718&id=339718) de configuración para tener un entorno de desarrollo validado por la caib

La parte de configuración de apps con KEYCLOAK no es necesaria, ya que la prueba no tendrá validación de roles ni usuarios.

***Requisitos mínimos***

Para poder pasar esta prueba técnica, el candidato tendrá que entregar dicha prueba para ser ejecutado desde docker.
Como servicios docker tiene que aparecer un servicio **JBOSS 7.2** y un servicio **Postgres**.


La forma de evaluación será la siguiente una vez entregada la prueba:

1. Se montará una máquina virtual en Linux ( Ubuntu 20.04)
2. Se clonará el repositorio del candidato
3. Dentro del repositorio se ejecutará ***docker-compose up***
4. Se seguirá las instrucciones  escritas en esta guía para poder desplegar la solución y probar su funcionamiento


## INSTRUCCIONES PARA CONSTRUIR LA IMAGEN DE DOCKER

Lanzar el siguiente comando desde la ruta base del proyecto:

```
    docker build -t intricom/jbosseap:7.2 -f .deployment/docker/jboss/Dockerfile .
```


## INSTRUCCIONES PARA EL DESPLIEGUE
****

Se necesita rellenar este apartado como guía para desplegar la solución

