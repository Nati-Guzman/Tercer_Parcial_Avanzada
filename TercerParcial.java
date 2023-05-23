
/******************************************************************************

Natalia Catalina Guzmán Fuentes 
Programación Avanzada
Entrega Parcial Tercer Corte 
Presentado a: John Corredor Franco
Fecha: 22 de mayo de 2023

*******************************************************************************/

/*RESPUESTAS TEÓRICAS 

Conceptos 

--------------------------------------------------------------------------------

1. La herencia permite que una clase adquiera los atributos y métodos de otra 
   clase
   RESPUESTA: 
   a. Verdadero
   
--------------------------------------------------------------------------------

2. El polimorfismo permite que un objeto se comporte de diferentes formas según
   el contexto
   RESPUESTA:
   a. Verdadero
   
--------------------------------------------------------------------------------

3. En Java, una clase puede heredar múltiples clases al mismo tiempo
   RESPUESTA:
   b. Falso
   
--------------------------------------------------------------------------------

4. El método "super ( )" se utiliza en una clase hija para llamar al constructor
   de la clase padre 
   RESPUESTA:
   a. Verdadero
   
--------------------------------------------------------------------------------

5. En el polimorfismo, se puede utilizar una referencia de la clase padre para 
   referirse a un objeto de la clase hija 
   RESPUESTA:
   a. Verdadero
   
--------------------------------------------------------------------------------

6. ¿Cuál de las siguientes opciones describe correctamente la herencia en POO?
   RESPUESTA:
   A) La capacidad de una clase de heredar propiedades y métodos de otra clase

--------------------------------------------------------------------------------

7. ¿Cuál de las siguientes opciones describe mejor el polimorfismo en Java?
   RESPUESTA:
   D) La capacidad de un objeto de ser tratado como uno de varios tipos posibles
   
--------------------------------------------------------------------------------

8. ¿Cuál de las siguientes afirmaciones sobre las clases abstractas es correcta?
   RESPUESTA:
   D) Se utilizan como plantillas para crear subclases concretas
   
--------------------------------------------------------------------------------

9. ¿Cuál de las siguientes opciones describe mejor el concepto de sobreescritura
   de métodos en Java?
   RESPUESTA:
   A) La capacidad de una subclase de proporcionar una implementación diferente 
      para un método heredado de la clase padre. 
   
--------------------------------------------------------------------------------

10. ¿Cuál afirmación sobre las interfaces en Java es correcta?
    RESPUESTA:
    D) Se utilizan para definir un contrato que una clase debe cumplir
    
--------------------------------------------------------------------------------
*/


/*******************************************************************************

Sistema de manejo de un Conjunto de Datos
Considere una aplicación de análisis de datos que procesa diferentes tipos
de conjuntos de datos.

*******************************************************************************/


/*----------------------------------------------------------------------------------------------------------------------------*/

import java.util.ArrayList;

//clase 'ConjuntoDeDatos' 
abstract class ConjuntoDeDatos{
    
    //Atributos de clase 
    private String nombre;
    private int tamanio;
    
    //Método constructor que inicializa los atributos
    public ConjuntoDeDatos(String nombre, int tamanio){
        this.nombre=nombre;
        this.tamanio=tamanio;
    }
    
    //método 'describir' abstracto 
    public abstract String describir();
    
    //métodos getters y setters para acceder y modificar los valores de los atributos
    public String getNombre(){
        return nombre;
    }
    
    public int getTamanio(){
        return tamanio;
    }
    
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    
    public void setTamanio(int tamanio){
        this.tamanio=tamanio;
    }
    
}//fin clase 'ConjuntoDeDatos'

/*----------------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------------*/

//clase 'ConjuntoDeDatosTabular' hija de la clase 'ConjuntoDeDatos'
class ConjuntoDeDatosTabular extends ConjuntoDeDatos{
    
    //Atributos de clase 
    private int numeroDeColumnas;
    private int numeroDeFilas;
    
    //Método constructor que inicializa todos los atributos de esta clase 
    public ConjuntoDeDatosTabular(String nombre, int tamanio, int numeroDeColumnas, 
           int numeroDeFilas){
        /*Se utiliza la palabra clave 'super' para invocar al constructor de la clase
        padre y así inicializar los miembros heredados de ella*/
        super(nombre, tamanio);
        this.numeroDeColumnas=numeroDeColumnas;
        this.numeroDeFilas=numeroDeFilas;
    }
    
    //sobreescribir el método 'describir' de la clase padre para que retorne un String
    @Override
    public String describir(){
        return "Nombre: <"+getNombre()+"> \n"+"Tamaño: <"+getTamanio()+"> \nTipo: Tabular \nFilas: <"
        +numeroDeFilas+"> \nColumnas: <"+numeroDeColumnas+">"; 
    }
          
          
}//fin clase 'ConjuntoDeDatosTabular'

