package ly.generalassemb.espresso;

import android.app.Application;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasErrorText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ApplicationTestCase;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */

@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {


    public ApplicationTest() {
        super(Application.class);
    }

    @Rule
    public ActivityTestRule<BalanceActivity> mTransactionTest =
            new ActivityTestRule<BalanceActivity>(BalanceActivity.class);

    @Test
    public void inputTransaction() throws Exception {
//        String value1 = "10000";
//        String value2 = "3000";
//        String description1 = "Audi Service";
//        String expectedValue = "$3000";
//
//        onView(withId(R.id.newTransactionButton)).perform(click());
//
//        onView(withId(R.id.balance_item_description)).perform(typeText(description1), closeSoftKeyboard());
//
//        onView(withId(R.id.amountEditText)).perform(typeText(value2), closeSoftKeyboard());
//
//        onView(withId(R.id.depositButton)).perform(click());
//
//        onView(withId(R.id.balanceTextView)).check(matches(withText(expectedValue)));

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Purchase"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("300"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("-$300.00")));

    }

    @Test
    public void outputTransaction() throws Exception {
        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Deposit"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("10000"), closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());
        onView(withId(R.id.balanceTextView)).check(matches(withText("$10000.00")));
    }

    @Test
    public void fullTestSuite() throws Exception {

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Rent"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("2000"), closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Gambling"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("5000"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Dividends"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("8000"), closeSoftKeyboard());
        onView(withId(R.id.depositButton)).perform(click());

        onView(withId(R.id.newTransactionButton)).perform(click());
        onView(withId(R.id.descriptionEditText)).perform(typeText("Withdraw"), closeSoftKeyboard());
        onView(withId(R.id.amountEditText)).perform(typeText("2000"), closeSoftKeyboard());
        onView(withId(R.id.withdrawButton)).perform(click());

        onView(withId(R.id.balanceTextView)).check(matches(withText("$3000.00")));

    }
}



