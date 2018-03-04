package mcs.salazar.jesus.mcsbattleship.util;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import mcs.salazar.jesus.mcsbattleship.R;
import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldInGameOpponentViewModel;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldInGamePlayerViewModel;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldViewModel;
import mcs.salazar.jesus.mcsbattleship.viewmodel.InGameActionsViewModel;

/**
 * Created by Ivan on 2/28/2018
 */
public class InGameUtil {

    public static void bindPlayerBattlefield(Context context, Battlefield model, BattlefieldView view) {
        BattlefieldViewModel viewModel = new BattlefieldInGamePlayerViewModel(context, model);
        view.setAdapter(viewModel.getAdapter());
        view.setFieldSize(viewModel.getFieldSize());
    }

    public static void bindOpponentBattlefield(Context context, Battlefield model, BattlefieldView view) {
        BattlefieldInGameOpponentViewModel viewModel = new BattlefieldInGameOpponentViewModel(context, model);
        view.setAdapter(viewModel.getAdapter());
        view.setOnItemClickListener(viewModel.getItemClickListener());
        view.setFieldSize(viewModel.getFieldSize());
    }

    public static void bindInGameActions(Context context, ViewGroup parent) {
        InGameActionsViewModel viewModel = new InGameActionsViewModel(context);
        for (int i = 0; i < parent.getChildCount(); i++) {
            View child = parent.getChildAt(i);
            switch(child.getId()) {
                case R.id.game_action_chat_button:
                    child.setOnClickListener(viewModel.getChatClickListener());
                    break;
                case R.id.game_action_pause_button:
                    child.setOnClickListener(viewModel.getPauseClickLisntener());
                    break;
                case R.id.game_action_surrender_button:
                    child.setOnClickListener(viewModel.getSurrenderClickListener());
                    break;
                case R.id.game_action_settings_button:
                    child.setOnClickListener(viewModel.getSettingsClickListener());
                    break;
            }
        }
    }
}
