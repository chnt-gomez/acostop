package oom.pocket.acostop.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import oom.pocket.acostop.R;

/**
 * Created by MAV1GA on 29/08/2017.
 */

public class DialogBuilder {

    public static Dialog newLoadingDialog(final Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View dialogView = inflater.inflate(R.layout.dialog_loading, null);
        builder.setView(dialogView);
        final TextView tvTips = (TextView)dialogView.findViewById(R.id.tv_tip);
        tvTips.setText(context.getString(R.string.calculando));
        return builder.create();
    }

}
