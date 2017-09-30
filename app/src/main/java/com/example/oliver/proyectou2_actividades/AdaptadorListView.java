package com.example.oliver.proyectou2_actividades;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


public class AdaptadorListView extends BaseAdapter {
    // Declare Variables
    Context context;
    String[] nombres;
    String[] cor;
    String[] tel;
    String[] car;
    int[] pos;
    LayoutInflater inflater;

    public AdaptadorListView(Context context, String[] nom, String[] cor, String[] tel, String[] carrera) {
        this.context = context;
        this.nombres = nom;
        //   this.pos = pos;
        this.cor = cor;
        this.tel = tel;
        this.car = carrera;
    }

    @Override
    public int getCount() {
        return nombres.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        // Declare Variables
        TextView txtNumero;
        TextView txtNombre;
        TextView txtTelefono;
        TextView txtCorreo;
        TextView txtCarrera;

        //http://developer.android.com/intl/es/reference/android/view/LayoutInflater.html
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView = inflater.inflate(R.layout.list_view_item, parent, false);

        // Locate the TextViews in listview_item.xml
        txtNombre = (TextView) itemView.findViewById(R.id.textView_superior);
        //txtNumero = (TextView) itemView.findViewById(R.id.numero);
        txtTelefono = (TextView) itemView.findViewById(R.id.textView_inferior);
        txtCorreo = (TextView) itemView.findViewById(R.id.textView_bajo);
        txtCarrera = (TextView)itemView.findViewById(R.id.textView_bajo1);

        // Capture position and set to the TextViews
        txtNombre.setText(nombres[position]);
        //+
        // txtNumero.setText(pos[position]+"");
        txtCorreo.setText(cor[position]);
        txtTelefono.setText(tel[position]);
        txtCarrera.setText(car[position]);

        return itemView;
    }
}
