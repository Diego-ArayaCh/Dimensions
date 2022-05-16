/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaAccesoDatos;

import CapaLogica.AudioVisual;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Diego
 */
public class ArchivoContenidoAudioVisual {
//     private final String RUTA_ARCHIVO = System.getProperty("user.dir").replace("\\dist", "") + "\\src\\Archivo\\AudioVisual.txt";
   private final String RUTA_ARCHIVO="AudioVisual.txt";
    private ObjectOutputStream oEscritor;
    private ObjectInputStream oLector;
    private FileInputStream archivoEntrada;
    private FileOutputStream archivoSalida;
    private ArrayList<AudioVisual> arrayAudioVisualesTemp;

    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static ArchivoContenidoAudioVisual instance = null;

    //Constructor privado, se implementa el patrón Singleton
    private ArchivoContenidoAudioVisual() {

    }

    //Método público que retorna una única instancia de la 
    //clase, únicamnete se construye la primera vez.
    public static ArchivoContenidoAudioVisual getInstance() {
        if (instance == null) {
            instance = new ArchivoContenidoAudioVisual();
        }
        return instance;
    }

    /**
     * Abre y retorna el archivo de datos, para escritura (de tipo output) al
     * final del archivo Tipo de Archivo: Secuencial. Lanza la Exception al
     * nivel donde fue llamado
     *
     * @return void
     */
    public void abrirArchivoOutput() throws Exception {
        //Abrir el archivo
        try {
            File oArchivo = new File(RUTA_ARCHIVO);
            if (!oArchivo.exists()) {
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo
                //true indica que se agregarán registros al final            
                archivoSalida = new FileOutputStream(RUTA_ARCHIVO, true);
                oEscritor = new ObjectOutputStream(archivoSalida);
            } else {
                //Abrir el archivo de Acceso Secuencial para  escritura
                //La primera vez incluye la cabecera del archivo
                archivoSalida = new FileOutputStream(RUTA_ARCHIVO, true);
                oEscritor = new MiObjectOutputStream(archivoSalida);
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void abrirArchivoInput() throws Exception {
        //Abrir el archivo
        try {
            archivoEntrada = new FileInputStream(RUTA_ARCHIVO);
            oLector = new ObjectInputStream(archivoEntrada);
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Permite cerrar el archivo de datos que se abrió de salida
     */
    public void cerrarArchivoOutput() throws Exception {
        try {
            if (oEscritor != null) {
                oEscritor.close();
                oEscritor = null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    private void cerrarArchivoInput() throws Exception {
        try {
            if (oLector != null) {
                oLector.close();
                oLector = null;
            }
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * Lista de todos los Departamentos que se encuentran en el archivo
     *
     * @return ArrayList
     */
    public ArrayList<AudioVisual> listaAudiovisuales() throws Exception {//Ver el libro que Paul mandó pg 5
        ArrayList listaAudioVisuales = new ArrayList();
        //Ya que habrá bloque finally se debe encerrar el bloque try
        //el throws del encabezado lanza la excepción del finally      
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                AudioVisual audioVisual
                        = (AudioVisual) oLector.readObject();
                listaAudioVisuales.add(audioVisual);
            }
        } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws   //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws   //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws   //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
        catch (Exception ex) {

        } finally {
            //Ocurra o no ocurra la excepción se cierra el archivo
            cerrarArchivoInput();
            return listaAudioVisuales;
        }

    }

    //Busca y retorna el objeto AudioVisual de acuerdo al código que recibe como 
    //parámetro, en caso de que no lo encuentre retorna null
    public AudioVisual consultarAudioVisual(String codigoAudioVisual) throws Exception {
        AudioVisual audioVisual, audioVisualBuscado = null;//Esta declaración se puede hacer separada
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                audioVisual = (AudioVisual) oLector.readObject();
                if (audioVisual.getCodigo().equalsIgnoreCase(codigoAudioVisual)) {
                    audioVisualBuscado = audioVisual;
                }
            }
        } catch (Exception e) {

        } finally { //Suceda o no suceda la excepción se deben cerrar los archivos
            cerrarArchivoInput();
            return audioVisualBuscado;
        }
    }

    /**
     * Agregar un nuevo AudioVisual al final del archivo
     *
     * @param AudioVisual Objeto AudioVisual a agregar
     * @return void
     */
    public void agregarAudioVisual(AudioVisual AudioVisual) throws Exception {
        try {
            this.abrirArchivoOutput();
            if (oEscritor != null) {
                //Ejecutar la escritura del objeto pDepartamento en el archivo
                oEscritor.writeObject(AudioVisual);
                oEscritor.flush();  //Envía el contenido del buffer al archivo
                oEscritor.reset();//Se requiere para cuando se reciben subclases de AudioVisual
            }

        } catch (Exception e) {
            throw e;
        } finally {
            //Ocurra o no la excepción se debe cerrar el archivo
            this.cerrarArchivoOutput(); //Cierra el archivo
        }

    }

    /**
     * Agregar un nuevo AudioVisual al archivo
     *
     * @param AudioVisual Objeto AudioVisual a agregar
     * @return void
     */
    public void modificarAudioVisual(AudioVisual AudioVisual) throws Exception {
        arrayAudioVisualesTemp = new ArrayList<AudioVisual>();
        try {
            abrirArchivoInput();
            //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
            AudioVisual audioVisual = null;
            //Si no hay más datos que leer el método available retorna cero
            while (true) {//Si va a leer y no hay objeto AudioVisual se va por el catch
                audioVisual = (AudioVisual) oLector.readObject();
                if (audioVisual.getCodigo().equalsIgnoreCase(AudioVisual.getCodigo())) {
                 
                    audioVisual = AudioVisual;
                }
                arrayAudioVisualesTemp.add(audioVisual);
            }
        } catch (Exception ex) {

        } finally {
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();
        }

    }

    public void eliminarAudioVisual(String codigoAudioVisual) throws Exception {
        arrayAudioVisualesTemp = new ArrayList<AudioVisual>();
        try {
            abrirArchivoInput();
            AudioVisual audioVisual = null;
            //Pasa al ArrayList temporal todos los departamentos cuyo código es 
            //diferente al del AudioVisual que se recibe como parámetro
            while (true) {
                audioVisual = (AudioVisual) oLector.readObject();
                if (!audioVisual.getCodigo().equalsIgnoreCase(codigoAudioVisual)) {
                    arrayAudioVisualesTemp.add(audioVisual);
                }
            }
        } catch (Exception e) {

        } finally {
            cerrarArchivoInput();
            pasarArrayTemporal_Archivo();
        }
    }

    private void pasarArrayTemporal_Archivo() throws Exception {
        File archivoOriginal = new File(RUTA_ARCHIVO);
        //Si hay departamentos en el ArrayList y el archivo existe
        //borra el archivo original para volverlo a llenar           

        if (archivoOriginal.exists()) {
            archivoOriginal.delete();
        }
        if (!arrayAudioVisualesTemp.isEmpty()) {
            abrirArchivoOutput();
            //Pasa todos los departamentos del ArrayList al archivo
            for (AudioVisual AudioVisual : arrayAudioVisualesTemp) {
                oEscritor.writeObject(AudioVisual);
            }
        }
        cerrarArchivoOutput();
    }
    public boolean existente(String codigo) throws Exception {
       AudioVisual contenido= null;
       boolean existe=false;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                contenido = (AudioVisual) oLector.readObject();
                if (contenido.getCodigo().equalsIgnoreCase(codigo)) {
                   existe=true;
                }
            }
        } catch (Exception e) {

        } finally { //Suceda o no suceda la excepción se deben cerrar los archivos
            cerrarArchivoInput();
            return existe;
        }
    }
}
