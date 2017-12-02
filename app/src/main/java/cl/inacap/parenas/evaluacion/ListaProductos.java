package cl.inacap.parenas.evaluacion;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class ListaProductos extends Activity {
    private List<Productos> lista= new ArrayList<Productos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);

        populateproductos();
        populatelistview();
    }

    private void populateproductos(){
        lista.add(new Productos(R.drawable.cfs,"Bebidas","Código: 331", "Precio: $850"));
        lista.add(new Productos(R.drawable.arroz,"Arroz","Código: 243", "Precio: $800"));
        lista.add(new Productos(R.drawable.sal,"Sal","Código: 603", "Precio: $400"));
        lista.add(new Productos(R.drawable.grbnzs,"Garbanzos","Código: 025", "Precio: $990"));
    }

    private void populatelistview(){
        ArrayAdapter<Productos> adapter = new listaadapter();
        ListView list = (ListView) findViewById(R.id.lista_productos);
        list.setAdapter(adapter);
    }

    private class listaadapter extends ArrayAdapter<Productos>{

        public listaadapter() {
            super(ListaProductos.this, R.layout.activity_productos_2, lista);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            View itemview = convertView;
            if (itemview == null){
                itemview=getLayoutInflater().inflate(R.layout.activity_productos_2, parent, false);
            }

            Productos producto = lista.get(position);

            ImageView imageView = (ImageView)itemview.findViewById(R.id.item_icon);
            imageView.setImageResource(producto.getIdicono());

            TextView maketext= (TextView) itemview.findViewById(R.id.item_txtnombre);
            maketext.setText(producto.getNombre());

            TextView codigotext= (TextView) itemview.findViewById(R.id.item_txtcodigo);
            codigotext.setText(producto.getCodigo());

            TextView preciotext= (TextView) itemview.findViewById(R.id.item_txtprecio);
            preciotext.setText(producto.getPrecio());

            return itemview;

        }
    }
}

