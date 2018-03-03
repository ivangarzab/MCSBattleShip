package mcs.salazar.jesus.mcsbattleship.util;

import android.content.Context;

import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldInGameOpponentViewModel;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldInGamePlayerViewModel;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldViewModel;

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
}
