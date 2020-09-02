package cc.brainbook.view.mycheckableframelayout;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //构造数据
        final List<DataHolder> dataList = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            dataList.add(new DataHolder("harvic的blog------" + i,"harvic"));
        }
        //构造Adapter
        final ListItemAdapter adapter = new ListItemAdapter(this, dataList);
        final ListView listView = findViewById(R.id.list);
        listView.setAdapter(adapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Click ... " + position, Toast.LENGTH_SHORT).show();

                //        Log.v("TAG", (String)mData.get(position).get("title"));
                Log.i("TAG", "onClick getCheckedItemCount(): " + listView.getCheckedItemCount());

//                int selectPosition = getListView().getCheckedItemPosition();///单选模式
//                Log.i("TAG", "onClick selectPosition: "+selectPosition+", " + getListView().getAdapter().getItem(selectPosition));

                SparseBooleanArray selectPositions = listView.getCheckedItemPositions();
                Log.i("TAG", "onClick selectPositions: "+selectPositions);
            }
        });

        //全部选中按钮的处理
        final Button all_sel = findViewById(R.id.all_sel);
        all_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0, size = dataList.size(); i < size; i++) {
                    listView.setItemChecked(i, true);
                }
            }
        });

        //全部取消按钮处理
        final Button all_unsel = findViewById(R.id.all_unsel);
        all_unsel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0, size = dataList.size(); i < size; i++) {
                    listView.setItemChecked(i, false);
                }
            }
        });

        //反选按钮处理
        final Button reverse_sel = findViewById(R.id.reverse_sel);
        reverse_sel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0, size = dataList.size(); i < size; i++) {
                    listView.setItemChecked(i, !listView.isItemChecked(i));
                }
            }
        });
    }
}
