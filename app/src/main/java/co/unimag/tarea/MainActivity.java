package co.unimag.tarea;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    EditText n1,n2,n3,n4;
    Button btnpen,btncu,btnpm;
   int x1,x2,y1,y2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        n1 =(EditText) findViewById(R.id.edt1);
        n2 =(EditText) findViewById(R.id.edt2);
        n3 = (EditText)findViewById(R.id.edt3);
        n4 = (EditText)findViewById(R.id.edt4);
        btnpen = findViewById(R.id.btnpen);
        btnpm = findViewById(R.id.btnpm);
        btncu = findViewById(R.id.btncu);

        btnpen.setOnClickListener(this);
        btnpm.setOnClickListener(this);
        btncu.setOnClickListener(this);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater= getMenuInflater();
        inflater.inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (R.id.m1==item.getItemId()){
        int ran[] = new int[4];
        int N=-51,M=51,p=0,y=0;
        for (int x=0;x<4;x++){
            y=0;
            while (y==0){
                p=(int) Math.floor(Math.random()*(N-M+1)+M);
                boolean b =false;

                for (int e : ran) {
                    if (e == p) {
                        b= true;
                    }
                }

                if(b==false){
                    ran[x]= p;
                    System.out.println("n: "+p);
                    y=1;
                }
            }
        }
        //asignacion
            n1.setText(""+ran[0]);
            n2.setText(""+ran[1]);
            n3.setText(""+ran[2]);
            n4.setText(""+ran[3]);
        Toast.makeText(this, "Numeros Aleatorios", Toast.LENGTH_LONG).show();
        }
        else if (TextUtils.isEmpty(n1.getText()) || TextUtils.isEmpty(n2.getText())) {
            Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();

        }else {
            x1 = Integer.parseInt(n1.getText().toString());
            y1 = Integer.parseInt(n2.getText().toString());
            x2 = Integer.parseInt(n3.getText().toString());
            y2 = Integer.parseInt(n4.getText().toString());
            double result = 0;
            switch (item.getItemId()) {
                case R.id.m2:
                    result=(x2-x1)+(y2-y1);
                    if (result<0){
                       result*=-1;
                    }
                        Toast.makeText(this, "Distancia: "+Math.sqrt(result) , Toast.LENGTH_LONG).show();


                    break;
            }
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public void onClick(View v) {
        if (TextUtils.isEmpty(n1.getText()) || TextUtils.isEmpty(n2.getText())|| TextUtils.isEmpty(n3.getText())|| TextUtils.isEmpty(n4.getText())) {
            Toast.makeText(getApplicationContext(), "Datos invalidos", Toast.LENGTH_LONG).show();

        }else {
             x1 = Integer.parseInt(n1.getText().toString());
             y1 = Integer.parseInt(n2.getText().toString());
            x2 = Integer.parseInt(n3.getText().toString());
            y2 = Integer.parseInt(n4.getText().toString());

            double result;
            switch (v.getId()) {
                case R.id.btnpen:
                    if (y2-y1==0){
                        Toast.makeText(this, "Pendiente: indefinida", Toast.LENGTH_LONG).show();
                    }else {
                        result=x2-x1 /y2-y1;
                        Toast.makeText(this, "Pendiente: "+result, Toast.LENGTH_LONG).show();
                    }
                    break;

                case R.id.btnpm:
                    result = ((x1 + x2) / 2) + ((y1 + y2) / 2);
                    Toast.makeText(this, "Punto Medio: " + result, Toast.LENGTH_LONG).show();
                    break;

                case R.id.btncu:
                    String cu="",cu2="";
                    //cuadrante1
                    if(x1>0 &&y1>0){
                        cu="1";
                    }
                    if(x2>0 &&y2>0){
                        cu2="1";
                    }

                    //cuadrante "1 y 2"
                    if(x1==0 && y1>0){
                        cu="1 y 2";
                    }
                    if(x2==0 &&y2>0){
                        cu2="1 y 2";
                    }

                    //cuadrante "2"
                    if(x1<0 && y1>0){
                        cu="2";
                    }
                    if(x2<0 &&y2>0){
                        cu2="2";
                    }

                    //cuadrante "2 y 3"
                    if(x1<0 && y1==0){
                        cu="2 y 3";
                    }
                    if(x2<0 &&y2==0){
                        cu2="2 y 3";
                    }

                    //cuadrante "3"
                    if(x1<0 && y1<0){
                        cu="3";
                    }
                    if(x2<0 &&y2<0){
                        cu2="3";
                    }

                    //cuadrante "3 y 4";
                    if(x1==0 && y1<0){
                        cu="3 y 4";
                    }
                    if(x2==0 && y2<0){
                        cu2="3 y 4";
                    }

                    //cuadrante "4"
                    if(x1>0 && y1<0){
                        cu="4";
                    }
                    if(x2>0 && y2<0){
                        cu2="4";
                    }

                    //cuadrante "4 y 1"
                    if(x1>0 && y1==0){
                        cu="4";
                    }
                    if(x2>0 &&y2==0){
                        cu2="4";
                    }
                    //cuadrante "0"
                    if(x1==0 && y1==0){
                        cu="centro";
                    }
                    if(x2==0 &&y2==0){
                        cu2="centro";
                    }
                    Toast.makeText(this, "P1-Cuadrante: "+cu.toString()+"\nP2-Cuandrante: "+cu2, Toast.LENGTH_LONG).show();
                    break;

            }
        }
    }
}