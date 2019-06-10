package bahaa.apps.pockettodo.services;

import android.app.IntentService;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.UUID;

import bahaa.apps.pockettodo.main.MainFragment;
import bahaa.apps.pockettodo.utils.StoreRetrieveData;
import bahaa.apps.pockettodo.utils.TodoItem;

public class DeleteNotificationService extends IntentService {
    private StoreRetrieveData storeRetrieveData;
    private ArrayList<TodoItem> mToDoItems;
    private TodoItem mItem;

    public DeleteNotificationService() {
        super("DeleteNotificationService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        storeRetrieveData = new StoreRetrieveData(this, MainFragment.FILENAME);
        UUID todoID = (UUID) intent.getSerializableExtra(TodoNotificationService.TODOUUID);

        mToDoItems = loadData();
        if (mToDoItems != null) {
            for (TodoItem item : mToDoItems) {
                if (item.getIdentifier().equals(todoID)) {
                    mItem = item;
                    break;
                }
            }

            if (mItem != null) {
                mToDoItems.remove(mItem);
                dataChanged();
                saveData();
            }

        }

    }

    private void dataChanged() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainFragment.SHARED_PREF_DATA_SET_CHANGED, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(MainFragment.CHANGE_OCCURED, true);
        editor.apply();
    }

    private void saveData() {
        try {
            storeRetrieveData.saveToFile(mToDoItems);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        saveData();
    }

    private ArrayList<TodoItem> loadData() {
        try {
            return storeRetrieveData.loadFromFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }
}
