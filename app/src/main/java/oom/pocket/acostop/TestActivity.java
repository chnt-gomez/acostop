package oom.pocket.acostop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.R.attr.checked;
import static android.R.attr.start;

public class TestActivity extends AppCompatActivity {

    private int mediumViolenceLevel;
    private int highViolenceLevel;
    private int lowViolenceLevel;
    ProgressBar bar;
    CheckBox[] box_1;
    CheckBox[] box_2;
    CheckBox[] box_3;
    TextView tvRecomendation;
    Button helpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        init();
    }

    private void init(){
        helpButton = (Button)findViewById(R.id.btn_help);
        helpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TestActivity.this, HelpActivity.class);
                startActivity(intent);

            }
        });
        bar = (ProgressBar)findViewById(R.id.progressBar);
        tvRecomendation = (TextView)findViewById(R.id.tv_results) ;
        box_1 = new CheckBox[] {
                (CheckBox)findViewById(R.id._pt1_bromas),
                (CheckBox)findViewById(R.id._pt1_celos),
                (CheckBox)findViewById(R.id._pt1_chantaje),
                (CheckBox)findViewById(R.id._pt1_controlar),
                (CheckBox)findViewById(R.id._pt1_culpabilizar),
                (CheckBox)findViewById(R.id._pt1_descalificar),
                (CheckBox)findViewById(R.id._pt1_hielo),
                (CheckBox)findViewById(R.id._pt1_humillar),
                (CheckBox)findViewById(R.id._pt1_intimidar),
                (CheckBox)findViewById(R.id._pt1_ridiculizar)
        };

        box_2 = new CheckBox[]{
                (CheckBox)findViewById(R.id._pt2_cachetear),
                (CheckBox)findViewById(R.id._pt2_caricias_agresivas),
                (CheckBox)findViewById(R.id._pt2_destruir),
                (CheckBox)findViewById(R.id._pt2_golpear_jugando),
                (CheckBox)findViewById(R.id._pt2_manosear),
                (CheckBox)findViewById(R.id._pt2_encerrado),
                (CheckBox)findViewById(R.id._pt2_empujar),
                (CheckBox)findViewById(R.id._pt2_patear),
                (CheckBox)findViewById(R.id._pt2_pellizcar),
        };

        box_3 = new CheckBox[]{
                (CheckBox)findViewById(R.id._pt3_abuso_sexual),
                (CheckBox)findViewById(R.id._pt3_amenazar_muerte),
                (CheckBox)findViewById(R.id._pt3_amenazar_objetos),
                (CheckBox)findViewById(R.id._pt3_asesinar),
                (CheckBox)findViewById(R.id._pt3_forzar_relacion),
                (CheckBox)findViewById(R.id._pt3_mutilar),
                (CheckBox)findViewById(R.id._pt3_violacion)
        };


        setSmallPoints();
        setMediumPoints();
        setBigPoints();

    }

    private void setBigPoints() {
        for (CheckBox ch : box_3){
            ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){

                        highViolenceLevel++;
                    }else{

                        highViolenceLevel--;
                    }
                    updateViolenceLevel();
                }
            });

        }
    }

    private void updateViolenceLevel() {

        if (mediumViolenceLevel <= 0 && highViolenceLevel <= 0){
            bar.setProgress(lowViolenceLevel);
        }
        if (mediumViolenceLevel > 0 && highViolenceLevel <= 0){
            bar.setProgress(11 + mediumViolenceLevel);
        }
        if (highViolenceLevel > 0){
            bar.setProgress(21 + highViolenceLevel);
        }

        int results = bar.getProgress();

        if (results == 0){
            tvRecomendation.setText(R.string.results_excellent);
        }
        if (results > 0 && results < 12){
            tvRecomendation.setText(R.string.results_low_violence);
        }
        if (results > 11 && results < 22){
            tvRecomendation.setText(R.string.results_medium_violence);
        }
        if (results > 21){
            tvRecomendation.setText(R.string.results_high_violence);
        }


    }

    private void setMediumPoints() {
        for (CheckBox ch : box_2){
            ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {

                        mediumViolenceLevel ++;
                    }
                    else {

                        mediumViolenceLevel --;
                    }
                    updateViolenceLevel();
                }
            });

        }
    }

    private void setSmallPoints() {
        for (CheckBox ch : box_1){
            ch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if (isChecked) {

                        lowViolenceLevel++;
                    }
                    else {

                        lowViolenceLevel--;
                    }
                    updateViolenceLevel();
                }
            });

        }
    }
}
