package com.srsofttech.studentcare.show_home_task;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.srsofttech.studentcare.R;
import com.srsofttech.studentcare.dashboard_activities.HomeTaskActivity;

import java.util.ResourceBundle;
import java.util.UUID;

public class HomeTaskViewActivity extends AppCompatActivity {

    ImageView backPage;
    private Button buttonChoose;
    private Button buttonUpload;
    private EditText editText;
    private int PICK_PDF_REQUEST = 1;
    private Uri filePath;

    //storage permission code
    private static final int STORAGE_PERMISSION_CODE = 123;

//    public Resources res = getResources();
//    private static ResourceBundle res;
   // public static final String UPLOAD_URL =(R.string.api_url) + "/api/home-task";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_task_view);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        backPage = findViewById(R.id.backPageId);
        //backPage.setOnClickListener(this);

/*
       // Toast.makeText(this,UPLOAD_URL,Toast.LENGTH_LONG).show();

            //Requesting storage permission
            requestStoragePermission();

            //Initializing views
            buttonChoose = findViewById(R.id.buttonChoose);
            buttonUpload = findViewById(R.id.buttonUpload);

            editText = findViewById(R.id.editTextName);

            //Setting clicklistener
            buttonChoose.setOnClickListener(this);
            buttonUpload.setOnClickListener(this);


        }




         // This is the method responsible for pdf upload
         // We need the full pdf path and the name for the pdf in this method


        public void uploadMultipart() {
            //getting name for the image
            String name = editText.getText().toString().trim();

            //getting the actual path of the image
            String path = FilePath.getPath(this, filePath);

            if (path == null) {

                Toast.makeText(this, "Please move your .pdf file to internal storage and retry", Toast.LENGTH_LONG).show();
            } else {
                //Uploading code
                try {

                    String uploadId = UUID.randomUUID().toString();

                    //Creating a multi part request
                    new MultipartUploadRequest(this, uploadId, UPLOAD_URL)
                            .addFileToUpload(path, "pdf") //Adding file
                            .addParameter("name", name) //Adding text parameter to the request
                            .setNotificationConfig(new UploadNotificationConfig())
                            .setMaxRetries(2)
                            .startUpload(); //Starting the upload

                } catch (Exception exc) {
                    Toast.makeText(this, exc.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        }


        //method to show file chooser
        private void showFileChooser() {
            Intent intent = new Intent();
            intent.setType("application/pdf");
            intent.setAction(Intent.ACTION_GET_CONTENT);
            startActivityForResult(Intent.createChooser(intent, "Select Pdf"), PICK_PDF_REQUEST);
        }

        //handling the image chooser activity result
        @Override
        protected void onActivityResult(int requestCode, int resultCode, Intent data) {
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == PICK_PDF_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
                filePath = data.getData();
            }
        }


        //Requesting permission
        private void requestStoragePermission() {
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED)
                return;

            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.READ_EXTERNAL_STORAGE)) {
                //If the user has denied the permission previously your code will come to this block
                //Here you can explain why you need this permission
                //Explain here why you need this permission
            }
            //And finally ask for the permission
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, STORAGE_PERMISSION_CODE);
        }


        //This method will be called when the user will tap on allow or deny
        @Override
        public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

            //Checking the request code of our request
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            if (requestCode == STORAGE_PERMISSION_CODE) {

                //If permission is granted
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Displaying a toast
                    Toast.makeText(this, "Permission granted now you can read the storage", Toast.LENGTH_LONG).show();
                } else {
                    //Displaying another toast if permission is not granted
                    Toast.makeText(this, "Oops you just denied the permission", Toast.LENGTH_LONG).show();
                }
            }
        }




    @Override
    public void onClick(View view) {
        if(view.getId()==R.id.backPageId){
            finish();
            Intent intent = new Intent(getApplicationContext(), HomeTaskActivity.class);
            intent.putExtra("EXTRA", "openHomeFragment");
            startActivity(intent);
            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        }
        if (view.getId()==(R.id.buttonChoose)) {
            showFileChooser();
        }
        if (view.getId() == R.id.buttonUpload) {

            try {
                uploadMultipart();
            }
            catch (Exception e)
            {
                Toast.makeText(getApplicationContext(),"Please upload a pdf file",Toast.LENGTH_LONG).show();

            }

        }

 */


    }
    @Override
    public void onBackPressed() {
        finish();
        Intent intent = new Intent(HomeTaskViewActivity.this, HomeTaskActivity.class);
        intent.putExtra("EXTRA", "openHomeFragment");
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

        super.onBackPressed();
    }
}