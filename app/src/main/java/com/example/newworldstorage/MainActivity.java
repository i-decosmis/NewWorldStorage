package com.example.newworldstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    // initialise the list items for the alert dialog
    final String[] listItems = new String[]{"Armi", "Arredamento", "Arti arcane", "Creazione di gioielli",
            "Cucina", "Falegnameria", "Fonderia", "Lavorazione del cuoio", "Modificatori", "Munizioni",
            "Oggetti utili", "Pesca", "Reagenti", "Ricompense", "Risorse", "Sfere da accordatura",
            "Strumenti", "Taglio della pietra", "Tessitura", "Tinte", "Vestiario"};
    final boolean[] checkedItems = new boolean[listItems.length];
    LinearLayout acquafetida_item;
    LinearLayout boscobrillante_item;
    LinearLayout calata_eterna_item;
    LinearLayout casamontana_item;
    LinearLayout eastburn_item;
    LinearLayout palude_del_tessitore_item;
    LinearLayout pendiomontano_item;
    LinearLayout prima_luce_item;
    LinearLayout promontorio_del_monarca_item;
    LinearLayout puntabreccia_item;
    LinearLayout roccafore_della_prodezza_item;
    LinearLayout scaglia_d_ebano_item;
    LinearLayout scogliere_della_sciabola_item;
    LinearLayout sopravvento_item;
    LinearLayout sponda_inquieta_item;
    LinearLayout ultimo_baluardo_item;
    LinearLayout valle_del_cordoglio_item;
    LinearLayout[] tutti_layout = {acquafetida_item, boscobrillante_item, calata_eterna_item, calata_eterna_item,
        eastburn_item,palude_del_tessitore_item,pendiomontano_item,prima_luce_item,promontorio_del_monarca_item,
        puntabreccia_item,roccafore_della_prodezza_item,scaglia_d_ebano_item,scogliere_della_sciabola_item,
        sopravvento_item,sponda_inquieta_item,ultimo_baluardo_item,valle_del_cordoglio_item};


    // copy the items from the main list to the selected item list for the preview
    // if the item is checked then only the item should be displayed for the user
    final List<String> selectedItems = Arrays.asList(listItems);
    LinearLayout button_pressed;
    ScrollView generale;
    int index_pressed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        generale = findViewById(R.id.generale);

        tutti_layout[0] = findViewById(R.id.acquafetida_item);

        tutti_layout[1] = findViewById(R.id.boscobrillante_item);

        tutti_layout[2]  = findViewById(R.id.calata_eterna_item);

        tutti_layout[3]  = findViewById(R.id.Casamontana_item);

        tutti_layout[4]  = findViewById(R.id.Eastburn_item);

        tutti_layout[5]  = findViewById(R.id.Palude_del_tessitore_item);

        tutti_layout[6]  = findViewById(R.id.Pendiomontano_item);

        tutti_layout[7]  = findViewById(R.id.Prima_luce_item);

        tutti_layout[8]  = findViewById(R.id.Promontorio_del_monarca_item);

        tutti_layout[9]  = findViewById(R.id.Puntabreccia_item);

        tutti_layout[10]  = findViewById(R.id.Roccaforte_della_prodezza_item);

        tutti_layout[11]  = findViewById(R.id.Scaglia_d_ebano_item);

        tutti_layout[12]  = findViewById(R.id.Scogliere_della_sciabola_item);

        tutti_layout[13]  = findViewById(R.id.Sopravvento_item);

        tutti_layout[14]  = findViewById(R.id.Sponda_inquieta_item);

        tutti_layout[15]  = findViewById(R.id.Ultimo_baluardo_item);

        tutti_layout[16]  = findViewById(R.id.Valle_del_cordoglio_item);

        TextView acquafetida_button = findViewById(R.id.Acquafetida_button);

        TextView boscobrillante_button = findViewById(R.id.Boscobrillante_button);

        TextView calata_eterna_button = findViewById(R.id.Calata_eterna_button);

        TextView casamontana_button = findViewById(R.id.Casamontana_button);

        TextView eastburn_button = findViewById(R.id.Eastburn_button);

        TextView palude_del_tessitore_button = findViewById(R.id.Palude_del_tessitore_button);
        palude_del_tessitore_button.setSelected(true);

        TextView pendiomontano_button = findViewById(R.id.Pendiomontano_button);

        TextView prima_luce_button = findViewById(R.id.Prima_luce_button);

        TextView promontorio_del_monarca_button = findViewById(R.id.Promontorio_del_monarca_button);
        promontorio_del_monarca_button.setSelected(true);

        TextView puntabreccia_button = findViewById(R.id.Puntabreccia_button);

        TextView roccaforte_della_prodezza_button = findViewById(R.id.Roccaforte_della_prodezza_button);
        roccaforte_della_prodezza_button.setSelected(true);

        TextView scaglia_d_ebano_button = findViewById(R.id.Scaglia_d_ebano_button);
        scaglia_d_ebano_button.setSelected(true);

        TextView scogliere_della_sciabola = findViewById(R.id.Scogliere_della_sciabola_button);
        scogliere_della_sciabola.setSelected(true);

        TextView sopravvento_button = findViewById(R.id.Sopravvento_button);

        TextView sponda_inquieta_button = findViewById(R.id.Sponda_inquieta_button);
        sponda_inquieta_button.setSelected(true);

        TextView ultimo_baluardo_button = findViewById(R.id.Ultimo_baluardo_button);
        ultimo_baluardo_button.setSelected(true);

        TextView valle_del_cordoglio_button = findViewById(R.id.Valle_del_cordoglio_button);
        valle_del_cordoglio_button.setSelected(true);

        acquafetida_button.setOnLongClickListener(view -> {
            index_pressed = 0;
            button_pressed = tutti_layout[0] ;
            selezionaClassi();
            return false;
        });

        boscobrillante_button.setOnLongClickListener(view -> {
            index_pressed = 1;
            button_pressed = tutti_layout[1] ;
            selezionaClassi();
            return false;
        });

        calata_eterna_button.setOnLongClickListener(view -> {
            index_pressed = 2;
            button_pressed = tutti_layout[2] ;
            selezionaClassi();
            return false;
        });

        casamontana_button.setOnLongClickListener(view -> {
            index_pressed = 3;
            button_pressed = tutti_layout[3] ;
            selezionaClassi();
            return false;
        });

        eastburn_button.setOnLongClickListener(view -> {
            index_pressed = 4;
            button_pressed = tutti_layout[4] ;
            selezionaClassi();
            return false;
        });

        palude_del_tessitore_button.setOnLongClickListener(view -> {
            index_pressed = 5;
            button_pressed = tutti_layout[5] ;
            selezionaClassi();
            return false;
        });

        pendiomontano_button.setOnLongClickListener(view -> {
            index_pressed = 6;
            button_pressed = tutti_layout[6] ;
            selezionaClassi();
            return false;
        });

        prima_luce_button.setOnLongClickListener(view -> {
            index_pressed = 7;
            button_pressed = tutti_layout[7] ;
            selezionaClassi();
            return false;
        });

        promontorio_del_monarca_button.setOnLongClickListener(view -> {
            index_pressed = 8;
            button_pressed = tutti_layout[8] ;
            selezionaClassi();
            return false;
        });

        puntabreccia_button.setOnLongClickListener(view -> {
            index_pressed = 9;
            button_pressed = tutti_layout[9] ;
            selezionaClassi();
            return false;
        });

        roccaforte_della_prodezza_button.setOnLongClickListener(view -> {
            index_pressed = 10;
            button_pressed = tutti_layout[10] ;
            selezionaClassi();
            return false;
        });

        scaglia_d_ebano_button.setOnLongClickListener(view -> {
            index_pressed = 11;
            button_pressed = tutti_layout[11] ;
            selezionaClassi();
            return false;
        });

        scogliere_della_sciabola.setOnLongClickListener(view -> {
            index_pressed = 12;
            button_pressed = tutti_layout[12] ;
            selezionaClassi();
            return false;
        });

        sopravvento_button.setOnLongClickListener(view -> {
            index_pressed = 13;
            button_pressed = tutti_layout[13] ;
            selezionaClassi();
            return false;
        });

        sponda_inquieta_button.setOnLongClickListener(view -> {
            index_pressed = 14;
            button_pressed = tutti_layout[14] ;
            selezionaClassi();
            return false;
        });

        ultimo_baluardo_button.setOnLongClickListener(view -> {
            index_pressed = 15;
            button_pressed = tutti_layout[15] ;
            selezionaClassi();
            return false;
        });

        valle_del_cordoglio_button.setOnLongClickListener(view -> {
            index_pressed = 16;
            button_pressed = tutti_layout[16] ;
            selezionaClassi();
            return false;
        });

        try {
            leggoDaFile();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    void selezionaClassi(){
        // initialise the alert dialog builder
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

        // set the title for the alert dialog
        builder.setTitle("Choose Items");

        // set the icon for the alert dialog
        builder.setIcon(R.drawable.treasure);

        // now this is the function which sets the alert dialog for multiple item selection ready
        builder.setMultiChoiceItems(listItems, checkedItems, (dialog, which, isChecked) -> {
            checkedItems[which] = isChecked;
            String currentItem = selectedItems.get(which);
        });

        // alert dialog shouldn't be cancellable
        builder.setCancelable(false);

        // handle the positive button of the dialog
        builder.setPositiveButton("Fatto", (dialog, which) -> {
            List<Integer> index_list = new ArrayList<>();
            button_pressed.removeAllViews();
            for (int i = 0; i < checkedItems.length; i++) {
                if (checkedItems[i]) {
                    ImageView immagine = aggiungiClasseItem(i);
                    button_pressed.addView(immagine);
                    immagine.setScaleY((float) 1.1);
                    immagine.setScaleX((float) 1.1);
                    immagine.getLayoutParams().width=160;
                    immagine.getLayoutParams().height=150;
                    index_list.add(i);
                }
            }
            Integer [] index = index_list.toArray(new Integer[index_list.size()]); //converting to array
            try {
                salvaSuFile(index);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Arrays.fill(checkedItems, false);
        });

        // handle the negative button of the alert dialog
        builder.setNegativeButton("Annulla", (dialog, which) -> {});

        // create the builder
        builder.create();

        // create the alert dialog with the alert dialog builder instance
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    void salvaSuFile(Integer[] index) throws IOException {
        FileOutputStream fos = openFileOutput(String.valueOf(index_pressed), Context.MODE_APPEND);
        PrintWriter writer = new PrintWriter( new OutputStreamWriter( fos ) );

        if (index.length == 0) {
            deleteFile(String.valueOf(index_pressed));
        } else {
            for (int i = 0; i<index.length; i++){
                writer.println(index[i]);
            }
        }
        writer.close();
    }

    void leggoDaFile() throws IOException, ClassNotFoundException {
        Log.d("test", "leggo");
        File dir = getFilesDir();
        int z = 0;
        while(z < 17){
            File file = new File(dir, String.valueOf(z));
            if(file.exists()){
                FileInputStream fis = openFileInput(String.valueOf(z));
                BufferedReader reader = new BufferedReader( new InputStreamReader( fis ) );
                String strLine;
                int i;
                while((strLine = reader.readLine()) != null) {
                    i = Integer.parseInt(strLine);
                    ImageView immagine = aggiungiClasseItem(i);
                    tutti_layout[z].addView(immagine);
                    immagine.setScaleY((float) 1.1);
                    immagine.setScaleX((float) 1.1);
                    immagine.getLayoutParams().width=160;
                    immagine.getLayoutParams().height=150;
                }
                reader.close();
            }
            z++;
        }
    }

    ImageView aggiungiClasseItem(int pos){
        ImageView imageView = new ImageView(this);
        if (pos == 0){
            imageView.setImageResource(R.drawable.armi);
        }
        if (pos == 1){
            imageView.setImageResource(R.drawable.arredamento);
        }
        if (pos == 2){
            imageView.setImageResource(R.drawable.arti_arcane);
        }
        if (pos == 3){
            imageView.setImageResource(R.drawable.creazione_di_gioielli);
        }
        if (pos == 4){
            imageView.setImageResource(R.drawable.cucina);
        }
        if (pos == 5){
            imageView.setImageResource(R.drawable.falegnameria);
        }
        if (pos == 6){
            imageView.setImageResource(R.drawable.fonderia);
        }
        if (pos == 7){
            imageView.setImageResource(R.drawable.lavorazione_del_cuoio);
        }
        if (pos == 8){
            imageView.setImageResource(R.drawable.modificatori);
        }
        if (pos == 9){
            imageView.setImageResource(R.drawable.munizioni);
        }
        if (pos == 10){
            imageView.setImageResource(R.drawable.oggetti_utili);
        }
        if (pos == 11){
            imageView.setImageResource(R.drawable.pesca);
        }
        if (pos == 12){
            imageView.setImageResource(R.drawable.reagenti);
        }
        if (pos == 13){
            imageView.setImageResource(R.drawable.ricompense);
        }
        if (pos == 14){
            imageView.setImageResource(R.drawable.risorse);
        }
        if (pos == 15){
            imageView.setImageResource(R.drawable.sfere_da_accordatura);
        }
        if (pos == 16){
            imageView.setImageResource(R.drawable.strumenti);
        }
        if (pos == 17){
            imageView.setImageResource(R.drawable.taglio_della_pietra);
        }
        if (pos == 18){
            imageView.setImageResource(R.drawable.tessitura);
        }
        if (pos == 19){
            imageView.setImageResource(R.drawable.tinte);
        }
        if (pos == 20){
            imageView.setImageResource(R.drawable.vestiario);
        }
        return imageView;
    }
}