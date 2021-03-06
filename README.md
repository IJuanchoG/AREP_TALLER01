# Calculadora de estadistica con Implementación de una Linked List 

Esta libreria está implementada en **JAVA** para la materia de **AREP**

Su principal funcionamiento se centra en una Calculadora de estadistica con las funciones de **promedio** y **desviación media** implementadas, se ha realizado la construcción de una **Linked  List** a partir de la teoría conocida y por la cual se generan los calculos necesarios.

Para conocer mayor información de la implementación del sistema puede ver el documento [INFORME](AREP_TALLER01.pdf)

## Getting Started

Principalmente se recomienda clonar el repositorio a su computadora, como opción puede realizarlo por medio del siguiente comando:

``` git clone https://github.com/IJuanchoG/AREP_TALLER01.git```

La construcción del proyecto se ha realizado por medio de **MAVEN**, es por este motivo que puede ser necesario tener la herramienta en su dispositivo. 

Para compilar el proyecto, ejecute el siguiente comando:

```mvn compile```

posteriormente puede hacer el empaquetado:

``` mvn package```

para verificar el correcto funcionamiento de las librerias es recomendable ejecutar las pruebas presentes en estos,
se pueden ejecutar desde el IDE de preferencia o desde comandos MVN tales como 

```mvn surefire:test```

Con el fin de correr el programa ejecute la siguiente instrucción:
``` java -cp target\MyStatCal-1.0-SNAPSHOT.jar edu.eci.arep.msc.mystatcal.App ```
 Encontrará los siguientes resultados:
 
Información de la lista encadenada creada de ejemplo.

 <img width="796" alt="LinkedLinkExample" src="https://user-images.githubusercontent.com/49318314/90288675-fdc3e080-de3f-11ea-856a-19bfed8bea59.png">
 
 Igualmente, los valores calculados por parte de la sección dinámica.
 
 <img width="165" alt="Desviacion" src="https://user-images.githubusercontent.com/49318314/90288600-d240f600-de3f-11ea-9111-1e5e5edcc77e.png">

### Prerequisitos.

Es necesario/recomendable que posea las siguientes herramientas:

- git instalado en su computador.
- Maven configurado en sus **Variables de Entorno**.
- Interprete de lenguaje de programacion **JAVA** (Eclipse, netbeans, Intellij, etc.)

si necesita instalar algunos de los servicios mencionados puede encontrarlos aquí:

- **Git** puede descargarlo [aqui.](https://git-scm.com/downloads)

- **Maven** puede descargarlo [aqui.](https://maven.apache.org/download.cgi)

- **IntelliJ** puede descargarlo [aqui.](https://www.jetbrains.com/es-es/idea/download/)



Ejemplo de ejecución:


<img width="461" alt="mvnpackage" src="https://user-images.githubusercontent.com/49318314/90283933-b6852200-de36-11ea-9c88-854fa02b6405.png">



## Running the tests
Las pruebas se corren por medio del comando:
```
mvn surefire:test
```

como resultado se ve lo siguiente:

<img width="634" alt="pruebas" src="https://user-images.githubusercontent.com/49318314/90284000-d61c4a80-de36-11ea-83cd-441c4ecdb6c5.png">


Estas pruebas son automáticas, si desea realizar más pruebas puede hacerlo manualmente o agregando más cualquiera de los archivos encontrados en la ruta **src\test\java\edu\eci\arep\msc\mystatcal**

Las pruebas fueron realizadas a partir de casos de usos que seguramente se verían envueltos en el funcionamiento del programa. entre ellos tenemos pruebas como:

```
@Test
    public void noDeberiaPromediar(){
        String mean = StatCalculator.Mean(linkedList);
        Assert.assertNotEquals(4,Double.valueOf(mean),0.2);
    }
```
 En la que se evalúa la precisión del sistema para realizar el calculo de una media de manera efectiva.
Las pruebas buscan de manera efectiva probar el funcionamiento del programa y como se desempeñaría en otros casos de uso

```
@Test
    public void deberiaAgregar2(){
        try {
            MyOwnLinkedList linkedList = new MyOwnLinkedList("1","double");
            boolean aDouble = linkedList.addNode("4", "double");
            Assert.assertTrue("Se agrego correctamente", linkedList.getSize() == 2);
        } catch (NodesException e) {
            fail("Ha lanzado error en Nodos");
        } catch (MyOwnLinkedListException e) {
            fail("Ha lanzado error en MyOwnLinkedList");
        }

    }
```
Como otro ejemplo tememos este código en el que se comprueba que la adición de nodos se haga de correcta manera y ningún tipo de excepción se haga presente en el transcurso de su llamado.

## Built With

* [IntelliJ](https://www.jetbrains.com/es-es/idea/) - The develop enviroment
* [Maven](https://maven.apache.org/) - Dependency Management
* [JUnit](https://junit.org/junit5/) - Used to generate Unitary Test


## Authors

* **Juan Carlos García** - *Initial work* - [IJuanchoG](https://github.com/IJuanchoG)


## License

Este proyecto es de libre uso y distribución, para más detalles vea el archivo [LICENSE.md](LICENSE.md).
