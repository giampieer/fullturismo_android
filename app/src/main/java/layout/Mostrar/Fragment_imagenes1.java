package layout.Mostrar;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

import layout.Adapter.Adapter_imagenes1;
import principal.android.empresa.vr_proyecto.Bean.LugaresBean;
import principal.android.empresa.vr_proyecto.R;
import principal.android.empresa.vr_proyecto.dao.dao;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_imagenes1 extends Fragment {
    //String[] listado = new String[]{"andes.jpg", "IMAGEN 2", "MAGEN 3", "IMAGEN 4"};
    ArrayList<LugaresBean> listado = new ArrayList<LugaresBean>();
    RecyclerView recyclerView;
    RecyclerView.Adapter adapter;
    FloatingActionButton fab;
    ImageView imagen;
    Toolbar toolbar;
    dao objdao = null;
    String conexion = "";

    public Fragment_imagenes1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View obj = inflater.inflate(R.layout.layout, container, false);

        recyclerView = (RecyclerView) obj.findViewById(R.id.recycler_view_proyecto_fragment);
        imagen = (ImageView) obj.findViewById(R.id.imagen_proyecto_mostrar);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
//        toolbar = (Toolbar) obj.findViewById(R.id.toolbar_proyecto_mostrar);
//
//        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle("PAQUETES DE VIAJES");
//        fab = (FloatingActionButton) obj.findViewById(R.id.fab_proyecto);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });
//        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//            }
//        });

        CargarDatosProyecto();


        return obj;
    }

    public void CargarDatosProyecto() {
        new Async_Listar_Proyectos().execute();
    }

    class Async_Listar_Proyectos extends AsyncTask<Void, Void, String> {

        private ProgressDialog progressDialog;

        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(), "", "Cargando", true);
        }

        @Override
        protected String doInBackground(Void... obj) {
            String mensaje = "";
            conexion = mensaje;
            objdao = new dao();
            //1 - Nacional
            //2 - Internacional
            listado = objdao.ListarLugares("1");
            adapter = new Adapter_imagenes1(listado, getActivity());
            return mensaje;
        }

        protected void onPostExecute(String result) {

            recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }


}
