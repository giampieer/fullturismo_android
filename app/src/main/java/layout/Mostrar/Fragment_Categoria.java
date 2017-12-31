package layout.Mostrar;


import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import layout.Adapter.Adapter_Categoria;
import principal.android.empresa.vr_proyecto.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Categoria extends Fragment {
String[] listado=new  String[]{"NACIONAL","INTERNACIONAL"};
    RecyclerView recyclerView;
    RecyclerView.Adapter  adapter;
    Toolbar toolbar;
    String conexion="";

    public Fragment_Categoria() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View obj=inflater.inflate(R.layout.layout_categoria, container, false);

        recyclerView=(RecyclerView)obj.findViewById(R.id.recycler_view_proyecto_fragment);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
        toolbar = (Toolbar) obj.findViewById(R.id.toolbar_proyecto_mostrar);

        ((AppCompatActivity)getActivity()).setSupportActionBar(toolbar);
        ((AppCompatActivity)getActivity()).getSupportActionBar().setTitle("CATEGORIA");

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });

        CargarDatosProyecto();


        return obj;
    }

    public void CargarDatosProyecto(){
        new Async_Listar_Proyectos().execute();
    }

    class Async_Listar_Proyectos extends AsyncTask<Void, Void, String> {

        private ProgressDialog progressDialog;
        protected void onPreExecute() {
            progressDialog = ProgressDialog.show(getActivity(), "", "Cargando", true);
        }
        @Override
        protected String doInBackground(Void... obj) {
            String mensaje="";
            conexion = mensaje;


                adapter=new Adapter_Categoria(listado,getActivity());
            return mensaje;
        }
        protected void onPostExecute(String result) {

                recyclerView.setAdapter(adapter);
            progressDialog.dismiss();
        }
    }


}
