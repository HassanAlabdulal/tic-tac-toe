package sa.kfupm.swe463project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.TextView;

public class VerifyOTPActivity extends AppCompatActivity {
    private EditText inputCode1, inputCode2, inputCode3, inputCode4, inputCode5, inputCode6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otpactivity);

        TextView textMobile = findViewById(R.id.textMobile);
        textMobile.setText(String.format("+966-%s", getIntent().getStringExtra("mobile")));

        inputCode1 = findViewById(R.id.inputCode1);
        inputCode2 = findViewById(R.id.inputCode2);
        inputCode3 = findViewById(R.id.inputCode3);
        inputCode4 = findViewById(R.id.inputCode4);
        inputCode5 = findViewById(R.id.inputCode5);
        inputCode6 = findViewById(R.id.inputCode6);

        setupOTPInputs();
    }

    private void setupOTPInputs() {
        inputCode1.addTextChangedListener(new GenericTextWatcher(inputCode1, inputCode2));
        inputCode2.addTextChangedListener(new GenericTextWatcher(inputCode2, inputCode3));
        inputCode3.addTextChangedListener(new GenericTextWatcher(inputCode3, inputCode4));
        inputCode4.addTextChangedListener(new GenericTextWatcher(inputCode4, inputCode5));
        inputCode5.addTextChangedListener(new GenericTextWatcher(inputCode5, inputCode6));
        inputCode6.addTextChangedListener(new GenericTextWatcher(inputCode6, null)); // No next EditText after the last one
    }

    class GenericTextWatcher implements TextWatcher {
        private EditText currentView;
        private EditText nextView;

        public GenericTextWatcher(EditText currentView, EditText nextView) {
            this.currentView = currentView;
            this.nextView = nextView;
        }

        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

        @Override
        public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
            String text = charSequence.toString();
            if (text.length() == 1 && nextView != null) {
                nextView.requestFocus();
            }
        }

        @Override
        public void afterTextChanged(Editable editable) {}
    }
}
