package com.example.sendmessageviewbinding;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.danielstone.materialaboutlibrary.MaterialAboutActivity;
import com.danielstone.materialaboutlibrary.items.MaterialAboutActionItem;
import com.danielstone.materialaboutlibrary.items.MaterialAboutTitleItem;
import com.danielstone.materialaboutlibrary.model.MaterialAboutCard;
import com.danielstone.materialaboutlibrary.model.MaterialAboutList;
/**
 * Clase AboutActivity que define la activity Sobre mi
 *
 * @author: David Zambrana Romero
 * @version: 1.0
 */
public class AboutActivity extends MaterialAboutActivity {
    @Override
    @NonNull
    protected MaterialAboutList getMaterialAboutList(@NonNull Context context) {
        MaterialAboutCard card = new MaterialAboutCard.Builder()
                // Configure card here
                .title("Autor")
                .addItem(new MaterialAboutActionItem.Builder()
                        .text("David Zambrana Romero")
                        .subText("Alumno de 2ºDAM")
                        .icon(R.drawable.ic_action_person)

                        .build())
                .addItem(new MaterialAboutActionItem.Builder()
                        .text("Mi página de GitHub")
                        .icon(R.drawable.ic_action_web)
                        .setOnClickAction(() -> {
                            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTY-Q5P6h_RTn8pOrlATMLud8PdrY6KkwMT7rOEjvSvhSjaLmnQWhbv7CgoUuunQz5nGYA&usqp=CAU"));
                            startActivity(intent);
                        })
                        .build())
                .build();
        MaterialAboutCard card2 = new MaterialAboutCard.Builder()

                .addItem(new MaterialAboutActionItem.Builder()
                        .text("Version")
                        .subText("1.0.0")
                        .icon(R.drawable.ic_action_info)
                        .build())
                .build();

        return new MaterialAboutList.Builder()
                .addCard(card)
                .addCard(card2)
                .build(); // This creates an empty screen, add cards with .addCard()
    }

    @Override
    protected CharSequence getActivityTitle() {
        return getString(R.string.mal_title_about);
    }
}
