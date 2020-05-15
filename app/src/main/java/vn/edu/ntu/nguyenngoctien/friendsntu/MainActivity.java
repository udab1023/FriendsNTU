package vn.edu.ntu.nguyenngoctien.friendsntu;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import vn.edu.ntu.nguyenngoctien.controller.IController;
import vn.edu.ntu.nguyenngoctien.model.Friends;

public class MainActivity extends AppCompatActivity {
    ArrayList<Friends> listFriends;
    FriendsAdapter adapter;
    RecyclerView rvlistFriends;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    private void addView() {
        rvlistFriends = findViewById(R.id.rvlistFriends);
        rvlistFriends.setLayoutManager(new LinearLayoutManager(this));
        IController controller = (IController) getApplication();
        listFriends = controller.getListFriends();
        adapter = new FriendsAdapter(listFriends);
        rvlistFriends.setAdapter(adapter);
    }
    //lop cai dat cho viec hien thi cua 1 friend
    private class FriendsViewHolder extends RecyclerView.ViewHolder {
        TextView txtName, txtDate, txtSdt;

        public FriendsViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = this.itemView.findViewById(R.id.txtName);
            txtDate = this.itemView.findViewById(R.id.txtdate);
            txtSdt = this.itemView.findViewById(R.id.txtSdt);
        }
        public void bind(Friends friends)
        {
            txtName.setText(friends.getName());
            txtSdt.setText(new Integer(friends.getSdt()).toString());
            txtDate.setText(friends.getDate());
        }
        //lop Adapter ket noi RecycleView va data
        private class FriendsAdapter extends RecyclerView.Adapter<FriendsViewHolder> {
            ArrayList<Friends> listFriends;

            public FriendsAdapter(ArrayList<Friends> listFriends) {
                this.listFriends = listFriends;
            }

            //tao 1 viewholder de hien thi data
            @NonNull
            @Override
            public FriendsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                LayoutInflater layoutInflater = getLayoutInflater();
                //chuyen layout da thiet ke = xml thanh 1 doi tuong
                View view = layoutInflater.inflate(R.layout.content_main, parent, false);
                return new FriendsViewHolder(view);
            }

            //ket noi 1 muc data trong list vs 1 cai vewholder
            @Override
            public void onBindViewHolder(@NonNull FriendsViewHolder holder, int position) {
                holder.bind(listFriends.get(position));
            }

            @Override
            public int getItemCount()
            {
                 return listFriends.size();
            }
        }

        //@Override
        //public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //    getMenuInflater().inflate(R.menu.menu_main, menu);
        //   return true;
        //}

        //@Override
        //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //   int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //    if (id == R.id.action_settings) {
        //       return true;
        //    }

        //   return super.onOptionsItemSelected(item);
        //}
    }
}
