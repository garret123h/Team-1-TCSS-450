package edu.uw.tcss450.chatapp.ui.contact;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import edu.uw.tcss450.chatapp.R;

public class ContactListRecyclerViewAdapter extends
        RecyclerView.Adapter<ContactListRecyclerViewAdapter.ContactViewHolder> {
    private List<ContactViewModel> listItems;
    private Context context;

    public ContactListRecyclerViewAdapter(List<ContactViewModel> listItem, Context context) {
        this.listItems = listItems;
        this.context = context;
    }



    @NonNull
    @Override
    public ContactListRecyclerViewAdapter.ContactViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_contact_list, parent, false);
        return new ContactViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactListRecyclerViewAdapter.ContactViewHolder holder, int position) {
        ContactViewModel listItem = listItems.get(position);

        holder.textViewName.setText(listItem.getName());
        holder.textViewId.setText(listItem.getId());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ContactViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewName;
        public TextView textViewId;
        public ContactViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = (TextView) itemView.findViewById(R.id.text_name);
            textViewId = (TextView) itemView.findViewById(R.id.text_id);
        }
    }
}