package layout.Adapter;

import android.animation.Animator;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;
import com.squareup.picasso.Picasso;

import layout.Informacion.Informacion5;
import principal.android.empresa.vr_proyecto.R;

/**
 * Created by Home on 31/08/2017.
 */

public class Adapter_imagenes5 extends RecyclerView.Adapter<Adapter_imagenes5.ViewHolderproyecto_Menu_Principal> {
    static  int lastPosition=-1;
    String[] listado;
    VrPanoramaView.Options options = new VrPanoramaView.Options();

    public Context context;
    public Adapter_imagenes5(String [] lista, Context context1)
    {listado=lista;
        context=context1;
    }
    @Override
    //RELACIONAMOS CON EL XML
    public Adapter_imagenes5.ViewHolderproyecto_Menu_Principal onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cardview_imagenes5,parent,false);
        Adapter_imagenes5.ViewHolderproyecto_Menu_Principal viewHolder=new Adapter_imagenes5.ViewHolderproyecto_Menu_Principal(view);


        return viewHolder;
    }

    @Override
    //ACTUALIZAR LOS DATOS
    public void onBindViewHolder(Adapter_imagenes5.ViewHolderproyecto_Menu_Principal holder, final int position) {

        holder.texto.setText(listado[position]);
        //libreria picasso
        String[] lista=new String[]{"http://www.bodamas.com/material/viajes/viaje_port_176_1430749556.jpg",
                "http://pic.vpackage.net/viaje_a_Espana/2014-0009_26859.jpg",
                "http://cms.kienthuc.net.vn/zoom/1000/uploaded/quocquan/2014_09_29/kienthuc-joseon-tomb-01_pxxh.jpg",
                "http://abzturistico.com/wp-content/uploads/2013/09/china2.jpg"};
        Picasso.with(context).load(lista[position]).into(holder.imagen);
        //imagen color
        TypedArray colorarray = context.getResources().obtainTypedArray(R.array.array_proyecto_color);
        Drawable drawablecolor = colorarray.getDrawable(position);
        holder.relativo.setBackground(drawablecolor);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                final CharSequence[] items = {"INFORMACION"};
                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(context);
                dialogo1.setTitle("Opcion:");
                dialogo1.setItems(items, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        if(items[item]=="INFORMACION"){
                            Informacion5 fragment = new Informacion5();

                            //enviar datos a solo fragments
                            Bundle parametro = new Bundle();
                            parametro.putString("nomb_imagen",listado[position]);


                            fragment.setArguments(parametro);
                            FragmentManager fragmentManager = ((FragmentActivity)context).getSupportFragmentManager();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.contenedor_fragments, fragment)
                                    .addToBackStack(null)
                                    .commit();
                        }
                    }});
                AlertDialog alert = dialogo1.create();
                alert.show();
            }});


    }



    @Override
    public void onViewAttachedToWindow(Adapter_imagenes5.ViewHolderproyecto_Menu_Principal holder) {
        super.onViewAttachedToWindow(holder);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            animateCircularReveal(holder.itemView);
        }
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void animateCircularReveal(View view) {
        int centerX = 0;
        int centerY = 0;
        int startRadius = 0;
        int endRadius = Math.max(view.getWidth(), view.getHeight());
        Animator animation = null;
        animation = ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, endRadius);
        view.setVisibility(View.VISIBLE);
        animation.start();
    }

    @Override
    //REGRESAR EL TAMÑO DEL ARRAY
    public int getItemCount() {
        return null!=listado?listado.length:0;    }
    //clase cleada para viewholder
    public static class ViewHolderproyecto_Menu_Principal  extends RecyclerView.ViewHolder{
        public TextView texto;
        public CardView cardView;
        public ImageView imagen;
        public RelativeLayout relativo;
        public   VrPanoramaView mVrPanoramaView;
        public ViewHolderproyecto_Menu_Principal(View itemView1){
            super(itemView1);
            //texto para actualizar
            //mVrPanoramaView = (VrPanoramaView) itemView1.findViewById(R.id.imagen1_vr);
            imagen=(ImageView)itemView1.findViewById(R.id.imagen5_vr) ;
            texto=(TextView)itemView1.findViewById(R.id.texto_menu_principal5);
            cardView=(CardView) itemView1.findViewById(R.id.cardview_menu_principal5);
            relativo=(RelativeLayout)itemView1.findViewById(R.id.relative_menu_principal5);

        }

    }



}
