package com.example.complete;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edHoTen;
    private AutoCompleteTextView Quequan;
    private MultiAutoCompleteTextView mtSecondLanguage;
    private Button btnSubmit;

    private String[] quequan =
            {"An Giang", "Bà Rịa - Vũng Tàu", "Bắc Giang", "Bắc Kạn", "Bạc Liêu","Bắc Ninh","Bến Tre","Bình Định","Bình Dương","Bình Phước","Bình Thuận",
            "Cà Mau", "Cao Bằng", "Đắk Lắk", "Đắk Nông", "Điện Biên","Đồng Nai","Đồng Tháp","Gia Lai","Hà Giang","Hà Nam","Hà Tĩnh"
            ,"Hải Dương","Hậu Giang","Hòa Bình","Hưng Yên","Khánh Hòa","Kiên Giang","Kon Tum","Lai Châu","Lâm Đồng","Lạng Sơn","Lào Cai","Long An","Nam Định","Nghệ An","Ninh Bình","Ninh Thuận","Phú Thọ"
            , "Quảng Bình", "Quảng Nam", "Quảng Ngãi", "Quảng Ninh", "Quảng Trị", "Sóc Trăng", "Sơn La", "Tây Ninh", "Thái Bình", "Thái Nguyên", "Thanh Hóa", "Thừa Thiên Huế", "Tiền Giang", "Trà Vinh",
            "Tuyên Quang", "Vĩnh Long", "Vĩnh Phúc", "Yên Bái", "Phú Yên", "Cần Thơ", "Đà Nẵng", "Hải Phòng", "Hà Nội", "TP HCM",
            };
    private String[] secondLanguage = {"Java", "CSharp", "JavaScript", "Swift", "C/C++"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edHoTen = (EditText) findVieById(R.id.edHoTen);
        Quequan = (AutoCompleteTextView) findViewById(R.id.address);
        mtSecondLanguage = (MultiAutoCompleteTextView) findViewById(R.id.mtSecondLanguage);
        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        ArrayAdapter adapterPrimaryLanguage = new ArrayAdapter(this, android.R.layout.simple_list_item_1, quequan);
        Quequan.setAdapter(adapterPrimaryLanguage);

        // Sét đặt số ký tự nhỏ nhất, để cửa sổ gợi ý hiển thị
        Quequan.setThreshold(1);



        ArrayAdapter adapterSecondLanguage = new ArrayAdapter(this, android.R.layout.simple_list_item_1, secondLanguage);
        mtSecondLanguage.setAdapter(adapterSecondLanguage);

        // Sét đặt số ký tự nhỏ nhất, để cửa sổ gợi ý hiển thị
        mtSecondLanguage.setThreshold(1);

        // Các đoạn text ngăn cách nhau bởi dấu phẩy.
        mtSecondLanguage.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        btnSubmit.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String text = "Họ tên: " + this.edHoTen.getText().toString()
                + "\nQuê quán hiện tại " + this.Quequan.getText().toString()
                + "\nNgôn LT ngữ chính: " + this.mtSecondLanguage.getText().toString();

        Toast.makeText(this, text, Toast.LENGTH_LONG).show();
    }
}
