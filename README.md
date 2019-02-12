THESIS - Acceleo transformation rules to generate mobile application code (Android and WP) from a model


## How to import the generated code to Android Studio (/src-gen/android)

1) Crear las siguientes subCarpetas a partir del nombre del paquete:
	->	activities
->	adapters
	->	bd
		->	dao
		->	helper
		->	tables
	->	beans
	->	conn
	->	file
	->	sharedpreferences
	->	utils
	
2) Copiar y pegar los archivos generados en las carpetas creadas correspondientes.
3) Copiar y pegar el contenido de la carpeta layout en res/layout (ya generado)
4) AndroidManifest.xml : 
Ir al archivo Manifest (ya generado) y reemplazar el contenido de <manifest></manifest> por el contenido del archivo AndroidManifest.xml generado.	
5) build.gradle : 
Ir al archivo build (ya generado) y reemplazar la sección dependencies{} por el dependencies{} en el archivo generado build.gradle.
Obs.: Hacer sync del proyecto luego de estos cambios.
6) Recorrer las clases generados, e ir importando los path de los archivos no encontrados. 
Obs.: Combinación de teclas: Alt+enter
7) En los beans, aquellas funciones (operations) declaradas en el modelo, son generados con un return vacio, el cual es necesario completar para poder compilar.


#### Links de consultas
•	Persisting Data to the Device: Breve resumen de las estrategias para la persistencia que encontramos en Android.
https://github.com/codepath/android_guides/wiki/Persisting-Data-to-the-Device

•	Files (almacenamiento interno o externo): manual de uso y manejo de los archivos en Android.
https://developer.android.com/training/basics/data-storage/files.html?hl=es-419

•	SharedPreferences: tutorial para el acceso y el almacenamiento de datos usando la clase SharedPreferences.
https://github.com/codepath/android_guides/wiki/Storing-and-Accessing-SharedPreferences

•	LocalDatabases with sQlite: tutorial para la creación de una base de datos SQLite.
https://github.com/codepath/android_guides/wiki/Local-Databases-with-SQLiteOpenHelper

• Android estructura de directorios
https://github.com/codepath/android_guides/wiki/Android-Directory-Structure

•	Recibiendo datos de otras apps (comunicación entre aplicaciones): via intents, la aplicación puede manejar datos provenientes de otras aplicaciones. De la página oficial de Android, tenemos el siguiente entrenamiento utilizando intents para recibir datos.
https://developer.android.com/training/sharing/receive.html
https://developer.android.com/training/secure-file-sharing/index.html

•	Sensores: cómo utilizar sensores y la estructura de la clase (consumir datos y registrar los eventos de los sensores).
 https://github.com/codepath/android_guides/wiki/Listening-to-Sensors-using-SensorManager

• Lista de sensores podemos encontrar en: 
 https://developer.android.com/guide/topics/sensors/sensors_overview.html

•	Rest: utilizamos la librería Retrofit como cliente Rest. El siguiente link presenta un ejemplo de uso.
http://www.androidhive.info/2016/05/android-working-with-retrofit-http-library/

•	Manejo de permisos: a partir de Android 6, el usuario se encarga de otorgar los permisos mientras la aplicación está en ejecución.
https://www.sitepoint.com/requesting-runtime-permissions-in-android-m-and-n/
https://developer.android.com/training/permissions/requesting.html
 


## How to import the generated code to Visual Studio (/src-gen/windows_phone)


### Configurar proyecto
Crear un proyecto Windows Phone (Blank App – Windows Phone). Luego agregar un Nuevo item (Click derecho en el Proyecto -> Add ítem -> Basic Page). De esta forma de auto-importan todos los recursos necesarios para cargar dicha página (Específicamente, se crea la carpeta Common, con las siguientes dependencias: NavigationHelper.cs, ObservableDictionary.cs, RelayCommand.cs y SuspensionManager.cs).

1)	El nombre del proyecto a crear en VS, tiene que tener el mismo nombre del paquete del modelo.
2)	Configuración de SQLite
Importar librería
https://code.msdn.microsoft.com/windowsapps/Sqlite-Sample-for-Windows-83d88433
2.1)Installing SQLite for Windows Phone SDK:
https://marketplace.visualstudio.com/items?itemName=SQLiteDevelopmentTeam.SQLiteforWindowsPhone81

2.2)Installing sqlite-net package:
Click on "Manage NuGet Packages" and search for "sqlite-net"  => Click on "Install" button

