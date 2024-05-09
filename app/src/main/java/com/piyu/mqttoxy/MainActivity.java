package com.piyu.mqttoxy;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.piyu.mqttoxy.databinding.ActivityMainBinding;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    ImageView mTopSet;
    StaggeredGridLayoutManager staggeredGridLayoutManager;

    ImageView advSetBottomSheet;
    BottomSheetDialog bottomSheetDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        mTopSet=findViewById(R.id.topSetting);
        advSetBottomSheet=findViewById(R.id.floatingActionButton);


        RecyclerView recyclerView= findViewById(R.id.recyclerview);

        List<ModelClass> items= new ArrayList<>();
        items.add((new ModelClass("Qy","Off-0%",R.drawable.baseline_question_mark_24)));
        items.add((new ModelClass("xy","Off-0%",R.drawable.baseline_question_mark_24)));
        items.add((new ModelClass("Fsd","Off-0%",R.drawable.baseline_question_mark_24)));

        staggeredGridLayoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(new MyAdapter(getApplicationContext(),items));



        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(binding.navView, navController);




        mTopSet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showMenu(view);
            }
        });


        advSetBottomSheet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                bottomSheetDialog = new BottomSheetDialog(MainActivity.this,R.style.BottomSheetTheme);

                View sheetView = LayoutInflater.from(getApplicationContext()).inflate(R.layout.fragment_home,findViewById(R.id.bottom_Sheet));

                sheetView.findViewById(R.id.toggle).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Toggle the Group", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });
                sheetView.findViewById(R.id.create_group).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Creating Group", Toast.LENGTH_SHORT).show();
                        bottomSheetDialog.dismiss();
                    }
                });

                bottomSheetDialog.setContentView(sheetView);
                bottomSheetDialog.show();

            }
        });
    }


    private void showMenu (View view){
        PopupMenu popupMenu = new PopupMenu(MainActivity.this,view);
        popupMenu.getMenuInflater().inflate(R.menu.topsetmenu,popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                if(menuItem.getItemId()==R.id.importExpViaMQTT){
                    Toast.makeText(MainActivity.this, "Import/Export via MQTT", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()==R.id.connect){
                    Toast.makeText(MainActivity.this, "Connect", Toast.LENGTH_SHORT).show();
                }
                if(menuItem.getItemId()==R.id.disconnect){
                    Toast.makeText(MainActivity.this, "Disconnect", Toast.LENGTH_SHORT).show();
                }

                if(menuItem.getItemId()==R.id.sortGroups){
                    Toast.makeText(MainActivity.this, "Sort Groups", Toast.LENGTH_SHORT).show();
                }

                return false;
            }
        });
        popupMenu.show();
    }

}