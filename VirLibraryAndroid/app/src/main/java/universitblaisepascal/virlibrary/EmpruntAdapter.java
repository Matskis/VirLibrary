package universitblaisepascal.virlibrary;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import java.util.List;

/**
 * Created by Cyril on 09/03/2016.
 */
public class EmpruntAdapter extends ArrayAdapter<Emprunt> {

    //livre est la liste des models à afficher
    public EmpruntAdapter(Context context, List<Emprunt> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.emprunt_fragment, parent, false);
        }

        LivreViewHolder viewHolder = (LivreViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new LivreViewHolder();
            viewHolder.pseudo = (TextView) convertView.findViewById(R.id.titre_commentaire_vue_livre_fragment);
            viewHolder.avatar = (ImageView) convertView.findViewById(R.id.avatar);
            viewHolder.edition = (TextView) convertView.findViewById(R.id.edition_livre_fragment);
            viewHolder.prix = (TextView) convertView.findViewById(R.id.txtPrixAjoutLivreFinal);
            viewHolder.auteur = (TextView) convertView.findViewById(R.id.auteur_livre_fragment);
            viewHolder.isbn = (TextView) convertView.findViewById(R.id.isbn_livre_fragment);
            viewHolder.accepte = (Switch) convertView.findViewById(R.id.switchEmpruntAccepteFragmentEmprunt);
            convertView.setTag(viewHolder);
            viewHolder.preteur = (TextView) convertView.findViewById(R.id.textViewpreteurEmpruntFragment);
            viewHolder.dateDebut = (TextView) convertView.findViewById(R.id.textViewDateDebutEmpruntFragmentEmprunt);
            viewHolder.dateFin = (TextView) convertView.findViewById(R.id.textViewDateFinEmpruntFragmentEmprunt);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        Emprunt livre = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.pseudo.setText(livre.getLivres().getTitre());
        viewHolder.edition.setText(livre.getLivres().getEdition());
        viewHolder.prix.setText(livre.getLivres().getPrix() + " " + livre.getLivres().getDevise());
        viewHolder.auteur.setText(livre.getLivres().getPrix());
        viewHolder.auteur.setText(livre.getLivres().getISBN());
        viewHolder.avatar.setImageDrawable(new ColorDrawable(Color.GRAY));
        viewHolder.isbn.setText(livre.getLivres().getISBN());
        viewHolder.accepte.setChecked(livre.getEmpruntAccepte());
        viewHolder.accepte.setClickable(false);
        viewHolder.preteur.setText("");
        viewHolder.dateDebut.setText(livre.getDateDebut());
        viewHolder.dateFin.setText(livre.getDateFin());

        return convertView;
    }

    private class LivreViewHolder {
        public TextView pseudo;
        public TextView text;
        public ImageView avatar;
        public TextView edition;
        public TextView prix;
        public TextView auteur;
        public TextView isbn;
        public Switch accepte;
        public TextView preteur;
        public TextView dateDebut;
        public TextView dateFin;
    }
}
