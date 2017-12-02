package cl.inacap.parenas.evaluacion;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cl.inacap.parenas.evaluacion.R;

public class MainActivity extends AppCompatActivity{
    Button btn;
    EditText usr,psd;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usr = (EditText) findViewById(R.id.usr);
        psd = (EditText) findViewById(R.id.psd);
        btn = (Button) findViewById(R.id.btn);


        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                if (usr.getText().toString().equals("bramirez") && psd.getText().toString().equals("inacap")){
                    Toast.makeText(getApplicationContext(),"Ingreso Correcto", Toast.LENGTH_LONG);
                    Intent myintent = new Intent(MainActivity.this,
                            cl.inacap.parenas.evaluacion.LoggedActivity.class);
                    startActivity(myintent);
                } else if (usr.getText().toString().equals("mascencio") && psd.getText().toString().equals("parenas")){
                    Toast.makeText(getApplicationContext(),"Ingreso Correcto", Toast.LENGTH_LONG);
                    Intent myintent1 = new Intent(MainActivity.this,
                            cl.inacap.parenas.evaluacion.LoggedActivity.class);
                    startActivity(myintent1);
                }
            }
        });
    }
}