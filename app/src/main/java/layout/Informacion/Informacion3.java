package layout.Informacion;

import android.content.res.AssetManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import java.io.IOException;
import java.io.InputStream;

import principal.android.empresa.vr_proyecto.R;

/**
 * Created by Home on 31/08/2017.
 */

public class Informacion3 extends Fragment {
    VrPanoramaView.Options options = new VrPanoramaView.Options();
    private VrPanoramaView mVrPanoramaView;

    public Informacion3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View obj=inflater.inflate(R.layout.informacion_imagen3, container, false);
        mVrPanoramaView = (VrPanoramaView) obj.findViewById(R.id.imagen3_vr);
        cargar();


        return obj;
    }
    @Override
    public void onPause() {
        mVrPanoramaView.pauseRendering();
        super.onPause();
    }

    @Override
    public void onResume() {
        super.onResume();
        mVrPanoramaView.resumeRendering();
    }

    @Override
    public void onDestroy() {
        mVrPanoramaView.shutdown();
        super.onDestroy();
    }
   public void cargar(){
       InputStream inputStream = null;

       AssetManager assetManager = getActivity().getAssets();
       String nombre  = getArguments().getString("nomb_imagen");
       try {
           inputStream = assetManager.open(nombre);
           options.inputType = VrPanoramaView.Options.TYPE_MONO;
           mVrPanoramaView.loadImageFromBitmap(BitmapFactory.decodeStream(inputStream), options);
           inputStream.close();
       } catch (IOException e) {
           Log.e("Tuts+", "Exception in loadPhotoSphere: " + e.getMessage() );
       }
   }


}
