/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaAccesoDatos;

import CapaLogica.Usuario;
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
public class ArchivoUsuarios {
//    private final String RUTA_ARCHIVO = System.getProperty("user.dir") .replace("\\dist","")+ "\\src\\Archivo\\Usuario.txt";
    private final String RUTA_ARCHIVO ="Usuario.txt";
    private ObjectOutputStream oEscritor;
    private ObjectInputStream oLector;
    private FileInputStream archivoEntrada;
    private FileOutputStream archivoSalida;
    private ArrayList<Usuario> arrayUsuarioTemp;

    //Instancia privada de la misma clase
    //implementa el patrón Singleton
    private static ArchivoUsuarios instance = null;

    //Constructor privado, se implementa el patrón Singleton
    private ArchivoUsuarios() {

    }
    
    
     public static ArchivoUsuarios getInstance() {
        if (instance == null) {
            instance = new ArchivoUsuarios();
        }
        return instance;
    }
     
     
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
      public ArrayList<Usuario> listaUsuarios() throws Exception {
        ArrayList listaUsuarios = new ArrayList();
       
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                Usuario user
                        = (Usuario) oLector.readObject();
                listaUsuarios.add(user);
            }
        } //No se indica el catch ya que no se hará nada, solamente se lanzará por medio del throws  
        catch (Exception ex) {

        } finally {
            //Ocurra o no ocurra la excepción se cierra el archivo
            cerrarArchivoInput();
            return listaUsuarios;
        }

    }
      //Validar si es null no se encontró usuario en el ingreso
       public Usuario consultarIngreso(String nombre, String clave) throws Exception {
        Usuario user, usuarioBuscado = null;//Esta declaración se puede hacer separada
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                user = (Usuario) oLector.readObject();
                if (user.getNombre().equalsIgnoreCase(nombre)&&user.getClave().equals(clave)) {
                    usuarioBuscado = user;
                }
            }
        } catch (Exception e) {

        } finally { //Suceda o no suceda la excepción se deben cerrar los archivos
            cerrarArchivoInput();
            return usuarioBuscado;
        }
    }
       
        public boolean existente(String nombre) throws Exception {
       Usuario user= null;
       boolean existe=false;
        try {
            abrirArchivoInput();
            //Si no hay más datos que leer el método available retorna cero
            while (true) {
                user = (Usuario) oLector.readObject();
                if (user.getNombre().equalsIgnoreCase(nombre)) {
                   existe=true;
                }
            }
        } catch (Exception e) {

        } finally { //Suceda o no suceda la excepción se deben cerrar los archivos
            cerrarArchivoInput();
            return existe;
        }
    }
       
       
       
       public void agregarUsuario(Usuario user) throws Exception {
        try {
            this.abrirArchivoOutput();
            if (oEscritor != null) {
                //Ejecutar la escritura del objeto pDepartamento en el archivo
                oEscritor.writeObject(user);
                oEscritor.flush();  //Envía el contenido del buffer al archivo
                oEscritor.reset();//Se requiere para cuando se reciben subclases de Departamento
            }

        } catch (Exception e) {
            throw e;
        } finally {
            //Ocurra o no la excepción se debe cerrar el archivo
            this.cerrarArchivoOutput(); //Cierra el archivo
        }

    }
       
       
        public void modificarDepartamento(Usuario usuario) throws Exception {
        
        arrayUsuarioTemp = new ArrayList();
        try {
            abrirArchivoInput();
            //Pasar todos los objetos del archivo al ArrayList temporal modificando el 
            //objeto que se recibe como parámetro de acuerdo al código
            Usuario user = null;
            //Si no hay más datos que leer el método available retorna cero
            while (true) {//Si va a leer y no hay objeto Departamento se va por el catch
                user = (Usuario) oLector.readObject();
               
                if (user.getNombre().equalsIgnoreCase(usuario.getNombre())) {
                    user = usuario;
                }
                arrayUsuarioTemp.add(user);
            }
        } catch (Exception ex) {

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
        if (!arrayUsuarioTemp.isEmpty()) {
            abrirArchivoOutput();
            //Pasa todos los departamentos del ArrayList al archivo
            for (Usuario user : arrayUsuarioTemp) {
                oEscritor.writeObject(user);
            }
        }
        cerrarArchivoOutput();
    }

      
}