/*----------------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------------*/

//clase 'conjuntoDeDatosImagen' hija de la clase 'ConjuntoDeDatos'
class ConjuntoDeDatosImagen extends ConjuntoDeDatos{
    
    //Atributos de clase 
    private int ancho;
    private int alto;
    
    //Método constructor que inicializa todos los atributos de esta clase 
    public ConjuntoDeDatosImagen(String nombre, int tamanio, int ancho, int alto){
        /*Se utiliza la palabra clave 'super' para invocar al constructor de la clase
        padre y así inicializar los miembros heredados de ella*/
        super(nombre, tamanio);
        this.ancho=alto;
        this.alto=alto;
    }
    
    //sobreescribir el método 'describir' de la clase padre para que retorne un String
    @Override
    public String describir(){
        return "Nombre: <"+getNombre()+"> \n"+"Tamaño: <"+getTamanio()+"> \nTipo: Imagen \nAncho: <"
        +ancho+"> \nAlto: <"+alto+">"; 
    }
}//fin clase 'ConjuntoDeDatosImagen'

/*----------------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------------*/

//clase 'AnalizadorDeDatos'
class AnalizadorDeDatos{
    
    //crear un ArrayList que almacena objetos de tipo 'ConjuntoDeDatos'
    private ArrayList <ConjuntoDeDatos> conjuntosDeDatos;
    
    //método constructor para crear una instancia de la clase
    public AnalizadorDeDatos(){
        
        //Se incializa la variable 'conjuntoDeDatos' como una nueva instancia de ArrayList
        conjuntosDeDatos = new ArrayList<>();
    }
    
    //método que recibe que recibe un objeto 'ConjuntoDeDatos' como parámetro
    public void anadirConjuntoDeDatos(ConjuntoDeDatos conjuntoDeDatos){
        
        //Agregar el objeto recibido a la lista 'cojuntosDeDatos'
        conjuntosDeDatos.add(conjuntoDeDatos);
    }
    
    //método que recibe como parámetro un nombre 
    public void eliminarConjuntoDeDatos(String nombre){
        
        //busca y elimina el objeto de la lista 'conjuntosDeDatos' que tenga el nombre especificado
        conjuntosDeDatos.removeIf(conjuntoDeDatos -> conjuntoDeDatos.getNombre().equals(nombre));
    }
    
    //método que devuelve un ArrayList de cadenas(String)
    public ArrayList<String> describirConjuntosDeDatos(){
        //almacenar las descripciones en un ArrayList para retornarlas al final
        ArrayList<String> descripcion = new ArrayList<>();
        //Recorrer la lista 'conjuntosDeDatos' y llamar al metodo describir de cada objeto 'ConjuntoDeDatos'
        for(ConjuntoDeDatos conjuntoDeDatos : conjuntosDeDatos){
            descripcion.add(conjuntoDeDatos.describir());
        }
        return descripcion;
    }
    
}//fin clase 'AnalizadorDeDatos'

/*----------------------------------------------------------------------------------------------------------------------------*/

/*----------------------------------------------------------------------------------------------------------------------------*/

//main para validar el funcionamiento de las clases anteriores
public class TercerParcial
{
	public static void main(String[] args) {
	    //instanciar un objeto de tipo 'AnalizadorDeDatos' llamado 'analizador'
	    AnalizadorDeDatos analizador = new AnalizadorDeDatos();
	    
	    
	    //se crea una instancia de 'ConjuntoDeDatosTabular' 
	    ConjuntoDeDatosTabular conjuntoDeDatosTabular = new ConjuntoDeDatosTabular("Notas finales del curso", 500, 100, 50);
	    //se llama al método 'añadirConjuntoDeDatos' en el objeto 'analizador' para agregar los conjuntos de datos creados
	    analizador.anadirConjuntoDeDatos(conjuntoDeDatosTabular);
	    
	    
	    //Se crea una instancia de 'ConjuntoDeDatosIamgen' 
	    ConjuntoDeDatosImagen conjuntoDeDatosImagen = new ConjuntoDeDatosImagen("Imagen galaxia", 1000, 1800, 80);
	    //se llama al método 'añadirConjuntoDeDatos' en el objeto 'analizador' para agregar los conjuntos de datos creados
	    analizador.anadirConjuntoDeDatos(conjuntoDeDatosImagen);
	    
	    //llamar al método 'describirConjuntoDeDatos' en 'analizador' 
	    ArrayList<String> descripcion = analizador.describirConjuntosDeDatos();
	    
	    //crear un ciclo para recorrer las descripciones de los conjuntos de datos e imprimirlas en consola
	    for(String descripciones : descripcion){
	        System.out.println(descripciones);
	        System.out.println("----------------------------------");
	    }
	}
}//fin clase principal 

/*----------------------------------------------------------------------------------------------------------------------------*/

//fin del programa :)


