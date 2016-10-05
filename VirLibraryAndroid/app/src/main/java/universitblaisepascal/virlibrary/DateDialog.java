package universitblaisepascal.virlibrary;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Cyril on 02/03/2016.
 */
public class DateDialog extends DialogFragment implements DatePickerDialog.OnDateSetListener {

    EditText txtDate;
    public DateDialog(View view){
        txtDate = (EditText)view;
    }

    public DateDialog(){

    }

    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        int mois = c.get(Calendar.MONTH);
        int day = c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, mois, day);
    }

    public void onDateSet(DatePicker view , int year, int mois, int day){
        String date = day+"-"+(mois+1)+"-"+year;
        txtDate.setText(date);
    }
}
