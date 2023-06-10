package org.d3if3038.mindfinderadmin.ui.history

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.snapshots
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.d3if3038.mindfinderadmin.model.PersonalityEntity

class HistoryViewModel : ViewModel() {
    private val firebaseDb = Firebase.firestore
    private var token: String = ""

    private val personalityTestResult = MutableLiveData<List<PersonalityEntity>>()

    fun setToken(token: String) {
        this.token = token
    }

    fun connectRealtimeDb() {
        firebaseDb.collection("personalities_result_${token}")
            .addSnapshotListener { value, error ->
                if (error != null) {
                    Log.w("FIREBASE", "Listen failed.", error)
                    return@addSnapshotListener
                }

                if (value != null) {
                    val d: MutableList<PersonalityEntity> = mutableListOf()

                    value.documents.forEach { doc ->
                        d.add(doc.toObject(PersonalityEntity::class.java)!!)
                    }

                    personalityTestResult.value = d
                }
            }
    }

    fun fetchTestResult() = viewModelScope.launch {
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

    fun deleteTestResult(index: Int) = viewModelScope.launch {
        withContext(Dispatchers.IO) {
            if (personalityTestResult.value == null || personalityTestResult.value!!.isEmpty()) {
                return@withContext
            }

            val documentId = personalityTestResult.value!![index].documentId!!
            firebaseDb.collection("personalities_result_${token}")
                .document(documentId)
                .delete()
                .addOnSuccessListener {
                    val data = personalityTestResult.value!!.toMutableList()
                    data.removeAt(index)

                    personalityTestResult.value = data
                }

        }
    }

    fun getTestResult() : LiveData<List<PersonalityEntity>> = personalityTestResult

}