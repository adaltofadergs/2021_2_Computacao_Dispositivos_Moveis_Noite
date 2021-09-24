package br.pro.adalto.apppersist;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public static void inserir(Context context, Produto produto){
        ContentValues values = new ContentValues();
        values.put( "nome" , produto.getNome() );
        values.put( "categoria" , produto.getCategoria() );

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.insert("produtos", null , values);
    }

    public static void editar(Context context, Produto produto){
        ContentValues values = new ContentValues();
        values.put( "nome" , produto.getNome() );
        values.put( "categoria" , produto.getCategoria() );

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.update("produtos", values, " id = " + produto.getId(), null);
    }

    public static void excluir(Context context, int idProduto){

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getWritableDatabase();

        db.delete("produtos", " id = " + idProduto, null);
    }

    public static List<Produto> getProdutos(Context context){
        List<Produto> lista = new ArrayList<>();

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM produtos ORDER BY nome ", null);

        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();
            do{
                Produto prod = new Produto();
                prod.setId(  cursor.getInt( 0 ) );
                prod.setNome( cursor.getString( 1 ));
                prod.setCategoria( cursor.getString( 2 ));
                lista.add( prod );

            }while ( cursor.moveToNext() );
        }
        return lista;
    }


    public static Produto getProdutoById(Context context, int idProduto){

        Banco conn = new Banco(context);
        SQLiteDatabase db = conn.getReadableDatabase();

        Cursor cursor = db.rawQuery("SELECT * FROM produtos WHERE id =  " + idProduto, null);

        if( cursor.getCount() > 0 ){
            cursor.moveToFirst();

            Produto prod = new Produto();
            prod.setId(  cursor.getInt( 0 ) );
            prod.setNome( cursor.getString( 1 ));
            prod.setCategoria( cursor.getString( 2 ));

            return prod;

        }else {
            return null;
        }
    }

}
