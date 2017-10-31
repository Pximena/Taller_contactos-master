package com.example.jonmid.contactosbasededatos.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jonmid.contactosbasededatos.Models.Contact;
import com.example.jonmid.contactosbasededatos.R;
import com.example.jonmid.contactosbasededatos.Views.DeleteActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jonmid on 26/10/17.
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.ViewHolder> {

    List<Contact> contactList = new ArrayList<>();
    Context context;

    public ContactAdapter(List<Contact> contactList, Context context) {
        this.contactList = contactList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View item = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_contact, parent, false);
        ViewHolder viewHolder = new ViewHolder(item);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(contactList.get(position).getName());
        holder.textViewPhone.setText(contactList.get(position).getPhone());
        holder.textViewEmail.setText(contactList.get(position).getEmail());
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView textViewName;
        TextView textViewPhone;
        TextView textViewEmail;
        public ViewHolder(View item) {
            super(item);

            item.setOnClickListener(this);

            textViewName = (TextView) item.findViewById(R.id.id_tv_item_name);
            textViewPhone = (TextView) item.findViewById(R.id.id_tv_item_phone);
            textViewEmail = (TextView) item.findViewById(R.id.id_tv_item_email);
        }

        @Override
        public void onClick(View view) {
            Context contextItem = view.getContext();

            Intent intent = new Intent(context, DeleteActivity.class);
            intent.putExtra("id", contactList.get(getLayoutPosition()).getId());
            intent.putExtra("name", contactList.get(getLayoutPosition()).getName());
            intent.putExtra("phone", contactList.get(getLayoutPosition()).getPhone());
            intent.putExtra("email", contactList.get(getLayoutPosition()).getEmail());
            contextItem.startActivity(intent);


           // String valor = Integer.toString(albumModelList.get(getLayoutPosition()).getId());
           // Toast.makeText(contextItem, valor, Toast.LENGTH_SHORT).show();
        }
    }

}
