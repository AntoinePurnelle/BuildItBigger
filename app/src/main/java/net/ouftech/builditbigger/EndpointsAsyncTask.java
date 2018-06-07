package net.ouftech.builditbigger;

import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;
import com.google.api.client.googleapis.services.AbstractGoogleClientRequest;
import com.google.api.client.googleapis.services.GoogleClientRequestInitializer;

import net.ouftech.builditbigger.backend.myApi.MyApi;
import net.ouftech.ouftechcommons.Logger;

import java.io.IOException;

public class EndpointsAsyncTask extends AsyncTask<Context, Void, String> {
    private MyApi myApiService = null;
    private EndpointsAsyncTaskListener listener;

    public interface EndpointsAsyncTaskListener {
        void onResult(String result);
    }

    @NonNull
    protected String getLogTag() {
        return "EndpointsAsyncTask";
    }

    public EndpointsAsyncTask(EndpointsAsyncTaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected String doInBackground(Context... params) {

        if (myApiService == null) {  // Only do this once
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(),
                    new AndroidJsonFactory(), null)
                    // options for running against local devappserver
                    // - 10.0.2.2 is localhost's IP address in Android emulator
                    // - turn off compression when running against local devappserver
                    .setRootUrl("http://udacity-25d48.appspot.com/_ah/api/")
                    .setGoogleClientRequestInitializer(new GoogleClientRequestInitializer() {
                        @Override
                        public void initialize(AbstractGoogleClientRequest<?> abstractGoogleClientRequest) throws IOException {
                            abstractGoogleClientRequest.setDisableGZipContent(true);
                        }
                    });
            // end options for devappserver

            myApiService = builder.build();
        }

        try {
            return myApiService.getJoke().execute().getData();
        } catch (IOException e) {
            Logger.e(getLogTag(), e);
            return e.getMessage();
        }
    }

    @Override
    protected void onPostExecute(String result) {
        listener.onResult(result);
    }
}
