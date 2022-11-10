package com.example.pbpcrud.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pbpcrud.R;
import com.example.pbpcrud.database.entitas.ruangan;

import java.util.List;

public class ruanganAdapter extends RecyclerView.Adapter<ruanganAdapter.ViewAdapter> {
    private List<ruangan> list;
    private Context context;
    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }

    public ruanganAdapter(Context context, List<ruangan> list){
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewAdapter onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_ruangan, parent, false);
        return new ViewAdapter(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter holder, int position) {
        holder.kode_ruangan.setText(list.get(position).kode_ruangan);
        holder.kapasitas.setText(list.get(position).kapasitas);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class ViewAdapter extends RecyclerView.ViewHolder{
        TextView kode_ruangan, kapasitas;

        public ViewAdapter(@NonNull View itemView) {
            super(itemView);
            kode_ruangan = itemView.findViewById(R.id.kode_ruangan);
            kapasitas = itemView.findViewById(R.id.kapasitas);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (dialog!=null){
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }

}
