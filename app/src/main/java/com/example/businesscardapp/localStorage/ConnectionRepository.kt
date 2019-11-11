package com.example.businesscardapp.localStorage

import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.LiveData
import com.example.businesscardapp.models.Connection

class ConnectionRepository(application: Application) {

    private var ConnectionDao: ConnectionDao

    private var allConnections: LiveData<List<Connection>>

    private var isOnline = true

    init {
        val database: UserDatabase = UserDatabase.getInstance(
            application.applicationContext
        )!!

        if (isOnline) {

            //TODO: get Data from RoamlyDao if valid,
            // delete local data, set local data equal to data from RoamlyDao
        }

        ConnectionDao = database.connectionDao()

        allConnections = ConnectionDao.getAllConnections()
    }

    fun insert(Connection: Connection) {
        val insertConnectionAsyncTask = InsertConnectionAsyncTask(ConnectionDao).execute(Connection)
    }

    fun update(Connection: Connection) {
        val updateConnectionAsyncTask = UpdateConnectionAsyncTask(ConnectionDao).execute(Connection)
    }

    fun delete(Connection: Connection) {
        val deleteConnectionAsyncTask = DeleteConnectionAsyncTask(ConnectionDao).execute(Connection)
    }

    fun deleteAllConnections() {
        val deleteAllConnectionsAsyncTask = DeleteAllConnectionsAsyncTask(
            ConnectionDao
        ).execute()
    }

    fun getAllConnections(): LiveData<List<Connection>> {
        return allConnections
    }


    fun getConnectionById(id:Long): LiveData<Connection> {
        return ConnectionDao.getConnectionById(id)
    }

    companion object {

        private class InsertConnectionAsyncTask(ConnectionDaoIn: ConnectionDao) :
            AsyncTask<Connection, Unit, Unit>() {
            val ConnectionDao = ConnectionDaoIn

            override fun doInBackground(vararg p0: Connection?) {
                ConnectionDao.insert(p0[0]!!)
            }
        }

        private class UpdateConnectionAsyncTask(ConnectionDaoIn: ConnectionDao) :
            AsyncTask<Connection, Unit, Unit>() {
            val ConnectionDao = ConnectionDaoIn

            override fun doInBackground(vararg p0: Connection?) {
                ConnectionDao.update(p0[0]!!)
            }
        }

        private class DeleteConnectionAsyncTask(ConnectionDaoIn: ConnectionDao) :
            AsyncTask<Connection, Unit, Unit>() {
            val ConnectionDao = ConnectionDaoIn

            override fun doInBackground(vararg p0: Connection?) {
                ConnectionDao.delete(p0[0]!!)
            }
        }

        private class DeleteAllConnectionsAsyncTask(ConnectionDaoIn: ConnectionDao) :
            AsyncTask<Unit, Unit, Unit>() {
            val ConnectionDao = ConnectionDaoIn

            override fun doInBackground(vararg p0: Unit?) {
                ConnectionDao.deleteAllConnections()
            }
        }

    }

}