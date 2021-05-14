package edu.uw.tcss450.chatapp_group1.ui.contact;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import edu.uw.tcss450.chatapp_group1.R;
import edu.uw.tcss450.chatapp_group1.databinding.FragmentContactListBinding;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactListFragment extends Fragment {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private List<ContactViewModel> listItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_contact_list, container, false);

    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        FragmentContactListBinding binding = FragmentContactListBinding.bind(getView());

        // binding.listRootContact.setAdapter(adapter);
        //binding.listRootContact.setHasFixedSize(true);
        //binding.listRootContact.setLayoutManager(new LinearLayoutManager((this)));
    }

}