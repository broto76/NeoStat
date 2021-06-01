package com.broto.neostat.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.broto.neostat.R;
import com.broto.neostat.fragments.InputFragment;
import com.broto.neostat.fragments.InputFragmentListener;
import com.broto.neostat.fragments.ResultFragment;
import com.broto.neostat.models.ResultModel;
import com.broto.neostat.utility.Constants;
import com.broto.neostat.viewmodels.MainViewModel;

public class MainActivity extends AppCompatActivity implements InputFragmentListener {

    private MainViewModel viewModel;

    private Dialog mDialog;

    private final BroadcastReceiver mNetworkFailureReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String message = intent.getStringExtra(Constants.REMOTE_DATA_FETCH_ERROR_MESSAGE);
            dismissProgressDialog();
            Toast.makeText(
                    MainActivity.this,
                    "Cannot fetch results. Error: " + message,
                    Toast.LENGTH_LONG
            ).show();
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        attachInputFragment();

        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        viewModel.getSummaryLiveData().observe(this, resultData -> {
            replaceWithResultFragment(resultData);
            dismissProgressDialog();
        });

        getApplicationContext().registerReceiver(
                mNetworkFailureReceiver,
                new IntentFilter(Constants.INTENT_REMOTE_DATA_FETCH_ERROR)
        );
    }

    private void attachInputFragment() {
        InputFragment fragment = new InputFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.main_root, fragment, "inputFragment")
                .commit();
    }

    private void replaceWithResultFragment(ResultModel data) {
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constants.KEY_RESULT_DATA, data);
        ResultFragment fragment = new ResultFragment();
        fragment.setArguments(bundle);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.main_root, fragment, "resultFragment")
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onSubmit(String start, String end) {
        Log.d("MainActivivity", "onSubmit");
        showProgressDialog();
        viewModel.fetchAsteroidData(start, end);
    }

    private void showProgressDialog() {
        mDialog = new Dialog(this);
        mDialog.setContentView(R.layout.progress_dialog_layout);
        mDialog.setCancelable(false);
        mDialog.show();
    }

    private void dismissProgressDialog() {
        if (mDialog != null && mDialog.isShowing()) {
            mDialog.dismiss();
            mDialog = null;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        getApplicationContext().unregisterReceiver(mNetworkFailureReceiver);
    }
}