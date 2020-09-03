# DummySetImplementation

Un conjunto se define como una estructura de datos que no permite duplicados y en la que podemos guardar cualquier tipo de dato.

Se puede implementar de muchas maneras pero probablemente la manera más optima para hacerla es usar un hashMap en él que como clave guardaderamo el objeto a guardar y asignaremos como valor de dicha clave un objeto tonto, el mismo objeto tonto, por motivos de eficiencia, porque igual creo que podriamos guardar como valor la misma clave.

Se usó JDK8 y junit 3.8.1. Ya, están deprecados, pero para la prueba piden jdk8 y esa versión de junit es suficiente para poder probar la implementación. Luego, a donde fueres, haz lo que vieres.

La super implementación de mi conjunto, MySetData, sospechosamente se parece a la de HashSet. Es la más sencilla. No permite que los elementos estén ordenados. Si quisieramos que esta implementacion ordenara los elementos tal y como se insertan, tendríamos que usar un TreeMap como estructura interna.

Es importante que nuestra super clase para conjuntos extienda AbstractSet<E> e implemente las interfaces Set<E>, Cloneable y Serializable.

public class MySetData<E> extends AbstractSet<E> implements Set<E>,Cloneable, java.io.Serializable

Para probar, clonar el proyecto, luego correr mvn clean install con el jdk8.


