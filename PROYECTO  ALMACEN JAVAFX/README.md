# PROYECTO GESTISIMAL*
(*ver información adicional al final del documento)

Este es el proyecto final de la asignatura de PROGRAMACIÓN.

Trata de la gestión de un almacén que realizamos en el Segundo    Trimestre y ahora lo que hemos hecho ha sido implementar la interfaz    gráfica de usuario gracias a JAVAFX.

Este proyecto consta de las siguientes partes:

# MENU PRINCIPAL

En este menú aparecen las siguientes opciones:

     * ALMACÉN
     * LISTADO
     * HERRAMIENTAS
     * CONTACTO

## ALMACÉN

En esta parte aparecen las siguientes opciones:
* Alta: donde podremos dar de alta artículos en nuestro almacén, para ello tendremos que rellenar los siguientes datos:

	       DESCRIPCIÓN
	       PRECIO DE COMPRA
	       PRECIO DE VENTA
	       UNIDADES
	       STOCK MÍNIMO
	       TIPO DE IVA (general, reducido,superreducido)
	       AÑADIR IMAGEN
       
 * Baja: donde podremos dar de baja un artículo que este en el almacén, para ello deberemos introducir el código de dicho artículo.
 * Modificación: sección dedicada a modificar alguno de los elementos citados anteriormente. Primeramente aparecerá una ventana para introducir el código del articulo a modificar y después la ventana para realizar los cambios oportunos.
 * Entrada de Mercancía: sección dedicada a introducir mercancía a un artículo determinado de nuestro almacén. Primero tendremos que introducir el código del artículo elegido y aumentar las unidades disponibles.
 * Salida de Mercancía: sección dedicada a decrementar mercancía a un artículo determinado de nuestro almacén. Primero tendremos que introducir el código del artículo elegido y después decrementar las unidades disponibles.
 * Pedido Automático: sección dedicada a realizar un pedido de los artículos cuyas unidades se encuentren por debajo del Stock mínimo. Genera un fichero en el que aparecerá reflejada la cantidad de unidades necesarias para alcanzar el stock mínimo.
 * Salir: botón para salir de la aplicación. 

## LISTADO

En esta parte aparecen las siguientes opciones:

- Lista Colectiva: en esta sección aparecerá una tabla con la información detallada de cada artículo (descripción, precio compra, precio venta, unidades. stock mínimo, tipo de iva).
También aparecen las siguientes opciones:
     - Modificar un artículo: abre la ventana para modificar artículos
     - Baja de artículos: elimina el artículo seleccionado
     - Alta articulo: abre la ventana para dar de alta un artículo
     - Cambiar vista: seleccionando un artículo se abrirá la vista de la lista individual, para ver los detalles de ese artículo.
- Lista Individual: en esta sección aparecerá la información de tallada de cada articulo, donde además podremos modificar su información y podremos ver la información del articulo anterior y posterior al seleccionado.
     
## HERRAMIENTAS

En esta parte aparecen las siguientes opciones:
- Exporta fichero: ventana dedicada a exportar a un fichero en formato CSV, XML, JSON la información almacenada en nuestro almacén.
- Importa fichero: ventana dedicada a importar de un fichero en formato CSV, XML, JSON la información que queremos almacenar en nuestro almacén.

## CONTACTO

Sección dedicada a ver la información y redes sociales de los autores de este proyecto que son:
- JOSÉ LUIS ÁLVAREZ FERNÁNDEZ
- FRANCISCO JAVIER CAMPOS GUTIERREZ
- ANTONIO QUESADA CUADRADO

## INFORMACIÓN ADICIONAL

En algunos casos desde Windows, y dependiendo de la seguridad en la carpeta contenedora de las imagenes abrá que, modificar los permisos para Java. Esto lo haremos haciendo clic sobre la carpeta contenedora y: Propiedades>Seguridad>Editar. En este apartado lo haremos de dos formas diferentes:
- Añadimos permisos de modificación o escritura a Java
- Añadimos al grupo 'Todos' permsisos de modificación o escritura. Esta segunda opción es más arriesgada por que ponemos en peligro tu equipo.

También para el uso completo del programa se recomienda extraer los ficheros del archivo .jar para hacer uso de la aplicación.