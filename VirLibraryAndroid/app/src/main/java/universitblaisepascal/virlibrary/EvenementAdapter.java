package universitblaisepascal.virlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Cyril on 10/03/2016.
 */
public class EvenementAdapter extends ArrayAdapter<Evenement> {

    //livre est la liste des models à afficher
    public EvenementAdapter(Context context, List<Evenement> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.evenement_fragment,parent, false);
        }

        EvenementViewHolder viewHolder = (EvenementViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new EvenementViewHolder();
            viewHolder.titre = (TextView) convertView.findViewById(R.id.titre_commentaire_vue_livre_fragment);
            viewHolder.description = (TextView) convertView.findViewById(R.id.txtPrixAjoutLivreFinal);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Evenement evenement = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.titre.setText(evenement.getTitre());
        viewHolder.description.setText(evenement.getDescription().substring(0, 100) +"...");

        return convertView;
    }

    private class EvenementViewHolder{
        public TextView titre;
        public TextView description;
    }
}
