##Manual de Usuario: Sistema de Gestión para Academia Melodía

#Descripción General
Este es un sistema de gestión integral para una academia de música, diseñado para administrar personas, instrumentos, clases y eventos musicales. Es un software basado en consola que organiza y facilita las tareas de gestión en la academia de manera eficiente.

##Cómo Usar el Sistema

#Menú Principal
Al iniciar el sistema, se presenta un menú principal que permite al usuario seleccionar diferentes opciones según sus necesidades.
Opciones disponibles:

- Gestión de Personas
- Gestión de Instrumentos
- Gestión de Clases
- Gestión de Eventos
- Salir del Sistema
Para seleccionar una opción, simplemente ingrese el número correspondiente y presione Enter.

#Funcionalidades Principales
1. Gestión de Personas
Opciones disponibles:

- Agregar Estudiantes: Registra nuevos estudiantes en la base de datos.
- Agregar Profesores: Registra nuevos profesores junto con su especialidad.
- Agregar Personal Administrativo: Registra al personal encargado de la administración.
- Buscar Personas: Realiza búsquedas de personas registradas en el sistema.

2. Gestión de Instrumentos
Opciones disponibles:

- Agregar Instrumentos: Registra un nuevo instrumento musical con detalles como tipo, marca y disponibilidad.
- Prestar Instrumentos: Registra el préstamo de un instrumento a un estudiante o profesor.
- Registrar Devoluciones: Marca un instrumento prestado como devuelto.
- Listar Instrumentos: Muestra un listado de todos los instrumentos disponibles o en préstamo.

3. Gestión de Clases
Opciones disponibles:

- Crear Clases: Configura nuevas clases con detalles como asignatura, horario y profesor encargado.
- Inscribir Estudiantes: Asocia estudiantes registrados a una clase específica.
- Registrar Asistencia: Lleva un registro de la asistencia de los estudiantes a las clases.
- Registrar Calificaciones: Asigna calificaciones a los estudiantes inscritos en una clase.
- Listar Clases: Muestra todas las clases creadas, junto con sus participantes.

4. Gestión de Eventos
Opciones disponibles:

- Crear Recitales: Registra un nuevo recital con fecha, hora y lugar.
- Agregar Participantes a Recitales: Asigna estudiantes o profesores como participantes en un recital.
- Modificar Orden de Participación: Permite reorganizar el orden en el que los participantes se presentarán.
- Listar Recitales: Muestra los recitales programados junto con sus participantes.
- Eliminar Recitales: Elimina recitales programados que ya no se realizarán.

#Consejos para Evitar Errores

- Siempre ingrese datos completos y precisos.
- Respete los formatos de entrada (por ejemplo, fechas: DD/MM/AAAA y horas: HH:MM).
- Verifique la existencia de personas o instrumentos antes de realizar operaciones.
- Preste atención al seleccionar las opciones del menú para evitar elegir una incorrecta.
- Use números enteros para seleccionar opciones en el menú principal.

#Errores Comunes a Evitar

- Ingresar datos en un formato incorrecto.
- Por ejemplo, usar fechas como "12-31-2024" en lugar de "31/12/2024".
- Intentar prestar instrumentos que no existen en el sistema o ya están prestados.
- Inscribir estudiantes en clases que no tienen cupo disponible.
- Modificar datos sin verificarlos previamente, lo que puede causar inconsistencias.
- Salir del sistema abruptamente sin guardar los cambios realizados.

#Cómo Ejecutar el Sistema

Paso 1: Descomprimir el Archivo ZIP

- Descargue el archivo .zip que contiene el sistema.
- Extraiga el contenido del archivo en una carpeta de su preferencia.
- Haga clic derecho sobre el archivo y seleccione Extraer todo o Extraer aquí.

Paso 2: Configurar el Entorno de Desarrollo

Asegúrese de tener instalado:
- Java JDK (Java Development Kit).
- Un IDE (IntelliJ IDEA, Eclipse, NetBeans) o la línea de comandos para compilar y ejecutar manualmente.
- Para verificar la instalación de Java:
- Abra la terminal o consola de comandos.
- Escriba el comando:
- java -version
- Si Java está instalado correctamente, verá la versión actual de Java.

Paso 3: Ejecutar el Sistema en un IDE

- Abra el IDE de su preferencia.
- Seleccione la opción de abrir un proyecto existente y navegue a la carpeta donde descomprimió el archivo .zip.
- Compile y ejecute el programa:
- En IntelliJ IDEA: Haga clic en el botón Run (triángulo verde).
- En Eclipse: Haga clic derecho sobre el archivo Main.java y seleccione Run As > Java Application.

Paso 4: Ejecutar el Sistema desde la Línea de Comandos
- Abra la terminal o consola de comandos.
- Navegue hasta la carpeta donde descomprimió el archivo usando el comando cd.
- Compile las clases con el comando:

javac *.java

- Ejecute el programa principal con el comando:

java Main

Paso 5: Uso del Sistema
- Al ejecutar el programa, verá el menú principal en la consola.
- Ingrese el número de la opción deseada y presione Enter.
- Siga las instrucciones en pantalla para realizar las operaciones disponibles.

Paso 6: Cerrar el Sistema

Para salir, seleccione la opción 5. Salir del Sistema. Esto cerrará el programa y asegurará que los cambios realizados sean guardados correctamente.
