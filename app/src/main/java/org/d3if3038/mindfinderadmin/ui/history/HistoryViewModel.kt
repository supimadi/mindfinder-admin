package org.d3if3038.mindfinderadmin.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3038.mindfinderadmin.model.PersonalityEntity

class HistoryViewModel : ViewModel() {
    private val firebaseDb = Firebase.firestore

    private val personalityTestResult = MutableLiveData<MutableList<PersonalityEntity>>(
        mutableListOf()
    )


    fun fetchTestResult(token: String) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            val firebaseDocument = firebaseDb.collection("personalities_result_${token}")
            firebaseDocument.get().addOnSuccessListener {
                val d: MutableList<PersonalityEntity> = mutableListOf()

                for (doc in it.documents) {
                    d.add(doc.toObject(PersonalityEntity::class.java)!!)
                }

                personalityTestResult.value = d
            }
        }
    }

    fun getTestResult() : LiveData<MutableList<PersonalityEntity>> = personalityTestResult

}