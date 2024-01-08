package com.patech.nfccheck.nfccheck;

import android.content.Intent;
import android.net.Uri;
import android.nfc.NfcAdapter;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.view.Menu;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;
import com.patech.utils.AppConstants;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseActivity {

    NfcAdapter nfcAdapter;
    private AppBarConfiguration mAppBarConfiguration;
    @BindView(R.id.toolbar) Toolbar toolbar;
    @BindView(R.id.drawer_layout) DrawerLayout drawer;
    @BindView(R.id.nav_view) NavigationView navigationView;

    @BindView(R.id.changeNfcSettings) Button nfcSettingsChangeBtn;
    @BindView(R.id.phone_list_btn) Button nfcPhonesBtn;
    @BindView(R.id.nfc_read) Button nfcReadBtn;
    @BindView(R.id.displayTxt) TextView displayText;
    @BindView(R.id.adImageView) ImageView adImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
//        mAppBarConfiguration = new AppBarConfiguration.Builder(
//                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
//                .setDrawerLayout(drawer)
//                .build();
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
//        NavigationUI.setupWithNavController(navigationView, navController);

        nfcAdapter = NfcAdapter.getDefaultAdapter(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

//    @Override
//    public boolean onSupportNavigateUp() {
//        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
//        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
//                || super.onSupportNavigateUp();
//    }

    private void resetDisplay() {
        nfcSettingsChangeBtn.setVisibility(View.INVISIBLE);
        displayText.setText(R.string.nfcDisplayDefault);
    }

    @OnClick(R.id.knowNfc)
    void onClickKnowNfc(View view) {
        super.showTutorial();
    }

    @OnClick(R.id.nfc_read)
    void onClickNfcRead(View view) {
        super.startNfcTagRead();
    }

    @OnClick(R.id.phone_list_btn)
    void onClickNFCPhones(View view) {
        String url = "https://en.wikipedia.org/wiki/List_of_NFC-enabled_mobile_devices";
        Intent voterInfoIntent = new Intent(getApplicationContext(), WebviewActivity.class);
        voterInfoIntent.putExtra(AppConstants.WEBVIEW_URL, url);
        voterInfoIntent.putExtra(AppConstants.TITLE, getResources().getString(R.string.list_of_nfc_phones));
        startActivity(voterInfoIntent);

    }

    @OnClick(R.id.adImageView)
    void onClickAdImageView(View view) {
        String url = "https://www.facebook.com/Shweta-Art-Creations-110130290433731";
//        Intent voterInfoIntent = new Intent(getApplicationContext(), WebviewActivity.class);
//        voterInfoIntent.putExtra(AppConstants.WEBVIEW_URL, url);
//        voterInfoIntent.putExtra(AppConstants.TITLE, getResources().getString(R.string.list_of_nfc_phones));
//        startActivity(voterInfoIntent);

        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }

    @OnClick(R.id.nfcCheckBtn)
    void onClickNfcCheckBtn(View view) {
        if (nfcAdapter != null) {
            boolean isEnabled = nfcAdapter.isEnabled();
            String nfcEnabled = getResources().getString(R.string.enabled);
            String nfcDisabled = getResources().getString(R.string.disabled);
            String nfcStatus = getResources().getString(R.string.nfc_status);

            displayText.setText(nfcStatus + " " + (isEnabled ? nfcEnabled : nfcDisabled));
            nfcSettingsChangeBtn.setVisibility(View.VISIBLE);
            nfcReadBtn.setVisibility(View.VISIBLE);
        } else {
            displayText.setText(getResources().getString(R.string.nfc_not_supported));
        }
    }

    @OnClick(R.id.changeNfcSettings)
    void onclickNfcSettings(View view) {
        startActivity(new Intent(Settings.ACTION_NFC_SETTINGS));
    }

    @Override
    protected void onResume() {
        super.onResume();
        resetDisplay();
    }

}