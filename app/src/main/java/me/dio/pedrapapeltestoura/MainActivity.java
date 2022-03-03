package me.dio.pedrapapeltestoura;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void selecionadoPedra (View view){
       this.opcaoSelecionada("pedra");

    }
   public void selecionadoPapel (View view){
       this.opcaoSelecionada("papel");

    }
   public void selecionadoTesoura (View view){
       this.opcaoSelecionada("Tesoura");

    }

    public void opcaoSelecionada(String escolhaUsuario)
    {

        ImageView Resultado = findViewById(R.id.Resultado);
        TextView textoResultado = findViewById(R.id.textResultado);


        int numero = new Random().nextInt(3);//0 1 2

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes [numero];

        switch (escolhaApp){
            case "pedra" :
                Resultado.setImageResource(R.drawable.pedra);
                break;

            case "papel" :
                Resultado.setImageResource(R.drawable.papel);
                break;

            case "tesoura" :
                Resultado.setImageResource(R.drawable.tesoura);
                break;


        }

        if(
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ){//App ganhador
                textoResultado.setText("Você perdeu :( ");
        }else if (
                (escolhaUsuario == "tesoura" && escolhaApp == "papel") ||
                (escolhaUsuario == "papel" && escolhaApp == "pedra") ||
                (escolhaUsuario == "pedra" && escolhaApp == "tesoura")
        ){//Usuario ganhador
            textoResultado.setText("Você Ganhou :) ");

        }else {//Empate
        textoResultado.setText("Empatamos ;) ");


    }


        System.out.println("item clicado" + escolhaApp);


    }
}