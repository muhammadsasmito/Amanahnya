//package id.amanahku.amanahku;
//
//import android.content.Intent;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.v7.app.AppCompatActivity;
//import android.view.View;
//
//import com.project.alllatf.amanahku.PesanBrg;
//import com.project.alllatf.amanahku.TambahBrg;
//
//public class MainActivity extends AppCompatActivity {
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
////        //load dialog fragment
////        DialogFragment dialogFragment = new GuestModal_dialogFragment();
////        dialogFragment.show(getFragmentManager(), "Dialog Guest");
////        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
////
////        //menyembunyikan actionbar
////        //getActionBar().hide();
////        getSupportActionBar().hide();
//
//        Intent i = new Intent(MainActivity.this,TambahBrg.class);
//        startActivity(i);
//
//        /**
//         * Yang tadinya menu tab slide untuk menambahkan pesanan menggunakan aktivity baru
//         * pindah ke aktivity pesanbarang
//         */
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fabPesanBrg);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i = new Intent(MainActivity.this,PesanBrg.class);
//                startActivity(i);
//            }
//        });
//    }
//}
