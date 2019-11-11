package com.example.businesscardapp.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.businesscardapp.localStorage.ConnectionRepository
import com.example.businesscardapp.models.Connection

class ConnectionViewModel(application: Application) : AndroidViewModel(application){
    private var repository: ConnectionRepository =
        ConnectionRepository(application)
    private var allConnections: LiveData<List<Connection>> = repository.getAllConnections()

    fun insert(connection: Connection) {
        repository.insert(connection)
    }

    fun update(connection: Connection) {
        repository.update(connection)
    }

    fun delete(connection: Connection) {
        repository.delete(connection)
    }

    fun deleteAllConnections() {
        repository.deleteAllConnections()
    }

    fun getAllConnections(): LiveData<List<Connection>> {
        return allConnections
    }

    fun getConnectionById(id:Long):LiveData<Connection>{
        return repository.getConnectionById(id)
    }
}