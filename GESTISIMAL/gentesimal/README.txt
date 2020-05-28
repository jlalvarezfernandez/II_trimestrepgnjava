ALMACEN GESTESIMAL

Encontramos tres partes:

Necesito una clase Articulo que representa a los artículos del almacén.   
Su estado será: código, descripción, precio de compra, precio de venta y  número de unidades (nunca negativas). 
Como comportamiento: Considero que el código va a  generarse de forma automática en el constructor, así no puede haber dos  artículos con el mismo código. Esto implica que no puede modificarse el  código de un artículo. Sí el resto de las propiedades. Podremos mostrar el  artículo, por lo que necesito una representación del artículo en forma de  cadena (toString) 
Clase Almacen que realice el alta, baja, modificación, entrada de  mercancía (incrementa unidades), salida de mercancía (decrementa unidades) 
El estado será un ArrayList de artículos. Esta clase es un envoltorio de un ArrrayList, pero su diseño es distinto al de GESTISIMAL. No te copies, sencillamente entiéndelo.
Su comportamiento será: añadir  artículos (no puede haber dos artículos iguales), eliminar artículos,  incrementar las existencias de un artículo (se delega en la clase artículo),  decrementar las existencias de un artículo (nunca por debajo de cero, se  delega en la clase artículo), devolver un artículo (para mostrarlo). Para  listar el almacén podría devolverse una cadena con todos los artículos del almacén (toString)
Clase TestAlmacen, donde se realiza la comunicación con el usuario  (mostrar menú y recuperar opción del menú, mostrar errores, listar) y se  manipula el almacén.  Debes organizarla en métodos que deleguen en la clase almacén (listar, annadir, eliminar... al menos uno por cada una de las opciones del menú).