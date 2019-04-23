package e.wonka.lab4_3_stocks;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton {
    private static MySingleton instance;
    private RequestQueue requestQueue;
    private static Context ctx;

    // private constructor!
    private MySingleton(Context context) {
        ctx = context;
        requestQueue = getRequestQueue();
    }

    // this method is used to create the one and only instance of this class
    // with synchronized we make sure, that only one thread at a time can access this method!
    public static synchronized MySingleton getInstance(Context context) {
        if (instance == null) {
            instance = new MySingleton(context);
        }
        return instance;
    }


    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            requestQueue = Volley.newRequestQueue(ctx.getApplicationContext());
        }
        return requestQueue;
    }

    public <T> void addToRequestQueue(Request<T> req) {
        getRequestQueue().add(req);
    }
}