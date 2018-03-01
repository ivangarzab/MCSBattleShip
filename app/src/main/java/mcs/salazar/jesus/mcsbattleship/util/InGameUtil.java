package mcs.salazar.jesus.mcsbattleship.util;

import android.content.Context;
import android.view.View;

import mcs.salazar.jesus.mcsbattleship.model.Battlefield;
import mcs.salazar.jesus.mcsbattleship.model.Model;
import mcs.salazar.jesus.mcsbattleship.view.BattlefieldView;
import mcs.salazar.jesus.mcsbattleship.view.BattleshipView;
import mcs.salazar.jesus.mcsbattleship.view.MVVMView;
import mcs.salazar.jesus.mcsbattleship.viewmodel.BattlefieldViewModel;

/**
 * Created by Ivan on 2/28/2018
 */
public class InGameUtil {

    public static void bindSession(Model model, MVVMView view) {

    }

    public static void bindBattlefield(Context context, Battlefield model, BattlefieldView view) {
        BattlefieldViewModel viewModel = new BattlefieldViewModel(context, model);

        view.setAdapter(viewModel.getAdapter());
        view.setFieldSize(viewModel.getFieldSize());
    }

    public static void bindBattleship(Model model, BattleshipView view) {

    }
}
