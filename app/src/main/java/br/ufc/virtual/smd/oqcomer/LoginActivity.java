package br.ufc.virtual.smd.oqcomer;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.EditText;

import br.ufc.virtual.smd.oqcomer.vo.Usuario;


public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        View v = (findViewById(R.id.logo));
        v.setPivotX(0);
        v.setPivotY(v.getWidth()/2);
        ObjectAnimator animation = ObjectAnimator.ofFloat(v, "rotationX", -1.0f, 1f);
        animation.setDuration(2000);
        animation.setRepeatMode(ObjectAnimator.REVERSE);
        animation.setRepeatCount(ObjectAnimator.INFINITE);
        animation.setInterpolator(new LinearInterpolator());
        animation.start();
    }

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
        finish();
    }
}
