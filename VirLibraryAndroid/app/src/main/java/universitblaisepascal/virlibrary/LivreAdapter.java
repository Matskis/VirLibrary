package universitblaisepascal.virlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyril on 04/03/2016.
 */
public class LivreAdapter extends ArrayAdapter<Livre> {

    //livre est la liste des models à afficher
    public LivreAdapter(Context context, List<Livre> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.livre_fragment,parent, false);
        }

        LivreViewHolder viewHolder = (LivreViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new LivreViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.titre_commentaire_vue_livre_fragment);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.edition = (TextView) convertView.findViewById(R.id.edition_livre_fragment);
            viewHolder.prix = (TextView) convertView.findViewById(R.id.txtPrixAjoutLivreFinal);
            viewHolder.auteur = (TextView) convertView.findViewById(R.id.auteur_livre_fragment);
            viewHolder.isbn = (TextView) convertView.findViewById(R.id.isbn_livre_fragment);
            viewHolder.dateEdition = (TextView) convertView.findViewById(R.id.date_edition_livre_fragment);
            viewHolder.devise = (TextView) convertView.findViewById(R.id.textViewDeviseLivreFragment);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Livre livre = getItem(position);


        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(livre.getTitre());
        viewHolder.edition.setText(livre.getEdition());
        viewHolder.prix.setText(livre.getPrix());
        viewHolder.auteur.setText(livre.getAuteur());
        viewHolder.avatar.setImageBitmap(livre.getCouverture());

        viewHolder.isbn.setText("ISBN : " + livre.getISBN());
        viewHolder.dateEdition.setText(livre.getDateEdition());
        viewHolder.devise.setText(livre.getDevise());

        return convertView;
    }

    private class LivreViewHolder{
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
        public TextView edition;
        public TextView prix;
        public TextView auteur;
        public TextView isbn;
        public TextView dateEdition;
        public TextView devise;
    }
}
