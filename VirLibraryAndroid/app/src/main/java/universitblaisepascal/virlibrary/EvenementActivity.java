package universitblaisepascal.virlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class EvenementActivity extends AppCompatActivity {

    ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenement);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        mListView = (ListView) findViewById(R.id.listViewEvenement);
        //final List<Evenement> evenements = new ArrayList<Evenement>();

        //r&cupération evenement
        Traitement trai = new Traitement();
        final List<Evenement> evenements = trai.evenementList();

        /*evenements.add(new Evenement("evenement 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed convallis imperdiet tincidunt. Morbi et pulvinar enim, at elementum mi. Nullam egestas tellus et metus lacinia elementum. Sed laoreet tincidunt est, a congue arcu aliquet ullamcorper. Sed sollicitudin venenatis urna vel vulputate. Nulla at est at lorem vehicula cursus. Curabitur rutrum dignissim velit, sed porta leo dictum vel. Mauris sit amet facilisis est. Sed vitae viverra risus."+
                "Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Maecenas egestas venenatis nulla eget tincidunt. Vestibulum dictum risus non nulla aliquam rutrum. Maecenas tempor dui et enim eleifend varius. Curabitur iaculis tincidunt aliquam. Morbi hendrerit sem nibh, sed dapibus dui ultrices et. Proin sagittis, elit id bibendum hendrerit, lectus libero pharetra sem, non fermentum arcu enim eu nisl. Curabitur tempor, mi iaculis venenatis ullamcorper, leo ligula accumsan risus, non porta ipsum est ut quam. Praesent vel dapibus mauris. Phasellus eu velit non arcu fermentum dictum.", 1));
        evenements.add(new Evenement("evenement 2", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus quis felis sit amet metus tristique interdum. Sed blandit elementum mi eu sollicitudin. Aenean venenatis a nisl id pellentesque. In et ullamcorper felis, vel consequat purus. Integer vel odio commodo, tempor purus nec, aliquam nibh. Suspendisse potenti. Fusce sollicitudin pulvinar pretium. Suspendisse lectus tortor, ullamcorper a lorem id, semper imperdiet est. Nulla rhoncus libero eget sollicitudin vehicula. Sed consectetur rhoncus nisi, a volutpat libero sagittis in. Curabitur ipsum arcu, laoreet et blandit eget, posuere non est. Nulla eu lacinia lorem. In hac habitasse platea dictumst. Cras viverra molestie velit id ullamcorper. Donec et finibus urna, eu dapibus nulla.", 2));
        evenements.add(new Evenement("evenement 3", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. In eu ligula molestie, bibendum justo nec, imperdiet lacus. Maecenas quis lorem sit amet magna semper venenatis. Etiam ultricies tortor nec tristique gravida. Vestibulum id scelerisque orci, at pulvinar arcu. Morbi rhoncus interdum faucibus. Quisque vel porttitor eros, nec ultrices tellus. Praesent libero mauris, rhoncus et risus in, sollicitudin cursus odio. Aliquam aliquam at magna sit amet luctus.\n" +
                "\nUt suscipit posuere mi, eu rutrum lorem ullamcorper vitae. Curabitur ipsum mi, semper vel nisi id, varius posuere velit. Suspendisse non eros suscipit, convallis tellus volutpat, porttitor augue. Suspendisse potenti. Nullam eu sem tempus magna maximus tincidunt. Phasellus tempor leo at dolor laoreet maximus. Nullam at elit pellentesque, elementum risus vel, eleifend magna. Duis suscipit dui ac laoreet facilisis. Maecenas molestie quis enim eu lobortis.\n" +
                "\nLorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce interdum consequat dui, non tincidunt nisi dignissim in. In mollis massa id blandit laoreet. Etiam est leo, sodales quis mi vel, lacinia elementum lorem. Mauris vitae accumsan nisi. Aenean nec sapien ut sem consequat interdum id et arcu. Aenean id semper est, in iaculis augue.\n" +
                "\nCurabitur vestibulum massa velit, vel hendrerit lacus condimentum id. Nulla ultrices, libero quis ultrices consequat, metus neque ultricies felis, non vehicula neque orci nec augue. Mauris pellentesque nisi ante, at imperdiet augue consectetur eget. Integer at gravida massa, feugiat ornare ipsum. Pellentesque eget metus molestie, elementum tortor ac, consequat purus. Etiam maximus dolor at volutpat pharetra. Duis a fermentum neque, malesuada convallis nulla. Vivamus suscipit dictum lacus, vel consequat augue faucibus non. Donec id ex in nisi laoreet convallis nec sed metus. Cras dignissim lectus ultrices metus tincidunt ultricies. Etiam convallis, justo eu ullamcorper luctus, est ligula vehicula nunc, in efficitur lorem augue vitae leo.", 3));*/
        EvenementAdapter adapter = new EvenementAdapter(EvenementActivity.this, evenements);
        mListView.setAdapter(adapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent mIntent = new Intent(EvenementActivity.this, VueEvenementActivity.class);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("vueEvenement", evenements.get(position));
                mIntent.putExtras(mBundle);
                startActivity(mIntent);
            }
        });
    }

}
