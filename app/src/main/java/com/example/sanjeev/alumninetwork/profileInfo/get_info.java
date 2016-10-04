package com.example.sanjeev.alumninetwork.profileInfo;


import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.sanjeev.alumninetwork.R;
 import java.util.List;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


//Class having OnItemClickListener to handle the clicks on list
public class get_info extends AppCompatActivity  {

    //Root URL of our web service
    public static final String ROOT_URL = "http://api.learn2crack.com/";

    //Strings to bind with intent will be used to send data to other activity
    //List view to show data
    private ListView listView;

    //List of type books this list will store type Book which is our data model
    private List<android_model> android_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        //Initializing the listview
        listView = (ListView) findViewById(R.id.listView_in_info);

        //Calling the method that will fetch data
        getAndroid();

        //Setting onItemClickListener to listview
        //listView.setOnItemClickListener(this);
    }

    private void getAndroid(){
        //While the app fetched data we are displaying a progress dialog
        final ProgressDialog loading = ProgressDialog.show(this,"Fetching Data","Please wait...",false,false);

        //Creating a rest adapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                .build();
        //Creating an object of our api interface
        android_interface api = adapter.create(android_interface.class);

        //Defining the method
        api.getAndroid(new Callback<List<android_model>>() {
            @Override
            public void success(List<android_model> list, Response response) {
                //Dismissing the loading progressbar
                loading.dismiss();

                //Storing the data in our list
                android_list = list;

                //Calling a method to show the list
                showList();
            }

            @Override
            public void failure(RetrofitError error) {
                //you can handle the errors here
            }
        });
    }

    //Our method to show list
    private void showList(){
        //String array to store all the book names
        String[] items = new String[android_list.size()];

        //Traversing through the whole list to get all the names
        for(int i=0; i<android_list.size(); i++){
            //Storing names to string array
            items[i] = android_list.get(i).getname();
        }

        //Creating an array adapter for list view
        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_items,items);

        //Setting adapter to listview
        listView.setAdapter(adapter);
    }


    //This method will execute on listitem click

}
