package br.pro.adalto.apppersist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FormularioActivity extends AppCompatActivity {

    private EditText etNome;
    private Spinner spCategorias;
    private Button btnSalvar;
    private String acao;
    private Produto produto;

    private FirebaseDatabase database;
    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        database = FirebaseDatabase.getInstance();
        reference = database.getReference();

        etNome = findViewById(R.id.etNome);
        spCategorias =  findViewById(R.id.spCategoria);
        btnSalvar = findViewById(R.id.btnSalvar);

        acao = getIntent().getStringExtra("acao");
        if( acao.equals("editar") ){
            carregarFormulario();
        }

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });
    }

    private void carregarFormulario(){
        String id = getIntent().getStringExtra("idProduto");
        //produto = ProdutoDAO.getProdutoById(this, id);
        etNome.setText( produto.getNome() );
        String[] categorias = getResources().getStringArray(R.array.categorias);
        for (int i = 1; i < categorias.length ;i++){
            if( produto.getCategoria().equals( categorias[i] ) ){
                spCategorias.setSelection(i);
                break;
            }
        }
    }
    private void salvar(){
        String nome = etNome.getText().toString();
        if( nome.isEmpty() || spCategorias.getSelectedItemPosition()  == 0 ){
            Toast.makeText(this, "Você deve preencher todos os campos!", Toast.LENGTH_LONG ).show();
        }else{
            if( acao.equals("inserir")) {
                produto = new Produto();
            }
            produto.setNome( nome );
            produto.setCategoria( spCategorias.getSelectedItem().toString() );
            if( acao.equals("inserir")) {
                // ProdutoDAO.inserir(this, produto);
                reference.child("produtos").push().setValue(produto);
                etNome.setText("");
                spCategorias.setSelection(0, true);
            }else{
                // ProdutoDAO.editar(this, produto);
                reference.child("produtos").child( produto.getId() ).setValue(produto);
                finish();
            }
        }
    }

}