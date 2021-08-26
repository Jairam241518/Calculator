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

public class InputFragment extends Fragment {

    private Button one,two,three,four,five,six,seven,eight,nine,zero;
    private Button add, sub, mul, div, mod, equ, clear;
    private TextView inputText;
    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';
    private final char PERCENTAGE = '%';
    private final char EQUAL = 0;
    private double val1 = Double.NaN;
    private double val2;
    private char ACTION;
    private InputFragmentListener inputFragmentListener;

    public String result;


    public interface InputFragmentListener{
        void onInputBSent(CharSequence input);
    }



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.input_fragment, container, false);

        inputText = v.findViewById(R.id.inputText);

        one = v.findViewById(R.id.btn1);
        two = v.findViewById(R.id.btn2);
        three = v.findViewById(R.id.btn3);
        four = v.findViewById(R.id.btn4);
        five = v.findViewById(R.id.btn5);
        six = v.findViewById(R.id.btn6);
        seven = v.findViewById(R.id.btn7);
        eight = v.findViewById(R.id.btn8);
        nine = v.findViewById(R.id.btn9);
        zero = v.findViewById(R.id.btn0);

        add = v.findViewById(R.id.plus);
        sub = v.findViewById(R.id.minus);
        mul = v.findViewById(R.id.divide);
        div = v.findViewById(R.id.multiply);
        equ = v.findViewById(R.id.equalto);
        mod = v.findViewById(R.id.modulus);
        clear = v.findViewById(R.id.clear);

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputText.setText(inputText.getText().toString() + "9");
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = ADDITION;
                result = String.valueOf(val1) + " + ";
                inputFragmentListener.onInputBSent(result);

                inputText.setText(null);




            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = SUBTRACTION;
                result = String.valueOf(val1) + " - ";
                inputFragmentListener.onInputBSent(result);

                inputText.setText(null);

            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = MULTIPLICATION;
                result = String.valueOf(val1) + " * ";
                inputFragmentListener.onInputBSent(result);

                inputText.setText(null);

            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = DIVISION;
                result = String.valueOf(val1) + " / ";
                inputFragmentListener.onInputBSent(result);

                inputText.setText(null);

            }
        });
        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = PERCENTAGE;
                result = String.valueOf(val1) + " % ";
                inputFragmentListener.onInputBSent(result);

                inputText.setText(null);

            }
        });

        equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                compute();
                ACTION = EQUAL;
                result = "=" + String.valueOf(val1);
                inputFragmentListener.onInputBSent(result);
                inputText.setText("");

            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (inputText.getText().length() > 0 ){
                    CharSequence name  = inputText.getText().toString();
                    inputText.setText(name.subSequence(0, name.length()-1));

                }else {
                    val1 = Double.NaN;
                    val2 = Double.NaN;
                    inputText.setText(null);
                }

            }
        });

        return v;
    }

    private void compute(){
        if (!Double.isNaN(val1)){

            val2 = Double.parseDouble(inputText.getText().toString());

            switch (ACTION){

                case ADDITION:{

                    val1 = val1 + val2;
                    break;

                }
                case SUBTRACTION:{

                    val1 = val1 - val2;
                    break;

                }
                case MULTIPLICATION:{

                    val1 = val1 * val2;
                    break;

                }
                case DIVISION:{

                    val1 = val1 / val2;
                    break;

                }
                case PERCENTAGE:{

                    val1 = (val1/val2)*100;
                    break;

                }
                case EQUAL:{
                    break;
                }

            }


        }
        else {
            val1 = Double.parseDouble(inputText.getText().toString());
        }
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof InputFragmentListener){

            inputFragmentListener = (InputFragmentListener) context;

        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        inputFragmentListener = null;
    }


}
