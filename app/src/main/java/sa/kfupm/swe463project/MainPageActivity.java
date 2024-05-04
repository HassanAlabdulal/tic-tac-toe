package sa.kfupm.swe463project;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.widget.TextView;

public class MainPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);

        TextView textView = findViewById(R.id.textViewWelcome);

        Shader redToOrange = new LinearGradient(0, 0, 0, textView.getTextSize(),
                new int[]{Color.parseColor("#F44336"), Color.parseColor("#FFC107")},
                null, Shader.TileMode.CLAMP);
        textView.getPaint().setShader(redToOrange);
    }
}
