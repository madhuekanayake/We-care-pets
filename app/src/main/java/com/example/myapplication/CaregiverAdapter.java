package com.example.myapplication;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.content.Context;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CaregiverAdapter extends RecyclerView.Adapter<CaregiverAdapter.ViewHolder> {

    private List<Caremodel> caregivers;
    private Context context;

    public CaregiverAdapter(List<Caremodel> caregivers, Context context) {
        this.caregivers = caregivers;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_caregivers, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Caremodel caregiver = caregivers.get(position);

        holder.textViewName.setText(caregiver.getName());
        holder.textViewExperience.setText(caregiver.getExperience());
        holder.textViewAvailability.setText(caregiver.getAvailability());
        holder.textViewPhoneNumber.setText(caregiver.getEmail());
        holder.textViewRate.setText(caregiver.getRate());


        holder.btnContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return caregivers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName, textViewExperience, textViewAvailability, textViewPhoneNumber, textViewRate;
        Button btnContact;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.viewname);
            textViewExperience = itemView.findViewById(R.id.viewexperience);
            textViewAvailability = itemView.findViewById(R.id.viewavailability);
            textViewPhoneNumber = itemView.findViewById(R.id.viewpnumber);
            textViewRate = itemView.findViewById(R.id.viewrate);
            btnContact = itemView.findViewById(R.id.btn_contact);
        }
    }
}