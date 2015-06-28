package com.example.sharegame;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.widget.ListAdapter;

public class PrefActivity extends PreferenceActivity{
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        getFragmentManager().beginTransaction().replace(android.R.id.content, PrefFragment.getPrefFragment()).commit();
    }
    
    /**
     * 設定情報を保存する
     * @author kkouji
     *
     */
    private static class PrefFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener{
        
        private static PrefFragment pf=new PrefFragment();
        
        private PrefFragment(){}
        
        private static PrefFragment getPrefFragment(){
            return pf;
        }
        
        @Override
        public void onCreate(Bundle b){
            super.onCreate(b);
            addPreferencesFromResource(R.layout.activity_pref);
        }
        
        @Override
        public void onResume() {
            super.onResume();
            reloadSummary();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        };
        
        @Override
        public void onPause() {
            super.onPause();
            getPreferenceScreen().getSharedPreferences().registerOnSharedPreferenceChangeListener(this);
        };

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,String key) {
            reloadSummary();
        }
        
        /**
         * 保存されている値を読み込み、サマリーに反映する
         */
        private void reloadSummary(){
            ListAdapter adapter = getPreferenceScreen().getRootAdapter();
            for (int i=0;i<adapter.getCount();i++){
                Object item = adapter.getItem(i);
                if (item instanceof ListPreference){
                    ListPreference preference = (ListPreference) item;
                    preference.setSummary(preference.getEntry() == null ? "" : preference.getEntry());
                }
            }
        }
    }

}
