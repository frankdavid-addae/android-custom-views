package com.example.androidcustomviews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class SignFormView extends LinearLayout {

    EditText etEmail;
    Button btnSubmit;

    OnSubmitButtonClicked onSubmitButtonClicked;

    public SignFormView(Context context) {
        super(context);
        init();
    }

    public SignFormView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SignFormView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        View view = LayoutInflater.from(getContext()).inflate(R.layout.sign_layout, this);
        etEmail = view.findViewById(R.id.etEmail);
        btnSubmit = view.findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onSubmitButtonClicked != null) {
                    onSubmitButtonClicked.onSubmitButtonClicked(etEmail.getText().toString());
                }
            }
        });
    }

    public void setOnSubmitButtonClicked(OnSubmitButtonClicked onSubmitButtonClicked) {
        this.onSubmitButtonClicked = onSubmitButtonClicked;
    }

    public interface OnSubmitButtonClicked {
        void onSubmitButtonClicked(String email);
    }
}
