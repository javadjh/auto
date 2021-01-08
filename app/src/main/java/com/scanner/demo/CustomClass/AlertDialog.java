package com.scanner.demo.CustomClass;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;
import android.widget.TextView;

import com.scanner.demo.R;

import java.util.Objects;

public class AlertDialog {
    public static void showAlertDialog(Context context, String title, String description){
        Dialog dialog = new Dialog(context);
        dialog.setContentView(R.layout.dialog_alert);
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(Objects.requireNonNull(dialog.getWindow()).getAttributes());
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        TextView titleAlertDialog = dialog.findViewById(R.id.titleAlertDialog);
        TextView descriptionAlertDialog = dialog.findViewById(R.id.descriptionAlertDialog);
        TextView doneButtonAlertDialog = dialog.findViewById(R.id.doneButtonAlertDialog);
        doneButtonAlertDialog.setOnClickListener(View -> dialog.dismiss());
        titleAlertDialog.setText(title);
        descriptionAlertDialog.setText(description);
        dialog.show();
        dialog.getWindow().setAttributes(lp);
    }
}
