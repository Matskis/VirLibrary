package universitblaisepascal.virlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyril on 11/03/2016.
 */
public class CommentaireVueLivreAdapter extends ArrayAdapter<Commentaire> {

//livre est la liste des models à afficher
public CommentaireVueLivreAdapter(Context context, List<Commentaire> tweets) {
        super(context, 0, tweets);
        }

@Override
public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
        convertView = LayoutInflater.from(getContext()).inflate(R.layout.commentaire_fragment,parent, false);
        }

        EvenementViewHolder viewHolder = (EvenementViewHolder) convertView.getTag();
        if(viewHolder == null){
        viewHolder = new EvenementViewHolder();
        viewHolder.titre = (TextView) convertView.findViewById(R.id.titre_commentaire_vue_livre_fragment);
        viewHolder.text = (TextView) convertView.findViewById(R.id.txtPrixAjoutLivreFinal);
        viewHolder.date = (TextView) convertView.findViewById(R.id.textViewDateCommentaireVueLivreFragment);
        viewHolder.pseudo = (TextView) convertView.findViewById(R.id.idUserCommentaireVueLivreFragment);
        convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Commentaire commentaire = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.text.setText(commentaire.getText());
        viewHolder.titre.setText(commentaire.getTitre());
        viewHolder.date.setText(commentaire.getDate());
        viewHolder.pseudo.setText(commentaire.getPseudo());
        return convertView;
        }

private class EvenementViewHolder{
    public TextView text;
    public TextView titre;
    public TextView date;
    public TextView pseudo;
}
}