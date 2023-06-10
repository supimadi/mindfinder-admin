package org.d3if3038.mindfinderadmin.ui

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import org.d3if3038.mindfinderadmin.R
import org.d3if3038.mindfinderadmin.data.SettingDataStore
import org.d3if3038.mindfinderadmin.data.dataStore

class SettingsFragment : PreferenceFragmentCompat() {
    private val settingDataStore: SettingDataStore by lazy {
        SettingDataStore(requireContext().dataStore)
    }

    private val firebaseDb = Firebase.firestore

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        preferenceManager.preferenceDataStore = settingDataStore
        setPreferencesFromResource(R.xml.prefrences, rootKey)

//        val tokenPreference: EditTextPreference? = findPreference(
//            getString(R.string.token_admin_prefrences)
//        )
//        tokenPreference!!.setOnPreferenceChangeListener { preference, newValue ->
//            val oldValue = preference.preferenceDataStore!!
//                .getString(getString(R.string.token_admin_prefrences), "")
//
//            firebaseDb.collection("personality_result_${newValue}").get()
//                .addOnSuccessListener {
//                    try {
//                        it.documents[0].exists()
//                    } catch (_: IndexOutOfBoundsException) {
//                        preference.preferenceDataStore!!.putString(
//                            getString(R.string.token_admin_prefrences),
//                            oldValue
//                        )
//                        Toast.makeText(requireContext(), "asd", Toast.LENGTH_LONG).show()
//                    }
//                }
//
//
////            Toast.makeText(requireContext(), "asd", Toast.LENGTH_LONG).show()
////            newValue.toString() == "lkm"
//            true
//        }

    }

}