package netter.uni.freshfoodfinder;

import java.util.List;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

public class ColoredArrayAdapter<T> extends ArrayAdapter<T> {
	private int[] colors = {0x304afb4a, 0x30fea400};
	public ColoredArrayAdapter(Context context, int textViewResourceId,
			List<T> objects) {
		super(context, textViewResourceId, objects);
	}
	
	public View getView(int position, View convertView, ViewGroup parent) {
		View view = super.getView(position, convertView, parent);
		int color = colors[position % 2];
		view.setBackgroundColor(color);
		return view;
	}
}
