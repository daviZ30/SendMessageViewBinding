package com.example.sendmessageviewbinding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sendmessageviewbinding.databinding.ActivitySendMessageBinding;
import com.example.sendmessageviewbinding.model.data.Message;
import com.example.sendmessageviewbinding.model.data.Person;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class SendMessageActivity extends AppCompatActivity {
    private ActivitySendMessageBinding binding;
    public static final String TAG = "SendMessageActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySendMessageBinding.inflate(getLayoutInflater());

        setContentView(binding.getRoot());

        //Opcion 3: Expresión labmda para implementar el evento OnClick

        binding.fab.setOnClickListener(v -> {
            SendMessage();


        });
        Log.d(TAG,"SendMessageActivity -> OnCreate");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        /* Para poder usar un switch agregamos esas lineas en gradle properties
        * # Para poder usar los switch
            android.nonTransitiveRClass=false
            android.nonFinalResIds = false
            * */
        if (item.getItemId() == R.id.menu_aboutas) {
            Intent intent = new Intent(this, AboutActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
//region Metodos que construyen y destrullen
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"SendMessageActivity -> OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"SendMessageActivity -> OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"SendMessageActivity -> OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"SendMessageActivity -> OnStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG,"SendMessageActivity -> OnDestroy");
    }
//endregion
    /**
     * Método que construlle el mesnaje y lo envia
     */
    public  void SendMessage(){
        //Lanza la otra ventana
        Intent intent = new Intent(this, ViewActivity.class);
        Bundle bundle = new Bundle();
        Person person = new Person("David","Zambrana Romero","1");
        Person remitente = new Person("2","e","e");
        Message mesan = new Message(1, binding.edMessage.getText().toString(),person,remitente);
        bundle.putParcelable(Message.KEY, mesan);
        bundle.putSerializable(Message.KEY , mesan);
        intent.putExtras(bundle);
        startActivity(intent);
    }
    /**
     * OPCIÓN 1: Método que construye el mensaje y lo envia a otra Activity
     */
    class SendMessageOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View w) {
            Toast.makeText(SendMessageActivity.this, "Se ha pulsado sobre el botón enviar", Toast.LENGTH_SHORT).show();

        }
    }
}
//habilitamos el binding en build.gradle.kts