3)	Configuración rest
Importar librería
Package Manager Console > Install-Package Kulman.WPA81.BaseRestService
4)	Package.appxmanifest:
Configurar permisos:
	Pestaña Capabilities para especificar las características del dispositivo que la aplicación puede utilizar.

5) Configurar Share Target:
	Pestaña Declarations: 
•	Supported Declarations: Add Share Target
•	Properties: 
	Share Description: Media Link
•	Add Data Formats: StorageItems, Text, Bitmap, URI
6)	Crear subcarpetas: Common, Model, ViewModel, Views
7)	Copiar y pegar los archivos generados en las carpetas creadas correspondientes.
8)	Reemplazar el archivo App.xaml.cs por el mismo generado.
9)	Reemplazar el archivo Main.xaml y Main.xaml.cs por los mismos generados.
10)	Los beans, si hay funciones con return, hay que corregir (poner vacio o “”) para compilar.
11)	Verificar si quedan cosas pendientes de importar


#### Links de consultas

• Tutorial para utilizar emulador de Windows
Link: System requirements for the emulator for Windows Phone 8
https://msdn.microsoft.com/es-es/library/windows/apps/ff626524(v=vs.105).aspx

• Getting started storing app data locally
https://blogs.windows.com/buildingapps/2016/05/10/getting-started-storing-app-data-locally/#DKmCFRtvSpzPthXb.97

• The MVVM Pattern
https://msdn.microsoft.com/en-us/library/hh848246.aspx

• The basics about Navigation and initializing the project: 
Windows/Phone 8.1–Frame, Page, NavigationHelper, SuspensionManager
https://mtaulty.com/2014/05/23/m_15262/

• Recibiendo datos de otras apps -> COMUNICACIÓN ENTRE APPS
Windows phone 8.1 - Shared Local Folder / Roaming Folder
https://blogs.windows.com/buildingapps/2016/05/24/sharing-your-local-app-data/
https://blogs.msdn.microsoft.com/thunbrynt/2014/04/24/windows-phone-8-1-for-developersapplication-data/

• FILEs
https://msdn.microsoft.com/en-us/windows/uwp/files/quickstart-reading-and-writing-files
FILEs -> SDCARD
https://monkeyweekend.wordpress.com/2014/12/09/write-a-file-to-the-sd-card-on-windows-phone-8-1/

• SQLITE
Working with SQLite (How to install and tutorial)
https://code.msdn.microsoft.com/windowsapps/Sqlite-Sample-for-Windows-83d88433
http://bsubramanyamraju.blogspot.com/2015/01/windowsphone-81-sqlite-how-to-store.html

• SENSORES
Acelerómetro en Windows Phone
 https://www.youtube.com/watch?v=srrQH2N6xNA

- GPS in windows 
http://windowsapptutorials.com/windows-phone/location/get-gps-coordinates-in-windows-phone-8-1-app/

- Audio Record
 http://www.codeproject.com/Articles/837500/Recording-Audio-in-Windows-Phone

- Lista de sensores
https://msdn.microsoft.com/en-us/library/windows/apps/hh202968(v=vs.105).aspx
https://msdn.microsoft.com/en-us/library/windows/apps/windows.devices.sensors.aspx

- How to use camera in WP8.1
http://blog.pnajinnovations.com/p/how-to-use-camera-in-wp-81-app.html
https://msdn.microsoft.com/en-us/library/windows/apps/hh394006(v=vs.105).aspx

• Rest
Librería: kulman.sk 
https://blog.kulman.sk/rest-service-base-class-for-windows-phone-8-1-xaml-apps/
Installation
PM> Install-Package Kulman.WPA81.BaseRestService
La limitación de la librería:
Solo permite este formato de llamadas,
Task<T> Get<T>(string url);
Task<T> Put<T>(string url, object request);
Task<T> Post<T>(string url, object request);
Task<T> Patch<T>(string url, object request);
Task Delete(string url);
Se limita a URL simples, con GET sin parámetros y con POST, PUST y PATCH con un parámetro de entrada.
El único caso que contemplamos es la URL de formato: /bookings/{id}/cancel/
Donde {id}, id tiene que venir como parámetro con el mismo nombre.

• KeyValue 
https://softwarejuancarlos.com/2014/04/25/windows-store-local-data-persistance/

• Permisos (Capabilities)
Location-> GPS
WebCam->Camara
Music, Picture and VideoLibrary -> Para almacenar audio, video e imagen respectivamente



