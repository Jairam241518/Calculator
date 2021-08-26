package com.jairam.calculator;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class OutputFragment extends Fragment {

    private Button clear ;
    private TextView output;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.output_fragment, container, false);

        output = v.findViewById(R.id.outputAns);

        clear = v.findViewById(R.id.clearOutput);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                output.setText("");
            }
        });

        return v;
    }

    public void updateTextView(CharSequence outputText){
        output.setText(outputText);
    }


}
