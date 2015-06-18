package br.ufc.virtual.smd.oqcomer;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import br.ufc.virtual.smd.oqcomer.adapter.ProdutoListaAdapter;


public class MainActivity extends ActionBarActivity {

    private ListView produtoLista;
    private String[] itemName ={
            "Safari",
            "Camera",
            "Global",
            "FireFox",
            "UC Browser",
            "Android Folder",
            "VLC Player",
            "Cold War"
    };
    private String[] imagemPath ={
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png",
            "http://e.cdn-hardware.com.br/static/20110413/m55ac8604.png"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        HttpGet uri = new HttpGet("http://example.com");

        try {
            DefaultHttpClient client = new DefaultHttpClient();
            HttpResponse resp = client.execute(uri);

            StatusLine status = resp.getStatusLine();
            if (status.getStatusCode() != 200) {
                //"HTTP error, invalid server status code: " + resp.getStatusLine();
            }

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(resp.getEntity().getContent());
        } catch(Exception ex) {

        }
        */

        ProdutoListaAdapter adapter=new ProdutoListaAdapter(this, itemName, imagemPath);
        produtoLista =(ListView) findViewById(R.id.produtoLista);
        produtoLista.setAdapter(adapter);

        produtoLista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = itemName[+position];
                Toast.makeText(getApplicationContext(), selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

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

    public void novoProdutoOnClick(View v) {
        Intent telaAlvo = new Intent(MainActivity.this, NovoProdutoActivity.class);
        startActivity(telaAlvo);
    }
}
