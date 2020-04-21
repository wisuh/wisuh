package id.ac.umn.wisuh;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private TextView cobaDoang;
    public String email,pNumber,fName,lName;
    private ImageButton accountbtn, activitybtn, lovebtn, settingbtn, nearbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        BottomNavigationView bottomNav= findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();


//        accountbtn = findViewById(R.id.accountbtn);
//        activitybtn = findViewById(R.id.activitybtn);
//        lovebtn = findViewById(R.id.lovebtn);
//        settingbtn = findViewById(R.id.settingbtn);
//        nearbtn = findViewById(R.id.nearbybtn);

//        nearbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent pindahnear = new Intent(MainActivity.this, NearbyActivity.class);
//                startActivity(pindahnear);
//            }
//        });

//        cobaDoang = findViewById(R.id.awal);
        Intent intent = getIntent();
        email = intent.getStringExtra("email");
        pNumber = intent.getStringExtra("nomorHp");
        fName = intent.getStringExtra("fname");
        lName = intent.getStringExtra("lname");
//        Button btnProfil = findViewById(R.id.btnProfil);
//
//        btnProfil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this, ProfilActivity.class);
//                intent.putExtra("email",email);
//                intent.putExtra("nomorHp",pNumber);
//                intent.putExtra("fname",fName);
//                intent.putExtra("lname",lName);
//                startActivity(intent);
//
//            }
//        });
//        cobaDoang.setText(email+pNumber+fName+lName);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if ( id == R.id.aboutMenu){
            //ini isi intent ke about
        } else if ( id == R.id.settingMenu) {
            //ini isi intent ke setting
        } else if ( id == R.id.logoutMenu) {
            //ini isi intent ke logout menu login
        }
        return true;
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()){
                        case R.id.homeMenu:
                            selectedFragment = new HomeFragment();
                            break;
                        case R.id.activityMenu:
                            selectedFragment = new ActivityFragment();
                            break;
                        case R.id.profileMenu:
                            selectedFragment = new ProfileFragment();
                            Bundle data = new Bundle();
                            data.putString("email",email);
                            data.putString("nomorHp",pNumber);
                            data.putString("fname",fName);
                            data.putString("lname",lName);
                            selectedFragment.setArguments(data);
                            break;
                    }

                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).commit();

                    return true;
                }
            };

}
