package com.esisalama.database_test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.esisalama.database_test.database.AppDatabase;
import com.esisalama.database_test.database.dao.EtudiantDao;
import com.esisalama.database_test.database.dao.PromotionDao;
import com.esisalama.database_test.database.entity.Etudiant;
import com.esisalama.database_test.database.entity.Promotion;
import com.esisalama.database_test.database.entity.User;
import com.esisalama.database_test.database.dao.UserDao;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText userNom;
    private EditText userPostNom;
    private EditText userEmail;
    private EditText userMatricule;
    private Button submit;
    private Button delete;
    private TextView allUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userNom=findViewById(R.id.nom);
        userPostNom=findViewById(R.id.postNom);
        userEmail=findViewById(R.id.email);
        userMatricule=findViewById(R.id.matricule);
        submit=findViewById(R.id.submitBtn);
        allUser=findViewById(R.id.userAll);
        delete=findViewById(R.id.btnDelete);
        onclick();
    }
    public void initialisation(){
        userNom=findViewById(R.id.nom);
        userPostNom=findViewById(R.id.postNom);
        userEmail=findViewById(R.id.email);
        userMatricule=findViewById(R.id.matricule);
        submit=findViewById(R.id.submitBtn);
    }
    public void onclick(){
        submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String nom=userNom.getText().toString();
                String postNom=userPostNom.getText().toString();
                String email=userEmail.getText().toString();
                String matricule=userMatricule.getText().toString();
                if(nom.isEmpty()){
                    Toast.makeText(MainActivity.this,"Vous devez remplir le champ nom",Toast.LENGTH_LONG).show();
                }else if(postNom.isEmpty()){
                    Toast.makeText(MainActivity.this,"Vous devez remplir le champ postnom",Toast.LENGTH_LONG).show();
                }else if(email.isEmpty()){
                    Toast.makeText(MainActivity.this,"Vous devez remplir le champ Email",Toast.LENGTH_LONG).show();
                }else if(matricule.isEmpty()){
                    Toast.makeText(MainActivity.this,"Vous devez remplir le champ matricule",Toast.LENGTH_LONG).show();
                }else{
                    enregistrer(nom,postNom,email,matricule);
                }
            }
        });
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                find();
            }
        });
    }
    private void find(){
        AppDatabase db= Room.databaseBuilder(this,AppDatabase.class,"db").allowMainThreadQueries().build();
        UserDao dao=db.userDao();
        List<User> dbuser=dao.findAll();
        StringBuilder string=new StringBuilder();
        for(User user:dbuser){
            string.append(user.matricule);
            string.append("\n");
        }
        allUser.setText(string);
    }
    private void enregistrer(
            String nom,
            String postNom,
            String email,
            String matricule
    ){
        User user=new User(nom,postNom,email,matricule);
        AppDatabase db= Room.databaseBuilder(this,AppDatabase.class,"db").allowMainThreadQueries().build();
        //Recuperer Dao
        EtudiantDao etudiantDao= db.etudiantDao();
        PromotionDao promotionDao=db.promotionDao();
        UserDao dao=db.userDao();
        //Requete d'insertion de la promotion
        Promotion g2si=new Promotion(1,"G2 SI");
        promotionDao.insert(g2si);
        //Requete d'insertion d'un Etudiant
        Etudiant etudiant=new Etudiant(1,"rosny","18ka108",1);
        etudiantDao.insert(etudiant);
        dao.insert(user);


        User dbUser=dao.findOnd(1);
        Toast.makeText(this,dbUser.postNom,Toast.LENGTH_LONG).show();
    }
}