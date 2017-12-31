package layout.Informacion;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Base64;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

import principal.android.empresa.vr_proyecto.R;

/**
 * Created by Home on 31/08/2017.
 */

public class Informacion extends Fragment {
    ImageView image;
    TextView lugar, problema, descripcion, itinerario, tipo, precio, dia;
//    VrPanoramaView.Options options = new VrPanoramaView.Options();
//    private VrPanoramaView mVrPanoramaView;

    public Informacion() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View obj = inflater.inflate(R.layout.informacion_imagen1, container, false);
        image = (ImageView) obj.findViewById(R.id.imagen_lug);
        lugar = (TextView) obj.findViewById(R.id.txtlugar);
        problema = (TextView) obj.findViewById(R.id.texto_problema);
        descripcion = (TextView) obj.findViewById(R.id.txtdescripcion);
        itinerario = (TextView) obj.findViewById(R.id.txtitinerario);
        tipo = (TextView) obj.findViewById(R.id.txttipo);
        precio = (TextView) obj.findViewById(R.id.txtprecio);
        dia = (TextView) obj.findViewById(R.id.txtdias);
        cargar();


        return obj;
    }

//    @Override
//    public void onPause() {
//        mVrPanoramaView.pauseRendering();
//        super.onPause();
//    }
//
//    @Override
//    public void onResume() {
//        super.onResume();
//        mVrPanoramaView.resumeRendering();
//    }
//
//    @Override
//    public void onDestroy() {
//        mVrPanoramaView.shutdown();
//        super.onDestroy();
//    }

    public void cargar() {
        String imagen = getArguments().getString("imagen_lugar");
        String lugares = getArguments().getString("nombre_lugar");
        String descripciones = getArguments().getString("descripcion_lugar");
        String itinerarios = getArguments().getString("itinerario_lugar");
        String tipos = getArguments().getString("tipo");
        String precios = getArguments().getString("precio");
        String moneda = getArguments().getString("tipo_moneda");
        String dias = getArguments().getString("dias");
        byte[] imageAsByte = Base64.decode(imagen, Base64.DEFAULT);
        //image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsByte, 0, imageAsByte.length));
        image.setImageBitmap(BitmapFactory.decodeByteArray(imageAsByte, 0, imageAsByte.length));
        problema.setText(lugares);
        lugar.setText("LUGAR : " + lugares);
        descripcion.setText("DESC : " + descripciones);
        itinerario.setText("ITINERARIO : " + itinerarios);
        tipo.setText("TIPO : " + tipos);
        precio.setText("PRECIO : " + precios + " " + moneda);
        dia.setText("DIAS : " + dias);
//       InputStream inputStream = null;
//
//       AssetManager assetManager = getActivity().getAssets();
//       String nombre  = getArguments().getString("nomb_imagen");
//       try {
//           inputStream = assetManager.open(nombre);
//           options.inputType = VrPanoramaView.Options.TYPE_MONO;
//           mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
//           inputStream.close();
//       } catch (IOException e) {
//           Log.e("Tuts+", "Exception in loadPhotoSphere: " + e.getMessage() );
//       }
    }


}
