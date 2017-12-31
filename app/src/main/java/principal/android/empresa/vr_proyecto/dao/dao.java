package principal.android.empresa.vr_proyecto.dao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import principal.android.empresa.vr_proyecto.Bean.LugaresBean;
import principal.android.empresa.vr_proyecto.Conexion.conexion_webservice;
//import principal.android.empresa.vr_proyecto.bean.camionbean;
//import principal.android.empresa.vr_proyecto.bean.horariobean;

/**
 * Created by Home on 08/07/2017.
 */

public class dao {
    public ArrayList<LugaresBean> ListarLugares(String tipo){
        ArrayList<LugaresBean> lista=new ArrayList<LugaresBean>();

        String ruta = "http://192.168.1.10/fullturismo/Controlador/LugarJson.php?op=1&tipo="+tipo;

        try {
            conexion_webservice conexion=new conexion_webservice();
            JSONObject obj = conexion.InvocarHttpClient(ruta);
            JSONArray arreglo=obj.getJSONArray("LUGARES");
            for(int i=0;i<arreglo.length();i++){
                JSONObject objeto=arreglo.getJSONObject(i);
                LugaresBean relacion=new LugaresBean();
                relacion.setIdlugar(objeto.getString("idlugar") );
                relacion.setNombre_lugar(objeto.getString("nombre_lugar")); ;
                relacion.setDescripcion_lugar(objeto.getString("descripcion_lugar"));
                relacion.setImagen_lugar(objeto.getString("imagen_lugar"));
                relacion.setItinerario_lugar(objeto.getString("itinerario_lugar"));
                relacion.setNombre(objeto.getString("nombre"));
                relacion.setPrecio(objeto.getString("precio"));
                relacion.setTipo_moneda(objeto.getString("tipo_moneda"));
                relacion.setDias(objeto.getString("dias"));
                lista.add(relacion);

            }

        }catch (Exception e){
        }
        return lista;
    }

    //public ArrayList<horariobean> listarhorario(){
        //ArrayList<horariobean> lista=new ArrayList<horariobean>();

        //String ruta = "http://mariscal.j.facilcloud.com/mariscal1/ProyectoServlet?op=8";
        //String ruta = "http://proye.jl.serv.net.mx/ev/EstuServlet?op=19";

        //try {
            //conexion_webservice conexion=new conexion_webservice();
            //JSONObject obj = conexion.InvocarHttpClient(ruta);
            //JSONArray arreglo=obj.getJSONArray("horario");
            //for(int i=0;i<arreglo.length();i++){
                //JSONObject objeto=arreglo.getJSONObject(i);
                //horariobean relacion=new horariobean();
                //relacion.setCodhorario(objeto.getInt("codhorario") );
                //relacion.setFecha(objeto.getString("fecha"));
                //relacion.setLugar(objeto.getString("lugar"));

                //lista.add(relacion);

            //}

        //}catch (Exception e){
        //}
        //return lista;
    //}
}
