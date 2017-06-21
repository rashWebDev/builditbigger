import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.core.deps.guava.util.concurrent.AsyncFunction;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.AndroidTestCase;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;

import com.udacity.gradle.builditbigger.EndPointAsyncTask;
import com.udacity.gradle.builditbigger.MainActivity;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

@RunWith(AndroidJUnit4.class)
public class AysncTaskTest {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testAsyncTask()  {
        String result=null;
        EndPointAsyncTask asyncTask = new EndPointAsyncTask(activityTestRule.getActivity().getApplicationContext());
        try {
            asyncTask.execute();

            result = asyncTask.get(30, TimeUnit.SECONDS);
            assertNotNull(result);
            assertTrue(!TextUtils.isEmpty(result));
        }
        catch (Exception e){
            Log.e("error","follow code");
        }
    }
}