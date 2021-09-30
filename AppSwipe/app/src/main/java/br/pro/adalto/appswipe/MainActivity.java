package br.pro.adalto.appswipe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvDirecao;
    private ConstraintLayout fundoDaTela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

   //     String texto = getResources().getString(R.string.txtDirecao);
   //     String mensagem = "Atenção! " + texto;
   //     tvDirecao.setBackgroundColor( getResources().getColor(R.color.corDoFundoDaTela) );

        tvDirecao = findViewById(R.id.tvDirecao);
        fundoDaTela = findViewById(R.id.fundoDaTela);

        
        fundoDaTela.setOnTouchListener( new OnSwipeTouchListener(this) {

            @Override
            public void onSwipeTop() {
                super.onSwipeTop();
                tvDirecao.setText("Para cima");
                fundoDaTela.setBackgroundColor( Color.BLUE );
            }

            @Override
            public void onSwipeBottom() {
                super.onSwipeBottom();
                tvDirecao.setText("Para baixo");
                fundoDaTela.setBackgroundColor( Color.GREEN);
            }

            @Override
            public void onSwipeRight() {
                super.onSwipeRight();
                tvDirecao.setText("Para direita");
                fundoDaTela.setBackgroundColor( Color.YELLOW );
            }

            @Override
            public void onSwipeLeft() {
                super.onSwipeLeft();
                tvDirecao.setText("Para esquerda");
                fundoDaTela.setBackgroundColor( Color.RED );
            }


            @Override
            public boolean onTouch(View v, MotionEvent event) {

                tvDirecao.setText( getResources().getString(R.string.txtDirecao)  );
                fundoDaTela.setBackgroundColor( getResources().getColor( R.color.corDoFundoDaTela) );

                return super.onTouch(v, event);
            }
        } );


    }
}