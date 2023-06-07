package org.d3if3038.mindfinderadmin.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import org.d3if3038.mindfinderadmin.R
import org.d3if3038.mindfinderadmin.data.SettingDataStore
import org.d3if3038.mindfinderadmin.data.dataStore

class SettingsFragment : PreferenceFragmentCompat() {
    private val settingDataStore: SettingDataStore by lazy {
        SettingDataStore(requireContext().dataStore)
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.preferenceDataStore = settingDataStore
        setPreferencesFromResource(R.xml.prefrences, rootKey)
    }
}