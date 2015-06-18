package br.ufc.virtual.smd.oqcomer;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import br.ufc.virtual.smd.oqcomer.vo.Usuario;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    /*
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }
    */

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    */

    public void cadastrarBotaoOnClick(View v) {
        Intent telaAlvo = new Intent(LoginActivity.this, CadastrarUsuarioActivity.class);
        EditText usuarioTexto = (EditText) findViewById(R.id.usuarioTexto);
        if (usuarioTexto.getText() != null && usuarioTexto.getText().toString().trim().length() > 0) {
            Usuario usuario = new Usuario();
            usuario.setUsuario(usuarioTexto.getText().toString());
            telaAlvo.putExtra("USUARIO", usuario);
        }
        startActivity(telaAlvo);
    }

    public void loginBotaoOnClick(View v) {
        Intent telaAlvo = new Intent(LoginActivity.this, MainActivity.class);
        EditText usuarioTexto = (EditText) findViewById(R.id.usuarioTexto);
        EditText usuarioSenha = (EditText) findViewById(R.id.usuarioSenha);
        if (usuarioTexto.getText() != null && usuarioTexto.getText().toString().trim().length() > 0 &&
                usuarioSenha.getText() != null && usuarioSenha.getText().toString().trim().length() > 0) {
        }
        startActivity(telaAlvo);
    }
}
