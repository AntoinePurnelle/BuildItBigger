package net.ouftech.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.CountDownLatch;

import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class JokeGCETest {
    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testDoInBackground() throws InterruptedException {
        final CountDownLatch signal = new CountDownLatch(1);
        EndpointsAsyncTask endpointsAsyncTask = new EndpointsAsyncTask(result -> {
            assertTrue(result != null);
            signal.countDown();
        });
        endpointsAsyncTask.execute();
        signal.await();
    }
}
