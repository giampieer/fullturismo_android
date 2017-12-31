package principal.android.empresa.vr_proyecto;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import layout.Ajustes;
import layout.Ayuda;
import layout.Developer;
import layout.Mostrar.Fragment_Categoria;
import layout.Mostrar.Fragment_imagenes1;
import layout.Mostrar.Fragment_imagenes2;
import layout.Mostrar.Fragment_imagenes3;
import layout.Mostrar.Fragment_imagenes4;
import layout.Mostrar.Fragment_imagenes5;
import layout.anuncio;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        cargar();
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }
    public void cargar(){
        FragmentManager fragmentManager = getSupportFragmentManager();
        anuncio container6Fragment = new anuncio();
        fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container6Fragment).addToBackStack(null).commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        if (id == R.id.Ayuda) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Ayuda container1Fragment = new Ayuda();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();}
        if (id == R.id.Informacion) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Developer container1Fragment = new Developer();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();}
        if (id == R.id.Ajustes) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Ajustes container1Fragment = new Ajustes();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();}
        if (id == R.id.CERRARSESION) {

            AlertDialog.Builder dialogo1 = new AlertDialog.Builder(MainActivity.this);
            dialogo1.setTitle("Importante");
            dialogo1.setMessage("¿Deseas cerrar sesion ?");
            dialogo1.setCancelable(false);
            dialogo1.setPositiveButton("Cerrar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {
                    cerrar_sesion();                }
            });
            dialogo1.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogo1, int id) {

                }
            });
            dialogo1.show();        }

        return super.onOptionsItemSelected(item);
    }
        public void cerrar_sesion(){
            //limpiar los datos almacenados para inicar sesion
            System.exit(0);

        }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_inicio) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            anuncio container6Fragment = new anuncio();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container6Fragment).addToBackStack(null).commit();
        } if (id == R.id.nav_camera) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_imagenes1 container1Fragment = new Fragment_imagenes1();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container1Fragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_gallery) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_imagenes2 container2Fragment = new Fragment_imagenes2();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container2Fragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_slideshow) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_imagenes2 container3Fragment = new Fragment_imagenes2();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container3Fragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_manage) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_imagenes1 container4Fragment = new Fragment_imagenes1();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container4Fragment).addToBackStack(null).commit();
        } else if (id == R.id.nav_share) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            Fragment_imagenes1 container5Fragment = new Fragment_imagenes1();
            fragmentManager.beginTransaction().replace(R.id.contenedor_fragments, container5Fragment).addToBackStack(null).commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
