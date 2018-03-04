package mcs.salazar.jesus.mcsbattleship.viewmodel;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import mcs.salazar.jesus.mcsbattleship.activity.PlayerDashboardActivity;

/**
 * Created by Ivan on 3/3/2018
 */

public class InGameActionsViewModel implements MVVMViewModel {

    private Context mContext;

    public InGameActionsViewModel(Context context) {
        this.mContext = context;
    }

    public View.OnClickListener getChatClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "CHAT", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public View.OnClickListener getPauseClickLisntener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(mContext)
                        .setTitle("One Second...")
                        .setMessage("Would you like to save and exit this session?")
                        .setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                Intent intent = new Intent(mContext, PlayerDashboardActivity.class);
                                mContext.startActivity(intent);
                            }
                        })
                        .setNegativeButton("Back",new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,int id) {
                                dialog.cancel();
                            }
                        });
                alertDialogBuilder.create().show();
            }
        };
    }

    public View.OnClickListener getSurrenderClickListener() {
        Log.i("TRASH", "SURRENDER");
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "SURRENDER", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public View.OnClickListener getSettingsClickListener() {
        Log.i("TRASH", "SETTINGS");
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(), "SETTINGS", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
