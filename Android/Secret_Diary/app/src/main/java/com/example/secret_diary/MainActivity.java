package com.example.secret_diary;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.transition.AutoTransition;
import androidx.transition.TransitionManager;

import com.example.secret_diary.databinding.ActivityMainBinding;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding b;
    private List<DiaryItem> items = new ArrayList<>();
    private List<DiaryItem> itemsAll = new ArrayList<>();
    private String currentQuery = "";
    private DiaryAdapter adapter;

    // PIN
    private static final String PREF_SEC = "sec_pref";
    private static final String KEY_PIN  = "pin";
    private boolean appUnlocked = false;

    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        b = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        setSupportActionBar(b.toolbar);

        items = DiaryStore.load(this);
        DiaryStore.sortByDateDesc(items);
        itemsAll = new ArrayList<>(items);

        adapter = new DiaryAdapter(new ArrayList<>(items), new DiaryAdapter.Listener() {
            @Override public void onEdit(int pos) { editItem(pos); }
            @Override public void onDelete(int pos) { deleteItem(pos); }
            @Override public void onClick(int pos) { viewOrUnlock(pos); }
        });
        b.recycler.setLayoutManager(new LinearLayoutManager(this));
        b.recycler.setAdapter(adapter);

        b.fabAdd.setOnClickListener(v -> openAdd());

        if(items.isEmpty()) Toast.makeText(this, getString(R.string.empty), Toast.LENGTH_SHORT).show();

        // 앱 시작 시 PIN 확인
        String pin = getSharedPreferences(PREF_SEC, MODE_PRIVATE).getString(KEY_PIN, null);
        if (pin != null) promptPin(false, ok -> { appUnlocked = ok; adapter.setAppUnlocked(ok); });
        else { appUnlocked = true; adapter.setAppUnlocked(true); }

        // 스와이프 삭제 + UNDO
        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,
                ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override public boolean onMove(androidx.recyclerview.widget.RecyclerView rv,
                                            androidx.recyclerview.widget.RecyclerView.ViewHolder vh,
                                            androidx.recyclerview.widget.RecyclerView.ViewHolder tgt) { return false; }
            @Override public void onSwiped(androidx.recyclerview.widget.RecyclerView.ViewHolder vh, int dir) {
                int pos = vh.getBindingAdapterPosition();
                DiaryItem target = adapter.getItemAt(pos);
                if (target == null) { adapter.notifyItemChanged(pos); return; }

                int removedIndex = -1; DiaryItem removed = null;
                for (int i=0;i<itemsAll.size();i++)
                    if (itemsAll.get(i).id.equals(target.id)) { removedIndex = i; removed = itemsAll.remove(i); break; }

                filterList(currentQuery);

                DiaryItem removedFinal = removed; int idxFinal = removedIndex;
                Snackbar.make(b.recycler, "삭제됨", Snackbar.LENGTH_LONG)
                        .setAction("되돌리기", v -> {
                            if(removedFinal != null){
                                itemsAll.add(Math.min(idxFinal, itemsAll.size()), removedFinal);
                                DiaryStore.sortByDateDesc(itemsAll);
                                filterList(currentQuery);
                            }
                        })
                        .addCallback(new Snackbar.Callback() {
                            @Override public void onDismissed(Snackbar bar, int event) {
                                if (event != Snackbar.Callback.DISMISS_EVENT_ACTION) {
                                    DiaryStore.save(MainActivity.this, itemsAll);
                                }
                            }
                        })
                        .show();
            }
        }).attachToRecyclerView(b.recycler);
    }

    private void openAdd() {
        b.fabAdd.animate().scaleX(0.9f).scaleY(0.9f).setDuration(80).withEndAction(() -> {
            b.fabAdd.animate().scaleX(1f).scaleY(1f).setDuration(120).start();
            showAddEditBottomSheet(null, -1);
        }).start();
    }

    private void editItem(int pos){
        DiaryItem target = adapter.getItemAt(pos);
        if (target == null) return;
        showAddEditBottomSheet(target, pos);
    }

    private void deleteItem(int pos){
        DiaryItem target = adapter.getItemAt(pos);
        if (target == null) return;
        new AlertDialog.Builder(this)
                .setMessage("삭제하시겠어요?")
                .setPositiveButton("삭제", (d, w) -> {
                    for (int i=0;i<itemsAll.size();i++)
                        if (itemsAll.get(i).id.equals(target.id)) { itemsAll.remove(i); break; }
                    filterList(currentQuery);
                })
                .setNegativeButton("취소", null)
                .show();
    }

    private void viewOrUnlock(int pos){
        DiaryItem target = adapter.getItemAt(pos);
        if (target == null) return;
        if (target.secret && !appUnlocked) {
            promptPin(false, ok -> {
                if (ok) { appUnlocked = true; adapter.setAppUnlocked(true); }
                else { adapter.notifyItemChanged(pos); }
            });
        } else {
            editItem(pos);
        }
    }

    private void showAddEditBottomSheet(@Nullable DiaryItem src, int pos){
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_add_edit, null, false);
        EditText etTitle = v.findViewById(R.id.etTitle);
        EditText etDate  = v.findViewById(R.id.etDate);
        EditText etContent = v.findViewById(R.id.etContent);
        CheckBox cbSecret = v.findViewById(R.id.cbSecret);

        if (src != null){
            etTitle.setText(src.title);
            etContent.setText(src.content);
            etDate.setText(Utils.fmt(src.dateMillis));
            cbSecret.setChecked(src.secret);
        } else {
            etDate.setText(Utils.fmt(System.currentTimeMillis()));
        }
        etDate.setOnClickListener(v1 -> pickDate(etDate, src));

        BottomSheetDialog sheet = new BottomSheetDialog(this);
        sheet.setContentView(v);

        v.findViewById(R.id.btnSave).setOnClickListener(btn -> {
            String title = String.valueOf(etTitle.getText());
            String content = String.valueOf(etContent.getText());
            String dateStr = String.valueOf(etDate.getText());
            if (TextUtils.isEmpty(title) || TextUtils.isEmpty(dateStr)) {
                Toast.makeText(this, "제목/날짜를 입력하세요", Toast.LENGTH_SHORT).show(); return;
            }
            long millis = (src != null) ? src.dateMillis : System.currentTimeMillis();
            DiaryItem item = (src != null)
                    ? new DiaryItem(src.id, title, content, millis, cbSecret.isChecked())
                    : new DiaryItem(Utils.id(), title, content, millis, cbSecret.isChecked());

            TransitionManager.beginDelayedTransition(b.recycler, new AutoTransition());
            if (src == null) { itemsAll.add(0, item); DiaryStore.sortByDateDesc(itemsAll); }
            else {
                for (int i=0;i<itemsAll.size();i++)
                    if (itemsAll.get(i).id.equals(item.id)) { itemsAll.set(i, item); break; }
            }
            filterList(currentQuery);
            sheet.dismiss();
        });

        sheet.show();
    }

    private void pickDate(EditText etDate, @Nullable DiaryItem src){
        Calendar c = Calendar.getInstance();
        if (src != null) c.setTimeInMillis(src.dateMillis);
        new DatePickerDialog(this, (DatePicker view, int y, int m, int d) -> {
            Calendar cc = Calendar.getInstance(); cc.set(y, m, d, 0, 0, 0);
            etDate.setText(Utils.fmt(cc.getTimeInMillis()));
            if (src != null) src.dateMillis = cc.getTimeInMillis();
        }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH)).show();
    }

    @Override public boolean onCreateOptionsMenu(android.view.Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView sv = (SearchView) searchItem.getActionView();
        if (sv != null){
            sv.setQueryHint(getString(R.string.search_hint));
            sv.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override public boolean onQueryTextSubmit(String query) { currentQuery = query; filterList(query); return true; }
                @Override public boolean onQueryTextChange(String newText) { currentQuery = newText; filterList(newText); return true; }
            });
        }
        return true;
    }

    @Override public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_add){ openAdd(); return true; }
        else if (id == R.id.action_sort){
            if (itemsAll.size() >= 2 && itemsAll.get(0).dateMillis > itemsAll.get(itemsAll.size()-1).dateMillis){
                DiaryStore.sortByDateAsc(itemsAll); Toast.makeText(this, getString(R.string.sort_old), Toast.LENGTH_SHORT).show();
            } else {
                DiaryStore.sortByDateDesc(itemsAll); Toast.makeText(this, getString(R.string.sort_new), Toast.LENGTH_SHORT).show();
            }
            filterList(currentQuery); return true;
        }
        else if (id == R.id.action_pin){ setOrChangePin(); return true; }
        else if (id == R.id.action_lock){
            appUnlocked = false;
            adapter.setAppUnlocked(false);
            promptPin(false, ok -> { appUnlocked = ok; adapter.setAppUnlocked(ok); });
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void filterList(String q){
        List<DiaryItem> out;
        if (q == null || q.trim().isEmpty()) out = new ArrayList<>(itemsAll);
        else {
            String qq = q.toLowerCase(); out = new ArrayList<>();
            for (DiaryItem d : itemsAll){
                String t = d.title != null ? d.title.toLowerCase() : "";
                String c = d.content != null ? d.content.toLowerCase() : "";
                if (t.contains(qq) || c.contains(qq)) out.add(d);
            }
        }
        TransitionManager.beginDelayedTransition(b.recycler, new AutoTransition());
        items = out;
        adapter.submit(new ArrayList<>(items));
        DiaryStore.save(this, itemsAll);
    }

    // ===== PIN =====
    interface PinCallback { void done(boolean ok); }

    private void promptPin(boolean isSetting, PinCallback cb){
        final EditText et = new EditText(this);
        et.setInputType(android.text.InputType.TYPE_CLASS_NUMBER | android.text.InputType.TYPE_NUMBER_VARIATION_PASSWORD);
        et.setHint(isSetting ? getString(R.string.pin_set) : getString(R.string.pin_enter));
        new AlertDialog.Builder(this)
                .setTitle(isSetting ? R.string.pin_set : R.string.pin_enter)
                .setView(et)
                .setPositiveButton(R.string.pin_confirm, (d, w) -> {
                    String pinInput = String.valueOf(et.getText());
                    if (isSetting){
                        if (TextUtils.isEmpty(pinInput)) { Toast.makeText(this, "빈 PIN은 허용되지 않습니다", Toast.LENGTH_SHORT).show(); cb.done(false); return; }
                        getSharedPreferences(PREF_SEC, MODE_PRIVATE).edit().putString(KEY_PIN, pinInput).apply();
                        cb.done(true);
                    } else {
                        String pin = getSharedPreferences(PREF_SEC, MODE_PRIVATE).getString(KEY_PIN, null);
                        boolean ok = pin != null && pin.equals(pinInput);
                        if (!ok) Toast.makeText(this, R.string.pin_wrong, Toast.LENGTH_SHORT).show();
                        cb.done(ok);
                    }
                })
                .setNegativeButton(R.string.pin_cancel, (d, w) -> cb.done(false))
                .show();
    }

    private void setOrChangePin(){
        String current = getSharedPreferences(PREF_SEC, MODE_PRIVATE).getString(KEY_PIN, null);
        if (current == null){
            promptPin(true, ok -> { if (ok) Toast.makeText(this, "PIN 설정 완료", Toast.LENGTH_SHORT).show(); });
        } else {
            promptPin(false, ok -> {
                if (!ok) return;
                promptPin(true, ok2 -> { if (ok2) Toast.makeText(this, "PIN 변경 완료", Toast.LENGTH_SHORT).show(); });
            });
        }
    }
}
