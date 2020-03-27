package com.example.hradvance.Utils;

import android.app.Dialog;
import android.content.Context;

import com.example.hradvance.Dialog.DialogValidation;

import java.util.ArrayList;

public class Utilities {

    static Context context;

    private static Utilities singleton = null;
    private Utilities() {

    }


//    / Static 'instance' method /
    public static Utilities getInstance(Context mContext) {
        context = mContext;
        if (singleton == null)
            singleton = new Utilities();
        return singleton;
    }

    Dialog dialogValidation;

    public void dialogValidation(Context context, ArrayList<String> messages) {
        if (dialogValidation != null && dialogValidation.isShowing())
            dialogValidation.dismiss();
        dialogValidation = new DialogValidation(context, messages);
        dialogValidation.show();
    }
}
