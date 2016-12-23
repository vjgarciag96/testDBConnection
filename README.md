# testDBConnection
Como ponerlo en funcionamiento:

1. Descargar mariadb-java-client-1.5.5(disponible en https://downloads.mariadb.com/Connectors/java/connector-java-1.5.5/) y copiarlo a la carpeta libs del proyecto

2. En el apartado dependencies del build.gradle de Module:app debe aparecer:
compile fileTree(dir: 'libs', include: ['*.jar'])

3. Copiar el codigo de MainActivity y clienteBD modificando el valor de las variables para conectarte al servidor de tu propia bd
