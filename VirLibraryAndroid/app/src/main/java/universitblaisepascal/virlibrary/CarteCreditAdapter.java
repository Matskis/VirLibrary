package universitblaisepascal.virlibrary;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Cyril on 14/03/2016.
 */
public class CarteCreditAdapter extends ArrayAdapter<CarteBanquaire> {

    //livre est la liste des models à afficher
    public CarteCreditAdapter(Context context, List<CarteBanquaire> tweets) {
        super(context, 0, tweets);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.carte_banquaire_fragment,parent, false);
        }

        CarteBanquaireViewHolder viewHolder = (CarteBanquaireViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CarteBanquaireViewHolder();
            viewHolder.proprio = (TextView) convertView.findViewById(R.id.textViewProprioCarteBanquaireFragment);
            viewHolder.numeroCarte = (TextView) convertView.findViewById(R.id.textViewNumCompteCarteBanquaireFragment);
            viewHolder.datePeremption = (TextView) convertView.findViewById(R.id.textViewDateCarteBanquaireFragment);
            viewHolder.typeCarte = (TextView) convertView.findViewById(R.id.textViewTypeCarteBancaireCoordBancaire);
            viewHolder.codeSecu = (TextView) convertView.findViewById(R.id.textViewCodeSecuCoordBancaire);
            convertView.setTag(viewHolder);
        }

        //getItem(position) va récupérer l'item [position] de la List<Tweet> tweets
        CarteBanquaire carteBanquaire = getItem(position);

        //il ne reste plus qu'à remplir notre vue
        viewHolder.proprio.setText(carteBanquaire.getProprietaire());
        viewHolder.numeroCarte.setText(carteBanquaire.getNumeroCarte().substring(0, 3) +"***********" + carteBanquaire.getNumeroCarte().substring(13, 15));
        viewHolder.datePeremption.setText(carteBanquaire.getDateValidite());
        viewHolder.typeCarte.setText(carteBanquaire.getTypeCarte());
        viewHolder.codeSecu.setText(Integer.toString(carteBanquaire.getCodeSecu()));

        return convertView;
    }

    private class CarteBanquaireViewHolder{
        public TextView proprio;
        public TextView numeroCarte;
        public TextView datePeremption;
        public TextView codeSecu;
        public TextView typeCarte;
    }
}
