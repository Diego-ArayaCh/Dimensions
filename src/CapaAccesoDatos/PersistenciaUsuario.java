/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CapaAccesoDatos;

import Animacion.Fade;
import CapaLogica.Descarga;
import CapaLogica.Perfil;
import CapaLogica.Usuario;
import CapaVista.FrmNexo;
import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Diego
 */
public class PersistenciaUsuario {

    public static Usuario usuarioSeleccionado;
    public static Perfil perfilSeleccionado;

    public static void agregarUsuario(Usuario user) {
        usuarioSeleccionado = user;
    }
    public static ArrayList<Descarga> listaDescarga = new ArrayList();

    public static void perfilSeleccionado(String nombre) {
        for (Perfil perfil : usuarioSeleccionado.getArrayPerfil()) {
            if (perfil.getPerfil().equals(nombre)) {
                perfilSeleccionado = perfil;

            }
        }

    }
    public static JFrame frame;

    public static Perfil getPerfilSeleccionado() {
        return perfilSeleccionado;
    }

    public static Usuario getUsuarioSeleccionado() {
        return usuarioSeleccionado;
    }

    public static ArrayList<Perfil> getArrayPerfiles() {
        return usuarioSeleccionado.getArrayPerfil();
    }

    public static int getCantidadPerfiles() {
        return usuarioSeleccionado.getArrayPerfil().size();
    }

    public static void app(JFrame f) {
        f.setVisible(false);
        frame = f;
        FrmNexo nexo = new FrmNexo();

        nexo.setVisible(true);

    }

    public static void actualizarPerfil() {

        usuarioSeleccionado.actualizarPerfil(perfilSeleccionado, listaDescarga);
       
    }

    public static void cerrarSesion() throws Exception {

      
        ArchivoUsuarios.getInstance().modificarDepartamento(usuarioSeleccionado);

    }

    public static void setPerfilSeleccionado(Perfil perfilSeleccionado) {
        PersistenciaUsuario.perfilSeleccionado = perfilSeleccionado;
    }

    public static void setListaDescarga(ArrayList<Descarga> listaDescarga) {

        if (!listaDescarga.isEmpty()) {
            PersistenciaUsuario.listaDescarga = listaDescarga;
         
        }
    }

    public static void ActualizarListaDescargas(ArrayList<Descarga> lista) {

        if (!lista.isEmpty()) {

            perfilSeleccionado.setArrayDescargas(lista);

        }

    }

    public static void annadirListaDescargas() {
        if (!listaDescarga.isEmpty()) {
            perfilSeleccionado.setArrayDescargas(listaDescarga);
        

        }
    }

}
