package cc.brainbook.view.mycheckableframelayout;

/**
 * Description.
 *
 * @author Robert Han
 * @email brainbook.cc@outlook.com
 * @website www.brainbook.cc
 * @time 2018/7/12 13:11
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

public class ListItemAdapter extends BaseAdapter {
    private List<DataHolder> mList;
    private Context mContext;
    private LayoutInflater mInflater;

    public ListItemAdapter(Context context, List<DataHolder> list){
        mList = list;
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.check_list_item, null);
            holder.mTitle = convertView.findViewById(R.id.title);
            holder.mSubTitile = convertView.findViewById(R.id.subtitle);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.mTitle.setText(mList.get(position).titleStr);
        holder.mSubTitile.setText(mList.get(position).subTitleStr);
        return convertView;
    }
}
