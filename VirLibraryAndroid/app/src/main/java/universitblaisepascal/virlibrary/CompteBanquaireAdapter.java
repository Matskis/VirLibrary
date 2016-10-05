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
 * Created by Cyril on 14/03/2016.
 */
public class CompteBanquaireAdapter extends ArrayAdapter<CompteBanquaire> {

    //livre est la liste des models à afficher
    public CompteBanquaireAdapter(Context context, List<CompteBanquaire> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.compte_banquaire_fragment, parent, false);
        }

        CompteBanquaireViewHolder viewHolder = (CompteBanquaireViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new CompteBanquaireViewHolder();
            viewHolder.proprio = (TextView) convertView.findViewById(R.id.textViewProprioCompteBanquaireFragment);
            viewHolder.numCompte = (TextView) convertView.findViewById(R.id.textViewNumCompteCompteBanquaireFragment);
            viewHolder.iban = (TextView) convertView.findViewById(R.id.textViewIBANCarteBanquaireFragment);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        CompteBanquaire compteBanquaire = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.proprio.setText(compteBanquaire.getProprio());
        viewHolder.numCompte.setText(Integer.toString(compteBanquaire.getNumeroCompte()));
        viewHolder.iban.setText(compteBanquaire.getIBAN());

        return convertView;
    }

    private class CompteBanquaireViewHolder {
        public TextView proprio;
        public TextView numCompte;
        public TextView iban;

    }
}