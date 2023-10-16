package com.example.sendmessageviewbinding;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sendmessageviewbinding.databinding.ActivityViewBinding;
import com.example.sendmessageviewbinding.model.data.Message;

public class ViewActivity extends AppCompatActivity {
    private ActivityViewBinding binding;
    public  static final String TAG ="ViewActivity";
    private Message mensaje;

    //region Metodos que construyen y destrullen
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"ViewActivity -> OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"ViewActivity -> OnResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"ViewActivity -> OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"ViewActivity -> OnStop");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
        Log.d(TAG,"ViewActivity -> OnDestroy");
    }
//endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Bundle bundle = getIntent().getExtras();
        mensaje = bundle.getParcelable(Message.KEY);
        inicializeView();
    }

    /**
     * Método para dar la informacion a todas las activities
     */
    private void inicializeView(){
        binding.tvUserInfo.setText("Remitente:\n" + mensaje.getSender().toString() + "\nReceptor\n" +  mensaje.getReceiver().toString());
        binding.tvMessage.setText(mensaje.getContent());

    }
}

//crear un punto de depuracion clic derecho pa pone ma cosas