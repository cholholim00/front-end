package com.example.secret_diary;

import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DiaryAdapter extends RecyclerView.Adapter<DiaryAdapter.VH> {
    public interface Listener {
        void onEdit(int pos);
        void onDelete(int pos);
        void onClick(int pos);
    }

    private List<DiaryItem> data;
    private final Listener listener;
    private boolean appUnlocked;

    public DiaryAdapter(List<DiaryItem> data, Listener listener){
        this.data = data; this.listener = listener; this.appUnlocked = false;
    }

    public void setAppUnlocked(boolean unlocked){ this.appUnlocked = unlocked; notifyDataSetChanged(); }

    public void submit(List<DiaryItem> newData){ this.data = newData; notifyDataSetChanged(); }

    public DiaryItem getItemAt(int pos){
        if(pos < 0 || pos >= getItemCount()) return null;
        return data.get(pos);
    }

    @NonNull @Override public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diary, parent, false));
    }

    @Override public void onBindViewHolder(@NonNull VH h, int position) {
        DiaryItem item = data.get(position);
        h.tvTitle.setText(item.title);
        h.tvDate.setText(Utils.fmt(item.dateMillis));

        boolean locked = item.secret && !appUnlocked;
        h.tvLock.setVisibility(locked ? View.VISIBLE : View.GONE);

        String masked = "••••••••••";
        CharSequence targetText = locked ? masked : item.content;
        h.itemView.setAlpha(locked ? 0.88f : 1f);

        // 크로스페이드
        h.tvContent.animate().cancel();
        h.tvContent.setAlpha(0f);
        h.tvContent.setText(targetText);
        h.tvContent.animate().alpha(1f).setDuration(120).start();

        h.itemView.setOnClickListener(v -> listener.onClick(h.getAdapterPosition()));
        h.btnMore.setOnClickListener(v -> showPopup(v, h.getAdapterPosition()));
    }

    private void showPopup(View anchor, int pos){
        PopupMenu pm = new PopupMenu(anchor.getContext(), anchor);
        MenuInflater inflater = pm.getMenuInflater();
        inflater.inflate(R.menu.menu_item_popup, pm.getMenu());
        pm.setOnMenuItemClickListener((MenuItem mi) -> {
            if(mi.getItemId()==R.id.action_edit) listener.onEdit(pos);
            else if(mi.getItemId()==R.id.action_delete) listener.onDelete(pos);
            return true;
        });
        pm.show();
    }

    @Override public int getItemCount() { return data.size(); }

    static class VH extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDate, tvContent, tvLock; ImageButton btnMore;
        VH(@NonNull View v){
            super(v);
            tvTitle = v.findViewById(R.id.tvTitle);
            tvDate = v.findViewById(R.id.tvDate);
            tvContent = v.findViewById(R.id.tvContent);
            tvLock = v.findViewById(R.id.tvLock);
            btnMore = v.findViewById(R.id.btnMore);
        }
    }
}
