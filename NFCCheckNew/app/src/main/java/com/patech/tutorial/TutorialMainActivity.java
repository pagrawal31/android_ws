package com.patech.tutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.patech.nfccheck.nfccheck.AdMobUtility;
import com.patech.nfccheck.nfccheck.BaseActivity;
import com.patech.nfccheck.nfccheck.R;
import com.patech.tutorial.adapter.ChapterItemAdapter;
import com.patech.utils.AppUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import androidx.appcompat.widget.Toolbar;
import butterknife.BindView;
import butterknife.ButterKnife;

public class TutorialMainActivity extends BaseActivity
        implements AdapterView.OnItemClickListener {

    private ListView listOfChapters;
    private List<String> chapters = Collections.EMPTY_LIST;

    @BindView(R.id.toolbar) Toolbar toolbar;
//    @BindView(R.id.webView) WebView webHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_layout);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        try {
            chapters = Arrays.asList(listAssetFiles(TutorialUtils.PATH_IN_ASSESTS_DIR));
        } catch(IOException ioe) {

        }

        listOfChapters = findViewById(R.id.listOfChapters);
        ListAdapter adapter = new ChapterItemAdapter(this, chapters);
        listOfChapters.setAdapter(adapter);
        listOfChapters.setOnItemClickListener(this);
    }

    public String[] listAssetFiles(String path) throws IOException {
        return getAssets().list(path);

//        String [] list;
//        try {
//            list = getAssets().list(path);
//            if (list.length > 0) {
//                // This is a folder
//                for (String file : list) {
//                    if (!listAssetFiles(path + "/" + file))
//                        return false;
//                    else {
//                        // This is a file
//                        // TODO: add file name to an array list
//                    }
//                }
//            }
//        } catch (IOException e) {
//            return false;
//        }
//
//        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//        Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        String path = chapters.get(position);
        Intent showTutorialIntent = new Intent(getApplicationContext(), ChapterActivity.class);
        showTutorialIntent.putExtra(AppUtils.PATH, path);
        startActivity(showTutorialIntent);
    }
}
