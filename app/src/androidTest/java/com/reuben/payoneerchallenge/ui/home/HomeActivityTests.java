package com.reuben.payoneerchallenge.ui.home;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner;

import com.reuben.payoneerchallenge.R;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4ClassRunner.class)
public class HomeActivityTests {

    @Rule
    public ActivityScenarioRule<HomeActivity> activityScenarioRule = new ActivityScenarioRule<>(HomeActivity.class);

    @Test
    public void test_IsActivityInView() {
        onView(withId(R.id.home_root))
                .check(matches(isDisplayed()));
    }


    @Test
    public void test_IsRecyclerInView() {
        onView(withId(R.id.payments_recycler))
                .check(matches(isDisplayed()));
    }

}