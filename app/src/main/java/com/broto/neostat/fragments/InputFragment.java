package com.broto.neostat.fragments;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.EditText;

import com.broto.neostat.R;
import com.broto.neostat.activities.MainActivity;
import com.broto.neostat.databinding.FragmentInputBinding;
import com.broto.neostat.utility.Constants;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class InputFragment extends Fragment implements View.OnClickListener {

    private FragmentInputBinding binding = null;
    private InputFragmentListener listener;

    private String mStartDate;
    private String mEndDate;

    private Long mStartDateRaw;
    private Long mEndDateRaw;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof MainActivity) {
            listener = (InputFragmentListener) context;
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Log.d("Input","onCreateView");

        binding = FragmentInputBinding.inflate(inflater, container, false);

        binding.btnSubmit.setOnClickListener(this);
        binding.etStartDate.setOnClickListener(this);
        binding.etEndDate.setOnClickListener(this);

        return binding.getRoot();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        binding = null;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_submit:
                boolean result = verifyDateRangeLimit();
                Log.d("Input","Validation: " + result);
                if (listener == null) {
                    return;
                }
                if (!isNetworkConnectionAvailable()) {
                    Snackbar.make(binding.getRoot(),
                            "No Internet", Snackbar.LENGTH_SHORT).show();
                    return;
                }
                if (result) {
                    listener.onSubmit(mStartDate, mEndDate);
                } else {
                    Snackbar.make(binding.getRoot(),
                            "Invalid Input", Snackbar.LENGTH_SHORT).show();
                }
                break;
            case R.id.et_start_date:
                    showDatePickerDialog(binding.etStartDate, mStartDateRaw);
                break;
            case R.id.et_end_date:
                    showDatePickerDialog(binding.etEndDate, mEndDateRaw);
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        updateDateInView(binding.etStartDate, Calendar.getInstance());
        updateDateInView(binding.etEndDate, Calendar.getInstance());
    }

    private void updateDateInView(EditText et, Calendar calendar) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());
        if (et.getId() == R.id.et_end_date) {
            mEndDate = sdf.format(calendar.getTime());
            mEndDateRaw = calendar.getTimeInMillis();
            et.setText(mEndDate);
        } else {
            mStartDate = sdf.format(calendar.getTime());
            mStartDateRaw = calendar.getTimeInMillis();
            et.setText(mStartDate);
        }
    }

    private void showDatePickerDialog(EditText et, Long rawTime) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(rawTime);
        new DatePickerDialog(getContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                calendar.set(Calendar.YEAR, year);
                calendar.set(Calendar.MONTH, month);
                calendar.set(Calendar.DAY_OF_MONTH, day);
                updateDateInView(et, calendar);
            }
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private boolean verifyDateRangeLimit() {
        if (mStartDateRaw > mEndDateRaw) {
            updateDateInView(binding.etStartDate, Calendar.getInstance());
            updateDateInView(binding.etEndDate, Calendar.getInstance());
            return false;
        } else if ((mEndDateRaw - mStartDateRaw) > Constants.DAYS_LIMIT) {
            updateDateInView(binding.etStartDate, Calendar.getInstance());
            updateDateInView(binding.etEndDate, Calendar.getInstance());
            return false;
        }
        return true;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private boolean isNetworkConnectionAvailable() {
        ConnectivityManager manager = (ConnectivityManager)
                getContext().getSystemService(Context.CONNECTIVITY_SERVICE);
        Network network = manager.getActiveNetwork();
        if (network == null) {
            return false;
        }

        return (
                manager.getNetworkCapabilities(network).hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
                        manager.getNetworkCapabilities(network).hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        );
    }
}